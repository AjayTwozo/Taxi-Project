package driver.login;

public class LoginAuthentication {
    private static final LoginMenuImpl LOGIN_MENU = new LoginMenuImpl();

    public static void printLoginInfo() {
        LOGIN_MENU.typeRegistration();
        LOGIN_MENU.typeMobileNumber();
        LOGIN_MENU.typePassword();
    }
}
