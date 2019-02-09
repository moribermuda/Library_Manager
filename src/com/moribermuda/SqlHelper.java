/**this class help you to connect a data base and make sql Query,you should creat database and Tables same classes 
* I will make a sqlhelper class to connect any type of sql platform (mysql,postgre,sqlServer,...) 
* moribermuda@gmail.com
*/
package com.moribermuda;

import com.moribermuda.classes.Book;
import com.moribermuda.classes.BookType;
import com.moribermuda.classes.Book_Stack;
import com.moribermuda.classes.Member;
import com.moribermuda.classes.Order;
import com.moribermuda.classes.Stack;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MORTEZA
 */
public class SqlHelper
{
//declare variables 
    static final String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=";
    private static String User = "";
    private static String Pass = "";
    private static String dbName = "";
//geter and seter of variables 
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
//method for connection is establish
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
//----very common method to get connection
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
//-----------<Order Class methods>--------
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

                try {
                    b.setBookType(BookType.valueOf(rs.getString("bookType")));
                } catch (NullPointerException ee) {
                    b.setBookType(BookType.DEFAULT);
                }
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
            if (rowInsert > 0) {
                flag = true;
            } else {
                flag = false;
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            flag = false;
        }
        return flag;

    }
//--------------<Stack table methods>---------------
    public static boolean insertStack(Stack s)
    {
        boolean flag = false;
        PreparedStatement pstm = null;
        try {
            Class.forName(Driver);
            Connection conn = getConnection();
            pstm = conn.prepareStatement(
                    "INSERT INTO Stack"
                    + " (id,titel,[rowCount],columnCount)"
                    + " VALUES(?,?,?,?)");
            pstm.setInt(1, s.getStack_id());
            pstm.setString(2, s.getStack_Titel());
            pstm.setInt(3, s.getRowCount());
            pstm.setInt(4, s.getColumnCount());

            int rowInsert = pstm.executeUpdate();
            if (rowInsert > 0) {
                flag = true;
            } else {
                flag = false;
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            flag = false;
        }
        return flag;

    }
//---------------<BookStack methods>------------
    public static boolean insertBookStack(Book_Stack bs)
    {
        boolean flag = false;
        PreparedStatement pstm = null;
        try {
            Class.forName(Driver);
            Connection conn = getConnection();
            pstm = conn.prepareStatement(
                    "INSERT INTO Book_Stack"
                    + " (Stack_id,stack_Row,stack_Column,book_id,property)"
                    + " VALUES(?,?,?,?,?)");
            pstm.setInt(1, bs.getStack_ID());
            pstm.setInt(2, bs.getStack_Row());
            pstm.setInt(3, bs.getStack_Coulomn());
            pstm.setInt(4, bs.getBook_ID());
            pstm.setString(5, bs.getProperty());

            int rowInsert = pstm.executeUpdate();
            if (rowInsert > 0) {
                flag = true;
            } else {
                flag = false;
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            flag = false;
        }
        return flag;

    }

    //___------------<Member>-----------____
    public static boolean insertMember(Member m)
    {
        boolean flag = false;
        PreparedStatement pstm = null;
        try {
            Class.forName(Driver);
            Connection conn = getConnection();
            pstm = conn.prepareStatement(
                    "INSERT INTO Member"
                    + " (mem_Code,fname,lname,[from],National_Code,brithday,mem_Date,expierDate,tellNum)"
                    + " VALUES(?,?,?,?,?,?,?,?,?)");
            pstm.setInt(1, m.getMem_code());
            pstm.setString(2, m.getFname());
            pstm.setString(3, m.getLname());
            pstm.setString(4, m.getFrom());
            pstm.setLong(5, m.getNational_Code());
            pstm.setString(6, m.getBrithday());
            pstm.setTimestamp(7, new Timestamp(m.getMem_Date().getTime()));
            pstm.setTimestamp(8, new Timestamp(m.getExpireDate().getTime()));
            pstm.setString(9, m.getTellNum());
            int rowInsert = pstm.executeUpdate();
            if (rowInsert > 0) {
                flag = true;
            } else {
                flag = false;
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            flag = false;
        }
        return flag;

    }

    public static ArrayList<Member> fillTableMember()
    {
        ArrayList<Member> list = new ArrayList<>();
        Connection con = getConnection();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from Member");
            while (rs.next()) {
                Member m = new Member();
                m.setMem_code(rs.getInt("mem_Code"));
                m.setFname(rs.getString("fname"));
                m.setLname(rs.getString("lname"));
                m.setFrom(rs.getString("from"));
                m.setBrithday(rs.getString("brithday"));
                m.setMem_Date(rs.getDate("mem_Date"));
                m.setExpireDate(rs.getDate("expierDate"));
                m.setTellNum(rs.getString("tellNum"));
                m.setNational_Code(rs.getLong("National_Code"));

                list.add(m);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;

    }
}
