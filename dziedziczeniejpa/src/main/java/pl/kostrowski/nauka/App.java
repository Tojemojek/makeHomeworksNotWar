package pl.kostrowski.nauka;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    final static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("Appka z dziedziczeniem encji startuje");

        SpringApplication.run(App.class, args);

    }
}