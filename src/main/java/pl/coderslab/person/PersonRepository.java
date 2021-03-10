package pl.coderslab.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findOneByLoginAndEmail(String login, String email);
    Person findTurlututuByLoginAndEmail(String login, String email);

}
