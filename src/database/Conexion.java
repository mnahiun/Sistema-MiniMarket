
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3308/dbMiniMarket";
    private static final String DB = "dbMiniMarket";
    private static final String USER = "root";
    private static final String PASSWORD = "";  
    
    
    public static Connection cadena;
    public static Conexion instancia;
  
    Conexion() {
       this.cadena = null;
    }
  
    public static Connection getConexion() throws SQLException {
      if (cadena == null || cadena.isClosed()) {
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          cadena = DriverManager.getConnection(URL, USER, PASSWORD);
          } catch (ClassNotFoundException e) {
         throw new SQLException("Driver MySQL no encontrado: "  + e.getMessage());
       }
    }
        return cadena;
  }
  
    public static void cerrarConexion() {
     try {
        if (cadena != null && !cadena.isClosed()) {
        cadena.close();
     }
        } catch (SQLException e) {
          System.err.println("Error al cerrar conexión: " + e.getMessage());
       }
     }
   
    public synchronized static Conexion getInstancia(){
        if (instancia==null) {
            instancia = new Conexion();
        }
        return instancia;
    }
    
  }
 

