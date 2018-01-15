package pl.kostrowski.nauka.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kostrowski.nauka.model.MyTimeAndDifference;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TimeCalculator {

    Logger LOG = LoggerFactory.getLogger(TimeCalculator.class);

    public Optional<Period> getDateDifference(MyTimeAndDifference myTimeAndDifference) {

        Optional<Period> dateDifference = Optional.empty();

        LocalDateTime localDateTimefrom = myTimeAndDifference.getFromDateTime();
        LocalDateTime localDateTimeTo = myTimeAndDifference.getToDateTime();

        if (localDateTimefrom != null && localDateTimeTo != null) {

            LocalDate localDateFrom = localDateTimefrom.toLocalDate();
            LocalDate localDateTo = localDateTimeTo.toLocalDate();

            dateDifference = Optional.of(localDateFrom.until(localDateTo));

            dateDifference.ifPresent(dd -> {
                myTimeAndDifference.setYears(dd.getYears());
                myTimeAndDifference.setMonths(dd.getMonths());
                myTimeAndDifference.setDays(dd.getDays());
            });
        }
        return dateDifference;
    }

    public Optional<LocalTime> getTimeDifference(MyTimeAndDifference myTimeAndDifference) {

        LocalDateTime localDateTimefrom = myTimeAndDifference.getFromDateTime();
        LocalDateTime localDateTimeTo = myTimeAndDifference.getToDateTime();

        LocalTime localTimeFrom = localDateTimefrom.toLocalTime();
        LocalTime localTimeTo = localDateTimeTo.toLocalTime();

        Optional<LocalTime> timeDifference = Optional.empty();

        if (localTimeFrom != null && localTimeTo != null) {

            LocalTime result;

            result = localTimeFrom.minusHours(localTimeTo.getHour());
            result = result.minusMinutes(localTimeTo.getMinute());
            result = result.minusSeconds(localTimeTo.getSecond());

            Optional<LocalTime> finalResult = Optional.empty();
            finalResult = Optional.of(result);

            myTimeAndDifference.setHours(result.getHour());
            myTimeAndDifference.setMinutes(result.getMinute());
            myTimeAndDifference.setSeconds(result.getSecond());
        }
        return timeDifference;
    }

}
