package gui.desktop.control;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import gui.desktop.vista.VenderBoleto;
import logica.excepciones.ConfiguracionException;
import logica.excepciones.NoExisteExcursionException;
import logica.excepciones.NoHayAsientosDisponiblesException;
import logica.negocio.IFachada;
import logica.valueobjects.VOBoletoEntrada;
import logica.valueobjects.VOBoletoEspecialEntrada;

public class ControladorVenderBoleto {
	
	private VenderBoleto ventana;
	private IFachada fachada;
	
	public ControladorVenderBoleto(VenderBoleto ventana) {
		this.ventana = ventana;
		try {
			fachada = FachadaWraper.getInstance().getFachada();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			ventana.actuarAnteErrorConexionInicial();
		} catch (ConfiguracionException e) {
			ventana.actuarAnteErrorConfiguracionInicial();
		}
	}
	
	public void venderBoleto(int edad,String procedencia,String celular,
			String nroExcursion,int descuento) {
		
		VOBoletoEntrada voBoleto;
		if(descuento > 0) {
			voBoleto = new VOBoletoEspecialEntrada(new BigDecimal(descuento), nroExcursion, edad, procedencia, celular);
		} else {
			voBoleto = new VOBoletoEntrada(nroExcursion, edad, procedencia, celular);
		}
		try {
			fachada.venderBoleto(voBoleto);
			ventana.notificarRegistroExitoso();
		} catch (RemoteException e) {
			ventana.actuarAnteErrorConexionMetodo();
		} catch (NoExisteExcursionException e) {
			ventana.actuarAnteNoExisteExcursion();
		} catch (NoHayAsientosDisponiblesException e) {
			ventana.actuarAnteNoHayAsientosDisponibles();
		}
	}

}
