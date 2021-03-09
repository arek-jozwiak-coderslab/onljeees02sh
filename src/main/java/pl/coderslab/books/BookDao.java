package pl.coderslab.books;

import org.springframework.stereotype.Repository;
import pl.coderslab.book.ServiceBook;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> getAll() {
        return entityManager
                .createQuery("SELECT b from Book b")
                .getResultList();
    }

    public List<Book> getRatingList(int rating) {
        Query query = entityManager.createQuery("SELECT b from Book b where " +
                "b.rating!=:rag");
        query.setParameter("rag", rating);
        return query.getResultList();
    }

    public List<Book> getListByActiveAndPublisher(Publisher publisher) {
        Query query = entityManager.createQuery("SELECT b from Book b where " +
                "b.active=true and b.publisher=:pub");
        query.setParameter("pub", publisher);
        return query.getResultList();
    }

}
