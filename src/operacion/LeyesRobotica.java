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
		
	    String regex = ".* (las 3 leyes|las tres leyes|las leyes|la \\w*) .*(?:de la robotica|ley de la robotica).*";
	    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
	    Matcher matcher = pattern.matcher(pedido.getMensaje());
	    while(matcher.find()) {
	    	if(matcher.matches()) {
	    		
	    		if(matcher.group(1).contains("las 3 leyes") || matcher.group(1).contains("las tres leyes") || matcher.group(1).contains("las leyes") ) {
	    		return pedido.getNameUsuario() + ", las tres leyes de la rob�tica son: \n" +
					"1- Un robot no har� da�o a un ser humano, ni permitir� con su inacci�n que sufra da�o.\n" + 
					"2- Un robot debe cumplir las �rdenes dadas por los seres humanos, a excepci�n de aquellas que entrasen en conflicto con la primera ley.\n" + 
					"3- Un robot debe proteger su propia existencia en la medida en que esta protecci�n no entre en conflicto con la primera o con la segunda ley";
	    		}

	    		if(matcher.group(1).contains("la 1") || matcher.group(1).contains("la primer")) {
		    		return pedido.getNameUsuario() + ", la primera ley de la rob�tica es: \n" + 
    				"Un robot no har� da�o a un ser humano, ni permitir� con su inacci�n que sufra da�o.";
	    		}

	    		if(matcher.group(1).contains("la 2") || matcher.group(1).contains("la segun")) {
		    		return pedido.getNameUsuario() + ", la segundea ley de la rob�tica es: \n" + 
    				"Un robot debe cumplir las �rdenes dadas por los seres humanos, a excepci�n de aquellas que entrasen en conflicto con la primera ley.";
	    		}

	    		if(matcher.group(1).contains("la 3") || matcher.group(1).contains("la terc")) {
		    		return pedido.getNameUsuario() + ", la tercera ley de la rob�tica es: \n" + 
    				"Un robot debe proteger su propia existencia en la medida en que esta protecci�n no entre en conflicto con la primera o con la segunda ley";
	    		}

	    		return pedido.getNameUsuario() + ", las leyes de la rob�tica son tres.";
	    	}
	    }
	    
	    return siguiente.calcular(pedido);
	}

}
