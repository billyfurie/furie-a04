package baseline;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution42Test {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesGetFormattedStringFromList.csv", numLinesToSkip = 1)
    void getFormattedStringFromList(String firstName, String lastName, int salary) {
        Solution42 solution = new Solution42();

        // create a list of employee
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee(firstName, lastName, salary);

        employees.add(employee);

        // build our expected output
        String header = String.format("%-10s%-10s%-7s%n", "Last", "First", "Salary");
        String divider = "--------------------------\n";

        StringBuilder expected = new StringBuilder();
        expected.append(header);
        expected.append(divider);

        expected.append(String.format("%-10s%-10s%-7s%n", employee.getLastName(), employee.getFirstName(),
                employee.getSalary()));

        // get our actual output
        String actual = solution.getFormattedStringFromList(employees);

        // make sure they are the same
        assertEquals(expected.toString(), actual);
    }
}