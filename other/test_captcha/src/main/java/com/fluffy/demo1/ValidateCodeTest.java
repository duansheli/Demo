package com.fluffy.demo1;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ValidateCodeTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ValidateCode vCode = new ValidateCode(120, 40, 5, 100);
        try {

            File createTempFile = File.createTempFile("aabbccdd", ".png");
            String path = createTempFile.getAbsolutePath();
            System.out.println(vCode.getCode() + " >" + path);

            vCode.write(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
