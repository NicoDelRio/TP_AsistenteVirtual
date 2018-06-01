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
	    		return pedido.getNameUsuario() + ", las tres leyes de la robótica son: \n" +
					"1- Un robot no hará daño a un ser humano, ni permitirá con su inacción que sufra daño.\n" + 
					"2- Un robot debe cumplir las órdenes dadas por los seres humanos, a excepción de aquellas que entrasen en conflicto con la primera ley.\n" + 
					"3- Un robot debe proteger su propia existencia en la medida en que esta protección no entre en conflicto con la primera o con la segunda ley";
	    	}
	    }
	    
	    String regexPrimera = ".*(?:primer|1).*(?:ley de la robotica).*";
	    Pattern patternPrimera = Pattern.compile(regexPrimera, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
	    Matcher matcherPrimera = patternPrimera.matcher(pedido.getMensaje());
	    while(matcherPrimera.find()) {
	    	if(matcherPrimera.matches()) {
	    		return pedido.getNameUsuario() + ", la primera ley de la robótica es: \n" + 
	    				"Un robot no hará daño a un ser humano, ni permitirá con su inacción que sufra daño.";
	    	}
	    }
	    
	    String regexSegunda = ".*(?:segun|2).*(?:ley de la robotica).*";
	    Pattern patternSegunda = Pattern.compile(regexSegunda, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
	    Matcher matcherSegunda = patternSegunda.matcher(pedido.getMensaje());
	    while(matcherSegunda.find()) {
	    	if(matcherSegunda.matches()) {
	    		return pedido.getNameUsuario() + ", la segundea ley de la robótica es: \n" + 
	    				"Un robot debe cumplir las órdenes dadas por los seres humanos, a excepción de aquellas que entrasen en conflicto con la primera ley.";
	    	}
	    }
	    
	    String regexTercera = ".*(?:tercer|3).*(?:ley de la robotica).*";
	    Pattern patternTercera = Pattern.compile(regexTercera, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
	    Matcher matcherTercera = patternTercera.matcher(pedido.getMensaje());
	    while(matcherTercera.find()) {
	    	if(matcherTercera.matches()) {
	    		return pedido.getNameUsuario() + ", la tercera ley de la robótica es: \n" + 
	    				"Un robot debe proteger su propia existencia en la medida en que esta protección no entre en conflicto con la primera o con la segunda ley";
	    	}
	    }
	    
	    return siguiente.calcular(pedido);
	}

}
