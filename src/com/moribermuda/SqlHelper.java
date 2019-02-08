package com.moribermuda;

import com.moribermuda.classes.Book;
import com.moribermuda.classes.BookType;
import com.moribermuda.classes.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MORTEZA
 */
public class SqlHelper
{

    static final String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=";
    private static String User = "";
    private static String Pass = "";
    private static String dbName = "";

    public static String getDbName()
    {
        return dbName;
    }

    public static void setDbName(String dbName)
    {
        SqlHelper.dbName = dbName;
    }

    public static String getURL()
    {
        return URL;
    }

    public static void setURL(String URL)
    {
        SqlHelper.URL = URL;
    }

    public static String getUser()
    {
        return User;
    }

    public static void setUser(String User)
    {
        SqlHelper.User = User;
    }

    public static String getPass()
    {
        return Pass;
    }

    public static void setPass(String Pass)
    {
        SqlHelper.Pass = Pass;
    }

    public static boolean connectionDB()
    {
        try {
            Class.forName(Driver);
            Connection con = DriverManager.getConnection(
                    URL + getDbName(), User, Pass);
            System.out.print("Connection is started");
            return true;
        } catch (Exception e) {
            System.out.print("Error in Connection");
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.print(e.getMessage());
            return false;
        }
    }

    public static Connection getConnection()
    {
        try {
            Connection con = DriverManager.getConnection(URL + getDbName(), User, Pass);
            return con;
        } catch (SQLException e) {
            System.out.print("Error in connection" + e.getMessage());
            return null;
        }
    }

    public static ArrayList<Order> fillTableIssu()
    {
        ArrayList<Order> list = new ArrayList<>();
        Connection con = getConnection();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from issue_status");
            while (rs.next()) {
                Order o = new Order();
                o.setId(rs.getInt("id"));
                o.setBook_Code(rs.getInt("Book_ID"));
                o.setTitell(rs.getString("title"));
                o.setMem_Code(rs.getInt("mem_Code"));
                o.setFname(rs.getString("fname"));
                o.setLname(rs.getString("lname"));
                o.setInit_Date(rs.getDate("init_Date"));
                o.setFinish_Date(rs.getDate("finish_Date"));
                list.add(o);

            }
        } catch (SQLException e) {

        }
        return list;

    }

    
    
//------------<Book>---------------
public static ArrayList<Book> fillTableBook()
    {
        ArrayList<Book> list = new ArrayList<>();
        Connection con = getConnection();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from Book");
            while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setAuthorName(rs.getString("authorName"));
                b.setPublisher(rs.getString("publisher"));
                b.setTranslator(rs.getString("translator"));
                b.setYear(rs.getInt("year"));
                b.setPrint_count(rs.getInt("print_Count"));
                b.setPrice(rs.getDouble("price"));
                b.setAvailibal(rs.getBoolean("availibal"));
                b.setCustomer_ID(rs.getInt("mem_Code"));
               // b.setBookType(BookType.valueOf(rs.getString("bookType")));
                list.add(b);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;

    }    
    public static boolean insertBook(Book b)
    {
        boolean flag = false;
        PreparedStatement pstm = null;
        try {
            Class.forName(Driver);
            Connection conn = getConnection();
            pstm = conn.prepareStatement(
                    "INSERT INTO Book"
                    + " (id,title,publisher,translator,price,year,authorName,availibal,print_count,mem_Code,bookType)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pstm.setInt(1, b.getId());
            pstm.setString(2, b.getTitle());
            pstm.setString(3, b.getPublisher());
            pstm.setString(4, b.getTranslator());
            pstm.setDouble(5, b.getPrice());
            pstm.setInt(6, b.getYear());
            pstm.setString(7, b.getAuthorName());
            pstm.setBoolean(8, b.isAvailibal());
            pstm.setInt(9, b.getPrint_count());
            pstm.setInt(10, b.getCustomer_ID());
            pstm.setString(11, b.getBookType().name());
  int rowInsert = pstm.executeUpdate();
            if (rowInsert > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e)
        {
            System.out.println(e.getMessage());
            flag = false;
        }
        return flag;

    }

}
