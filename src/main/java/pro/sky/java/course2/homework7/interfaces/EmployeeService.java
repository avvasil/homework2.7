package pro.sky.java.course2.homework7.interfaces;

import pro.sky.java.course2.homework7.classes.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> getListOfEmployees();
}
