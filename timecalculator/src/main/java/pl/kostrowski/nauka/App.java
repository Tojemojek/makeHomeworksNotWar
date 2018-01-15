package pl.kostrowski.nauka;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kostrowski.nauka.calculator.MethodChooser;
import pl.kostrowski.nauka.calculator.StringToDateParser;
import pl.kostrowski.nauka.model.MyTimeAndDateHistory;
import pl.kostrowski.nauka.model.MyTimeAndDifference;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;


public class App {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);


    private static MyTimeAndDateHistory HISTORY = new MyTimeAndDateHistory();
    private static final String HISTORY_XML = "c:/temp/history.xml";

    public static void main(String[] args) throws Throwable {

        JAXBContext context = JAXBContext.newInstance(MyTimeAndDateHistory.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        File f = new File(HISTORY_XML);
        if (!f.exists()) {
            f.createNewFile();
        } else {
            Unmarshaller um = context.createUnmarshaller();
            try {
                HISTORY = (MyTimeAndDateHistory) um.unmarshal(new FileReader(HISTORY_XML));
            } catch (Exception e) {
                LOG.error("Nie udało się odczytać z pliku");
            }

        }

        if (HISTORY.getShortHistory().size() > 0){
            LOG.info("Historyczne wyniki to");
            for (MyTimeAndDifference myTimeAndDifference : HISTORY.getShortHistory()) {
                LOG.info(myTimeAndDifference.toString());
            }
        }


        String option = "";
        String from = "";
        String to = "";
        StringToDateParser stdp = new StringToDateParser();

        Scanner sc = new Scanner(System.in);

        MethodChooser mc = new MethodChooser();

        LOG.info("Witaj w kalkulatorze dat i czasu");
        LOG.info("Daty powinny być w formacie RRRR-MM-DD");
        LOG.info("Godziny powinny być w formacie gg-mm-ss");

        do {

            MyTimeAndDifference myTimeAndDifference = new MyTimeAndDifference();
            LOG.info("Aby uzyskać różnicę między datami wpisz \"1\"");
            LOG.info("Aby uzyskać różnicę między godzinami wpisz \"2\"");
            LOG.info("Aby wyjść wpisz \"x\"");

            option = sc.nextLine();
            if(option.equals("x")){
                break;
            }

            LOG.info("Podaj czas od");
            from = sc.nextLine();
            LOG.info("Podaj czas do");
            to = sc.nextLine();

            myTimeAndDifference = stdp.parseThisStrings(from, to, myTimeAndDifference);
            mc.selector(option, myTimeAndDifference);

            HISTORY.getModifyDateTimes().add(LocalDateTime.now());
            HISTORY.getShortHistory().add(myTimeAndDifference);

            LOG.info(myTimeAndDifference.toString());

            m.marshal(HISTORY, f);

        } while (!option.equals("x"));


    }


}
