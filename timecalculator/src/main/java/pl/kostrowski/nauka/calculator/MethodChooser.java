package pl.kostrowski.nauka.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kostrowski.nauka.model.MyTimeAndDifference;

import java.time.LocalTime;
import java.time.Period;
import java.util.Optional;
import java.util.Scanner;

public class MethodChooser {

    Logger LOG = LoggerFactory.getLogger(MethodChooser.class);

    public void selector(String option, MyTimeAndDifference myTimeAndDifference) {

        TimeCalculator tc = new TimeCalculator();
        Scanner sc = new Scanner(System.in);

        switch (option) {
            case "1": {
                Optional<Period> dateDifference = tc.getDateDifference(myTimeAndDifference);
                break;
            }

            case "2": {
                Optional<LocalTime> timeDifference = tc.getTimeDifference(myTimeAndDifference);
                break;
            }
        }
    }
}
