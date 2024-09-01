package assessment.email.domain;

/**
 * This class holds login specific details
 * @author Kanagarajan
 */
public class LoginDetails {

    private String userName;

    private String passWord;

    public LoginDetails(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LoginDetails{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", passWord='").append("<masked>").append('\'');
        sb.append('}');
        return sb.toString();
    }
}
