package operacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clase.Pedido;

public class ChuckNorrisFacts implements Operacion{

	private Operacion siguiente;
	
	private int contadorChuck;
	
	private String[] v_ChuckNorrisFacts = {
			"Chuck Norris arrojó una granada y mató a 50 personas, luego explotó.",
			"Chuck Norris contó hasta el infinito. Dos veces.",
			"Chuck Norris puede recoger naranjas de un manzano y hacer la mejor limonada que haya probado en su vida.",
			"Una vez, una cobra mordió la pierna de Chuck Norris. Después de cinco días de dolor insoportable, la cobra murió.",
			"No existe una teoría de la evolución, solo una lista de las criaturas que Chuck Norris permite vivir.",
			"Chuck Norris puede matar a tus amigos imaginarios.",
			"Chuck Norris es la única persona que puede golpear un cíclope entre los ojos.",
			"Chuck Norris puede estrangularte con un teléfono inalámbrico.",
			"Chuck puede prender fuego a las hormigas con una lupa. Por la noche.",
			"Chuck Norris hace llorar a las cebollas.",
			"Chuck Norris es la razón por la que Waldo se está escondiendo.",
			"El tipo de sangre de Chuck Norris es AK-47."
	};
	
	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;		
	}


	@Override
	public String calcular(Pedido pedido) {
		
		String regex = ".*(?:dime|deci|cuent|conta).*(?:chuck|norris).*";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		Matcher matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
				String fact = v_ChuckNorrisFacts[contadorChuck++ % v_ChuckNorrisFacts.length];
				return "" + pedido.getNameUsuario() + ", " + fact;
			}
		}
		return siguiente.calcular(pedido);
	}

}
