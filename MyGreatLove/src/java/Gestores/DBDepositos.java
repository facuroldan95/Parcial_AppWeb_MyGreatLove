/*
 * "MyGreatLove"
 * Conexión a la Tabla Depositos.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */

package Gestores;

import Modelos.Deposito;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBDepositos {

    private Conexion con = new Conexion();

    public void AgregarDeposito(Deposito d) {
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("INSERT INTO Depositos (IdPareja, Monto, Tarjeta, Dni, Fecha, Invitado) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, d.getIdPareja());
            ps.setDouble(2, d.getMonto());
            ps.setString(3, d.getTarjeta());
            ps.setInt(4, d.getDni());
            ps.setObject(5, d.getFecha());
            ps.setString(6, d.getInvitado());
            ps.executeUpdate();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
    }

    public int ObtenerCantidadDepositosDeUnaPareja(int id) {
        int cantidad = 0;
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("SELECT Count(*) as Cantidad FROM Depositos WHERE IdPareja = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cantidad = rs.getInt("Cantidad");
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return cantidad;
    }
    
    public ArrayList<Deposito> ListadoDepositos(int id) {
        ArrayList<Deposito> deps = new ArrayList<>();
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("SELECT Fecha, Invitado, Dni, Monto FROM Depositos WHERE IdPareja = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object fecha = rs.getDate("Fecha"); 
                String invitado = rs.getString("Invitado");
                int Dni = rs.getInt("Dni");
                double Monto = rs.getInt("Monto");
                Deposito d = new Deposito();
                d.setFecha(String.valueOf(fecha));
                d.setInvitado(invitado);
                d.setDni(Dni);
                d.setMonto(Monto);
                deps.add(d);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return deps;
    }
    
    public double ObtenerMontoDepositosDeUnaPareja(int id) {
        double monto = 0;
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("SELECT sum(Monto) as Monto FROM Depositos WHERE IdPareja = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                monto = rs.getInt("Monto");
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return monto;
    }
    
}
