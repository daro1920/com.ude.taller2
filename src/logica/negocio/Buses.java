package logica.negocio;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;
import java.util.Date;


public class Buses {
	
private  Map<String,Bus> buses = new TreeMap<>();

public void agregarBus(Bus bus){
	buses.put(bus.matricula, bus);
}

public Bus obtenerBusDisponible(Date fechaHoraPartida, Date fechaHoraRegreso){
	
	Bus auxiliar = buses.info;
	for(int i=0;i<auxiliar.excursionesAsignadas.lenght();i++){
		exAuxiliar = auxiliar.excursionesAsignadas[i];
		if(exAuxiliar.fechaHoraPartida > fechaHoraRegreso || exAuxiliar.fechaHoraRegreso < fechaHoraPardida)
			return auxiliar;
		else
			return obtenerBusDisponible( fechaHoraPartida, fechaHoraRegreso);
	}
	
}
public boolean hayBusDisponible(Date fechaHoraPartida, Date fechaHoraRegreso){
	boolean hayBus= false;
	Bus auxiliar = buses.info;
	for(int i=0;i<auxiliar.excursionesAsignadas.lenght();i++){
		exAuxiliar = auxiliar.excursionesAsignadas[i];
		if(exAuxiliar.fechaHoraPartida > fechaHoraRegreso || exAuxiliar.fechaHoraRegreso < fechaHoraPardida)
			hayBus =  true;
		else
			return hayBusDisponible( fechaHoraPartida, fechaHoraRegreso);
	}	
	
}


}
