package demo.log;

import lombok.extern.java.Log;

/**
 * <pre>
 * @CommonsLog ____org.apache.commons.logging.LogFactory.getLog(LogExample.class);
 * @Log ___________java.util.logging.Logger.getLogger(LogExample.class.getName());
 * @Log4j _________org.apache.log4j.Logger.getLogger(LogExample.class);
 * @Log4j2 ________org.apache.logging.log4j.LogManager.getLogger(LogExample.class);
 * @Slf4j _________org.slf4j.LoggerFactory.getLogger(LogExample.class);
 * @XSlf4j ________org.slf4j.ext.XLoggerFactory.getXLogger(LogExample.class);
 * </pre>
 */
@Log
public class LogExample {

    public static void main(String... args) {
        System.out.println(log.getClass().getName());
        log.info("Something else is wrong here");
    }
}

// =>相当于
class LogExample2 {
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(LogExample2.class.getName());

    public static void main(String... args) {
        log.info("发生了什么");
    }
}