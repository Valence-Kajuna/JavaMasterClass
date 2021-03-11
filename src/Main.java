import java.sql.*;

public class Main {
    public static final String DB_NAME= "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/home/valence/IdeaProjects/TestDB/"+DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            //conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE IF EXISTS "+ TABLE_CONTACTS);
            statement.execute("CREATE TABLE "+TABLE_CONTACTS +"("+COLUMN_NAME+" TEXT,"+COLUMN_PHONE+" INTEGER,"+COLUMN_EMAIL+" TEXT)");
            statement.execute("INSERT INTO " + TABLE_CONTACTS +" VALUES ('Victor Njunwa',0753932250,'njunwawamavoko@gmail.com'),('Violeth Muganda',0759886643,'violethmukaile@ymail.com'),('Vestina Muganda', 0621876543,'vecyfreddy@gmail.com'),('Valence Kajuna',0765975152,'valencekajuna@yahoo.com')");
            statement.execute("UPDATE " + TABLE_CONTACTS + " SET "  + COLUMN_PHONE +" = 0688966410 WHERE " + COLUMN_NAME +"='Valence Kajuna'");
            statement.execute("DELETE FROM " + TABLE_CONTACTS + " WHERE " + COLUMN_NAME + " = 'Vestina Muganda'");

            ResultSet results = statement.executeQuery("SELECT * FROM "+TABLE_CONTACTS);
            while (results.next()){
                System.out.println(results.getString(COLUMN_NAME) + " " + results.getInt(COLUMN_PHONE) + " " + results.getString(COLUMN_EMAIL));

            }
            results.close();
            statement.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("Something went wrong: "+ e.getMessage());
            e.printStackTrace();
        }
    }
}
