package com.abhishek;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.util.Collection;

import org.junit.Test;

import com.abhishek.models.Employee;
import com.abhishek.repo.EmployeeRepository;

public class EmployeeRepositoryTest {

    @Test
    public void testLoadFromCSVAndLinking() throws Exception {
        File temp = File.createTempFile("employees", ".csv");
        temp.deleteOnExit();

        try (FileWriter w = new FileWriter(temp)) {
            w.write("id,firstName,lastName,salary,managerId\n");
            w.write("1,Manager,One,5000,\n");
            w.write("2,Sub,Employee,2000,1\n");
        }

        EmployeeRepository repo = new EmployeeRepository();
        repo.loadFromCSV(temp.getAbsolutePath());

        Collection<Employee> all = repo.findAll();
        assertEquals(2, all.size());

        Employee manager = null;
        Employee subordinate = null;
        for (Employee e : all) {
            if (e.getId() == 1) manager = e;
            if (e.getId() == 2) subordinate = e;
        }

        assertNotNull(manager);
        assertNotNull(subordinate);
        assertEquals(manager, subordinate.getManager());
        assertTrue(manager.getSubordinates().contains(subordinate));
    }
}
