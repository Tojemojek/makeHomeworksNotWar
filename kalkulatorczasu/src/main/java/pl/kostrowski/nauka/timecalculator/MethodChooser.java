package pl.kostrowski.nauka.timecalculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.time.Period;
import java.util.Optional;
import java.util.Scanner;

public class MethodChooser {

    Logger LOG = LoggerFactory.getLogger(MethodChooser.class);

    public void selector(String option) {

        TimeCalculator tc = new TimeCalculator();
        Scanner sc = new Scanner(System.in);

        switch (option) {
            case "1": {
                LOG.info("Wybrałeś różnicę między datami");
                LOG.info("Data powinna być w formacie RRRR-MM-DD");
                LOG.info("Podaj pierwszą datę");
                String firstDate = sc.nextLine();
                LOG.info("Podaj drugą datę");
                String secondDate = sc.nextLine();
                Optional<Period> dateDifference = tc.getDateDifference(firstDate, secondDate);
                dateDifference.ifPresent(dd -> LOG.warn("Różnica między datami wynosi"));
                dateDifference.ifPresent(dd -> LOG.warn("Lata: " + dd.getYears() + " miesiące: " + dd.getMonths() + " dni: " + dd.getDays()));
                break;
            }

            case "2": {
                LOG.info("Wybrałeś różnicę między godzinami");
                LOG.info("Czas powinien być w formacie gg-mm-ss");
                LOG.info("Podaj pierszy  czas");
                String firstTime = sc.nextLine();
                LOG.info("Podaj drugi czas");
                String secondTime = sc.nextLine();
                Optional<LocalTime> timeDifference = tc.getTimeDifference(firstTime, secondTime);
                timeDifference.ifPresent(td -> LOG.warn("Różnica między godzinami wynosi"));
                timeDifference.ifPresent(td -> LOG.warn("Godziny: " + td.getHour() + " minuty: " + td.getMinute() + " sekundy: " + td.getSecond()));
                break;

            }
        }
    }
}
