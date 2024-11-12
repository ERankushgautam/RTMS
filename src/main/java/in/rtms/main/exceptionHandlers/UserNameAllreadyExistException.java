package in.rtms.main.exceptionHandlers;

public class UserNameAllreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UserNameAllreadyExistException() {}
	
	public UserNameAllreadyExistException(String msg) {
		super(msg);
	}	
	
}
