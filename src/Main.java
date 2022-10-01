public class Main {
    public static void main(String[] args) {

        Employee[] employeeBook = new Employee[10];
        EmployeeBook eBook = new EmployeeBook(employeeBook);
        employeeBook[0] = new Employee("Федотов А. Е.", 4, 15_000);
        employeeBook[1] = new Employee("Федотова Л. А.", 4, 17_000);
        employeeBook[2] = new Employee("Федосеев А. Е.", 1, 18_000);
        employeeBook[3] = new Employee("Федоров П. К.", 2, 25_000);
        employeeBook[4] = new Employee("Асмодеев А. Е.", 5, 45_000);
        //  employeeBook[5] = new Employee("Туранов А. Е.", 5, 85_000);
        employeeBook[6] = new Employee("Кревеня У. Е.", 3, 18_500);
        employeeBook[7] = new Employee("Прухлов П. П.", 3, 5_000);
        employeeBook[8] = new Employee("Амеба Е. Е.", 4, 19_400);
        employeeBook[9] = new Employee("Федотов А. Е.", 4, 15_000);
        printEmployeesInfo(employeeBook);
        printEmployeesName(employeeBook);
        System.out.println("Работник с минимальной зарплатой: " + getMinSalaryEmployee(employeeBook));
        System.out.println("Работник с максимальной зарплатой: " + getMaxSalaryEmployee(employeeBook));
        System.out.println("Общая зарплата:" + getTotalSalary(employeeBook));
        System.out.println("Средняя зарплата:" + getAverageSalary(employeeBook));
        System.out.println(getAverageSalaryFromDepartment(employeeBook, 5));
        printEmployeesFromDepartment(employeeBook, 3);


        System.out.println("Проверка методов");
        double averageSalary = eBook.getAverageSalary();
        System.out.println(averageSalary);
        eBook.printEmployeesInfo();
    }

    public static void printEmployeesInfo(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null)
                System.out.println(employees[i]);
        }
    }

    public static double getTotalSalary(Employee[] employees) {
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null)
                totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

    public static Employee getMinSalaryEmployee(Employee[] employees) {
        double minSalary = Double.MAX_VALUE;
        Employee target = null;
        for (Employee employee : employees) {
            if (employee != null)
                if (minSalary > employee.getSalary()) {
                    target = employee;
                    minSalary = employee.getSalary();
                }
        }
        return target;
    }

    public static Employee getMaxSalaryEmployee(Employee[] employees) {
        double maxSalary = 0;
        Employee target = null;
        for (Employee employee : employees) {
            if (employee != null)
                if (maxSalary < employee.getSalary()) {
                    target = employee;
                    maxSalary = employee.getSalary();
                }
        }
        return target;
    }

    public static double getAverageSalary(Employee[] employees) {
        int employeesNum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                employeesNum++;
            }
        }
        return getTotalSalary(employees) / employeesNum;
    }

    public static void printEmployeesName(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null)
                System.out.println(employee.getName());
        }
    }

    public static void indexSalaryAllEmployees(Employee[] employees, double percent) {
        for (Employee employee : employees) {
            if (employee != null)
                employee.setSalary(employee.getSalary() * (1 + percent / 100));
        }
    }

    public static Employee getMinSalaryEmployeeFromDepartment(Employee[] employees, int department) {
        double minSalary = Integer.MAX_VALUE;
        Employee target = null;
        for (Employee employee : employees) {
            if (employee != null)
                if (employee.getDepartment() == department) {
                    if (minSalary > employee.getSalary()) {
                        minSalary = employee.getSalary();
                        target = employee;
                    }
                }
        }
        return target;
    }

    public static Employee getMaxSalaryEmployeeFromDepartment(Employee[] employees, int department) {
        double maxSalary = 0;
        Employee target = null;
        for (Employee employee : employees) {
            if (employee != null)
                if (employee.getDepartment() == department) {
                    if (maxSalary < employee.getSalary()) {
                        maxSalary = employee.getSalary();
                        target = employee;
                    }
                }
        }
        if (maxSalary == 0) {
            throw new IllegalArgumentException("В отделе нет ни одного работника");
        }
        return target;
    }

    public static double getTotalSalaryFromDepartment(Employee[] employees, int department) {
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null)
                if (employee.getDepartment() == department) {
                    totalSalary += employee.getSalary();
                }
        }
        if (totalSalary == 0) {
            throw new IllegalArgumentException("В отделе нет ни одного работника");
        }
        return totalSalary;
    }

    public static double getAverageSalaryFromDepartment(Employee[] employees, int department) {
        double total = getTotalSalaryFromDepartment(employees, department);
        int employeeNum = 0;
        for (Employee employee : employees) {
            if (employee != null)
                if (employee.getDepartment() == department) {
                    employeeNum++;
                }
        }
        return total / employeeNum;
    }

    public static void indexSalaryEmployersFromDepartment(Employee[] employees, int department, double percent) {
        for (Employee employee : employees) {
            if (employee != null)
                if (employee.getDepartment() == department) {
                    employee.setSalary(employee.getSalary() * (1 + percent / 100));
                }
        }
    }

    public static void printEmployeesFromDepartment(Employee[] employees, int department) {
        for (Employee employee : employees) {
            if (employee != null)
                if (employee.getDepartment() == department) {
                    System.out.println(employee.toString().replace("Работает в отделе №" + department + ". ", ""));
                }
        }
    }

    public static void printEmployeesSalaryBelowThreshold(Employee[] employees, double threshold) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSalary() < threshold) {
                    System.out.println(employee.toString().replace("Работает в отделе №" + employee.getDepartment() + ". ", ""));
                }
            }
        }
    }

    public static void printEmployeesSalaryAboveThreshold(Employee[] employees, double threshold) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSalary() > threshold) {
                    System.out.println(employee.toString().replace("Работает в отделе №" + employee.getDepartment() + ". ", ""));
                }
            }
        }
    }
}