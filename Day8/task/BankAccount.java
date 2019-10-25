class BankAccount{
    //pending docs
    private String accountNumber;
    private double balance;

BankAccount(String s, double d)
{
    accountNumber=s;
    balance=d;
}

public void setAcctNumber(String a){
    accountNumber=a;
}
public void setBalance(double b){
    balance=b;
}

public String getAcctNumber(){
    return accountNumber;
}
public double getBalance(){
    return balance;
}
}