package spring.dao;

import java.util.List;
import org.springframework.context.annotation.Primary;
import spring.entity.Employee;

public interface EmployeeDAO {  //without implementing JPARepository

    public Employee findById(int theId);

    public void save(Employee theEmployee);//Create or update

    public List<Employee> findAll();//Read

    public void deleteById(int theId);//Delete

}
