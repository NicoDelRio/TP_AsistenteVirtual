package operacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clase.Pedido;

public class LeyesRobotica implements Operacion{

	private Operacion siguiente;

	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;		
	}


	@Override
	public String calcular(Pedido pedido) {
	    String regex = ".*(?:leyes de la robotica).*";
	    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
	    Matcher matcher = pattern.matcher(pedido.getMensaje());
	    while(matcher.find()) {
	      if(matcher.matches()) {
	        return pedido.getNameUsuario() + ", las 3 leyes de la robótica son:" + "\n" 
	                + "1- Un robot no puede hacer daño a un ser humano o, por inanición, "
	                + "permitir que un ser humano sufra daño." + "\n"
	                + "2- Un robot debe obedecer las ordenes dadas por los seres humanos, "
	                + "excepto si estas órdenes entrasen en conflicto con la primera ley." + "\n"
	                + "3- Un robot debe proteger su propia existencia en la medida en que esta "
	                + "protección no entre en conflicto con la primera o la segunda ley.";
	      }
	    }
	    return siguiente.calcular(pedido);

  }
}
