package pl.coderslab.books;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Publisher findById(Long id) {
        return entityManager.find(Publisher.class, id);
    }


    public void save(Publisher publisher) {
        entityManager.persist(publisher);
    }
}
