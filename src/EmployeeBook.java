public class EmployeeBook {
    private Employee[] employees;


    //Базовый конструктор
    public EmployeeBook(int bookSize) {
        employees = new Employee[bookSize];
    }

    //Баз. слож. пункт 8.А
    // Print information about employees
    public void printEmployeesInfo() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    //Баз. слож. пункт 8.B
    //Calculation total salary
    public double getTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    //Баз. слож. пункт 8.C
    //Search employee with minimal salary
    public Employee findEmployeeWithMinSalary() {
        double minSalary = Double.MAX_VALUE;
        Employee target = null;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (minSalary > employee.getSalary()) {
                target = employee;
                minSalary = employee.getSalary();
            }

        }
        return target;
    }

    //Баз. слож. пункт 8.D
    //Search employee with maximal salary
    public Employee findEmployeeWithMaxSalary() {
        double maxSalary = 0;
        Employee target = null;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (maxSalary < employee.getSalary()) {
                target = employee;
                maxSalary = employee.getSalary();
            }

        }
        return target;
    }

    //Баз. слож. пункт 8.E
    //Calculation employees average salary
    public double getAverageSalary() {
        int employeesNum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                employeesNum++;
            }
        }
        return getTotalSalary() / employeesNum;
    }

    //Баз. слож. пункт 8.F
    public void printNamesEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getName());
            }
        }
    }

    //Повыш. слож. пункт 1
    //Index salary of employees
    public void indexSalaryEmployees(double percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * (1 + percent / 100));
            }
        }
    }

    //Повыш. слож. пункт 2.A
    //Search employee with minimal salary of department
    public Employee findEmployeeWithMinSalaryOfDepartment(int department) {
        double minSalary = Integer.MAX_VALUE;
        Employee target = null;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDepartment() == department && minSalary > employee.getSalary()) {
                minSalary = employee.getSalary();
                target = employee;
            }
        }
        if (minSalary == 0) {
            throw new IllegalArgumentException("В отделе нет ни одного работника");
        }
        return target;
    }

    //Повыш. слож. пункт 2.B
    //Search employee with minimal salary of department
    public Employee findEmployeeWithMaxSalaryOfDepartment(int department) {
        double maxSalary = 0;
        Employee target = null;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDepartment() == department && maxSalary < employee.getSalary()) {
                maxSalary = employee.getSalary();
                target = employee;
            }
        }
        if (maxSalary == 0) {
            throw new IllegalArgumentException("В отделе нет ни одного работника");
        }
        return target;
    }

    //Повыш. слож. пункт 2.C
    //Search employees total salary of department
    public double getTotalSalaryFromDepartment(int department) {
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDepartment() == department) {
                totalSalary += employee.getSalary();
            }
        }
        if (totalSalary == 0) {
            throw new IllegalArgumentException("В отделе нет ни одного работника");
        }
        return totalSalary;
    }

    //Повыш. слож. пункт 2.D
    //Search employee with minimal salary of department
    public double getAverageSalaryFromDepartment(int department) {
        double total = getTotalSalaryFromDepartment(department);
        int employeeNum = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDepartment() == department) {
                employeeNum++;
            }
        }
        if (employeeNum == 0) {
            throw new IllegalArgumentException("В отделе нет ни одного работника");
        }
        return total / employeeNum;
    }

    //Повыш. слож. пункт 2.E
    //Index salary employee of department
    public void indexSalaryEmployeesOfDepartment(int department, double percent) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() * (1 + percent / 100));
            }
        }
    }

    //Повыш. слож. пункт 2.F
    //Print information of department employees
    public void printEmployeesOfDepartment(int department) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDepartment() == department) {
                System.out.println(employee.toString().replace("Работает в отделе №" + department + ". ", ""));
            }

        }
    }

    //Повыш. слож. пункт 3.A
    //Print information of employee with salary below threshold
    public void printEmployeesSalaryBelowThreshold(double threshold) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() < threshold) {
                System.out.println(employee.toString().replace("Работает в отделе №" + employee.getDepartment() + ". ", ""));
            }

        }
    }

    //Повыш. слож. пункт 2.B
    //Print information of employee with salary above threshold
    public void printEmployeesSalaryAboveThreshold(double threshold) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() > threshold) {
                System.out.println(employee.toString().replace("Работает в отделе №" + employee.getDepartment() + ". ", ""));
            }
        }

    }

    //Очень сложно пункт 4.А
    //add new employee to data or create new employee use params
    public void addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return;
            }
        }
        throw new IllegalArgumentException("В базе данных (employees) сотрудника не хватает места");
    }

    public void addEmployee(String name, int department, double salary) {
        Employee employee = new Employee(name, department, salary);
        addEmployee(employee);
    }

    //Очень сложно пункт 4.B
    //remove employee from data using name or id
    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getId() == id) {
                employees[i] = null;
                return;
            }
        }
        throw new IndexOutOfBoundsException("В базе данных (employees) нет сотрудника с таким ID" + id);
    }

    public void removeEmployee(String employeeName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getName().equals(employeeName)) {
                employees[i] = null;
                return;
            }
        }
        throw new IllegalArgumentException("В базе данных (employees) нет сотрудника с таким именем" + employeeName);
    }

    //Очень сложно пункт 5.A
    //Change employee salary
    public void changeSalaryEmployee(String employeeName, double salary) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getName().equals(employeeName)) {
                employee.setSalary(salary);
                return;
            }
        }
    }

    //Очень сложно пункт 5.B
    //Change employee department
    public void changeDepartmentEmployee(String employeeName, int department) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getName().equals(employeeName)) {
                employee.setDepartment(department);
                return;
            }
        }
    }

    //Оень сложно пункт 6.
    //Print employees sorted by Departments
    public void printEmployeesSortedByDepartments() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Список сотрудников из отдела № " + i);
            printEmployeesOfDepartment(i);
        }
    }

}
