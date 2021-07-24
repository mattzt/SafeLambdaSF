package model;

public class Login {
    private boolean validLogin;

    public Login(String inputUser,String inputPass){
        validLogin = Authenticator.validate(inputUser,inputPass);
    }
}
