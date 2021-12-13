package name.xupeng.spring.boot.logging.noconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

/**
 * 演示一个没有任何日志配置的应用程序。
 *
 * @author Arthur Xu
 */
@SuppressWarnings("SpringFacetCodeInspection")
@SpringBootApplication
public class NoConfigApplication {

    private static final Logger logger = LoggerFactory.getLogger(NoConfigApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(NoConfigApplication.class);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        logger.error("error log");
        logger.warn("warn log");
        logger.info("info log");
        // 不记录以下日志，Spring Boot 默认日志级别为 INFO
        logger.debug("debug log");
        logger.trace("trace log");
    }
}
