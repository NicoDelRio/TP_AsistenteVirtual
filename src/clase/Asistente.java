package clase;

import database.HSQL;
import operacion.Interpretacion;

public class Asistente{
	
	private static final String USUARIO = "delucas";
	
	private String nameAsistente;
	private String nameUsuario = "@"+USUARIO;
	private Interpretacion interpretacion;
	private HSQL db;
	
	public Asistente(String nameAsistente) {
		this.nameAsistente = "@"+nameAsistente;
		interpretacion = new Interpretacion();
		this.db = new HSQL();
	}
	
	public String escuchar(String mensaje) {
		Pedido pedido = new Pedido(mensaje, nameUsuario, nameAsistente, db);
		return interpretacion.calcular(pedido);
	}

}
