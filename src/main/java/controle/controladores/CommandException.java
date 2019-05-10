package controle.controladores;

public class CommandException extends Exception {

	private Integer statusHttp;
	
	public CommandException(String message, Integer statusHttp) {
		super(message);
		this.statusHttp = statusHttp;
	}

	public Integer getStatusHttp() {
		return statusHttp;
	}

	public void setStatusHttp(Integer statusHttp) {
		this.statusHttp = statusHttp;
	}
	
}
