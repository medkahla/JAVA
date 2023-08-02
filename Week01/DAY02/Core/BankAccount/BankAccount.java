public class BankAccount {
    
    private double checkingBalance;
    private double savingsBalance;


    private static Integer nbrAccount = 0;
    private static double totalAmount = 0;

    public BankAccount (){
        checkingBalance = 0;
        savingsBalance = 0;
        nbrAccount+=1;
    }

    public void depositSavings(double amount){
        this.savingsBalance += amount;
        totalAmount+=amount;
    }
    public void depositChecking(double amount){
        this.checkingBalance += amount;
        totalAmount+=amount;
    }


    public void withDrawMoney(double amount){
        if(this.savingsBalance < amount){
            System.out.println("Sorry, insufficient funds!");
        }else{
            this.savingsBalance-=amount;
            System.out.println("Done with success, and your current balance is "+this.savingsBalance);
        }
    }

    public double getMyTotalMoney(){
        return (this.checkingBalance+ this.savingsBalance);
    }


    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    // public void setCheckingBalance(double amount){
    //     this.checkingBalance += amount;
    // }

    public double getSavingsBalance(){
        return this.savingsBalance;
    }
    // public void setSavingsBalance(double amount){
    //     this.savingsBalance += amount;
    // }


    public static Integer getNbrAccount(){
        return nbrAccount;
    }
    public static double getTotalAmount(){
        return totalAmount;
    }
}