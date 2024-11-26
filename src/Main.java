public class Main {
    private static Employee[] employees = new Employee[10];
    private static int employeeCount = 0;

    public static void main(String[] args) {
        addEmployee(new Employee("Иванов Иван Иванович", 1, 50000));
        addEmployee(new Employee("Петров Петр Петрович", 2, 55000));
        addEmployee(new Employee("Сидоров Сидор Сидорович", 3, 60000));
        addEmployee(new Employee("Алексеев Алексей Алексеевич", 4, 45000));
        addEmployee(new Employee("Николаев Николай Николаевич", 5, 70000));

        printAllEmployees();
        System.out.println("Сумма затрат на ЗП: " + getTotalSalary());
        System.out.println("Сотрудник с минимальной ЗП: " + getEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной ЗП: " + getEmployeeWithMaxSalary());
        System.out.println("Среднее значение зарплат: " + getAverageSalary());
        printEmployeeNames();
    }
    private static void addEmployee(Employee employee) {
        if (employeeCount < employees.length) {
            employees[employeeCount++] = employee;
        } else {
            System.out.println("Массив заполнен.");
        }
    }

    private static void printAllEmployees() {
        for (int i = 0; i < employeeCount; i++) {
            System.out.println(employees[i]);
        }
    }

    private static double getTotalSalary() {
        double total = 0;
        for (int i = 0; i < employeeCount; i++) {
            total += employees[i].getSalary();
        }
        return total;
    }

    private static Employee getEmployeeWithMinSalary() {
        if (employeeCount == 0) return null;
        Employee minSalaryEmployee = employees[0];

        for (int i = 1; i < employeeCount; i++) {
            if (employees[i].getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employees[i];
            }
        }
        return minSalaryEmployee;
    }

    private static Employee getEmployeeWithMaxSalary() {
        if (employeeCount == 0) return null;
        Employee maxSalaryEmployee = employees[0];

        for (int i = 1; i < employeeCount; i++) {
            if (employees[i].getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employees[i];
            }
        }
        return maxSalaryEmployee;
    }

    private static double getAverageSalary() {
        return getTotalSalary() / employeeCount;
    }
    private static void printEmployeeNames() {
        for (int i = 0; i < employeeCount; i++) {
            System.out.println(employees[i].getFullName());
        }
    }
}