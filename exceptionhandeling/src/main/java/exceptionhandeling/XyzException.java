package exceptionhandeling;

public class XyzException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public XyzException(String message) {
		super();
		this.message = message;
	}
	public XyzException() {
		super();
	}
	public String getMessage() {
		System.out.println(message);
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
