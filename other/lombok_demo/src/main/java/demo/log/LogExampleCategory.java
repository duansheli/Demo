package demo.log;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog(topic = "CounterLog")
// org.apache.commons.logging.Log log
public class LogExampleCategory {
    public static void main(String... args) throws Exception {
        log.info("错误点 the 'CounterLog' with a message");
    }
}