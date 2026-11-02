class Employee {
    private String firstName;
    private String lastName;
    private double monthlySalary;

    Employee(String firstName, String lastName, double monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;

        if (monthlySalary > 0)
            this.monthlySalary = monthlySalary;
        else
            this.monthlySalary = 0;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    double getSalary() {
        return monthlySalary;
    }

    void setSalary(double monthlySalary) {
        if (monthlySalary > 0)
            this.monthlySalary = monthlySalary;
    }
	
	public static void main(String[] args) {

        Employee emp1 = new Employee("Amit", "Patil", 38000);
        Employee emp2 = new Employee("Sneha", "Sharma", 18000);

        System.out.println("Yearly Salary Before Raise");

        System.out.println(
            emp1.getFirstName() + " " + emp1.getLastName()
            + " : Rs. " + (emp1.getSalary() * 12)
        );

        System.out.println(
            emp2.getFirstName() + " " + emp2.getLastName()
            + " : Rs. " + (emp2.getSalary() * 12)
        );


        emp1.setSalary(emp1.getSalary() * 1.10);
        emp2.setSalary(emp2.getSalary() * 1.10);

        System.out.println("\nYearly Salary After 10% Raise");

        System.out.println(
            emp1.getFirstName() + " " + emp1.getLastName()
            + " : Rs. " + (emp1.getSalary() * 12)
        );

        System.out.println(
            emp2.getFirstName() + " " + emp2.getLastName()
            + " : Rs. " + (emp2.getSalary() * 12)
        );
    }
}

    
