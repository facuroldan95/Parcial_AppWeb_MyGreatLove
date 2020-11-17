/*
 * "MyGreatLove"
 * Conexión a la Tabla TipoArticulos.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */
package Gestores;

import Modelos.TipoArticulo;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DBTipoArticulos {
    private Conexion con = new Conexion(); 
    public ArrayList<TipoArticulo> ObtenerTipoArticulos(){
    ArrayList<TipoArticulo> lista = new ArrayList<TipoArticulo>();
    try{
        con.abrirConexion();
        Statement st = con.getCon().createStatement();
        ResultSet rs = st.executeQuery("SELECT IdTipoArticulo , Tipo FROM TipoArticulos");
        while(rs.next()){
            int IdTipoArticulo = rs.getInt("IdTipoArticulo");
            String tipo = rs.getString("Tipo");
            TipoArticulo ta = new TipoArticulo(IdTipoArticulo, tipo);          
            lista.add(ta);
        }
        rs.close();
    }
    catch(Exception exc){
        exc.printStackTrace();
    }
    finally{
        con.cerrarConexion();
    }
    return lista;

    }
}
