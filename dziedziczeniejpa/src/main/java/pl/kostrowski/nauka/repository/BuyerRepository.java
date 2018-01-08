package pl.kostrowski.nauka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kostrowski.nauka.model.Admin;

@Repository
public interface BuyerRepository extends CrudRepository<Admin, String> {

}
