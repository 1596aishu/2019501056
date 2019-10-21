import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.time.format.DateTimeFormatter;

public class tasklist{
    todolist [] tdlist = new todolist[10];
    int lst = 0;
    public void addTask(todolist list){
        tdlist[lst] = list;
        lst++;
    }
    public String deleteContact(String taskname) {
        //  Your code goes here....
        for(int i=0;i<lst;i++){
            if(tdlist[i].getTaskName() == taskname){
                for(int j = i+1;j<lst;j++){
                    tdlist[i] = tdlist[i+1];
                }
                tdlist[lst]=null;
                lst--;
                return "Deleted";
            }
        }
        return "Not found";
    }
    public void updateStatus(String taskname, String status){
        for(int i=0;i<lst;i++){
            if(tdlist[i].getTaskName() == taskname){
                tdlist[i].setStatus(status);
            }
        }
    }
    public void dispIncompleteTask(String status){
        for(int i=0;i<lst;i++){
            if(tdlist[i].getStatus().compareTo("Pending")==0 || tdlist[i].getStatus().compareTo("Incomplete")==0){
                System.out.println(tdlist[i].toString());
            }
        }
    }
    public void dispByDate(String date){
        for(int i=0;i<lst;i++){
            if(tdlist[i].getDueDate().compareTo(date)==0){
                System.out.println(tdlist[i].toString());
            }
        }
    }
    public void searchByName(String taskName){
        for(int i=0;i<lst;i++){
            if(tdlist[i].getTaskName() == taskName){
                System.out.println(tdlist[i].toString());
            }
        }
    }
    public void dispAll(){
        for(int i=0;i<lst;i++){
            System.out.println(tdlist[i].toString());
            }
    }
    public void overDue(){
        try{
            for (int i=0;i<lst;i++){
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
                String dateString = format.format( new Date()   );
                Date date = format.parse( tdlist[i].getDueDate() );
                if (date.before(new Date())){
                    System.out.println(tdlist[i].toString());
                }
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        } 
    }
}