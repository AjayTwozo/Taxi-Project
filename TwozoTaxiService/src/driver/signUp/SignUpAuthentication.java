package driver.signUp;

public class SignUpAuthentication {

    private static final SignUpMenuImpl SIGNUP_MENU = new SignUpMenuImpl();
    public static void printSignUpInfo() {
        System.out.println("name :" +
                SIGNUP_MENU.getName());
        System.out.println("mobile no" + SIGNUP_MENU.getMobileNumber());
        //System.out.println(SIGNUP_MENU.getRegistration());
        System.out.println("pass" + SIGNUP_MENU.getPassword());
        System.out.println("confirm" + SIGNUP_MENU.getConfirmPassword());
    }
}
