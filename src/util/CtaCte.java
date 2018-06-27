package util;

public class CtaCte {
	private String usuario;
	private float saldo;
	
	public CtaCte(String usuario, float saldo) {
		super();
		this.usuario = usuario;
		this.saldo = saldo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
}
