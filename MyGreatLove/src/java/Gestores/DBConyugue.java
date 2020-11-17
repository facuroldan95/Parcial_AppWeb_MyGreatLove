/*
 * "MyGreatLove"
 * Conexión a la Tabla Conyugues.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */
package Gestores;

import Modelos.Conyugue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConyugue {

    private Conexion con = new Conexion();

    public void AgregarConyugue(Conyugue conyugue) {
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("INSERT INTO Conyugues (Nombre, Apellido, Dni, Estado) VALUES (?, ?, ?, ?)");
            ps.setString(1, conyugue.getNombre());
            ps.setString(2, conyugue.getApellido());
            ps.setInt(3, conyugue.getDni());
            ps.setBoolean(4, conyugue.isEstado());
            ps.executeUpdate();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
    }

    /*
    public ArrayList<Conyugue> ObtenerConyugues(){
    ArrayList<Conyugue> lista = new ArrayList<Conyugue>();
    try{
        con.abrirConexion();
        Statement st = con.getCon().createStatement();
        ResultSet rs = st.executeQuery("SELECT Dni, Nombre, Apellido FROM Conyugues WHERE Estado = 1");
        while(rs.next()){
            int dni = rs.getInt("Dni");
            String nombre = rs.getString("Nombre");
            String apellido = rs.getString("Apellido");
            Conyugue c = new Conyugue();
            
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setDni(dni);
            
            lista.add(c);
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
     */
    public void AgregarPareja(int dni, int idPareja) {
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("UPDATE Conyugues SET IdPareja = ? WHERE Dni = ?");
            ps.setInt(1, idPareja);
            ps.setInt(2, dni);
            ps.executeUpdate();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
    }

    public ArrayList<Conyugue> ObtenerConyuguesDeUnaPareja(int id) {
        ArrayList<Conyugue> lista = new ArrayList<>();
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("SELECT Dni, Nombre, Apellido FROM Conyugues WHERE IdPareja = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int dni = rs.getInt("Dni");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");

                Conyugue c = new Conyugue();
                
                c.setDni(dni);
                c.setNombre(nombre);
                c.setApellido(apellido);
                
                lista.add(c);

            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return lista;

    }
    
    public void ActualizarConyugues(Conyugue c) {
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("UPDATE Conyugues SET Nombre = ?, Apellido = ? WHERE Dni = ?");
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setInt(3, c.getDni());
            ps.executeUpdate();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
    }
}
