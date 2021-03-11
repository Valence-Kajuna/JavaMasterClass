import java.sql.*;

public class Main {
//    public static final String DB_NAME= "testjava.db";
//    public static final String CONNECTION_STRING = "testjava.db";

    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/valence/IdeaProjects/TestDB/testjava.db");
            //conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
//            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");
          //statement.execute("INSERT INTO contacts VALUES ('Vestina',0765975152,'valence@yahoo.com'),('Violeth',0759886654,'violeth@yahoo.com'),('Valerian',0688966410,'valerian@yahoo.com')");
            //statement.execute("UPDATE contacts SET phone=0753932250  WHERE name ='Valerian'");
           // statement.execute("DELETE FROM contacts WHERE name='Valerian'");

//            statement.execute("SELECT * FROM contacts");

            ResultSet results = statement.executeQuery("SELECT * FROM contacts");
            while (results.next()){
                System.out.println(results.getString("name") + " " + results.getInt("phone") + " " + results.getString("email"));

            }

            results.close();
            statement.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("Something went wrong: "+ e.getMessage());
        }
    }
}
