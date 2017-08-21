package demo.data;

import java.util.Set;

import com.alibaba.fastjson.JSON;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Builder
@Data
public class Test_Builder {
    String name;
    int age;
    @Singular
    private Set<String> als;

    public static void main(String[] args) {
        Test_BuilderBuilder builder = Test_Builder.builder();
        Test_Builder example = builder.name("张三").age(10).al("cat").al("pig").build();
        System.out.println("builder: " + builder);
        System.out.println("实体: " + example);
        System.out.println(JSON.toJSONString(example));
    }
}
