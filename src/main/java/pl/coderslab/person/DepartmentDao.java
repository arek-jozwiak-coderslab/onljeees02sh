package pl.coderslab.person;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DepartmentDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Department> getAll() {
        return entityManager.createQuery("SELECT  d from Department d").getResultList();
    }

    public Department findById(long id) {
        return entityManager.find(Department.class, id);
    }
}
