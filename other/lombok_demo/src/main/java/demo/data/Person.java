
package demo.data;

import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class Person {
    @Getter @Setter @NonNull
    private List<String> cars;
}
//=>相当于
class Person2 {
    @NonNull
    private List<String> cars;

    public Person2(@NonNull final List<String> cars) {
        if (cars == null) throw new java.lang.NullPointerException("members");
        this.cars = cars;
    }
        
    @NonNull
    public List<String> getMembers() {
        return cars;
    }

    public void setMembers(@NonNull final List<String> cars) {
        if (cars == null) throw new java.lang.NullPointerException("members");
        this.cars = cars;
    }
}
