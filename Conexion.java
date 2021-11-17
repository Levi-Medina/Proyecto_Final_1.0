package configuration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
     
    private Connection conexion;
    //private final String url = "jdbc:mysql://localhost:3306/dyjamir?serverTimezone=GMT-5&useSSL=false&useUnicode=true&characterEncoding=utf-8";
    String url="";
    File ip= new File("C:\\Prueba\\nodeIPmysql.txt");
    
    
    private String user = "root";
    private String password = "";
    
    public Connection getConexion() {
            try {

if(ip.exists()){
FileReader fr = new FileReader("C:\\Prueba\\nodeIPmysql.txt");
BufferedReader bf = new BufferedReader(fr);
url=bf.readLine();
bf.readLine();
user=bf.readLine();
bf.readLine();
password=bf.readLine();
bf.close();

fr.close();

}else


{
    
ip.createNewFile();
FileWriter fw= new FileWriter("C:\\Prueba\\nodeIPmysql.txt");
BufferedWriter bw= new BufferedWriter(fw);
//bw.write("jdbc:mysql://localhost:3306/dyjamir?serverTimezone=GMT-5&useSSL=false&useUnicode=true&characterEncoding=utf-8");
bw.write("jdbc:mysql://localhost:3306/dyjamir?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
bw.write("#User:\n");
bw.write("root\n");
bw.write("#Password\n");
bw.write("\n");
bw.close();
fw.close();

//url="jdbc:mysql://localhost:3306/dyjamir?serverTimezone=GMT-5&useSSL=false&useUnicode=true&characterEncoding=utf-8";
url="jdbc:mysql://localhost:3306/mysql?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
user="root";
password="";
}
        
       
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conectando a la bd...");
            
        } catch(ClassNotFoundException | SQLException ex) {
            System.out.println(" Error no se ha establecido la conexión: ");
            System.out.println(" " + ex.getMessage() + "\n" + ex.getCause() + "\n" + ex.toString());
        }catch(IOException e){
        }
        
        return conexion;
    }
    
    public static void main (String []args) {
        Conexion con = new Conexion();
        con.getConexion();
    }
}
