package utils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MAINjdbc {
    public static void main(String[] args) throws SQLException {

        JDBCutils.establishConnection();
        // print Asia region
        List<Map<String, Object>> regions = JDBCutils.executeQuery("select * from regions");

        System.out.println(regions.get(2).get("REGION_NAME"));


        // print all country name
        List<Map<String, Object>> countries = JDBCutils.executeQuery("select * from countries");
        for (int i =0; i<countries.size(); i++){  // countries.size() gives us how many rows we have
            System.out.println(countries.get(i).get("COUNTRY_NAME"));

        }

        JDBCutils.closeConnection();
    }
}
