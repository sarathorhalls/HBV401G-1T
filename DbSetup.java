import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

//sqlite3 1T.db
//.read schema.sql
//java -classpath ".;sqlite-jdbc-3.36.0.3.jar" dbSetup false false
public class DbSetup {
    public static void main(String[] args) throws Exception {

        Class.forName("org.sqlite.JDBC");

        boolean USE_AUTOCOMMIT = args[0].equals("autocommit");
        boolean USE_INDEX = args[1].equals("index");

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:1T.db");
            conn.setAutoCommit(USE_AUTOCOMMIT);

            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO Users(ssn,username,firstname,lastname,email,password,isAdmin) VALUES(?,?,?,?,?,?,?);");

            pstmt.clearParameters();
            pstmt.setString(1, "0101704490");
            pstmt.setString(2, "admin");
            pstmt.setString(3, "Óskar");
            pstmt.setString(4, "Agnarsson");
            pstmt.setString(5, "oskaragnarson@gmail.com");
            pstmt.setString(6, "yessir");
            pstmt.setBoolean(7, true);

            pstmt.executeUpdate();
            conn.commit();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users");
            ResultSet set = stmt.executeQuery();
            ResultSetMetaData rsmd = set.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (set.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = set.getString(i);
                    System.out.print(rsmd.getColumnName(i) +":"+columnValue);
                }
                System.out.println("");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}