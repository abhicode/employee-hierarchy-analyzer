package com.abhishek.models;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private double salary;
    private Integer managerId;
    private Employee manager;
    private List<Employee> subordinates = new ArrayList<>();

    public Employee(int id, String firstName, String lastName, double salary, Integer managerId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.managerId = managerId;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Getters and setters
    public int getId() { return id; }
    public double getSalary() { return salary; }
    public Integer getManagerId() { return managerId; }
    public Employee getManager() { return manager; }
    public void setManager(Employee manager) { this.manager = manager; }
    public List<Employee> getSubordinates() { return subordinates; }

    @Override
    public String toString() {
        return id + " - " + getFullName() + " ($" + salary + ")";
    }
}
