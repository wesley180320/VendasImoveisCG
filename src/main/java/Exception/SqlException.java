package exception;

public class SqlException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SqlException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
