package pl.kostrowski.nauka.timecalculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class TimeCalculator {

    Logger LOG = LoggerFactory.getLogger(TimeCalculator.class);

    private String input1;
    private String input2;

    public Optional<Period> getDateDifference(String input1, String input2) {

        List<LocalDate> localDates = verifyAndParseDates(input1, input2);
        Optional<Period> dateDifference = Optional.empty();

        if (localDates != null && localDates.size() == 2) {
            dateDifference = getDateDifference(localDates);
        }

        return dateDifference;
    }

    public Optional<LocalTime> getTimeDifference(String input1, String input2) {

        List<LocalTime> localTimes = verifyAndParseTime(input1, input2);
        Optional<LocalTime> timeDifference = Optional.empty();

        if (localTimes != null && localTimes.size() == 2) {
            timeDifference = getTimeDifference(localTimes);
        }

        return timeDifference;
    }

    private Optional<Period> getDateDifference(List<LocalDate> localDates) {

        Collections.sort(localDates);

        Optional<Period> optionalPeriod = Optional.empty();
        optionalPeriod = Optional.of(localDates.get(0).until(localDates.get(1)));

        return optionalPeriod;
    }

    private Optional<LocalTime> getTimeDifference(List<LocalTime> localTimes) {

        Collections.sort(localTimes);

        LocalTime result;
        LocalTime start = localTimes.get(1);
        LocalTime end = localTimes.get(0);

        result = start.minusHours(end.getHour());
        result = result.minusMinutes(end.getMinute());
        result = result.minusSeconds(end.getSecond());

        Optional<LocalTime> finalResult = Optional.of(result);

        return finalResult;
    }


    private List<LocalDate> verifyAndParseDates(String input1, String input2) {

        List<LocalDate> localDates = new LinkedList<>();

        try {
            localDates.add(LocalDate.parse(input1));
            localDates.add(LocalDate.parse(input2));
        } catch (DateTimeParseException e) {
            LOG.info("Niestety wpisane wartości dat nie były w prawidłowej formie");
            LOG.info("Powinny być w formacie RRRR-MM-DD");
            LOG.info("Podane wartości to");
            LOG.info(input1);
            LOG.info(input2);
            return null;
        }
        return localDates;
    }

    private List<LocalTime> verifyAndParseTime(String input1, String input2) {

        List<LocalTime> localTimes = new LinkedList<>();

        try {
            localTimes.add(LocalTime.parse(input1));
            localTimes.add(LocalTime.parse(input2));
        } catch (DateTimeParseException e) {
            LOG.info("Niestety wpisane wartości czasu nie były w prawidłowej formie");
            LOG.info("Powinny być w formacie gg-mm-ss");
            LOG.info("Podane wartości to");
            LOG.info(input1);
            LOG.info(input2);
            return null;
        }
        return localTimes;
    }


}
