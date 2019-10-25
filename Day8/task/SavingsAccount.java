class SavingsAccount extends BankAccount{
    private int transfers;
    SavingsAccount(String s, double b, int e){
        super(s,b);
        transfers=e;
    }
    
    public void setTransfer(int n){
        transfers=n;
    }
    
    public double getTransfer(){
        return transfers;
    }
    
    public void withdrawl(double b){
        if(getBalance() - b >= 0){
        setBalance(getBalance() - b);
        System.out.println("The balance after withdrawl is : "+getBalance());
        }
        else{
            System.out.println("Cant possible limit exceeded");
        }
    }
}