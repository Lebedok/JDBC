package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JDBCpractice {



    /*
    Connection --> it helps us to provide database credentials and connect to the database
    Statement -->  we define our conditions to get the result from database
    ResultSet --> We store the data from database to the resultset object in java
    Three of them are INTERFACE
    DataBase connectivity is INTERFACE
     */

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@techtorial.chv2pkalqzis.us-east-2.rds.amazonaws.com:1521/ORCL",
                "Nargiza",
                "GizaGo1990"
        );

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees");
        resultSet.next();  // it will go to the next row. If there is  a next() row it will return TRUE if No it will return FALSE
        System.out.println(resultSet.getString("first_name"));

        resultSet.last();  // it will go to last row
        //resultSet.first();  -- it will go to the first row
        // resultSet.beforeFirst();  -- it will go to the column names
        System.out.println(resultSet.getString("last_name"));
        System.out.println(resultSet.getRow());  // 107
        System.out.println(resultSet.next());  // false


        //----------------------
        resultSet.beforeFirst();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        // METADATA --> information about your columns, row ect in your table
        System.out.println(resultSetMetaData.getColumnCount());
        System.out.println(resultSetMetaData.getColumnName(3));


        List<Map<String, Object>>employees = new ArrayList<>();

        while (resultSet.next()){
            Map<String, Object> employee = new LinkedHashMap<>();

            for (int i = 1; i < resultSetMetaData.getColumnCount(); i++){
                employee.put(resultSetMetaData.getColumnName(i),resultSet.getObject(i));
            }

            employees.add(employee);
        }

        System.out.println(employees.get(2).get("EMAIL"));



    }
}
