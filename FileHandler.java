import java.io.*;

public class FileHandler
{
    FileWriter fw;
    FileReader fr;
    String fileName;
    File file;
    String str;
    
    public FileHandler()
    {
        fileName = "/Routes/defaultFile.txt";
        file = new File(fileName);
    }
    public FileHandler(String fN)
    {
        fileName = "/Routes/" + fN + ".txt";
        file = new File(fileName);
    }
    
    public void saveRoutes(String s){
        this.str = s;
        try{
        if(file.exists()){
            initialiseFileHandlers();
            writeToFile();
        }else{
            
            file.createNewFile();
            initialiseFileHandlers();
            writeToFile();
            
        }
        }catch(IOException e){System.out.println("File not created");}
    }
    
    public void initialiseFileHandlers() throws IOException{
        
            fw = new FileWriter(file,true);
            fr = new FileReader(file);
        
    }
    
    
    
    public void writeToFile(){
        System.out.println(str);
        try{
            fw.write(str);
            fw.flush();
            fw.close();
        }catch(IOException e){System.out.println("File not written to");}
    }
}
