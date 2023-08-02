public class TestBankAccount {
    public static void main(String[] args) {

        BankAccount myAccount = new BankAccount();
        myAccount.depositChecking(100);
        myAccount.depositSavings(320.346);
        System.out.println("The total amount in your account: "+myAccount.getMyTotalMoney());
        System.out.println("Please enter the amount you want to retrive:");
        String retriveAmount = System.console().readLine();
        myAccount.withDrawMoney(Double.parseDouble(retriveAmount));

    }
}
