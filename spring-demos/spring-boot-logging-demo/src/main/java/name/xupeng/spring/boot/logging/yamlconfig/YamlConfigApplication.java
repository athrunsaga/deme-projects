package name.xupeng.spring.boot.logging.yamlconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

/**
 * 演示一个通过 YAML 配置文件配置的应用程序。
 * <p>
 * <p/>本例中使用 {@code application-yaml.yml} 配置文件，
 * 正常代码可以直接使用 {@code application.yml} 配置文件。
 *
 * @author Arthur Xu
 */
@SuppressWarnings("SpringFacetCodeInspection")
@SpringBootApplication
public class YamlConfigApplication {

    private static final Logger logger = LoggerFactory.getLogger(YamlConfigApplication.class);

    private final UseLogClass useLogClass;

    public static void main(String[] args) {
        SpringApplication.run(YamlConfigApplication.class, "--spring.profiles.active=yaml");
    }

    public YamlConfigApplication(UseLogClass useLogClass) {
        this.useLogClass = useLogClass;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        logger.error("error log");
        logger.warn("warn log");
        logger.info("info log");
        // 记录以下日志，application-yaml.yml 设置全局日志级别为 trace
        logger.debug("debug log");
        logger.trace("trace log");

        useLogClass.log();
    }
}
