public class EmployeeBook {
    private Employee[] employees;

    public EmployeeBook(Employee[] employees) {
        this.employees = employees;
    }

    public void printEmployeesInfo() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i]);
            }
        }
    }

    public double getTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    public Employee getMinSalaryEmployee() {
        double minSalary = Double.MAX_VALUE;
        Employee target = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (minSalary > employee.getSalary()) {
                    target = employee;
                    minSalary = employee.getSalary();
                }
            }
        }
        return target;
    }

    public Employee getMaxSalaryEmployee() {
        double maxSalary = 0;
        Employee target = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (maxSalary < employee.getSalary()) {
                    target = employee;
                    maxSalary = employee.getSalary();
                }
            }
        }
        return target;
    }

    public double getAverageSalary() {
        int employeesNum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                employeesNum++;
            }
        }
        return getTotalSalary() / employeesNum;
    }

    public void printEmployeesName() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getName());
            }
        }
    }

    public void indexSalaryAllEmployees(double percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * (1 + percent / 100));
            }
        }
    }

    public Employee getMinSalaryEmployeeFromDepartment(int department) {
        double minSalary = Integer.MAX_VALUE;
        Employee target = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartment() == department) {
                    if (minSalary > employee.getSalary()) {
                        minSalary = employee.getSalary();
                        target = employee;
                    }
                }
            }
        }
        return target;
    }

    public Employee getMaxSalaryEmployeeFromDepartment(int department) {
        double maxSalary = 0;
        Employee target = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartment() == department) {
                    if (maxSalary < employee.getSalary()) {
                        maxSalary = employee.getSalary();
                        target = employee;
                    }
                }
            }
        }
        if (maxSalary == 0) {
            throw new IllegalArgumentException("В отделе нет ни одного работника");
        }
        return target;
    }

    public double getTotalSalaryFromDepartment(int department) {
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartment() == department) {
                    totalSalary += employee.getSalary();
                }
            }
        }
        if (totalSalary == 0) {
            throw new IllegalArgumentException("В отделе нет ни одного работника");
        }
        return totalSalary;
    }

    public double getAverageSalaryFromDepartment(int department) {
        double total = getTotalSalaryFromDepartment(department);
        int employeeNum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartment() == department) {
                    employeeNum++;
                }
            }
        }
        return total / employeeNum;
    }

    public void indexSalaryEmployersFromDepartment(int department, double percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartment() == department) {
                    employee.setSalary(employee.getSalary() * (1 + percent / 100));
                }
            }
        }
    }

    public void printEmployeesFromDepartment(int department) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartment() == department) {
                    System.out.println(employee.toString().replace("Работает в отделе №" + department + ". ", ""));
                }
            }
        }
    }

    public void printEmployeesSalaryBelowThreshold(double threshold) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSalary() < threshold) {
                    System.out.println(employee.toString().replace("Работает в отделе №" + employee.getDepartment() + ". ", ""));
                }
            }
        }
    }

    public void printEmployeesSalaryAboveThreshold(double threshold) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSalary() > threshold) {
                    System.out.println(employee.toString().replace("Работает в отделе №" + employee.getDepartment() + ". ", ""));
                }
            }
        }
    }
}
