package ee.bcs.valiit.securitiyconfiguration;

public class LoginRequest {
    private String clientName;
    private String password;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
