package logica.excepciones;

@SuppressWarnings("serial")
public class YaExisteBusException extends Exception {
	
	public YaExisteBusException() {
		super();
	}

	public YaExisteBusException(String message) {
		super(message);
	}
}
