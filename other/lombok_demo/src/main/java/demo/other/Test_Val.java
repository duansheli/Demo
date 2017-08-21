
package demo.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.val;

public class Test_Val {
    public static void main(String[] args) {
        val sets = new HashSet<String>();
        val lists = new ArrayList<String>();
        val maps = new HashMap<String, String>();

        // =>相当于
        final Set<String> sets2 = new HashSet<String>();
        final List<String> lists2 = new ArrayList<String>();
        final Map<String, String> maps2 = new HashMap<String, String>();
    }
}
