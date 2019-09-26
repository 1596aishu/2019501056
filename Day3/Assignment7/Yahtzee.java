public class Yahtzee{
    public static int random(){
        double rand =0;
        rand=Math.random();
        rand*= 6;
        rand++;
        return (int)rand;
    }

public static void main(String[] args){
    int rand1=random();
    int rand2=random();
    int rand3=random();
    int rand4=random();
    int rand5=random();
    boolean p =true;
    int count=0;
    while(p){
        if((rand1 == rand2)&&(rand2==rand3)&& (rand3==rand4)&&(rand4==rand5)){
            p=false;
        }
        else{
            rand1=random();
            rand2=random();
            rand3=random();
            rand4=random();
            rand5=random();
            count=count+1;

        }

        }
        System.out.println(count);
        System.out.println(rand1);
        System.out.println(rand2);
        System.out.println(rand3);
        System.out.println(rand4);
        System.out.println(rand5);


    }


}