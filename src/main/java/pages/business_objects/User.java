package pages.business_objects;

public class User {

    private  String emailUrl;
    private  String login;
    private  String password;

    public void setEmailUrl(String emailUrl) {
        this.emailUrl = emailUrl;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailUrl() {
        return emailUrl;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
