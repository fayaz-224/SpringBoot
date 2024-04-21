package spring.dao;

import java.util.List;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.entity.Employee;

//DAO layer is not mandatory, we can use service layer for business logic
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    // define field for entityManager which is similar to session - see Readme.md
    private final EntityManager entityManager;

    //constructor injection
    public EmployeeDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query - HQL
        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        return employees;
    }


    @Override
    public Employee findById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the employee
        Employee theEmployee = currentSession.get(Employee.class, theId);

        return theEmployee;
    }


    @Override
    public void save(Employee theEmployee) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //used saveOrUpdate, so it does both operations No need to write separately.
        currentSession.saveOrUpdate(theEmployee);
    }


    @Override
    public void deleteById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();
    }
}


