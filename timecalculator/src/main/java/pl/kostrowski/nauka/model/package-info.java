@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(type = LocalDateTime.class, value = XmlLocalDateTimeAdapter.class),
})
package pl.kostrowski.nauka.model;

import pl.kostrowski.nauka.adapters.XmlLocalDateTimeAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.time.LocalDateTime;
