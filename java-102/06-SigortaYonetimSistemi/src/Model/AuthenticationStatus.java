package Model;

public enum AuthenticationStatus {
    SUCCESS (1), FAIL (2);

    private final int status;

    AuthenticationStatus(int status) {
        this.status=status;
    }

    public int getStatus() {
        return status;
    }
}