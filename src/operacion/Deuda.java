package operacion;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import clase.Pedido;
import util.CtaCte;

public class Deuda implements Operacion {
	private Operacion siguiente;
	private String regex;
	private Pattern pattern;
	private Matcher matcher;
	
	@Override
	public void siguiente(Operacion siguiente) {
		this.siguiente = siguiente;
	}

	@Override
	public String calcular(Pedido pedido) {
		//Me deben - CtaCte_Insertar
		//@jenkins @juan me debe $50
		regex = ".*\\s(@\\w*)\\s(?:me debe)\\s\\$(\\d*)";
		pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
				pedido.getDB().CtaCte_Insertar(matcher.group(1), pedido.getNameUsuario(), Float.parseFloat(matcher.group(2)));
				return pedido.getNameUsuario() + " anotado.";
			}
		}
		//Me pago - CtaCte_Insertar
		//@jenkins @juan me pagó $501
		regex = ".*\\s(@\\w*)\\s(?:me pago)\\s\\$(\\d*)";
		pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
				pedido.getDB().CtaCte_Insertar(pedido.getNameUsuario(), matcher.group(1), Float.parseFloat(matcher.group(2)));
				return pedido.getNameUsuario() + " anotado.";
			}
		}
		//Cuanto me deben - CtaCte_ConsultaSaldo
		//"@jenkins cuánto me debe @juan?"
		regex = ".*(?:cuanto me debe).*(@\\w*).*";
		pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
				String usuario1 = matcher.group(1);
				float saldo = pedido.getDB().CtaCte_ConsultaSaldo(usuario1, pedido.getNameUsuario());
				if(saldo > 0) {
					//"@delucas @juan te debe $50",
					return pedido.getNameUsuario() + " " + usuario1 + " te debe $" + String.format(formatoRedondeo(saldo), Math.abs(saldo)).replace(",", ".");
				}
				if(saldo < 0) {
					//"@delucas @juan no te debe nada. Vos le debés $1"
					return pedido.getNameUsuario() + " " + usuario1 + " no te debe nada. Vos le debés $" + String.format(formatoRedondeo(saldo), Math.abs(saldo)).replace(",", ".");
				}
			}
		}
		//Cuanto le debo - CtaCte_ConsultaSaldo
		//@jenkins cuánto le debo a @juan?
		regex = ".*(?:cuanto le debo a).*(@\\w*).*";
		pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
				String usuario1 = matcher.group(1);
				float saldo = pedido.getDB().CtaCte_ConsultaSaldo(pedido.getNameUsuario(), usuario1);
				if(saldo > 0) {
					//"@delucas debés $1 a @juan"
					return pedido.getNameUsuario() + " debés $" + String.format(formatoRedondeo(saldo), Math.abs(saldo)).replace(",", ".") + " a " + usuario1;
				}
				if(saldo < 0) {
					//"@delucas no le debés nada. @juan te debe $9"
					return pedido.getNameUsuario() + " no le debés nada. " + usuario1 + " te debe $" + String.format(formatoRedondeo(saldo), Math.abs(saldo)).replace(",", ".");
				}
			}
		}
		//Le pague - CtaCte_Insertar
		//"@jenkins le pagué a @juan $10"
		regex = ".*(?:le pague a).*(@\\w*)\\s\\$(\\d*)";
		pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
				pedido.getDB().CtaCte_Insertar(matcher.group(1), pedido.getNameUsuario(), Float.parseFloat(matcher.group(2)));
				return pedido.getNameUsuario() + " anotado.";
			}
		}
		//le debo - CtaCte_Insertar
		//"@jenkins le debo $60 a @maria"
		regex = ".*(?:le debo)\\s\\$(\\d*).*(@\\w*).*";
		pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
				pedido.getDB().CtaCte_Insertar(pedido.getNameUsuario(), matcher.group(2), Float.parseFloat(matcher.group(1)));
				return pedido.getNameUsuario() + " anotado.";
			}
		}
		//Mi estado de deudas - CtaCte_ConsultaEstadoDeuda
		//"@jenkins cual es mi estado de deudas?"
		regex = ".*(?:cual es mi estado de deudas).*";
		pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
				boolean conDeuda = false;
				boolean conCredito = false;
				List<CtaCte> lista = pedido.getDB().CtaCte_ConsultaEstadoDeuda(pedido.getNameUsuario());
				//"@delucas le debés $60 a @maria. @juan te debe $50"
				//"@delucas @juan te debe $100. @maria te debe $100",
				String respuesta = pedido.getNameUsuario();
				for (CtaCte l_ctaCte : lista) {
					if(l_ctaCte.getSaldo() > 0) {
						if (!conDeuda) {
							conDeuda = true;
							respuesta += " le debés $" + String.format(formatoRedondeo(l_ctaCte.getSaldo()), Math.abs(l_ctaCte.getSaldo())).replace(",", ".") + " a " + l_ctaCte.getUsuario();
						}else {
							respuesta += ". Le debés $" + String.format(formatoRedondeo(l_ctaCte.getSaldo()), Math.abs(l_ctaCte.getSaldo())).replace(",", ".") + " a " + l_ctaCte.getUsuario();
						}
					}
				}
				if (!conDeuda) {
//					respuesta += " no le debes a nadie. ";
				}else {
//					respuesta += ". ";
				}
				for (CtaCte l_ctaCte : lista) {
					if(l_ctaCte.getSaldo() < 0) {
						if (!conCredito) {
							conCredito = true;
							if (conDeuda) {
								respuesta += ".";
							}
							respuesta += " " +l_ctaCte.getUsuario() + " te debe $" + String.format(formatoRedondeo(l_ctaCte.getSaldo()), Math.abs(l_ctaCte.getSaldo())).replace(",", ".");
						}else {
							respuesta += ". " + l_ctaCte.getUsuario() + " te debe $" + String.format(formatoRedondeo(l_ctaCte.getSaldo()), Math.abs(l_ctaCte.getSaldo())).replace(",", ".");
						}
					}
				}
				if (!conCredito) {
//					respuesta += " Nadie te debe";
				}else {
					respuesta += "";
				}
				if (!conDeuda && !conCredito) {
					respuesta += " tu estado de deudas esta saldado";
				}
				return respuesta;
			}
		}
		//Simplificacion - CtaCte_Simplificar
		//"@jenkins simplificar deudas con @juan y @maria"
		regex = ".*(?:simplificar deudas con )(@\\w*).*(@\\w*)";
		pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
				if(pedido.getDB().CtaCte_Simplificar(pedido.getNameUsuario(), matcher.group(1), matcher.group(2))) {
					return pedido.getNameUsuario() + " bueno.";
				}else {
					return pedido.getNameUsuario() + ", no se puede simplificar deudas.";
				}
			}
		}
		//DeudasGrupales - CtaCte_DeudasGrupales
		//"@jenkins con @juan y @maria gastamos $300 y pagó @juan"
		regex = ".*(?:con )(@\\w*).*(@\\w*).*(?:gastamos \\$)(\\d*).*(?:y pago).*(@\\w*).*";
		pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
