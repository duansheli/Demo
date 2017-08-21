package com.fluffy.demo2;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Properties;

import javax.imageio.ImageIO;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.common.io.ByteSink;
import com.google.common.io.Files;

/**
 * 中文验证码
 */
public class Demo_img2 {

    // 步骤
    // 1.定义BufferedImage对象
    // 2.获得Graphics
    // 3.通过Random长生随机验证码信息
    // 4.使用Graphics绘制图片
    // 5.记录验证码信息到session中
    // 6.使用ImageIO输出图片
    public static void main(String[] args) throws Exception {

        DefaultKaptcha kaptcha = new DefaultKaptcha();

        Properties props = new Properties();
        props.setProperty("kaptcha.image.width", "100");
        props.setProperty("kaptcha.image.height", "50");
        props.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");
        props.setProperty("kaptcha.textproducer.char.string", "0123456789abcdefghijklmnopqrstuvwxyz");
        props.setProperty("kaptcha.textproducer.char.length", "4");

        kaptcha.setConfig(new com.google.code.kaptcha.util.Config(props));

        String result = kaptcha.createText();
        BufferedImage bi = kaptcha.createImage(result);

        File img = File.createTempFile("cccc", ".jpg");
        ByteSink byteSink = Files.asByteSink(img);

        StringBuffer sb = new StringBuffer();

        ImageIO.write(bi, "JPG", byteSink.openBufferedStream());

        System.out.println("中文验证码： " + sb.toString());
        System.out.println(img.getAbsolutePath());
    }

}
