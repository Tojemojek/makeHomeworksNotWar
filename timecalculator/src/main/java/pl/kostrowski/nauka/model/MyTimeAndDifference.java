package pl.kostrowski.nauka.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDateTime;

@XmlRootElement(name = "TimeDiffHistory")
@XmlType
public class MyTimeAndDifference {

    private LocalDateTime fromDateTime;
    private LocalDateTime toDateTime;

    private Integer years = 0;
    private Integer months = 0;
    private Integer days = 0;

    private Integer hours = 0;
    private Integer minutes = 0;
    private Integer seconds = 0;

    public LocalDateTime getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(LocalDateTime fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public LocalDateTime getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(LocalDateTime toDateTime) {
        this.toDateTime = toDateTime;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "Od daty " + fromDateTime +
                ", do daty " + toDateTime +
                ", upływa lat = " + years +
                ", miesięcy = " + months +
                ", dni = " + days +
                ", godzin = " + hours +
                ", minut = " + minutes +
                ", sekund = " + seconds +
                '}';
    }
}
