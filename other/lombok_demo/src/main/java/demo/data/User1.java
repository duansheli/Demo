
package demo.data;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class User1 {
    String userName;
    String pwd;
}

class User2 {
    @Getter @Setter 
    String pwd;
    @Setter(AccessLevel.PROTECTED) 
    String userName;
}
