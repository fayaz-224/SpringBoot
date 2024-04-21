package spring.dao;

import java.util.List;
import org.springframework.context.annotation.Primary;
import spring.entity.Employee;

@Primary
public interface EmployeeDAO {

    public Employee findById(int theId);

    public void save(Employee theEmployee);//Create or update

    public List<Employee> findAll();//Read

    public void deleteById(int theId);//Delete

}
