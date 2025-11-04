package com.abhishek.service;

import java.util.Collection;
import java.util.List;

import com.abhishek.analyzer.Analyzer;
import com.abhishek.models.Employee;

public class EmployeeAnalyzerService {
    private final List<Analyzer> analyzers;

    public EmployeeAnalyzerService(List<Analyzer> analyzers) {
        this.analyzers = analyzers;
    }

    public void runAnalysis(Collection<Employee> employees) {
        analyzers.forEach(a -> a.analyze(employees));
    }
}
