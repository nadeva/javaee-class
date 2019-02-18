package fr.nadeva;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {

    // Comment to use local derby

    static final String DB_URL = "jdbc:h2:mem:test";
    static final String USER_PASSWORD = null;

    // Uncomment to use local derby

//    static final String DB_URL = "jdbc:derby://localhost:1527/testjpa;create=true";
//    static final String USER_PASSWORD = "APP";

    public static void main(String[] args) {
        listTables();
    }

    static List<String> listTables() {

        List<String> resultList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER_PASSWORD, USER_PASSWORD)) {

            DatabaseMetaData md = conn.getMetaData();
            try (ResultSet rs = md.getTables(null, null, "%", null)) {
                while (rs.next()) {
                    resultList.add(rs.getString(3));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Table list");
        System.out.println(resultList);

        return resultList;
    }

    static List<String> listColumnsFromTable(String tableName) {

        List<String> resultList = new ArrayList<>();


        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM " + tableName;
            try (ResultSet rs = stmt.executeQuery(sql)) {
                ResultSetMetaData rsmd = rs.getMetaData();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    resultList.add(rsmd.getColumnName(i));
                }
            }

//
//                //STEP 5: Extract data from result set
//                while(rs.next()){
//                    //Retrieve by column name
//                    int id  = rs.getInt("id");
//                    int age = rs.getInt("age");
//                    String first = rs.getString("first");
//                    String last = rs.getString("last");
//
//                    //Display values
//                    System.out.print("ID: " + id);
//                    System.out.print(", Age: " + age);
//                    System.out.print(", First: " + first);
//                    System.out.println(", Last: " + last);
//                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Column list of table " + tableName);
        System.out.println(resultList);

        return resultList;
    }

    static List<Book> listBook(String tableName) {

        List<Book> resultList = new ArrayList<>();


        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM " + tableName;
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {

                    Book book = new Book();
                    book.setId(rs.getLong("id"));
                    book.setName(rs.getString("name"));
                    book.setAuthor(rs.getString("author"));
                    resultList.add(book);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Content of table " + tableName);
        System.out.println(resultList);

        return resultList;
    }
}