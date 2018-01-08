package pl.kostrowski.nauka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Entity
public class Buyer extends AbstractUser {

    @Column(name = "listOfStuff")
    private String listOfStuff;

    public Buyer() {
    }

    public Buyer(String name, String surname, Integer age, String listOfStuff) {
        super(name, surname, age);
        this.listOfStuff = listOfStuff;
    }

    @PrePersist
    public void prePersist() {
        super.setDateOfCreation(LocalDateTime.now().toString());
    }

    @PreUpdate
    public void preUpdate() {
        super.setDateOfUpdate(LocalDateTime.now().toString());
    }


}
