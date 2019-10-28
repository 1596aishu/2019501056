public class todolist{
    private String taskname;
    private String taskdesc;
    private String duedate;
    private String status;

    todolist(){
        this.taskname="";
        this.taskdesc="";
        this.duedate="";
        this.status="";
    }
    todolist(String n, String d, String date, String s){
        this.taskname = n;
        this.taskdesc = d;
        this.duedate = date;
        this.status = s;
    }
    public String getTaskName(){
        return this.taskname;
    }
    public String getTaskDesc(){
        return this.taskdesc;
    }
    public String getDueDate(){
        return this.duedate;
    }
    public String getStatus(){
        return this.status;
    }
    public void setTaskName(String n){
        this.taskname = n;
    }
    public void setTaskDesc(String d){
        this.taskdesc = d;
    }
    public void setDueDate(String date){
        this.duedate = date;
    }
    public void setStatus(String s){
        this.status = s;
    }
    public static void main(String args[]){
        
    }
}