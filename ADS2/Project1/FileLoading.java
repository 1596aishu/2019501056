import java.io.*; 
import java.util.*; 

class FileLoading{
    HashMap<String, String> map = new HashMap<>();
    public static void main(String args[]) throws Exception{ 
        
        FileLoading as2 = new FileLoading();
        String synsets = "C:\\Users\\aishwarya\\Desktop\\2019501056\\ADS2\\Day1\\Assignment1\\wordNet\\synsets.txt";
        String hypernyms = "C:\\Users\\aishwarya\\Desktop\\2019501056\\ADS2\\Day1\\Assignment1\\wordNet\\hypernyms.txt";
        as2.synset_file(synsets);
        as2.hypernym_file(hypernyms);
    }

    private void synset_file(String file) throws Exception{  
                  
            FileReader fr = new FileReader(file);    
            BufferedReader br = new BufferedReader(fr);
            String j;
            String[] str = new String[100];
            // int c = 0;
            // int y = 0;
            while((j = br.readLine())!=null){
                // int i = 0;
                // if(c<5){
                    // System.out.println(j);
                    str = j.split(",",3);
                    for(int x=0;x<str.length;x+=3)
                        for(int z=1;z<str.length;z+=3)
                            map.put(str[x],str[z]);                        
                // }c = c+1;
            }
            System.out.println(map);
            fr.close();    
        } 
        
    private void hypernym_file(String file) throws Exception{
        FileReader fr = new FileReader(file);    
        BufferedReader br = new BufferedReader(fr);
        String j;
        int c = 0;
        String[] str = new String[100];
        while((j = br.readLine())!=null){
            int i = 0;
            // if(c<5){
                // System.out.println(j);
                str = j.split(",",3);
                for(int x=0;x<str.length;x+=3)
                    for(int z=1;z<str.length;z+=3)
                        map.put(str[x],str[z]);
            // } c=c+1;
        }
        System.out.println(map);
        fr.close();    
    }
}
