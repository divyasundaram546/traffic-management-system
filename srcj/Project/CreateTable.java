package Project;
import java.sql.Connection;
import java.sql.Statement;
public class CreateTable {
       public static void main(String[] args) {
         Connection conn = null;
         Statement statement = null;
         ConnectDB app = new ConnectDB();
         conn = app.connect();
          try {	 
         String query = "create table Admin(ID int primary key,USERNAME varchar(200),PASSWORD varchar(200),USER_TYPE char(20))";
         statement = conn.createStatement();
         statement.executeUpdate(query);
         System.out.println("Finished");
        }
        catch(Exception e) {
        	e.printStackTrace(); 
        }
   }
}