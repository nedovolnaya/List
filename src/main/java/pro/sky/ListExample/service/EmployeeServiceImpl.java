package pro.sky.ListExample.service;

import org.springframework.stereotype.Service;
import pro.sky.ListExample.Employee;
import pro.sky.ListExample.exception.EmployeeAlreadyAddedException;
import pro.sky.ListExample.exception.EmployeeNotFoundException;
import pro.sky.ListExample.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    public static final int EMPLOYEE_MAX_COUNT = 10;
    private final List<Employee> employees;

    public EmployeeServiceImpl(List<Employee> employees) {
        this.employees = new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {

        if (employees.size() >= EMPLOYEE_MAX_COUNT) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName);

        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public List<Employee> findAll() {
        return List.copyOf(employees);
    }
}
