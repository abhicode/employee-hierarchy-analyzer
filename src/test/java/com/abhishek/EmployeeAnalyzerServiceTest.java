package com.abhishek;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.abhishek.analyzer.Analyzer;
import com.abhishek.models.Employee;
import com.abhishek.service.EmployeeAnalyzerService;

public class EmployeeAnalyzerServiceTest {

    @Test
    public void testAnalyzersAreInvoked() {
        final boolean[] invoked = new boolean[] { false, false };

        Analyzer a1 = new Analyzer() {
            @Override
            public void analyze(Collection<Employee> employees) {
                invoked[0] = true;
            }
        };

        Analyzer a2 = new Analyzer() {
            @Override
            public void analyze(Collection<Employee> employees) {
                invoked[1] = true;
            }
        };

        EmployeeAnalyzerService svc = new EmployeeAnalyzerService(List.of(a1, a2));
        svc.runAnalysis(new ArrayList<>());

        assertTrue(invoked[0]);
        assertTrue(invoked[1]);
    }
}
