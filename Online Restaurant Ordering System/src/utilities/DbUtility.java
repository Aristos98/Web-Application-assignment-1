package utilities;

public class DbUtility {

    private static boolean startConnection(){
        return true;
    }

    private static boolean endConnection(){
        return true;
    }

    public static boolean checkUserExist(final String username, final String password){
        return true;
    }

    public static boolean checkUsernameAvailability(String username) {
        return (username.equals("120107")) ? true : false;
    }

    public static boolean checkEmailAvailability(String email) {
        return (email.equals("haabusahyoon16@cit.just.edu.jo")) ? true : false;
    }
}
