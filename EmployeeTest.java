class Employee {
   private String employeeId;   // instance variable 
   private String name;
   private String department;
   private double baseSalary;
   private int yearsOfExperience;
   private boolean isActive;

   private static int totalEmployees;
   static String COMPANY_NAME;
   static {
      COMPANY_NAME = "Hero Motorcorp";
   }
  

   
    

   static int getTotalEmployees() {
      return totalEmployees;
   }


   Employee(String employeeId, String name, String department, double baseSalary, int yearsOfExperience) {
       this.isActive = true;
       this.employeeId = employeeId;
       this.name = name;
       this.department = department;
       if(baseSalary < 0) {
           this.baseSalary = 0;
       }else {
          this.baseSalary = baseSalary;
       }
       this.yearsOfExperience = yearsOfExperience;
        totalEmployees++;
   }

   Employee() {   // no-args constructor
       this.isActive = true;
       this.employeeId = "E0000";
       this.name = "Unknown";
       this.department = "General";
       this.baseSalary = 3000;
       this.yearsOfExperience = 0; 
        totalEmployees++;
   }

   String getEmployeeId() {
      return employeeId;
   }

   String getName() {
      return name;
   }

   String getDepartment() {
      return department;
   }

   double getBaseSalary() {
      return baseSalary; 
   }
  
   int getYearsOfExperience() {
      return yearsOfExperience; 
   }

   boolean getIsActive() {
      return isActive; 
   }


   void setName(String name) {
      this.name = name;
   }

  
   void setDepartment(String department) {
      this.department = department;
   }

   void setBaseSalary(double baseSalary) {
      if(baseSalary <0) {
          this.baseSalary = 0;
      }else {
          this.baseSalary = baseSalary;
      }
   }

   void setYearsOfExperience(int yearsOfExperience) {
      this.yearsOfExperience = yearsOfExperience;
   }


   void setIsActive(boolean isActive) { 
      this.isActive = isActive;
   }

   double calculateAnnualSalary() {
      return baseSalary * 12;
   }

   boolean promoteEmployee(double salaryIncrease, String newDepartment) {
       if(isActive == true) {
           yearsOfExperience++;
           baseSalary += salaryIncrease;
           department = newDepartment;
           return true; 
       }else {
           return false;
       }
       

   }
 

   double calculateBonus() {
       if(yearsOfExperience >= 5) { 
          return calculateAnnualSalary() * 0.10; 
       }else if(yearsOfExperience >= 3) {
          return calculateAnnualSalary() * 0.05; 
       }else {
          return calculateAnnualSalary() * 0.02; 
       }
   }

   void terminateEmployee() {
      isActive = false;
   }

   String displayEmployeeInfo() {
        return    "Employee ID: " + employeeId + "\n" +
                  "Name: " + name + "\n" +
                  "Department: " + department + "\n" +
                  "Monthly Salary: " + baseSalary + "\n" +
                  "Years of Experience: " + yearsOfExperience + "\n" +
                  "Annual Salary: " + calculateAnnualSalary() + "\n" + 
                  "Bonus: " + calculateBonus() + "\n"; 
    }

   

}

public class EmployeeTest {
   public static void main(String[] args) {
       System.out.println("Name of Company: " + Employee.COMPANY_NAME);
       Employee emp1 = new Employee("E0001", "Jack Smith", "Sales", 50000, 3); 
       emp1.setBaseSalary(5000);

       System.out.println("Before Promotion:");
       System.out.println(emp1.displayEmployeeInfo());
 
       System.out.println();
 
       System.out.println("After Promotion:");
       if(emp1.promoteEmployee(500, "Sales Executive") !=  true) {
          System.out.println("Jack is not promoted");
       }
       System.out.println(emp1.displayEmployeeInfo());

       Employee emp2 = new Employee();
       Employee emp3 = new Employee();
       Employee emp4 = new Employee();
       Employee emp5 = new Employee();
       Employee emp6 = new Employee("E005", "Richard Gere", "Intern", -500, 1 );

       emp6.setBaseSalary(-500);


      System.out.println(emp6.displayEmployeeInfo());

      System.out.println("Total Employees are: " + Employee.getTotalEmployees());

      
   }
}











