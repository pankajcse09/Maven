package ActionClass;
/**
 *
 * @author kanchan
 */
public class MyBackupTest{ 
public static void exportData(){      
//String path="c:/Backup/back.sql";  
Runtime rt = Runtime.getRuntime();
try{ 
Process proc=rt.exec("C:/backup.cmd"); 
}
catch(Exception e){System.out.println(e.getMessage());}
}
public static void main(String a[]){
    exportData();
}
}
