package spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.entity.Employee;
import spring.exception.EmployeeNotFoundException;
import spring.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class HomeController {

    private EmployeeService employeeService;

    @Autowired    //constructor injection
    public HomeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    //intro
    @GetMapping("/welcome")
    public String demo() {
        return "Hi, WELCOME to my project :)";
    }


    //Getting all the emp's
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }


    //getting an emp by ID
    @GetMapping("/employees/{Id}")
    public Employee getEmployee(@PathVariable("Id") int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new EmployeeNotFoundException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }


    // add or Save new employee
    @PostMapping("/employees")    //in POSTMAN-->Body-->Raw & Text=JSON(application/json) and send data
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        // also just in case they pass an id in JSON, set id to 0. This is to force a save of new item, instead of update
        theEmployee.setId(0); //if ID=0, then save ...else update (shown in next method)
        employeeService.save(theEmployee);

        return theEmployee;
    }


    // update existing employee
    @PutMapping("/employees")    //in POSTMAN-->Body-->Raw & Text=JSON(application/json) and send data along with "Id"
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        employeeService.save(theEmployee);
        return theEmployee;
    }


    //delete employee
    @DeleteMapping("/employees/{Id}")
    public String deleteEmployee(@PathVariable("Id") int employeeId) {

        Employee tempEmployee = employeeService.findById(employeeId);

        // throw exception if null
        if (tempEmployee == null) {
            throw new EmployeeNotFoundException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }

}