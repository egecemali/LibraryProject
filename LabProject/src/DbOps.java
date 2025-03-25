import java.awt.print.Book;
import java.sql.*;
import java.util.ArrayList;

public class DbOps {

    public static void showData() throws SQLException {
        DbHelper db = new DbHelper();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = db.getConnection();
            stmt = conn.createStatement();
            rs= stmt.executeQuery("SELECT * FROM public.\"Books\" ORDER BY book_id ASC ");
            ArrayList<Books> books = new ArrayList<Books>();
            while (rs.next()) {
                books.add(new Books(rs.getInt("book_id"),rs.getString("name"),rs.getString("author") ));
            }
            for (Books b : books) {
                System.out.println(b);
            }


        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            if (rs != null) {
                rs.close();
                conn.close();
                stmt.close();
            }
        }
    }
    public static void insertData(String name , String author) throws SQLException {
        DbHelper db = new DbHelper();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = db.getConnection();
            stmt = conn.prepareStatement("insert into public.\"Books\"(name,author) VALUES (?,?)");
            stmt.setString(1, name);
            stmt.setString(2, author);
            stmt.executeUpdate();
            System.out.println("Book inserted to database");


        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void updateData(String thingToUpdate , String newStatement,int book_id) throws SQLException {
        DbHelper db = new DbHelper();
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = db.getConnection();
            stmt = conn.prepareStatement("update public.\"Books\" set " + thingToUpdate + " = ?  where book_id = ?");
            stmt.setString(1, newStatement);
            stmt.setInt(2, book_id);
            stmt.executeUpdate();
            System.out.println("Book database updated");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            if (stmt != null) {
                stmt.close();
                conn.close();
            }
        }
    }
    public static void deleteData(int book_id) throws SQLException {
        DbHelper db = new DbHelper();
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = db.getConnection();
            stmt = conn.prepareStatement("delete from public.\"Books\" where book_id = ?");
            stmt.setInt(1, book_id);
            stmt.executeUpdate();
            System.out.println("Book deleted from database ");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            if (stmt != null) {
                stmt.close();
                conn.close();
            }
        }
    }
}
