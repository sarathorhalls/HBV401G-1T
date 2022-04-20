package is.hi.tripplanner.vinnsla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class UserController {
    private ArrayList<User> users;

    public UserController() throws Exception {
        getUsersFromDB();
    }

    private void getUsersFromDB() throws Exception {
        Class.forName("org.sqlite.JDBC");

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:1T.db");

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Users;");
            ResultSet set = pstmt.executeQuery();
            while(set.next()) {
                users.add(new User(
                    set.getBoolean("isAdmin"),
                    set.getString("firstname"),
                    set.getString("lastname"),
                    set.getString("ssn"),
                    set.getString("username"),
                    set.getString("email"),
                    set.getInt("userID")
                ));
            }

        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

}
