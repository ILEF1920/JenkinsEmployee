package com.example.service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    private final EmployeeRepository repository = mock(EmployeeRepository.class);
    private final EmployeeService service = new EmployeeService(repository);

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = Arrays.asList(new Employee(1L, "John Doe", "Developer"));
        when(repository.findAll()).thenReturn(employees);

        List<Employee> result = service.getAllEmployees();

        assertEquals(1, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testAddEmployee() {
        Employee employee = new Employee(null, "Jane Doe", "Manager");
        when(repository.save(employee)).thenReturn(new Employee(1L, "Jane Doe", "Manager"));

        Employee result = service.addEmployee(employee);

        assertNotNull(result.getId());
        assertEquals("Jane Doe", result.getName());
        verify(repository, times(1)).save(employee);
    }
}
