package pl.kostrowski.nauka.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kostrowski.nauka.model.MyTimeAndDifference;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class StringToDateParser {

    private static final Logger LOG = LoggerFactory.getLogger(StringToDateParser.class);

    LocalDateTime dateTimeFrom;
    LocalDateTime dateTimeTo;

    public MyTimeAndDifference parseThisStrings(String from, String to, MyTimeAndDifference myTimeAndDifference) {

        from = addNeededParts(from);
        to = addNeededParts(to);

        try {
            dateTimeFrom = LocalDateTime.parse(from);
            dateTimeTo = LocalDateTime.parse(to);
            myTimeAndDifference.setFromDateTime(dateTimeFrom);
            myTimeAndDifference.setToDateTime(dateTimeTo);

        } catch (DateTimeParseException e) {
            LOG.error("Nie udało się sparsować dat...");
            LOG.error(e.toString());
        }
        return myTimeAndDifference;
    }


    private String addNeededParts(String processed) {
        if (processed.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
            return processed + "T00:00:00";
        } else if (processed.matches("[0-9]{2}:[0-9]{2}:[0-9]{2}")) {
            return "1900-01-01T" + processed;
        } else return "1900-01-01T00:00:00";
    }

}
