package com.abhishek.analyzer;

import java.util.Collection;

import com.abhishek.models.Employee;

public class ReportingLineAnalyzer implements Analyzer {
    @Override
    public void analyze(Collection<Employee> employees) {
        System.out.println("=== Reporting Line Analysis ===");
        for (Employee e : employees) {
            int chainLength = getChainLength(e);
            if (chainLength > 4) {
                System.out.printf("%s has reporting line too long by %d levels%n",
                        e.getFullName(), chainLength - 4);
            }
        }
    }

    private int getChainLength(Employee e) {
        int count = 0;
        Employee curr = e.getManager();
        while (curr != null) {
            count++;
            curr = curr.getManager();
        }
        return count;
    }
}
