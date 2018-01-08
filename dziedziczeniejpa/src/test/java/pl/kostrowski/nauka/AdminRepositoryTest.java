package pl.kostrowski.nauka;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kostrowski.nauka.model.Admin;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)


@SpringBootTest
@DataJpaTest
public class AdminRepositoryTest {

    Logger LOG = LoggerFactory.getLogger(AdminRepositoryTest.class);

    @Autowired
    private pl.kostrowski.nauka.repository.AdminRepository adminRepository;

    @Test
    public void shouldPrePersists() {

        Admin admin = new Admin("Imie testowe","Nazwisko Testowe", 15, "rola testowa");

        LOG.debug(admin.getId());
        LOG.debug(admin.getDateOfCreation());

        assertThat(admin.getId()).isNull();
        assertThat(admin.getDateOfCreation()).isNull();
        assertThat(admin.getDateOfUpdate()).isNull();

        adminRepository.save(admin);

        LOG.debug(admin.getId());
        LOG.debug(admin.getDateOfCreation());

        assertThat(admin.getId()).isNotNull();
        assertThat(admin.getDateOfCreation()).isNotNull();
        assertThat(admin.getDateOfUpdate()).isNull();

    }

    @Test
    public void shouldPrePersistAndPreUpdate() {

        Admin admin = new Admin("Imie testowe","Nazwisko Testowe", 15, "rola testowa");

        LOG.debug(admin.getId());
        LOG.debug(admin.getDateOfCreation());

//        assertThat(admin.getId()).isNull();
//        assertThat(admin.getDateOfCreation()).isNull();
//        assertThat(admin.getDateOfUpdate()).isNull();

        adminRepository.save(admin);

        LOG.debug(admin.getId());
        LOG.debug(admin.getDateOfCreation());

        Admin fromRepository = adminRepository.findFirstBySurname("Nazwisko Testowe");

        fromRepository.setSurname("Inne Nazwisko");

        adminRepository.save(fromRepository);
//
//        assertThat(fromRepository.getId()).isNotNull();
//        assertThat(fromRepository.getDateOfCreation()).isNotNull();
        assertThat(fromRepository.getDateOfUpdate()).isNotNull();

    }

}
