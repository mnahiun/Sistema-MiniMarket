
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**

- Singleton de conexión a la base de datos MySQL.
- Modifique URL, USER y PASSWORD según su configuración local.
  */

public class Conexion {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3308/dbMiniMarket";
    private static final String DB = "dbMiniMarket";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";  // <– cambie si tiene contraseña
    
    
    public static Connection instancia = null;
   
  
    private Conexion() {}
  
    public static Connection getConexion() throws SQLException {
      if (instancia == null || instancia.isClosed()) {
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          instancia = DriverManager.getConnection(URL, USER, PASSWORD);
          } catch (ClassNotFoundException e) {
         throw new SQLException("Driver MySQL no encontrado: "  + e.getMessage());
       }
    }
        return instancia;
  }
  
    public static void cerrarConexion() {
     try {
        if (instancia != null && !instancia.isClosed()) {
        instancia.close();
     }
        } catch (SQLException e) {
          System.err.println("Error al cerrar conexión: " + e.getMessage());
       }
     }
  }
 

