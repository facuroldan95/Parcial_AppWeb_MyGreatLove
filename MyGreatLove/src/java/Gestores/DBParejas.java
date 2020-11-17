/*
 * "MyGreatLove"
 * Conexión a la Tabla Parjas.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */


package Gestores;

import Modelos.Cuenta;
import Modelos.Pareja;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBParejas {

    private Conexion con = new Conexion();

    public void AgregarPareja(Pareja pareja) {
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("INSERT INTO Parejas (Monto, Estado, IdCuenta) VALUES (?, ?, ?)");
            ps.setDouble(1, pareja.getMonto());
            ps.setBoolean(2, pareja.isEstado());
            ps.setInt(3, pareja.getIdCuenta());
            ps.executeUpdate();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
    }

    public ArrayList<Pareja> ObtenerParejas() {
        ArrayList<Pareja> lista = new ArrayList<Pareja>();
        try {
            con.abrirConexion();
            Statement st = con.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Parejas");
            while (rs.next()) {
                int idPareja = rs.getInt("IdPareja");
                Double monto = rs.getDouble("Monto");
                boolean estado = rs.getBoolean("Estado");
                int idCuenta = rs.getInt("IdCuenta");
                Pareja p = new Pareja();
                p.setEstado(estado);
                p.setIdCuenta(idCuenta);
                p.setMonto(monto);
                p.setIdPareja(idPareja);
                lista.add(p);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return lista;

    }

    public int localizarPareja(int idCuenta) {
        DBParejas dbp = new DBParejas();
        ArrayList<Pareja> lista = dbp.ObtenerParejas();
        for (Pareja pareja : lista) {
            if (pareja.getIdCuenta() == idCuenta) {
                return pareja.getIdPareja();
            }
        }
        return -1;
    }

    public Pareja ObtenerParejaPorIdCuenta(int idC) {
        Pareja p = new Pareja();
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("SELECT * FROM Parejas WHERE IdCuenta = ?");
            ps.setInt(1, idC);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idPareja = rs.getInt("IdPareja");
                Double monto = rs.getDouble("Monto");
                boolean estado = rs.getBoolean("Estado");
                int idCuenta = rs.getInt("IdCuenta");

                //p = new Pareja(monto, estado, idCuenta);
                p.setIdPareja(idPareja);
                p.setEstado(estado);
                p.setIdCuenta(idCuenta);
                p.setMonto(monto);

            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return p;

    }

    public Pareja ObtenerParejaPorId(int id) {
        Pareja p = new Pareja();
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("SELECT * FROM Parejas WHERE IdPareja = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idPareja = rs.getInt("IdPareja");
                Double monto = rs.getDouble("Monto");
                boolean estado = rs.getBoolean("Estado");
                int idCuenta = rs.getInt("IdCuenta");

                //p = new Pareja(monto, estado, idCuenta);
                p.setIdPareja(idPareja);
                p.setEstado(estado);
                p.setIdCuenta(idCuenta);
                p.setMonto(monto);

            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return p;

    }

    public Pareja ObtenerInformacionPareja(String usuario) {
        DBCuentas gestorCuenta = new DBCuentas();
        Cuenta c = gestorCuenta.ObtenerCuentaPorUsuario(usuario);
        Pareja p = ObtenerParejaPorIdCuenta(c.getIdCuenta());
        return p;
    }

    public void ModicicarSaldo(double monto, int idPareja) {
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("UPDATE Parejas SET Monto = ? WHERE IdPareja = ?");
            ps.setDouble(1, monto);
            ps.setInt(2, idPareja);

            ps.executeUpdate();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
    }

    public double ObtenerFondosDeLosMontos() {
        double total = 0;
        try {
            con.abrirConexion();
            Statement st = con.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT sum(Monto) as Total\n"
                    + "FROM Depositos");
            if (rs.next()) {
                total = rs.getDouble("Total");
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return total;

    }
}
