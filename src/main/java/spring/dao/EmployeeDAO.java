package spring.dao;

import java.util.List;
import org.springframework.context.annotation.Primary;
import spring.entity.Employee;

@Primary
public interface EmployeeDAO {

    public void save(Employee theEmployee);//Create

    public List<Employee> findAll();//Read

    public Employee findById(int theId);

    //used saveOrUpdate, so it does both operations No need to write separetly.

    public void deleteById(int theId);//Delete

}
