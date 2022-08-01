package net.guides.springboot2.springboot2jpacrudexample.service;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public ResponseEntity<Employee> getEmployeeById(Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :" + employeeId));
        return ResponseEntity.ok(employee);
    }

    public ResponseEntity<Employee> createEmployee(Employee employee) {
        Employee employeecreate = employeeRepository.save(employee);
        return ResponseEntity.ok(employeecreate);
    }


    public ResponseEntity<Employee> updateEmployee(Long employeeId, Employee employeeDetails) throws ResourceNotFoundException {
        Employee employeeUpdate = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id : " + employeeId));
        employeeUpdate.setEmailId(employeeDetails.getEmailId());
        employeeUpdate.setLastName(employeeDetails.getLastName());
        employeeUpdate.setFirstName(employeeDetails.getFirstName());
        Employee updatedEmployee = employeeRepository.save(employeeUpdate);
        return ResponseEntity.ok(updatedEmployee);
    }

    public ResponseEntity<Map<String, Boolean>> deleteEmployee(Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :" + employeeId));
        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<String, Boolean>(){{
            put("deleted",Boolean.TRUE);
        }};
        return ResponseEntity.ok(response);
    }
}