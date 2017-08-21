
package com.fluffy.demo2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

import com.google.common.io.ByteSink;
import com.google.common.io.Files;

/**
 * 计算验证码
 */
public class Demo_CalculateCaptcha {
    public static void main(String[] args) throws Exception {
        int result = 0;
        BufferedImage bi = buildImg(result);
        
        File img = File.createTempFile("aaaa", ".jpg");
        ByteSink byteSink = Files.asByteSink(img);

        ImageIO.write(bi, "JPG", byteSink.openBufferedStream());

        System.out.println(result);
        System.out.println(img.getAbsolutePath());
    }

    static BufferedImage buildImg(int result) {
        BufferedImage bi = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        Color c = new Color(200, 150, 255);
        g.setColor(c);
        g.fillRect(0, 0, 68, 22);

        char[] op = "+-".toCharArray();
        Random r = new Random();
        int index, len1 = op.length;
        int firstNum = 0, secondNum = 0;
        char operation = '0';
        for (int i = 0; i < 4; i++) {
            if (i != 1)
                index = r.nextInt(100);
            else
                index = r.nextInt(len1);

            g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));
            if (i == 0) {
                g.drawString(index + "", (i * 15) + 3, 18);
                firstNum = index;
            } else if (i == 2) {
                g.drawString(index + "", (i * 15) + 3, 18);
                secondNum = index;
            } else if (i == 1) {
                g.drawString(op[index] + "", (i * 15) + 3, 18);
                operation = op[index];
            } else {
                g.drawString("=", (i * 15) + 3, 18);
            }
        }

        if (operation == '+')
            result = firstNum + secondNum;
        else if (operation == '-')
            result = firstNum - secondNum;
        else if (operation == '*')
            result = firstNum * secondNum;
        return bi;
    }
}
