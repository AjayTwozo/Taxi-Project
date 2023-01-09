package service;

/**
 * Acquires name, mobile no, password from the users
 *
 * @author Ajay
 * @version 1.0
 */
public class SignUpMenuImpl implements SignUpMenu {
    private String name;
    private String mobileNumber;
    private String password;
    private String retypePassword;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNumber;
    }

    public void setMobileNo(final String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return retypePassword;
    }

    public void setConfirmPassword(final String retypePassword) {
        this.retypePassword = retypePassword;
    }
}





