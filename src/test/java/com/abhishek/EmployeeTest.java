package com.abhishek;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.abhishek.models.Employee;

public class EmployeeTest {

    @Test
    public void testGetFullName() {
        Employee e = new Employee(1, "John", "Doe", 1000.0, null);
        assertEquals("John Doe", e.getFullName());
    }

    @Test
    public void testToStringContainsIdNameAndSalary() {
        Employee e = new Employee(42, "Jane", "Smith", 2500.5, null);
        String s = e.toString();
        assertEquals(true, s.contains("42"));
        assertEquals(true, s.contains("Jane Smith"));
        assertEquals(true, s.contains("2500.5") || s.contains("2500.50") );
    }
}
