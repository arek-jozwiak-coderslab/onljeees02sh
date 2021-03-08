package pl.coderslab.books;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.book.ServiceBook;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Author findById(Long id) {
        return entityManager.find(Author.class, id);
    }

    public Author getWithBooksById(Long id) {
        Author byId = findById(id);
        Hibernate.initialize(byId.getBooks());
        return byId;
    }
}
