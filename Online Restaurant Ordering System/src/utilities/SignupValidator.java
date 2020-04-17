package utilities;

import java.util.regex.*;

public class SignupValidator {
    private String email;
    private String username;
    private String password;
    private String passwordConfirmation;

    public static String validateEmail(String email){
        if(email == null || email.length() == 0)
            return "Email is Null";

        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        String message;

        if(Pattern.matches(regex, email)) {
            message = DbUtility.checkEmailAvailability(email) ? emailExist() : emailDoesntExist();
        }else{
            message = emailNotValid();
        }

        return message;
    }

    public static boolean validateEmailBoolean(String email){
        if(email == null || email.length() == 0)
            return true;

        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        if(Pattern.matches(regex, email)) {
            return DbUtility.checkEmailAvailability(email);
        }else{
            return true;
        }
    }

    public static String validateUsername(String username){
        return validateUsernameBoolean(username) ? usernameExist() : usernameDoesntExist();
    }

    public static boolean validateUsernameBoolean(String username){
        if(username == null || username.length() == 0)
            return true;

        return DbUtility.checkUsernameAvailability(username);
    }

    public static boolean validatePassword(String password){
        if(password == null || password.length() == 0)
            return true;

        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        return !matcher.matches();
    }

    public static boolean validatePasswordConfirmation(String password, String passwordConfirmation){
        if(password == null || password.length() == 0 || passwordConfirmation == null || passwordConfirmation.length() == 0)
            return true;

        return !password.equals(passwordConfirmation);
    }

    public static boolean validateUser(String username, String email, String password, String passwordConfirmation){
        return validateUsernameBoolean(username) || validateEmailBoolean(email)
                || validatePassword(password) || validatePasswordConfirmation(password, passwordConfirmation);
    }

    private static String usernameDoesntExist(){
        return "<p id=\"check2\" class=\"valid\"> Username Is Available </p>";
    }

    private static String usernameExist(){
        return "<p id=\"check1\" class=\"invalid\"> Username Is Not Available </p>";
    }

    private static String emailExist(){
        return "<p class=\"invalid\"> An Account with this Email exists </p>";
    }

    private static String emailDoesntExist(){
        return "<p class=\"valid\"> Email Accepted </p>";
    }
    private static String emailNotValid(){
        return "<p class=\"invalid\"> Email Is Not Valid </p>";
    }
}
