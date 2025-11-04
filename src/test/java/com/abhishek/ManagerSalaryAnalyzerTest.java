package com.abhishek;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.abhishek.analyzer.ManagerSalaryAnalyzer;
import com.abhishek.models.Employee;

public class ManagerSalaryAnalyzerTest {

    @Test
    public void testManagerSalaryAnalysisPrintsWarning() {
        Employee manager = new Employee(1, "Mgr", "One", 1000.0, null);
        Employee sub1 = new Employee(2, "A", "B", 1000.0, 1);
        Employee sub2 = new Employee(3, "C", "D", 1000.0, 1);

        sub1.setManager(manager);
        sub2.setManager(manager);
        manager.getSubordinates().add(sub1);
        manager.getSubordinates().add(sub2);

        Collection<Employee> list = new ArrayList<>();
        list.add(manager);
        list.add(sub1);
        list.add(sub2);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(baos));

        try {
            new ManagerSalaryAnalyzer().analyze(list);
        } finally {
            System.setOut(oldOut);
        }

        String out = baos.toString();
        assertTrue(out.contains("LESS"));
    }
}
