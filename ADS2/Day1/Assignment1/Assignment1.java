import java.io.*;  

class Assignment1{
    String[] str;
    public static void main(String args[]) throws Exception{ 
        Assignment1 as = new Assignment1();
        String synsets = "C:\\Users\\aishwarya\\Desktop\\2019501056\\ADS2\\Day1\\Assignment1\\wordNet\\synsets.txt";
        String hypernyms = "C:\\Users\\aishwarya\\Desktop\\2019501056\\ADS2\\Day1\\Assignment1\\wordNet\\hypernyms.txt";
        as.synsets_file(synsets);
        as.hypernyms_file(hypernyms);
    }

    private void synsets_file(String file) throws Exception{        
            FileReader fr = new FileReader(file);    
            BufferedReader br = new BufferedReader(fr);
            String j;
            // String[] str = new String[100];
            String[] key = new String[100];
            String[] val = new String[100];
            int c = 0;
            int y = 0;
            while((j = br.readLine())!=null){
                int i = 0;
                if(c<5){
                    System.out.println(j);
                    str = j.split(",",2);
                    key[y]=str[i];
                    val[y]=str[i+1];
                }
                i++;
                y++;
                c = c+1;
            }
            for (int a =0; a<5;a++) 
                System.out.println(key[a]+ " : {"+ val[a]+"}");
            fr.close();    
        } 
        
    private void hypernyms_file(String file) throws Exception{
        FileReader fr = new FileReader(file);    
        BufferedReader br = new BufferedReader(fr);
        String j;
        int c = 0;        
        while((j = br.readLine())!=null){
            int i = 0;
            if(c<5){
                // System.out.println(j);
                str = j.split(",",2);
                for (int a = 0; a<str.length;a+=2)
                    for (int b = 1 ; b<str.length;b+=2) 
                        System.out.println(str[a]+" : "+ str[b]);
            } c=c+1;
        }
        
        fr.close();    
    }
}
