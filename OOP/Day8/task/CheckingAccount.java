class CheckingAccount extends BankAccount{
    private double limit;
    CheckingAccount(String s, double b, double l){
        super(s,b);
        limit=l;
    }
    
    public void setLimit(double l){
        limit=l;
    }
    
    public double getLimit(){
        return limit;
    }

    public void withdrawl(double b){
        if(getBalance()-b > limit){
        setBalance(getBalance()-b);
        System.out.println("The balance after withdrawl is : "+getBalance());
        }
        else{
            System.out.println("Cant possible limit exceeded");
        }
    }
}