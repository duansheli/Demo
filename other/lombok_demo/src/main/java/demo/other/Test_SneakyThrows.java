
package demo.other;

import lombok.SneakyThrows;

public class Test_SneakyThrows {
    // 1. 在不加注解的情况下会抛出异常, 此时需要对异常进行捕获，或者声明抛出
    // 该方法包含两个异常
    void throw_eeeeeeeeeeeException() throws IllegalAccessException, CloneNotSupportedException {
        boolean f1 = true;
        if (f1)
            throw new IllegalAccessException();
        if (f1)
            throw new CloneNotSupportedException();
    };

    // 2. 使用@SneakyThrows后， 不需要声明抛出，或者进行try catch
    @SneakyThrows
    public void test1() {
        throw_eeeeeeeeeeeException();
        System.out.println("自动抛出， 调用方会收到到exception");
    }

    @SneakyThrows(CloneNotSupportedException.class)
    public void test2() {
        // 3. 由于注解标注了CloneNotSupportedException
        // 对不包含的IllegalAccessException 则需要try catch
        try {
            throw_eeeeeeeeeeeException();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("自动抛出， 调用方会收到到exception");
    }
    public static void main(String[] args) {
        Test_SneakyThrows t = new Test_SneakyThrows();
        try {
            t.test1();
        } catch (Exception e) {
            e.printStackTrace();  
            System.out.println("方法的异常都抛到main里处理");
        }
    }

}
