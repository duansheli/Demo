
package demo.other;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Synchronized;

/**
 * @classDesc: 目前更推荐使用lock对象， 该注解有点鸡肋
 * @createTime: 2017年6月23日 下午4:56:20
 */
public class Test_Synchronized {
    private DateFormat format = new SimpleDateFormat("MM-dd-YYYY");

    @Synchronized
    public String synchronizedFormat(Date date) {
        return format.format(date);
    }

}

// =>相当于
class Test_Synchronized2 {
    private final java.lang.Object $lock = new java.lang.Object[0];
    private DateFormat format = new SimpleDateFormat("MM-dd-YYYY");

    public String synchronizedFormat(Date date) {
        synchronized ($lock) {
            return format.format(date);
        }
    }
}
