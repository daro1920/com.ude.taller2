package gui.desktop.control;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import configuracion.Configuracion;
import logica.excepciones.ConfiguracionException;
import logica.negocio.IFachada;

public class FachadaWraper {
	
	private static FachadaWraper instance;
	
	private IFachada fachada;
	
	private FachadaWraper() throws MalformedURLException, RemoteException, ConfiguracionException, NotBoundException {
		obtenerFachadaRemota();
	}
	
	private void obtenerFachadaRemota() throws ConfiguracionException, MalformedURLException, RemoteException, NotBoundException {
		String ipServidor = Configuracion.getProperty("ipServidor");
		String puertoServidor = Configuracion.getProperty("puertoServidor");
		fachada = (IFachada) Naming.lookup("//" + ipServidor + ":" + puertoServidor + "/fachada");
	}
	
	public synchronized static FachadaWraper getInstance() throws MalformedURLException, RemoteException, ConfiguracionException, NotBoundException {
		if (instance == null) {
			instance = new FachadaWraper();
		}
		return instance;
	}
	
	public IFachada getFachada() {
		return fachada;
	}

}
