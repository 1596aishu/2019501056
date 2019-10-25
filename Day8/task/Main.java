class Main{
    public static void main(String[] args) {
        CheckingAccount obj = new CheckingAccount("123-456",1234.0,150.0);
        System.out.println(obj.getAcctNumber());
        System.out.println(obj.getBalance());
        System.out.println(obj.getLimit());
        obj.withdrawl(120);

        System.out.println();

        SavingsAccount obj1 = new SavingsAccount("123-456",1234.0,15);
        System.out.println(obj1.getAcctNumber());
        System.out.println(obj1.getBalance());
        System.out.println(obj1.getTransfer());
        obj1.withdrawl(1200);

        System.out.println();

        COD obj2 = new COD("123-456",1234.0,"23-09-2019");
        System.out.println(obj2.getAcctNumber());
        System.out.println(obj2.getBalance());
        System.out.println(obj2.getExpiry());
        obj2.CalculateIntrest();
    }
}