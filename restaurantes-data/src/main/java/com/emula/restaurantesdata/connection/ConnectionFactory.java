/**
 * 
 */
package com.emula.restaurantesdata.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author HL Clase para la configuracion la conexion y habilitar las
 *         transacciones
 *
 */
public class ConnectionFactory {

	/**
	 * Objeto para mantener la conexion a la BD
	 */
	private static Connection connection;
	/**
	 * Objeto encargado de habilitar y ejecutar sentencias SQL
	 */
	private static Statement statement;

	public static Connection conectar() throws ClassNotFoundException, SQLException {
		// 1: Cargar el driver de la conexion
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2: Establecer los datos de coneccion
		String url = "jdbc:mysql://localhost:3306/restaurante";
		String user = "root";
		String password = "Nm2b6FJuv22s";

		// 3: Establecer la coneccion
		connection = DriverManager.getConnection(url, user, password);
		if (connection != null) {
			System.out.println("Coneccion establecida con exito");
		}

		statement = connection.createStatement();// Habilitando procesos para ejecutar sentencias SQL
		return connection;
	}

	/**
	 * Permite ejecutar sentencias INSERT, UPDATE y DELETE
	 * 
	 * @param La cadena SQL a ejecutarse
	 * @return 1 en caso de exit | 0 en caso de error
	 * @throws SQLException en caso de error en la ejecucion de la sentencia SQL
	 */
	public static int ejecutarSQL(String sql) throws SQLException {
		System.out.println("Query:=" + sql);
		return statement.executeUpdate(sql);
	}

	/**
	 * Permite ejecutar sentencias SELECT
	 * 
	 * @param La cadena SQL a ejecutarse
	 * @return objeto con la informacion obtenida de la sentencia
	 * @throws SQLException en caso de error en la ejecucion de la sentencia SQL
	 */
	public static ResultSet ejecutarSQLSelect(String sql) throws SQLException {
		System.out.println("Query:=" + sql);
		return statement.executeQuery(sql);
	}

}
