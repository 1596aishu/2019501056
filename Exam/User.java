import java.util.*;

public class User {
    private String userName;
    private int Number;
    private User[] connections;
    // private String connections;
    User(String userName, User[] connections, int Number){
        this.userName = userName;
        this.Number = Number;
        this.connections = connections;
        // connections = new User[1];
    }
    public String getUserName(){
        return this.userName;
    }
    public void setUserName(final String userName){
        this.userName = userName;
    }
    public int getNumber(){
        return this.Number;
    }
    public void setNumber(final int number){
        this.Number = number;
    }
    public String toString(){
        return userName + ": "+Arrays.toString(connections);
    }
}