package pl.kostrowski.nauka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kostrowski.nauka.model.Admin;

import javax.persistence.Entity;

@Repository
public interface AdminRepository extends CrudRepository<Admin, String> {

    Admin findFirstBySurname(String surname);
}
