  
package demo.data;

import java.util.Arrays;

import lombok.ToString;

@ToString(callSuper=true,exclude="someExcludedField")
public class SuperMan extends Person{
    private boolean someBoolean = true;
    private String someStringField;
    private float someExcludedField;
    
    public static void main(String[] args) {
        SuperMan man = new SuperMan();
        man.setCars(Arrays.asList("big car", "small car"));
        System.out.println(man);
    }
}
//=>相当于
 class SuperMan2 extends Person{
    private boolean someBoolean = true;
    private String someStringField;
    private float someExcludedField;
    
    @java.lang.Override
    public java.lang.String toString() {
        return "SuperMan(super=" + super.toString() +
            ", someBoolean=" + someBoolean +
            ", someStringField=" + someStringField + ")";
    }
}
