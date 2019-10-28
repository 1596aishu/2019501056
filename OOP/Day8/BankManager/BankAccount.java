class Bank{
    public double account = 2;
    public double balance = 100;
}

class CheckingAccount extends Bank{
    public double limit;
    public void disp(){
        System.out.println(account);
        System.out.println(balance);
    }
}

class SavingsAccount extends Bank{
    public double limits;
    public void disp(){
        System.out.println(account);
        System.out.println(balance);
    }
}

class CertificateOfDeposit extends Bank{
    public double limited;
    public void disp(){
        System.out.println(account);
        System.out.println(balance);
    }
}
class BankAccount{
    public static void main(String[] args){
        CheckingAccount ca = new CheckingAccount();
        SavingsAccount sa = new SavingsAccount();
        CertificateOfDeposit cod = new CertificateOfDeposit();
        ca.disp();
        sa.disp();
        cod.disp();
    }
}



