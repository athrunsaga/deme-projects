package name.xupeng.spring.boot.logging.yamlconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UseLogClass {

    private static final Logger logger = LoggerFactory.getLogger(UseLogClass.class);

    public UseLogClass() {}

    public void log() {
        logger.error("error from UseLogClass");
        logger.warn("warn from UseLogClass");
        // 不记录以下日志，application-yaml.yml 设置 UseLogClass 日志级别为 warn
        logger.info("info from UseLogClass");
        logger.debug("debug from UseLogClass");
        logger.trace("trace from UseLogClass");
    }
}
