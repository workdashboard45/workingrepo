class SavingsAccount
{
    private static float annualInterestRate;
    private float savingsBalance;

    SavingsAccount(float balance)
    {
        savingsBalance = balance;
    }

    public void calculateMonthlyInterest()
    {
        float monthlyInterest =
            (savingsBalance * annualInterestRate) / 12;

        savingsBalance += monthlyInterest;

        System.out.println("Current Balance = " + savingsBalance);
    }

    public static void modifyInterestRate(float rate)
    {
        annualInterestRate = rate;
    }
	
	public static void main(String args[])
    {
        SavingsAccount saver1 = new SavingsAccount(22000.00f);
        SavingsAccount saver2 = new SavingsAccount(34500.00f);

        System.out.println("Annual Interest Rate = 4%");

        SavingsAccount.modifyInterestRate(0.04f);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("\nAnnual Interest Rate = 5%");

        SavingsAccount.modifyInterestRate(0.05f);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
    }
}

