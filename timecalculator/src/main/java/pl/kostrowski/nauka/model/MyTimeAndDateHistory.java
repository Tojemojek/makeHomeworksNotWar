package pl.kostrowski.nauka.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


@XmlRootElement(namespace = "pl.kostrowski.nauka.model")
public class MyTimeAndDateHistory {

    private List<LocalDateTime> modifyDateTimes = new LinkedList<>();

    @XmlElementWrapper(name = "TimeDiffHistoryWrapper")
    @XmlElement(name = "historyElement")
    private List<MyTimeAndDifference> shortHistory = new LinkedList<>();

    public List<LocalDateTime> getModifyDateTimes() {
        return modifyDateTimes;
    }

    public List<MyTimeAndDifference> getShortHistory() {
        return shortHistory;
    }

}
