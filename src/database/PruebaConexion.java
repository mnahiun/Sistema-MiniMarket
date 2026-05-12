
package database;

import java.sql.SQLException;

public class PruebaConexion {
      public static void main(String[] args) throws SQLException {
        Conexion con = Conexion.getInstancia();
       
        if (con.getConexion()!= null) {
            System.out.println("Conectado");
        }else{
            System.out.println("Desconectado");
        }
    }
}
