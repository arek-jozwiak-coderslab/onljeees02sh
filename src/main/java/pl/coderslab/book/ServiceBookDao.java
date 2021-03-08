package pl.coderslab.book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ServiceBookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(ServiceBook serviceBook) {
        entityManager.persist(serviceBook);
    }

    public ServiceBook findById(long id) {
        return entityManager.find(ServiceBook.class, id);
    }
}
