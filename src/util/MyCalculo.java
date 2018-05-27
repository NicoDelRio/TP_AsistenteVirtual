package util;


import java.util.StringTokenizer;

// Clase que calcula el resultado de una expresiÃ³n recibida por string a travÃ©s de un Ã¡rbol
public class MyCalculo {

	private Pila pOperandos;              	// Pila de operandos
	private Pila pOperadores;             	// Pila de operadores
	private final String espacioEnBlanco; 	// Cadena de espacios en blanco
	private final String operadores;		// Cadena con operadores para expresiones
	private String[][] reemplazarPorNegativo = {{"+-", "+N"}, {"*-", "*N"}, {"--", "-N"}, {"/-", "/N"}, {"^-", "^N"}, {"(-", "(N"}};
	private String[][] reemplazarPorRaizCuadrada = {{"+√", "+2√"}, {"*√", "*2√"}, {"-√", "-2√"}, {"/√", "/2√"}, {"^√", "^2√"}, {"(√", "(2√"}};


	public MyCalculo() {
		pOperandos = new Pila();
		pOperadores = new Pila();
		espacioEnBlanco = " \t";
		operadores = ")+-*/N^√%(";  // Acomodados por precedencia
	}
	
	public double calcular(String expresion) {
		expresion = normalizar(expresion);
		NodoArbol n = construirArbol(expresion);
		return operar(n);
	}

	private String normalizar(String expresion) { 
		// Diferenciar el operador resta (binario) con los nÃºmeros negativos (unario)
		if(expresion.startsWith("-")) // Si el primer caracter es - reemplazar por N
			expresion = "N" + expresion.substring(1);
		for(String[] reemplazo : reemplazarPorNegativo) { // Hacer los reemplazos correspondientes al operador unario
			expresion = expresion.replace(reemplazo[0], reemplazo[1]);
		}
		expresion = expresion.replace("de", "*"); // MultiplicaciÃ³n implÃ­cita en porcentaje
		if(expresion.startsWith("√")) // Si el primer caracter es √ reemplazar por 2√
			expresion = "2√" + expresion.substring(1);
		for(String[] reemplazo : reemplazarPorRaizCuadrada) { // Hacer los reemplazos correspondientes a la raÃ­z cuadrada
			expresion = expresion.replace(reemplazo[0], reemplazo[1]);
		}
		
		return expresion;
	}

	// Construir un Ã¡rbol a partir de una expresiÃ³n aritmÃ©tica
	private NodoArbol construirArbol(String expresion) {
		StringTokenizer tokenizer;
		String token;
		NodoArbol raiz = null;

		tokenizer = new StringTokenizer(expresion, espacioEnBlanco + operadores, true);

		while (tokenizer.hasMoreTokens()) {

			token = tokenizer.nextToken();

			if (espacioEnBlanco.indexOf(token) >= 0) 
				// Si es un espacio en blanco: ignorar
				;

			else if (operadores.indexOf(token) < 0) {
				// Si es un operando: guardar como nodo del Ã¡rbol
				pOperandos.poner(new NodoArbol(token));

			} else if(token.equals(")")) {
				// Sacar elementos hasta encontrar (
				while (!pOperadores.estaVacia() && !pOperadores.verTope().equals("(")) {
					guardarSubArbol();
				}
				pOperadores.sacar();  // Sacar el parÃ©ntesis izquierdo

			} else {
				if (!token.equals("(") && !pOperadores.estaVacia()) {
					// Operador diferente de cualquier parÃ©ntesis
					String op = (String) pOperadores.verTope();
					while (!op.equals("(") && !pOperadores.estaVacia()
							&& operadores.indexOf(op) >= operadores.indexOf(token)) {
						guardarSubArbol();
						if (!pOperadores.estaVacia()) 
							op = (String) pOperadores.verTope();
					}
				}

				pOperadores.poner(token);  // Guardar el operador
			} // else

		} // while (tokenizer.hasMoreTokens())

		// Sacar todo lo que queda
		raiz = (NodoArbol)pOperandos.verTope();

		while (!pOperadores.estaVacia()) {
			if (pOperadores.verTope().equals("(")) {
				pOperadores.sacar();
			} else {
				guardarSubArbol();
				raiz = (NodoArbol) pOperandos.verTope();
			}
		}

		return raiz;
	}

	// Almacenar un subÃ¡rbol en la pila
	private void guardarSubArbol() {
		NodoArbol op = (NodoArbol) pOperandos.sacar();

		if(pOperadores.verTope().equals("%") || pOperadores.verTope().equals("N")) { // Si es una operaciÃ³n unaria
			pOperandos.poner(new NodoArbol(op, pOperadores.sacar(), null));
		} else { // Sino
			NodoArbol opIzq = (NodoArbol) pOperandos.sacar(); // Sacar operador izquierdo para realizar operaciÃ³n binaria
			pOperandos.poner(new NodoArbol(opIzq, pOperadores.sacar(), op));
		}
	}

	private boolean esOperador(Object valor) {
		return valor.equals("+") || valor.equals("-") || valor.equals("*")
				|| valor.equals("/") || valor.equals("^") || valor.equals("%")
				|| valor.equals("N") || valor.equals("√");
	}

	private double operar(NodoArbol n) {

		if(esOperador(n.obtenerValor())) {
			// Si es operador: hacer operaciÃ³n
			return operacion(n);
		}

		else {
			// Si es nÃºmero: devolverlo
			return Double.parseDouble((String) n.obtenerValor());
		}
	}

	@SuppressWarnings("null")
	private double operacion(NodoArbol operador) {
		if(operador.obtenerValor().equals("+")) {
			return operar(operador.nodoIzquierdo()) + operar(operador.nodoDerecho());
		}

		else if(operador.obtenerValor().equals("-")) {
			return operar(operador.nodoIzquierdo()) - operar(operador.nodoDerecho());

		}
		else if(operador.obtenerValor().equals("*"))
			return operar(operador.nodoIzquierdo()) * operar(operador.nodoDerecho());

		else if(operador.obtenerValor().equals("/"))
			return operar(operador.nodoIzquierdo()) / operar(operador.nodoDerecho());

		else if(operador.obtenerValor().equals("^"))
			return Math.pow(operar(operador.nodoIzquierdo()), operar(operador.nodoDerecho()));

		else if(operador.obtenerValor().equals("%"))
			return operar(operador.nodoIzquierdo()) / 100.0;

		else if(operador.obtenerValor().equals("N"))
			return 0.0 - operar(operador.nodoIzquierdo());
		
		else if(operador.obtenerValor().equals("√"))
			return Math.pow(operar(operador.nodoDerecho()), 1 / operar(operador.nodoIzquierdo()));

		else
			return (Double) null;
	}

}
