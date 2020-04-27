package utilities;

import classes.OrderInterface;
import classes.*;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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

    public static ArrayList<Meal> mealsInfo(String mealType){
        try {
            mealType = mealType.toLowerCase();
            //return executeStatment("select * from website_user where username='" + username + "'").getFetchSize() > 0;
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "temp", "temp");

            Statement stmt = connection.createStatement();
            ResultSet resultSet = null;

            if(mealType.endsWith("burger")){
                resultSet = stmt.executeQuery("select * from burger");
            }else if(mealType.endsWith("pizza")){
                resultSet = stmt.executeQuery("select * from pizza");
            }else{
                resultSet = stmt.executeQuery("select * from pasta");
            }

            ArrayList<Meal> ret = new ArrayList<>();
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

    public static Meal getMealByName(String mealName){
        try {
            //return executeStatment("select * from website_user where username='" + username + "'").getFetchSize() > 0;
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "temp", "temp");

            Statement stmt = connection.createStatement();
            ResultSet resultSet = null;

            if(mealName.endsWith("urger")){
                resultSet = stmt.executeQuery("select * from burger where name = '" + mealName + "'");
            }else if(mealName.endsWith("izza")){
                resultSet = stmt.executeQuery("select * from pizza where name='" + mealName + "'");
            }else{
                resultSet = stmt.executeQuery("select * from pasta where name = '" + mealName + "'");
            }

            Meal meal = null;
            if(resultSet.next()){
                meal = new Meal();
                meal.setName(resultSet.getString(1));
                meal.setUrlKey(resultSet.getString(2));
                meal.setPrice(resultSet.getDouble(3));
            }

            connection.close();

            return meal;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public static Cart getCart(String username){
        try {
            //return executeStatment("select * from website_user where username='" + username + "'").getFetchSize() > 0;
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "temp", "temp");

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from user_order where username='" + username + "' and type='cart'");

            Cart ret = null;
            if(resultSet.next()) {
                ret = new Cart();
                ret.setOrderId(resultSet.getString(1));
            }

            connection.close();

            if(ret == null)
                return ret;

            ret.addOrders(getAllMealOrders(username, ret.getOrderId()));

            return ret;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public static Cart getOrder(String username, String id){
        try {
            //return executeStatment("select * from website_user where username='" + username + "'").getFetchSize() > 0;
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "temp", "temp");

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from user_order where order_id = '" + id + "'");

            if(resultSet == null)
                return null;

            Cart ret = null;
            if(resultSet.next()) {
                ret = new Cart();
                ret.setOrderId(resultSet.getString(1));
            }

            connection.close();

            if(ret == null)
                return ret;

            ret.addOrders(getAllMealOrders(username, ret.getOrderId()));

            return ret;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    private static List<OrderInterface> getAllMealOrders(String username, String orderId) {
        List<OrderInterface> orders = new ArrayList<>();
        List<OrderInterface> tmp = getAllBurgerOrders(username, orderId);
        if(tmp != null)
            orders.addAll(tmp);
        tmp = getAllPastaOrders(username, orderId);
        if(tmp != null)
            orders.addAll(tmp);
        tmp = getAllPizzaOrders(username, orderId);
        if(tmp != null)
            orders.addAll(tmp);
        return orders;
    }

    private static List<OrderInterface> getAllBurgerOrders(String username, String orderId) {
        try {
            //return executeStatment("select * from website_user where username='" + username + "'").getFetchSize() > 0;
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "temp", "temp");

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from burger_order where order_Id = '" + orderId + "'");

            if(resultSet == null)
                return null;

            List<OrderInterface> orders = null;
            while(resultSet.next()){
                BurgerOrder burgerOrder = new BurgerOrder();
                burgerOrder.setName(resultSet.getString(1));
                burgerOrder.setOrderId(resultSet.getString(2));
                burgerOrder.setMeatWeight(resultSet.getInt(3));
                burgerOrder.setCheese(resultSet.getInt(4));
                burgerOrder.setTomato(resultSet.getInt(5));
                burgerOrder.setLettuce(resultSet.getInt(6));
                burgerOrder.setTotalPrice(resultSet.getDouble(7));
                if(orders == null)
                    orders = new ArrayList<>();
                orders.add(burgerOrder);
            }

            connection.close();

            return orders;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    private static List<OrderInterface> getAllPizzaOrders(String username, String orderId) {
        try {
            //return executeStatment("select * from website_user where username='" + username + "'").getFetchSize() > 0;
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "temp", "temp");

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from pizza_order where order_id = '" + orderId + "'");

            if(resultSet == null)
                return null;

            List<OrderInterface> orders = null;
            while(resultSet.next()){
                PizzaOrder pizzaOrder = new PizzaOrder();
                pizzaOrder.setName(resultSet.getString(1));
                pizzaOrder.setOrderId(resultSet.getString(2));
                pizzaOrder.setOlive(resultSet.getInt(3));
                pizzaOrder.setOnion(resultSet.getInt(4));
                pizzaOrder.setCorn(resultSet.getInt(5));
                pizzaOrder.setTotalPrice(resultSet.getDouble(6));
                if(orders == null)
                    orders = new ArrayList<>();
                orders.add(pizzaOrder);
            }

            connection.close();

            return orders;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    private static List<OrderInterface> getAllPastaOrders(String username, String orderId) {
        try {
            //return executeStatment("select * from website_user where username='" + username + "'").getFetchSize() > 0;
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "temp", "temp");

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from pasta_order where orderid = '" + orderId + "'");

            if(resultSet == null)
                return null;

            List<OrderInterface> orders = null;
            while(resultSet.next()){
                PastaOrder pastaOrder = new PastaOrder();
                pastaOrder.setName(resultSet.getString(1));
                pastaOrder.setOrderId(resultSet.getString(3));
                pastaOrder.setMeatType(resultSet.getString(2));
                pastaOrder.setTotalPrice(resultSet.getDouble(4));
                if(orders == null)
                    orders = new ArrayList<>();
                orders.add(pastaOrder);
            }

            connection.close();

            return orders;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public static Cart newCart(String username) throws Exception {
        username = username.trim();


        try {
            //return executeStatment("select * from website_user where username='" + username + "'").getFetchSize() > 0;
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "temp", "temp");

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("insert into user_order values('" + (username + System.currentTimeMillis()) + "', '" + username + "', 'cart')");
            connection.close();


            Cart ret = getCart(username);

            return ret;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public static void addOrder(OrderInterface order) {
        try {
            //return executeStatment("select * from website_user where username='" + username + "'").getFetchSize() > 0;
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "temp", "temp");

            Statement stmt = connection.createStatement();
            if (order.getName().endsWith("urger")) {
                ResultSet resultSet = stmt.executeQuery("insert into burger_order values('" + order.getName() + "', '" + order.getOrderId() + "',  " + ((BurgerOrder) order).getMeatWeightInt() + ", " + ((BurgerOrder) order).getCheeseInt() + ", " + ((BurgerOrder) order).getTomatoInt() + ", " + ((BurgerOrder) order).getLettuceInt() + ", " + ((BurgerOrder) order).getTotalPrice() + ")");
            } else if (order.getName().endsWith("izza")) {
                ResultSet resultSet = stmt.executeQuery("insert into pizza_order values('" + order.getName() + "', '" + order.getOrderId() + "',  " + ((PizzaOrder) order).getOliveInt() + ", " + ((PizzaOrder) order).getOnionInt() + ", " + ((PizzaOrder) order).getCornInt() + ", " + ((PizzaOrder) order).getTotalPrice() + ")");
            } else {
                ResultSet resultSet = stmt.executeQuery("insert into pasta_order values('" + order.getName() + "', '" + ((PastaOrder) order).getMeatType() + "',  '" + order.getOrderId() + "', " + ((PastaOrder) order).getTotalPrice() + ")");
            }

            connection.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();

        }
    }

    public static void cleanCart(String username, double totalPrice) {
        String id = getCart(username).getOrderId();
        try {
            Clock clock = Clock.systemDefaultZone();
            Instant instant = clock.instant();   // or Instant.now();
            long seconds = instant.getEpochSecond();
            //return executeStatment("select * from website_user where username='" + username + "'").getFetchSize() > 0;
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "temp", "temp");

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("insert into history values ('" + id + "', '" +  username + "', " + totalPrice + ", CURRENT_DATE)");
            resultSet = stmt.executeQuery("update user_order set type ='purchased' where order_Id = '" + id + "'");

            connection.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();

        }
    }

    public static History getHistory(String username) {
        try {
            //return executeStatment("select * from website_user where username='" + username + "'").getFetchSize() > 0;
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "temp", "temp");

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from history where username = '" + username + "'");

            History history = null;
            while(resultSet.next()){
                if(history == null)
                    history = new History();
                Cart cart = getOrder(username, resultSet.getString(1));
                cart.setDate(dateToString(resultSet.getDate(4), "dd/MMMM/yyyy hh:mm"));
                history.addOrders(cart);
            }

            connection.close();

            return history;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    private static String dateToString(java.util.Date date,String format) {
        if (date != null) {
            DateFormat formatter = new SimpleDateFormat(format);
            String sdate = formatter.format(date);
            return sdate;
        } else {
            return null;
        }
    }
}
