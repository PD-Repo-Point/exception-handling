package pd.workshop.exception;

public class EmployeeAlreadyExistsException
        extends RuntimeException {

    private String message;

    public EmployeeAlreadyExistsException(){}

    public EmployeeAlreadyExistsException(String msg){
        super(msg);
        this.message = msg;
    }

}
