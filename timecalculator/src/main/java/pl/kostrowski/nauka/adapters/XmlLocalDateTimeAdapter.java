package pl.kostrowski.nauka.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

public class XmlLocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    public LocalDateTime unmarshal(String string) throws Exception {
        return LocalDateTime.parse(string);
    }

    public String marshal(LocalDateTime localDateTime) throws Exception {
        return localDateTime.toString();
    }
}
