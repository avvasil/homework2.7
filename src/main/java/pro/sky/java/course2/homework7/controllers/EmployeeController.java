package pro.sky.java.course2.homework7.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.homework7.classes.Employee;
import pro.sky.java.course2.homework7.services.EmployeeServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping(path = "/list")
    public Collection<Employee> getListOfEmployees() {
        return employeeServiceImpl.getListOfEmployees();
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeServiceImpl.addEmployee(firstName, lastName);
        return employee;

    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        Employee removedEmployee = new Employee(firstName, lastName);
        employeeServiceImpl.removeEmployee(firstName, lastName);
        return removedEmployee;
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        Employee foundEmployee = new Employee(firstName, lastName);
        employeeServiceImpl.findEmployee(firstName, lastName);
        return foundEmployee;
    }

}
