package service;

/**
 * Displays users the SignUp Menu to put in their information
 * Such as Name, Mobile Number, Password
 *
 * @author Ajay
 * @version 1.0
 */
public interface SignUpMenu {
    String getName();

    String getMobileNo();

    String getPassword();

    String getConfirmPassword();
}