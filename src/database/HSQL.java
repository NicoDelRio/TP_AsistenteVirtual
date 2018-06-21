package database;

import java.sql.*;

public class HSQL {
	
	public HSQL() {
		
//		public static void main(String[] args) throws SQLException {
			Connection conn = null;
			Statement  st	= null;
			String	   sql	= null;
			ResultSet  rst1 = null;
			
			try {
				// Cargamos el controlador JDBC
				Class.forName("org.hsqldb.jdbcDriver");
			} catch (Exception ex){
//				System.err.println("Se pa producido un error al cargar el controlador JDBC");
				return;
			}
			
			try {
				// Nos conectamos a la base de datos creándola en caso de que no exista 
				conn = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\Nicolas\\Documents\\GitHub\\TP_AsistenteVirtual(2018-06-09)\\DataBase\\BD_Chat\\database", "chat", "");
			} catch (Exception ex){
//				System.out.println(ex);
			}
			
			try {
				st  = conn.createStatement();
			} catch (Exception ex){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
				}
//				System.out.println(ex);
			}	
				
			try {
				//Eliminar  la tabla CtaCte
				st.executeUpdate("DROP TABLE IF EXISTS CtaCte");
				//Eliminar  la tabla Usuario
				st.executeUpdate("DROP TABLE IF EXISTS Usuario");
				
				
				// Crear tabla Usuario
				sql = "CREATE TABLE IF NOT EXISTS Usuario (IdUsuario varchar(50), Contraseña varchar(200), PRIMARY KEY (IdUsuario))";
				st.executeUpdate(sql);
		
				//Borrar usuarios de tabla Usuario
				st.executeUpdate("DELETE FROM Usuario");	
				
				// Añar usuarios
				st.executeUpdate("INSERT INTO Usuario (IdUsuario, Contraseña) VALUES ('@delucas', '123456')");
				st.executeUpdate("INSERT INTO Usuario (IdUsuario, Contraseña) VALUES ('@juan', '123456')");
				st.executeUpdate("INSERT INTO Usuario (IdUsuario, Contraseña) VALUES ('@maria', '123456')");
				
				// Consultar usuarios
//				rst1 = st.executeQuery("SELECT * FROM Usuario");
//				while (rst1.next()){
//					System.out.println("IdUsuario: " + rst1.getString("IdUsuario") + " - Contraseña: " + rst1.getString("Contraseña") );
//				}	
				
				// Crear tabla CtaCte
				sql = "CREATE TABLE IF NOT EXISTS CtaCte (Deudor varchar(50), Acreedor varchar(50), Importe float, "
						+ "FOREIGN KEY(Deudor) REFERENCES Usuario(IdUsuario) , FOREIGN KEY(Acreedor) REFERENCES Usuario(IdUsuario))";
				st.executeUpdate(sql);
				
				//Borrar usuarios de tabla Usuario
				st.executeUpdate("DELETE FROM CtaCte");	
				
				
//				public class RF14Tests
//				public void transferenciaDeDeudas() 

				st.executeUpdate("INSERT INTO CtaCte (Deudor, Acreedor, Importe) VALUES ('@juan', '@delucas', 50.00)");
				st.executeUpdate("INSERT INTO CtaCte (Deudor, Acreedor, Importe) VALUES ('@juan', '@delucas', 50.00)");
				
				// Consultar CtaCte
				rst1 = st.executeQuery("SELECT * FROM CtaCte");
				float saldo = 0;
				while (rst1.next()){
					if(rst1.getString("Deudor").equals("@juan") && rst1.getString("Acreedor").equals("@delucas"))
						saldo += rst1.getDouble("Importe");
					if(rst1.getString("Deudor").equals("@delucas") && rst1.getString("Acreedor").equals("@juan"))
						saldo -= rst1.getDouble("Importe");
				}	
//				System.out.println("@juan debe a @delucas $ " + saldo);
				
				
				st.executeUpdate("SHUTDOWN");
			} catch (Exception ex){
				try {
					rst1.close();
					st.close();
					conn.close();
				} catch (SQLException e1) {
					System.out.println(1);
					e1.printStackTrace();
				}
			}		
	
		// Liberamos recursos
		try {
			rst1.close();
		} catch (SQLException e) {
			System.out.println(2);
//			e.printStackTrace();
		}
		
		// Cerramos la conexión
		try {
			st.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(3);
//			e.printStackTrace();
		}
	}
}
