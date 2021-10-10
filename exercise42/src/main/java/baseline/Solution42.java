/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Solution42 {

    public static void main(String[] args) {
        Solution42 solution = new Solution42();

        // parse the input and get an employee list
        List<Employee> employees = solution.readEmployeeListFromFile();

        // display the employee list formatted
        solution.displayEmployeeList(employees);
    }

    private List<Employee> readEmployeeListFromFile() {
        List<Employee> employees = new ArrayList<>();

        // check that the file exists
        // open and parse through the file
        try (Scanner input = new Scanner(Paths.get("data/exercise42_input.txt"))) {
            while (input.hasNext()) {
                // read the file, using a comma as a delimiter
                // each value is comma separated, linebreak for each employee
                // this also supports csv with spaces after the comma
                input.useDelimiter(",\\p{javaWhitespace}*|\\R");

                // file must have a first name, last name, and a salary
                String last = input.next();
                String first = input.next();
                int salary = input.nextInt();

                // convert each line to an employee object
                Employee employee = new Employee(first, last, salary);
                // add employee to list
                employees.add(employee);
            }
        } catch (IOException | NoSuchElementException | IllegalStateException e) {
            e.printStackTrace();
        }

        // return the list of employees
        return employees;
    }

    private void displayEmployeeList(List<Employee> employees) {
        // get formatted string of the list
        String displayMessage = getFormattedStringFromList(employees);

        // display the formatted string to the console
        System.out.print(displayMessage);
    }

    public String getFormattedStringFromList(List<Employee> employees) {
        // use the header format as provided
        String header = String.format("%-10s%-10s%-7s%n", "Last", "First", "Salary");
        String divider = "--------------------------\n";

        // use StringBuilder to append each employee row
        StringBuilder employeeListFormatted = new StringBuilder();
        employeeListFormatted.append(header);
        employeeListFormatted.append(divider);

        // add each of the employees to the StringBuilder
        for (Employee employee : employees) {
            String first = employee.getFirstName();
            String last = employee.getLastName();
            int salary = employee.getSalary();

            employeeListFormatted.append(String.format("%-10s%-10s%-7s%n", last, first, salary));
        }

        // return a String that has been formatted in a table format
        return employeeListFormatted.toString();
    }
}
