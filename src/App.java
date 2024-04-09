
import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int Id;


    public Employee(String name, int Id)
    {
        this.name = name;
        this.Id = Id;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return Id;
    }


    public abstract double calculateSalary();


    @Override
    public String toString(){
        return "Employee [name="+name+", Id="+Id+", salary = "+calculateSalary()+"]";
    }
}


class FullTimeEmployee extends Employee{
    private double monthlySalary;


    public FullTimeEmployee(String name, int Id, double monthlySalary){
        super(name, Id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}


class PartTimeEmployee extends Employee{
    
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int Id, int hoursWorked, double hourlyRate){
        super(name, Id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hourlyRate*hoursWorked;
    }

}


class PayRollSystem{
    private ArrayList<Employee> employeeList;

    public PayRollSystem(){
        employeeList = new ArrayList<>();   

    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);

    }

    public void removeEmployee(int Id){
        Employee employeeToReomve = null;
        for(Employee employee : employeeList){
            if(employee.getId()==Id){
                employeeToReomve = employee;
                break;
            }
        }

        if(employeeToReomve!=null){
            employeeList.remove(employeeToReomve);
        }
    }


    public void displayEmployees(){
        for(Employee employee:employeeList){
            System.out.println(employee);
        }
    }


}


public class App {
    public static void main(String[] args)  {
        PayRollSystem payRollSystem = new PayRollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("vikas", 196, 70000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Alex", 199, 40, 100);

        payRollSystem.addEmployee(emp1);
        payRollSystem.addEmployee(emp2);
        System.out.println("Initial Employee details:");
        payRollSystem.displayEmployees();

        System.out.println("Removing employee details");
        payRollSystem.removeEmployee(199);  

        System.out.println("remaning empployee details");
        payRollSystem.displayEmployees();
    }
}
