package com.abhishek.repo;

import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.abhishek.models.Employee;
import com.opencsv.CSVReader;

public class EmployeeRepository {
    private Map<Integer, Employee> employees = new HashMap<>();

    public void loadFromCSV(String filePath) throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            reader.readNext(); // skip header

            while ((line = reader.readNext()) != null) {
                int id = Integer.parseInt(line[0]);
                String firstName = line[1];
                String lastName = line[2];
                double salary = Double.parseDouble(line[3]);
                Integer managerId = line.length > 4 && !line[4].isEmpty()
                        ? Integer.parseInt(line[4])
                        : null;

                employees.put(id, new Employee(id, firstName, lastName, salary, managerId));
            }
        }

        for (Employee e : employees.values()) {
            if (e.getManagerId() != null) {
                Employee manager = employees.get(e.getManagerId());
                e.setManager(manager);
                manager.getSubordinates().add(e);
            }
        }
    }

    public Collection<Employee> findAll() {
        return employees.values();
    }
}
