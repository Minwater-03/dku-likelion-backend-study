public class SavingAccount extends BankAccount implements Withdrawable {
    boolean isOverdraft;
    void transfer(){};
    public void withdraw(){
        System.out.println("Withdrawing");
    };
}
