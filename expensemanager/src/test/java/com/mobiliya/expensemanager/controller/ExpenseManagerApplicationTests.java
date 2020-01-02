package com.mobiliya.expensemanager.controller;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mobiliya.expensemanager.dto.CategoryDto;
import com.mobiliya.expensemanager.dto.ExpenseDto;

// TODO: Auto-generated Javadoc
/**
 * The Class ExpenseControllerTest.
 * 
 * @author Nitin
 */
@SpringBootTest
public class ExpenseManagerApplicationTests {
    
    /** The Constant JDBC_DRIVER. */
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    
    /** The Constant DB_URL. */
    static final String DB_URL = "jdbc:mysql://localhost:3306/expensemanager?"
    + "createDatabaseIfNotExist=true";

    /** The Constant USER. */
    // Database credentials
    static final String USER = "root";
    
    /** The Constant PASS. */
    static final String PASS = "root";

    /** The conn. */
    Connection conn = null;
    
    /** The stmt. */
    Statement stmt = null;

    /**
     * Adds the expense.
     */
    @Test
    public void addExpense() {
        Date date=new Date();
        date.setYear(119);
        date.setMonth(11);
        date.setDate(19);
        date.setHours(00);
        date.setMinutes(00);
        date.setSeconds(00);
        ExpenseDto dto=new ExpenseDto("Lunch",new CategoryDto("Food"), 1000, date);
        ExpenseDto dto2=dbConnection();
        assertEquals(dto,dto2);
        //assertThat(dto, is(dto2));
    }

    /**
     * Db connection.
     *
     * @return the expense dto
     */
    public ExpenseDto dbConnection() {
        ExpenseDto dto = new ExpenseDto();
        try {
            // STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            // STEP 4: Execute a query
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = "CREATE TABLE category (categoryid int(11) NOT NULL AUTO_INCREMENT,"
                    + "category_name varchar(255) DEFAULT NULL,PRIMARY KEY (categoryid))";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE expense (expenseid int(11) NOT NULL AUTO_INCREMENT,"
                    + "amount double NOT NULL,date datetime DEFAULT NULL,expense_title varchar(255)"
                    + " DEFAULT NULL,category int(11) NOT NULL,PRIMARY KEY "
                    + "(expenseid),KEY FK8qx7605jnyuedpdduhownyo5w (category))";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE category_list_of_expenses (category_categoryid int(11) "
                    + "NOT NULL,list_of_expenses_expenseid int(11) NOT NULL,"
                    + "UNIQUE KEY UK_dom0vtnw4goc96rikhfqyvfmk (list_of_expenses_expenseid),"
                    + "KEY FK4d3ucqmq4fb1sdplu8xnyosbn (category_categoryid))";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO expense VALUES (1,1000,'2019-12-19','Lunch',1)";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO category VALUES (1,'Food')";
            stmt.executeUpdate(sql);

            System.out.println("Inserted records into the table...");
            String sql2 = "SELECT * FROM expense";
            ResultSet rs = stmt.executeQuery(sql2);
            // STEP 5: Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                double amount = rs.getDouble("amount");
                String title = rs.getString("expense_title");
                Date date = rs.getDate("date");
                dto.setAmount(amount);
                dto.setDate(new Date(date.getYear(), date.getMonth(), date.getDate()));
                dto.setExpenseTitle(title);
                // Display values
                System.out.print("amount: " + amount);
                System.out.print(", title: " + title);
                System.out.println(", date: " + date);
            }
            rs.close();
            String sql3 = "SELECT * from category";
            ResultSet rs1 = stmt.executeQuery(sql3);

            while (rs1.next()) {
                String name = rs1.getString("category_name");
                dto.setCategory(new CategoryDto(name));
                // Display values
                System.out.println("Name: " + name);
            }
            rs1.close();
            
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            } // do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        System.out.println("Goodbye!");
        return dto;
    }
}
