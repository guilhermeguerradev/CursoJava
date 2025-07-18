

import db.DB;
import db.DbException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "Insert into seller" +
                    " (Name, Email, BirthDate, BaseSalary, DepartmentId) " +
                    "VALUES " +
                    "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1 , "Guilherme Guerra");
            st.setString(2, "guilhermeguerradev@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("09/08/2001").getTime()));
            st.setDouble(4, 4000.0);
            st.setInt(5, 3);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while(rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! - " + id );
                }
            } else {
                System.out.println("No rown affected");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }


    }
}