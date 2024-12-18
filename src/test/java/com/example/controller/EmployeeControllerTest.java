package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

    private final EmployeeService service = mock(EmployeeService.class);
    private final EmployeeController controller = new EmployeeController(service);

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = Arrays.asList(new Employee(1L, "John Doe", "Developer"));
        when(service.getAllEmployees()).thenReturn(employees);

        ResponseEntity<List<Employee>> response = controller.getAllEmployees();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void testAddEmployee() {
        Employee employee = new Employee(null, "Jane Doe", "Manager");
        when(service.addEmployee(employee)).thenReturn(new Employee(1L, "Jane Doe", "Manager"));

        ResponseEntity<Employee> response = controller.addEmployee(employee);

        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody().getId());
    }
}
