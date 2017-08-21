
package demo.other;

import lombok.Data;
import lombok.NonNull;

/**
 * 与@Data配合使用，则会生成包含pwd的构造器 
 * 当new Test_nonNull(null);则会抛出空指针异常
 */
@Data
public class Test_nonNull {
    @NonNull
    String pwd;

    public static void main(String[] args) {
        new Test_nonNull(null);

        Test_nonNull2.hello(null);
    }
}
class Test_nonNull2 {
    static void hello(@NonNull String str) {
        System.out.println("参数null检查。 调用该方法时，传入null则抛出空指针异常");
    }
}
