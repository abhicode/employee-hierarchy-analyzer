package com.abhishek;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.abhishek.analyzer.ReportingLineAnalyzer;
import com.abhishek.models.Employee;

public class ReportingLineAnalyzerTest {

    @Test
    public void testReportingLineTooLongPrinted() {
        Employee top = new Employee(1, "Top", "Manager", 10000.0, null);
        Employee e2 = new Employee(2, "E2", "X", 9000.0, 1);
        Employee e3 = new Employee(3, "E3", "X", 8000.0, 2);
        Employee e4 = new Employee(4, "E4", "X", 7000.0, 3);
        Employee e5 = new Employee(5, "E5", "X", 6000.0, 4);
        Employee e6 = new Employee(6, "E6", "X", 5000.0, 5);

        e2.setManager(top);
        e3.setManager(e2);
        e4.setManager(e3);
        e5.setManager(e4);
        e6.setManager(e5);

        Collection<Employee> list = new ArrayList<>();
        list.add(top);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);
        list.add(e6);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(baos));

        try {
            new ReportingLineAnalyzer().analyze(list);
        } finally {
            System.setOut(oldOut);
        }

        String out = baos.toString();
        assertTrue(out.contains("reporting line too long") || out.contains("too long"));
    }
}
