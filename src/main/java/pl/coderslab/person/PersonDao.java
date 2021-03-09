package pl.coderslab.person;

import org.springframework.stereotype.Repository;
import pl.coderslab.books.Book;
import pl.coderslab.books.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Person person) {
        entityManager.persist(person);
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public List<Person> getAll() {
        return entityManager
                .createQuery("SELECT b from Person b")
                .getResultList();
    }

    public void update(Person person) {
        entityManager.merge(person);
    }

    public void delete(long id) {
        Person byId = findById(id);
        entityManager.remove(entityManager.contains(byId) ?
                byId : entityManager.merge(byId));
    }
}
