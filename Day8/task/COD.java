import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.*;

class COD extends BankAccount{
    final long n=-100000000;
    final double intrest=.12;
    private String expiry;
    COD(String s, double b, String e){
        super(s,b);
        expiry=e;
    }
    
    public void setExpiry(String e){
        expiry=e;
    }
    
    public String getExpiry(){
        return expiry;
    }

    public void CalculateIntrest(){
        SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
        Date ConvertExpire;
        long day;
        try {
        ConvertExpire = ft.parse(expiry); 
         Date date = new Date();
         day=-TimeUnit.DAYS.convert(ConvertExpire.getTime()-date.getTime(), TimeUnit.MILLISECONDS); 
        } catch (ParseException e) { 
         day=n; 
        }
        if(day != n){
            if(day<=0) System.out.println("Term not yet done");
            else 
            {
                double finalValue;
                finalValue=getBalance() + (getBalance()*day*intrest/100);
                System.out.println("The Final intrest Value is : "+ finalValue);
            }
        }
        else System.out.println("Date Format is wrong");
    }
}