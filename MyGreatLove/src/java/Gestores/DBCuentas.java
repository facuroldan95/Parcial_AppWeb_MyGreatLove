/*
 * "MyGreatLove"
 * Conexión a la Tabla Cuentas.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */
package Gestores;

import DTOs.DTOCuenta;
import Modelos.Conyugue;
import Modelos.Cuenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBCuentas {

    private Conexion con = new Conexion();

    public void AgregarCuenta(Cuenta cuenta) {
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("INSERT INTO Cuentas (Usuario, Clave, admin, Estado) VALUES (?, ?, ?, ?)");
            ps.setString(1, cuenta.getUsuario());
            ps.setString(2, cuenta.getPassword());
            ps.setBoolean(3, cuenta.isAdmin());
            ps.setBoolean(4, cuenta.isEstado());
            ps.executeUpdate();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
    }

    public ArrayList<Cuenta> ObtenerCuentas() {
        ArrayList<Cuenta> lista = new ArrayList<>();
        try {
            con.abrirConexion();
            Statement st = con.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Cuentas");
            while (rs.next()) {
                int idCuenta = rs.getInt("IdCuenta");
                String usuario = rs.getString("Usuario");
                String password = rs.getString("Clave");
                Boolean admin = rs.getBoolean("Admin");
                Boolean estado = rs.getBoolean("Estado");
                Cuenta c = new Cuenta();

                c.setIdCuenta(idCuenta);
                c.setUsuario(usuario);
                c.setPassword(password);
                c.setAdmin(admin);
                c.setEstado(estado);

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

    public Cuenta ObtenerCuentaPorUsuario(String usuario) {
        Cuenta c = new Cuenta();
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("SELECT * FROM Cuentas WHERE Usuario = ?");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idCuenta = rs.getInt("IdCuenta");
                String usr = rs.getString("Usuario");
                String password = rs.getString("Clave");
                boolean admin = rs.getBoolean("Admin");
                boolean estado = rs.getBoolean("Estado");

                c.setIdCuenta(idCuenta);
                c.setUsuario(usr);
                c.setPassword(password);
                c.setAdmin(admin);
                c.setEstado(estado);

            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return c;

    }

    public ArrayList<DTOCuenta> ObtenerCuentasADM() {
        ArrayList<DTOCuenta> lista = new ArrayList<>();
        DBDepositos gDep = new DBDepositos();
        try {
            con.abrirConexion();
            Statement st = con.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT c.IdCuenta as IdCuenta, c.Usuario ,p.IdPareja as IdPareja, p.Monto as Monto, c.Estado as Estado\n"
                    + "FROM Cuentas c\n"
                    + "INNER JOIN Parejas p\n"
                    + "ON p.IdCuenta = c.IdCuenta");
            while (rs.next()) {
                int idCuenta = rs.getInt("IdCuenta");
                int idPareja = rs.getInt("IdPareja");
                String usuario = rs.getString("Usuario");
                double monto = rs.getDouble("Monto");
                int cantidadRegalos = gDep.ObtenerCantidadDepositosDeUnaPareja(idPareja);
                boolean estado = rs.getBoolean("Estado");
                DBConyugue GC = new DBConyugue();
                ArrayList<Conyugue> C = GC.ObtenerConyuguesDeUnaPareja(idPareja);
                DTOCuenta c = new DTOCuenta();

                c.setIdCuenta(idCuenta);
                c.setIdPareja(idPareja);
                c.setUsuario(usuario);
                c.setMonto(monto);
                c.setConyugues(C);
                c.setCantidadRegalos(cantidadRegalos);
                c.setEstado(estado);
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
    
    public void ActualizarCuenta(Cuenta c) {
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("UPDATE Cuentas SET Usuario = ?, Clave = ? WHERE IdCuenta = ?");
            ps.setString(1, c.getUsuario());
            ps.setString(2, c.getPassword());
            ps.setInt(3, c.getIdCuenta());
            ps.executeUpdate();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
    }
    
    public Cuenta ObtenerCuenta(int id) {
        Cuenta c = new Cuenta();
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("SELECT * FROM Cuentas WHERE idCuenta = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idCuenta = rs.getInt("IdCuenta");
                String usr = rs.getString("Usuario");
                String password = rs.getString("Clave");
                boolean admin = rs.getBoolean("Admin");
                boolean estado = rs.getBoolean("Estado");

                c.setIdCuenta(idCuenta);
                c.setUsuario(usr);
                c.setPassword(password);
                c.setAdmin(admin);
                c.setEstado(estado);

            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return c;
    }
    
    public void ActualizarEstado(int id, boolean estado) {
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("UPDATE Cuentas SET Estado = ? WHERE IdCuenta = ?");
            ps.setBoolean(1, estado);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
    }
}
