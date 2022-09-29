public class Employee {
    private static int ID_COUNT;
    private String name;
    private int department;
    private double salary;
    private int id;

    public Employee(String name, int department, double salary) {
        this.id = ID_COUNT++;
        this.name = name;
        setDepartment(department);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        if (department > 0 && department <= 5) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Ввели неверный отдел. Всего существует 5 отделов с именем: от 1 до 5.");
        }
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной.");
        }
    }

    @Override
    public String toString() {
        String info = "Сотрудник ID: " + id + "\nФИО: " + name
                + "\nРаботает в отделе №" + department + ". Зарплата составляет " + salary + " руб.";
        return info;
    }
}
