package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import util.CtaCte;

public class HSQL {
	
	private Connection conn = null;
	private Statement  st	= null;
	private String	   sql	= null;
	private ResultSet  rst1 = null;
	private ResultSet  rst2 = null;
	
	public HSQL() {
		
		crearTablas();
		cargarUsuarios();

	}
	
	public void conectar() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (Exception ex){	return;	}		
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\Nicolas\\Documents\\GitHub\\TP_AsistenteVirtual(2018-06-09)\\DataBase\\BD_Chat\\database", "chat", "");
		} catch (Exception ex){	}
		
		try {
			st  = conn.createStatement();
		} catch (Exception ex){
			try {
				conn.close();
			} catch (SQLException e) { }
		}
	}
	
	public void desconectar() {
		// Liberamos recursos y cerramos la conexión
		try {
			st.executeUpdate("SHUTDOWN");
//			if(rst1.isClosed())
//				rst1.close();
			st.close();
			conn.close();
		} catch (SQLException e1) { 
			// Cerramos la conexión
			try {
				st.close();
				conn.close();
			} catch (SQLException e2) {System.out.println(4); }
		}
	}
	
	public void crearTablas() {
		try {
			conectar();
			//Eliminar  la tabla CtaCte
			st.executeUpdate("DROP TABLE IF EXISTS CtaCte");
			//Eliminar  la tabla Usuario
			st.executeUpdate("DROP TABLE IF EXISTS Usuario");
			
			// Crear tabla Usuario
			sql = "CREATE TABLE IF NOT EXISTS Usuario (IdUsuario varchar(50), Contraseña varchar(200), PRIMARY KEY (IdUsuario))";
			st.executeUpdate(sql);
	
			//Borrar usuarios de tabla Usuario
			st.executeUpdate("DELETE FROM Usuario");	
			
			// Crear tabla CtaCte
			sql = "CREATE TABLE IF NOT EXISTS CtaCte (Deudor varchar(50), Acreedor varchar(50), Importe float, "
					+ "FOREIGN KEY(Deudor) REFERENCES Usuario(IdUsuario) , FOREIGN KEY(Acreedor) REFERENCES Usuario(IdUsuario))";
			st.executeUpdate(sql);
			
			//Borrar usuarios de tabla Usuario
			st.executeUpdate("DELETE FROM CtaCte");	
			
		} catch (Exception ex){ }
		finally {
			desconectar();
		}
	}
	
	public void cargarUsuarios() {
		try {
			conectar();
			
			// Añar usuarios
			st.executeUpdate("INSERT INTO Usuario (IdUsuario, Contraseña) VALUES ('@delucas', '123456')");
			st.executeUpdate("INSERT INTO Usuario (IdUsuario, Contraseña) VALUES ('@juan', '123456')");
			st.executeUpdate("INSERT INTO Usuario (IdUsuario, Contraseña) VALUES ('@maria', '123456')");
			
			// Consultar usuarios
//			rst1 = st.executeQuery("SELECT * FROM Usuario");
//			while (rst1.next()){
//				System.out.println("IdUsuario: " + rst1.getString("IdUsuario") + " - Contraseña: " + rst1.getString("Contraseña") );
//			}	
//
//			st.executeUpdate("INSERT INTO CtaCte (Deudor, Acreedor, Importe) VALUES ('@juan', '@delucas', 50.00)");
//			st.executeUpdate("INSERT INTO CtaCte (Deudor, Acreedor, Importe) VALUES ('@juan', '@delucas', 50.0)");
//			st.executeUpdate("INSERT INTO CtaCte (Deudor, Acreedor, Importe) VALUES ('@delucas', '@juan', 30.0)");
//			
//			rst1 = st.executeQuery("SELECT * FROM CtaCte");
//			float saldo = 0;
//			while (rst1.next()){
//				if(rst1.getString("Deudor").equals("@juan") && rst1.getString("Acreedor").equals("@delucas"))
//					saldo += rst1.getDouble("Importe");
//				if(rst1.getString("Deudor").equals("@delucas") && rst1.getString("Acreedor").equals("@juan"))
//					saldo -= rst1.getDouble("Importe");
//			}	
//			System.out.println("@juan debe a @delucas $ " + saldo);
			
		} catch (Exception ex){ }
		finally {
			desconectar();
		}
	}
	
	public void CtaCte_Insertar(String deudor, String acreedor, float importe) {
		try {
			conectar();
			
//			st.executeUpdate("INSERT INTO CtaCte (Deudor, Acreedor, Importe) VALUES ('@juan', '@delucas', 50.00)");
//			st.executeUpdate("INSERT INTO CtaCte (Deudor, Acreedor, Importe) VALUES ('"+ deudor +"', '"+ acreedor +"', " + importe +")");
			sql = "INSERT INTO CtaCte (Deudor, Acreedor, Importe) VALUES ('"+ deudor +"', '"+ acreedor +"', " + importe +")";
			st.executeUpdate(sql);
//			System.out.println(sql);
//			System.out.println(deudor + " debe a " + acreedor + "$ " + CtaCte_ConsultaSaldo(deudor,acreedor));
			
		} catch (Exception ex){ }
		finally {
			desconectar();
		}
	}
	
	@SuppressWarnings("finally")
	public float CtaCte_ConsultaSaldo(String deudor, String acreedor) {
		float saldo = 0;
		try {
			conectar();
			
			rst1 = st.executeQuery("SELECT * FROM CtaCte");
			while (rst1.next()){
				if(rst1.getString("Deudor").equals(deudor) && rst1.getString("Acreedor").equals(acreedor))
					saldo += rst1.getDouble("Importe");
				if(rst1.getString("Deudor").equals(acreedor) && rst1.getString("Acreedor").equals(deudor))
					saldo -= rst1.getDouble("Importe");
			}	
			
		} catch (Exception ex){ }
		finally {
			desconectar();
			return saldo;
		}
	}
	
	@SuppressWarnings("finally")
	public List<CtaCte> CtaCte_ConsultaEstadoDeuda(String deudor) {
		List<CtaCte> lista = new ArrayList<CtaCte>();
		String acreedor;
		float saldo;
		try {
			conectar();
			
			rst1 = st.executeQuery("SELECT * FROM Usuario");
			while (rst1.next()){
				acreedor = rst1.getString("IdUsuario");
				saldo = 0;
				rst2 = st.executeQuery("SELECT * FROM CtaCte");
				while (rst2.next()){
					if(rst2.getString("Deudor").equals(deudor) && rst2.getString("Acreedor").equals(acreedor))
						saldo += rst2.getDouble("Importe");
					if(rst2.getString("Deudor").equals(acreedor) && rst2.getString("Acreedor").equals(deudor))
						saldo -= rst2.getDouble("Importe");
				}
				lista.add(new CtaCte(acreedor, saldo));
			}	
			
		} catch (Exception ex){ }
		finally {
			desconectar();
			return lista;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean CtaCte_Simplificar(String intermediario, String usuario1, String usuario2) {
		try {
			conectar();
			
			float saldoUsuario1 = CtaCte_ConsultaSaldo(intermediario, usuario1);
			float saldoUsuario2 = CtaCte_ConsultaSaldo(intermediario, usuario2);
			
			if(saldoUsuario1 == 0 || saldoUsuario2 == 0)
				return false;
			if(saldoUsuario1 > 0 && saldoUsuario2 > 0)
				return false;
			if(saldoUsuario1 < 0 && saldoUsuario2 < 0)
				return false;
			
			float impMinAbs = Math.min(Math.abs(saldoUsuario1), Math.abs(saldoUsuario2));
			
			if(saldoUsuario1 < 0) {
				//usuario1 es deudor y usuario2 es acreedor
				CtaCte_Insertar(intermediario, usuario1, impMinAbs);
				CtaCte_Insertar(usuario2, intermediario, impMinAbs);
				CtaCte_Insertar(usuario1, usuario2, impMinAbs);
			}else {
				//usuario2 es deudor y usuario1 es acreedor
				CtaCte_Insertar(intermediario, usuario2, impMinAbs);
				CtaCte_Insertar(usuario1, intermediario, impMinAbs);
				CtaCte_Insertar(usuario2, usuario1, impMinAbs);
			}
			
		} catch (Exception ex){ }
		finally {
			desconectar();
			return true;
		}
	}
	
	public void CtaCte_DeudasGrupales(String[] v_usuarios, float importe, String usuarioPagador) {
		try {
			conectar();

			for (int i = 0; i < v_usuarios.length; i++) {
				CtaCte_Insertar(v_usuarios[i], usuarioPagador, Math.round(importe/v_usuarios.length));
			}
			
		} catch (Exception ex){ }
		finally {
			desconectar();
		}
	}
	
}
