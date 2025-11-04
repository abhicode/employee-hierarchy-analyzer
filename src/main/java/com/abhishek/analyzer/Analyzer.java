package com.abhishek.analyzer;

import java.util.Collection;

import com.abhishek.models.Employee;

public interface Analyzer {
    void analyze(Collection<Employee> employees);
}

