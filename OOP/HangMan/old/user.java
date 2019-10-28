class user{
    public char guess;
    public char[] wordguessed = new char[10];
    // public String available_letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public char[] letters = new char[] {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public int size= letters.length;
    public void available_letters(char guess){
        // System.out.print("inside");
        for( int i=0;i<size;i++){
            if(letters[i]==guess){
                for(int j=i;j<size-1;j++){
                    letters[j]=letters[j+1];
                }
            }
             size-=1;
        }
      System.out.println(letters);  
    }
    
}    
class mains{
    public static void main(String[] args){
        System.out.println("Hello");
        user obj = new user();
        obj.available_letters('B');
    }
    
}
