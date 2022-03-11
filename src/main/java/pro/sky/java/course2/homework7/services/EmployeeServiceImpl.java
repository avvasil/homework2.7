package pro.sky.java.course2.homework7.services;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework7.classes.Employee;
import pro.sky.java.course2.homework7.classes.EmployeeAlreadyExistsException;
import pro.sky.java.course2.homework7.classes.EmployeeNotFoundException;
import pro.sky.java.course2.homework7.interfaces.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeesMap = new HashMap<>();

    @Override
    public Collection<Employee> getListOfEmployees() {
        Collection<Employee> employeeList;
        employeeList = employeesMap.values();
        return employeeList;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee addingEmployee = new Employee(firstName, lastName);
        String key = firstName + lastName;
        if (employeesMap.containsKey(key)) {
            throw new EmployeeAlreadyExistsException("Этот работник уже добавлен");
        }
        employeesMap.put(key, addingEmployee);
        return addingEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        String key = firstName + lastName;
        if (!employeesMap.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
        return employeesMap.remove(key);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String key = firstName + lastName;
        if (!employeesMap.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
        return employeesMap.get(key);
    }
}