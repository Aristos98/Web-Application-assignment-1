package utilities;

import classes.Meal;

import java.sql.*;
import java.util.ArrayList;

public class DbUtility {

    public static boolean checkUserExist(final String username, final String password) {
        ResultSet resultSet = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "temp", "temp");

            Statement stmt = connection.createStatement();
            resultSet = stmt.executeQuery("select * from website_user where username='" + username + "' and password='" + password + "'");

            if(resultSet == null)
                return true;

            boolean ret = resultSet.next();

            connection.close();

            return ret;
        } catch (ClassNotFoundException | SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public static boolean checkUsernameAvailability(String username) {
        try {
            //return executeStatment("select * from website_user where username='" + username + "'").getFetchSize() > 0;
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "temp", "temp");

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from website_user where username='" + username + "'");

            if(resultSet == null)
                return true;

            boolean ret = resultSet.next();

            connection.close();

            return ret;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            return true;
        }
    }

    public static boolean checkEmailAvailability(String email) {
        try {
            //return executeStatment("select * from website_user where username='" + username + "'").getFetchSize() > 0;
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "temp", "temp");

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from website_user where email='" + email + "'");

            if(resultSet == null)
                return true;

            boolean ret = resultSet.next();

            connection.close();

            return ret;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            return true;
        }
    }

    public static ArrayList<Meal> burgersInfo(){
        try {
            //return executeStatment("select * from website_user where username='" + username + "'").getFetchSize() > 0;
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "temp", "temp");

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from burger");

            ArrayList<Meal> ret = new ArrayList<>();
            resultSet.next();
            while(resultSet.next()){
                Meal meal = new Meal();
                meal.setName(resultSet.getString(1));
                meal.setUrlKey(resultSet.getString(2));
                meal.setPrice(resultSet.getDouble(3));
                ret.add(meal);
            }

            connection.close();

            return ret;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

}
