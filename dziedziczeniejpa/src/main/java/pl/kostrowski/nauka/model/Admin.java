package pl.kostrowski.nauka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Entity
public class Admin extends AbstractUser {

    @Column(name = "role")
    private String role;

    public Admin() {
    }

    public Admin(String name, String surname, Integer age, String role) {
        super(name, surname, age);
        this.role = role;
    }

    @PrePersist
    public void prePersist() {
        super.setDateOfCreation(LocalDateTime.now().toString());
    }

    @PreUpdate
    public void preUpdate() {
        super.setDateOfUpdate(LocalDateTime.now().toString());
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
