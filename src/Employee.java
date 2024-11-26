import java.util.Objects;

public class Employee {

    private static int idCounter = 1;
    private final int id;
    private String fullName;
    private int department;
    private double salary;

    public Employee(String fullName, int department, double salary) {
        this.id = idCounter++;
        this.fullName = fullName;
        setDepartment(department);
        setSalary(salary);
    }
    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }


    public int getDepartment() {
        return department;
    }


    public double getSalary() {
        return salary;
    }


    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Отдел должен быть от 1 до 5");
        }
        this.department = department;
    }


    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        }
        this.salary = salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                department == employee.department &&
                Double.compare(employee.salary, salary) == 0 &&
                fullName.equals(employee.fullName);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, department, salary);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", fullName='" + fullName + '\'' + ", department=" + department + ", salary=" + salary;


    }
}