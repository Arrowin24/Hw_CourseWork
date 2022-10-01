public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook(10);
        employeeBook.addEmployee(new Employee("Федотов А. Е.", 4, 10_000));
        employeeBook.addEmployee(new Employee("Федотова Л. А.", 4, 20_000));
        employeeBook.addEmployee(new Employee("Федотова Л. А.", 4, 20_000));
        employeeBook.addEmployee( new Employee("Федосеев А. Е.", 1, 30_000));
        employeeBook.addEmployee(new Employee("Федоров П. К.", 2, 40_000));
        employeeBook.addEmployee(new Employee("Асмодеев А. Е.", 5, 50_000));
        employeeBook.addEmployee(new Employee("Кревеня У. Е.", 3, 60_000));
        employeeBook.addEmployee(new Employee("Прухлов П. П.", 3, 70_000));
        employeeBook.addEmployee(new Employee("Амеба Е. Е.", 4, 80_000));
        employeeBook.addEmployee(new Employee("Федотов А. Е.", 4, 90_000));

        testMethods(employeeBook);
    }

    public static void testMethods(EmployeeBook employeeBook){
        System.out.println("Проверка методов базовой сложности");
        employeeBook.printEmployeesInfo();
        System.out.println("Сумма затрат на зарплаты на месяц:"+employeeBook.getTotalSalary());
        System.out.println("Сотрудник с минимальной зарплатой:"+employeeBook.findEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной зарплатой:"+employeeBook.findEmployeeWithMaxSalary());
        System.out.println("Средняя зарплата на предприятии: "+employeeBook.getAverageSalary());
        System.out.println("Печать всех имет сотрудников: ");
        employeeBook.printNamesEmployees();
        System.out.println("-------------------------------------------------------------");

        System.out.println("Проверка методов повышенной сложности");
        System.out.println("Индексация зарплат на 10%");
        employeeBook.indexSalaryEmployees(10);
        System.out.println("Вывод сотрудника с минимальной зп после индексации: "+employeeBook.findEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной зп после индексации: "+employeeBook.findEmployeeWithMaxSalary());
        System.out.println("Сотрудник с минимальной зарплатой в 3 отделе: "+employeeBook.findEmployeeWithMinSalaryOfDepartment(3));
        System.out.println("Сотрудник с максимальной зарплатой в 3 отделе: "+employeeBook.findEmployeeWithMaxSalaryOfDepartment(3));
        System.out.println("Сумма затрат на зарплату в 3 отделе: "+employeeBook.getTotalSalaryFromDepartment(3));
        System.out.println("Средняя зарплата в 3 отделе: "+employeeBook.getAverageSalaryFromDepartment(3));
        System.out.println("Индексация зарплат на 20% в 3 отделе");
        employeeBook.indexSalaryEmployeesOfDepartment(3,20);
        System.out.println("Вывод сотрудника с минимальной зп в 3 отделе после индексации: "+employeeBook.findEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной зп после в 3 отделе после индексации: "+employeeBook.findEmployeeWithMaxSalary());
        employeeBook.printEmployeesOfDepartment(3);
        System.out.println("Сотрудники с зарплатой меньше 27 000 руб.:");
        employeeBook.printEmployeesSalaryBelowThreshold(27_000);
        System.out.println("Сотрудники с зарплатой больше 27 000 руб.:");
        employeeBook.printEmployeesSalaryAboveThreshold(27_000);

        System.out.println("-------------------------------------------------------------");

        System.out.println("Проверка методов очень сложной сложности");
        employeeBook.removeEmployee(3);
        employeeBook.removeEmployee("Федотова Л. А.");
        employeeBook.addEmployee("Пупков П. П.",4,12_000);
        employeeBook.changeDepartmentEmployee("Пупков П. П.",5);
        employeeBook.changeSalaryEmployee("Пупков П. П.",30_000);
        employeeBook.printEmployeesSortedByDepartments();

    }
}