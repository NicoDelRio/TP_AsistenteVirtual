package operacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clase.Pedido;

public class Juego implements Operacion {
	
	private int contador;
	private int numeroPensado;
	private int min;
	private int max;
	private int numeroCalculado;
	private boolean estoyPensando;
	private boolean estoyAdivinando;
	
	private Operacion siguiente;

	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;		
	}


	@Override
	public String calcular(Pedido pedido) {
		String regex;

		contador = pedido.getContador();
		numeroPensado = pedido.getNumeroPensado();
		min = pedido.getMin();
		max = pedido.getMax();
		numeroCalculado = pedido.getNumeroCalculado();
		estoyPensando = pedido.isEstoyPensando();
		estoyAdivinando = pedido.isEstoyAdivinando();
		
		if(estoyPensando) {
			regex = ".*es el (.+).+.*";
			Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(pedido.getMensaje());
			while(matcher.find()) {
				if(matcher.matches()) {
					contador++;
					int numeroRecibido = Integer.parseInt(matcher.group(1));
					if(numeroPensado < numeroRecibido) {
						pedido.setJuego(contador, numeroPensado, min, max, numeroCalculado, estoyPensando, estoyAdivinando);
						return pedido.getNameUsuario() + " más chico";
					}
					else if(numeroPensado > numeroRecibido) {
						pedido.setJuego(contador, numeroPensado, min, max, numeroCalculado, estoyPensando, estoyAdivinando);
						return pedido.getNameUsuario() + " más grande";
					}
					else {
						estoyPensando = false;
						pedido.setJuego(contador, numeroPensado, min, max, numeroCalculado, estoyPensando, estoyAdivinando);
						return pedido.getNameUsuario() + " ¡si! Adivinaste en " + contador + " pasos...";
					}
				}
			}
			pedido.setJuego(contador, numeroPensado, min, max, numeroCalculado, estoyPensando, estoyAdivinando);
			return siguiente.calcular(pedido); // Si está pensando y no se manda algo relacionado al juego continúa la cadena pero puede seguir jugando
		}
		
		if(estoyAdivinando) {
			regex = ".*listo.*";
			Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(pedido.getMensaje());
			while(matcher.find()) {
				if(matcher.matches()) {
					numeroCalculado = (int) Math.floor((min + max)/2);
					System.out.println("Se ejecuto estoyAdivinando: " + numeroCalculado);
					pedido.setJuego(contador, numeroPensado, min, max, numeroCalculado, estoyPensando, estoyAdivinando);
					return pedido.getNameUsuario() + " ¿es el " + numeroCalculado + "?";
				}
			}
			
			regex = ".*mas (.+).*";
			pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
			matcher = pattern.matcher(pedido.getMensaje());
			while(matcher.find()) {
				if(matcher.matches()) {
					System.out.println("Se ejecuto estoyAdivinando: " + numeroCalculado);
					if(matcher.group(1).equals("chico")) {
						System.out.println("Se ejecuto estoyAdivinando: mas chico");
						max = numeroCalculado;
					}
					else if(matcher.group(1).equals("grande")) {
						System.out.println("Se ejecuto estoyAdivinando: mas grande");
						min = numeroCalculado;
					}
					
					numeroCalculado = (int) Math.floor((min + max) / 2);
					System.out.println("Se ejecuto estoyAdivinando: " + numeroCalculado);
					pedido.setJuego(contador, numeroPensado, min, max, numeroCalculado, estoyPensando, estoyAdivinando);
					return pedido.getNameUsuario() + " ¿es el " + numeroCalculado + "?";
				}
			}
			
			regex = ".*si.*";
			pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
			matcher = pattern.matcher(pedido.getMensaje());
			while(matcher.find()) {
				if(matcher.matches()) {
					min = 1;
					max = 100;
					estoyAdivinando = false;
					pedido.setJuego(contador, numeroPensado, min, max, numeroCalculado, estoyPensando, estoyAdivinando);
					return pedido.getNameUsuario() + " fue divertido :)";
				}
			}
		}
		
		regex = ".*jugamos.+pensa.*";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		Matcher matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
				this.contador = 0;
				this.estoyPensando = true;
				// System.out.println(estoyPensando); Se pone en true
				this.numeroPensado = (int) (Math.random() * 100) + 1; // Pensar número aleatorio entre 1 y 100
//				this.numeroPensado = 12;
				pedido.setJuego(contador, numeroPensado, min, max, numeroCalculado, estoyPensando, estoyAdivinando);
				return pedido.getNameUsuario() + " ¡listo!";
			}
		}
		
		regex = ".*jugamos.+.*";
		pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
				this.estoyAdivinando = true;
				pedido.setJuego(contador, numeroPensado, min, max, numeroCalculado, estoyPensando, estoyAdivinando);
				return pedido.getNameUsuario() + " ¡sale y vale! Pensá un número del 1 al 100";
			}
		}
		
		return siguiente.calcular(pedido);
	}

}
