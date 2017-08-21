package demo.constructor;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor
public class LombokDemo {
    @NonNull
    private int id;
    @NonNull
    private String shap;
    private int age;

    public static void main(String[] args) {
        // 对应着@NoArgsConstructor
        new LombokDemo();

        // 对应着@AllArgsConstructor， 包含所有参数
        new LombokDemo(1, "circle", 2);

        // @NonNull标注的属性如果传入null则会抛出空指针
        // @RequiredArgsConstructor需要配合@NonNull使用
        new LombokDemo(1, "circle");
        // 属性staticName使用静态工厂方法
        LombokDemo.of(2, null);
    }
}