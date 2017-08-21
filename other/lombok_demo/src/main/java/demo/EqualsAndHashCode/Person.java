package demo.EqualsAndHashCode;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * 
 * <pre>
 * 1. 通过of属性表明只使用某些字段，或者exclude属性表明不包含哪些字段
 * 
 * 2. 当类继承了非Object类时，equals和hashcode方法是不会使用父类中的字段的。
 * 需要使用父类字段则需要 @EqualsAndHashCode( callSuper=true)
 * 如果没有继承其他类，却使用callSuper，则会报编译错误
 * 
 * 3. 使用的是非 static，transient修饰的所有属性
 * </pre>
 */

@EqualsAndHashCode(callSuper = true, exclude = { "address", "city", "state", "zip" })
public class Person extends Person2 {
    enum Gender {
        Male, Female
    }

    @NonNull
    private String name;
    @NonNull
    private Gender gender;

    private String ssn;
    private String address;
}

class Person2 {
    private String city;
    private String state;
    private String zip;
}