# Employee Hierarchy Analyzer

A Java application that analyzes employee hierarchies, reporting lines, and salary distributions from CSV data.

## Technology Stack

- **Java**: JDK 21 (Latest LTS)
- **Build Tool**: Apache Maven 3.x
- **Dependencies**:
  - OpenCSV 5.7.1: CSV file parsing
  - Lombok 1.18.32: Boilerplate code reduction
  - JUnit 4.11: Testing framework

## Project Structure

```
src/
├── main/java/com/abhishek/
│   ├── analyzer/          # Analysis implementations
│   ├── models/           # Domain models (Employee)
│   ├── repo/             # Data access (CSV loading)
│   ├── service/          # Business logic
│   └── App.java          # Application entry point
└── test/java/com/abhishek/
    └── *Test.java        # Unit tests
```

## Features

- Loads employee data from CSV files
- Analyzes manager-subordinate salary ratios
- Detects long reporting lines (>4 levels)
- Outputs analysis results to console

## Getting Started

### Prerequisites
- JDK 21 or later
- Maven 3.x

### Building
```bash
mvn clean install
```

### Running
```bash
mvn exec:java -Dexec.mainClass="com.abhishek.App"
```

## Testing
Run the test suite with:
```bash
mvn test
```
