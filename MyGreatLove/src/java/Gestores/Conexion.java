/*
 * "MyGreatLove"
 * Conexión a Base de Datos.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50.
 */
package Gestores;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Facundo Roldán Legajo 109505 Comisión 2W50 -> Parcial 2 Tema 2.
 */
public class Conexion {
    private Connection con;

    public Connection getCon() {
        return con;
    }
    
    public void abrirConexion(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://SUMX555LAB\\SQLEXPRESS:1433;databaseName=MyGreatLove","sa","Facu123456");
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }
    
    public void cerrarConexion(){
        try{
            if(con != null && !con.isClosed())
                con.close();
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }
}
