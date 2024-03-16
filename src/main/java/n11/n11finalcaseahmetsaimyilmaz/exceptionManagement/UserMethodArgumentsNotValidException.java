package n11.n11finalcaseahmetsaimyilmaz.exceptionManagement;

public class UserMethodArgumentsNotValidException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserMethodArgumentsNotValidException(String message) {
        super(message);
    }
}