//				System.out.println("se ejecuto");
				String[] v_usuarios = {pedido.getNameUsuario(), matcher.group(1), matcher.group(2)};
				pedido.getDB().CtaCte_DeudasGrupales(v_usuarios, Float.parseFloat(matcher.group(3)), matcher.group(4));
				return pedido.getNameUsuario() + " anotado.";
			}
		}
		//"@jenkins con @juan y @maria gastamos $300 y pagué yo"
		regex = ".*(?:con )(@\\w*).*(@\\w*).*(?:gastamos \\$)(\\d*).*(?:y pague yo).*";
		pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		matcher = pattern.matcher(pedido.getMensaje());
		while(matcher.find()) {
			if(matcher.matches()) {
//				System.out.println("se ejecuto");
				String[] v_usuarios = {pedido.getNameUsuario(), matcher.group(1), matcher.group(2)};
				pedido.getDB().CtaCte_DeudasGrupales(v_usuarios, Float.parseFloat(matcher.group(3)), pedido.getNameUsuario());
				return pedido.getNameUsuario() + " anotado.";
			}
		}
		
		return siguiente.calcular(pedido);
	}
	
	private String formatoRedondeo(float valor) {
		double decimales = valor - (int) valor;
		if(decimales  == 0 || (int) (decimales * 1000) < 9 || (int) (decimales * 1000) > 990)
			return "%.0f";
		return "%.2f";
	}
	
}
