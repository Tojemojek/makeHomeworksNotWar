package pl.kostrowski.mtga;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MakeTasksGreatAgainApplication {
    final static Logger logger = LoggerFactory.getLogger(MakeTasksGreatAgainApplication.class);

    public static void main(String[] args) {
        logger.info("Aplikacja wystartowała");
        SpringApplication.run(MakeTasksGreatAgainApplication.class, args);
    }
}
