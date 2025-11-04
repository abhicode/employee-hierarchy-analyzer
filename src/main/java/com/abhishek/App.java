package com.abhishek;

import java.util.Arrays;

import com.abhishek.analyzer.ManagerSalaryAnalyzer;
import com.abhishek.analyzer.ReportingLineAnalyzer;
import com.abhishek.repo.EmployeeRepository;
import com.abhishek.service.EmployeeAnalyzerService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        try {
            String filePath = "src/main/resources/employees.csv";

            EmployeeRepository repo = new EmployeeRepository();
            repo.loadFromCSV(filePath);

            EmployeeAnalyzerService service = new EmployeeAnalyzerService(
                    Arrays.asList(
                            new ManagerSalaryAnalyzer(),
                            new ReportingLineAnalyzer()
                    )
            );
            service.runAnalysis(repo.findAll());
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
}
