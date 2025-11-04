package com.abhishek.analyzer;

import java.util.Collection;

import com.abhishek.models.Employee;

public class ManagerSalaryAnalyzer implements Analyzer {
    @Override
    public void analyze(Collection<Employee> employees) {
        System.out.println("=== Manager Salary Analysis ===");
        for (Employee e : employees) {
            if (e.getSubordinates().isEmpty()) continue;

            double avgSubSalary = e.getSubordinates()
                                .stream()
                                .mapToDouble(Employee::getSalary)
                                .average()
                                .orElse(0);

            double expectedMinSalary = avgSubSalary * 1.2;
            double expectedMaxSalary = avgSubSalary * 1.5;

            if (e.getSalary() < expectedMinSalary) {
                System.out.printf("Manager %s earns LESS by $%.2f%n", e.getFullName(), expectedMinSalary - e.getSalary());
            } else if (e.getSalary() > expectedMaxSalary) {
                System.out.printf("Manager %s earns MORE by $%.2f%n", e.getFullName(), e.getSalary() - expectedMaxSalary);
            }
        }
    }
}
