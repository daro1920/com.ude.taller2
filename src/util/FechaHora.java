package util;

import java.util.Calendar;
import java.util.Date;

public final class FechaHora {
	
	private FechaHora() {}
	
	public static Date obtenerFechaHora(int dia, int mes, int anio, int hora, int minuto) {

		Calendar calendario = Calendar.getInstance();
		calendario.setTimeInMillis(0);
		calendario.set(anio, mes, dia, hora, minuto, 0);

		return calendario.getTime();
		
	}

}
