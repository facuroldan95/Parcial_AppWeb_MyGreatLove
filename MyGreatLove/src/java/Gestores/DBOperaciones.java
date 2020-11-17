/*
 * "MyGreatLove"
 * Conexión a la Tabla Operaciones y DetalleOperaciones.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */

package Gestores;

import DTOs.DTOAdmOperaciones;
import DTOs.DTOAdmDetalleOperacion;
import DTOs.DTOAdmTop5Ventas;
import DTOs.DetalleOperacion;
import Modelos.Operacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBOperaciones {

    private Conexion con = new Conexion();

    public void AgregarOperacion(Operacion o) {
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("INSERT INTO Operaciones (IdPareja, Fecha, Cargado) VALUES (?, ?, ?)");
            ps.setInt(1, o.getIdPareja());
            ps.setObject(2, o.getFecha());
            ps.setBoolean(3, false);
            ps.executeUpdate();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }

    }

    public int ObtenerIdOperacion(int id) {
        int IdOperacion = 0;
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("SELECT IdOperacion FROM Operaciones WHERE IdPareja = ? AND Cargado = 0");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                IdOperacion = rs.getInt("IdOperacion");
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return IdOperacion;
    }

    public void CargarOperaciones(int idOperacion, int idArticulo, double precioUnitario, int cantidad, double monto) {
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("INSERT INTO DetalleOperaciones (IdOperacion, IdArticulo, PrecioUnitario ,Cantidad, Monto) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, idOperacion);
            ps.setInt(2, idArticulo);
            ps.setDouble(3, precioUnitario);
            ps.setInt(4, cantidad);
            ps.setDouble(5, monto);
            ps.executeUpdate();
            SetearCargado(idOperacion);
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
    }

    public void SetearCargado(int idOperacion) {
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("UPDATE Operaciones SET Cargado = 1 WHERE IdOperacion = ?");
            ps.setInt(1, idOperacion);
            ps.executeUpdate();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
    }

    public ArrayList<DetalleOperacion> ObtenerOperaciones(int idPareja) {
        ArrayList<DetalleOperacion> lista = new ArrayList<>();
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("SELECT do.IdOperacion as ID, a.Articulo as Articulo, do.PrecioUnitario as PrecioUnitario,\n"
                    + "do.Cantidad as Cantidad, do.Monto as MontoTotal\n"
                    + "FROM DetalleOperaciones do\n"
                    + "INNER JOIN Articulos a\n"
                    + "on A.IdArticulo = do.IdArticulo\n"
                    + "INNER JOIN Operaciones o\n"
                    + "ON o.idOperacion = do.IdOperacion\n"
                    + "INNER JOIN Parejas p\n"
                    + "ON p.IdPareja = o.IdPareja\n"
                    + "WHERE o.IdPareja = ? ");
            ps.setInt(1, idPareja);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idOperacion = rs.getInt("ID");
                String articulo = rs.getString("Articulo");
                double precioUnitario = rs.getDouble("PrecioUnitario");
                int cantidad = rs.getInt("Cantidad");
                double montoTotal = rs.getDouble("MontoTotal");

                DetalleOperacion detOp = new DetalleOperacion(idOperacion, articulo, precioUnitario, cantidad, montoTotal);

                lista.add(detOp);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return lista;
    }

    public double ObtenerFondosDeLosMontos() {
        double total = 0;
        try {
            con.abrirConexion();
            Statement st = con.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT sum(Monto) as Total\n"
                    + "FROM DetalleOperaciones");
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

    public ArrayList<DTOAdmOperaciones> ObtenerOperaciones() {
        ArrayList<DTOAdmOperaciones> ops = new ArrayList<>();
        try {
            con.abrirConexion();
            Statement st = con.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT o.Fecha, do.IdOperacion, c.Usuario ,sum(do.Monto) as MontoTotal\n"
                    + "FROM DetalleOperaciones do\n"
                    + "INNER JOIN Operaciones o\n"
                    + "ON o.IdOperacion = do.IdOperacion\n"
                    + "INNER JOIN Parejas p\n"
                    + "ON p.IdPareja = o.IdPareja\n"
                    + "INNER JOIN Cuentas c\n"
                    + "ON c.IdCuenta = p.IdCuenta\n"
                    + "GROUP BY o.Fecha, do.IdOperacion, c.Usuario\n"
                    + "ORDER BY o.fecha desc, do.IdOperacion desc");
            while (rs.next()) {
                int idOperacion = rs.getInt("IdOperacion");
                String usuario = rs.getString("Usuario");
                double total = rs.getDouble("MontoTotal");
                Object fecha = rs.getDate("Fecha");
                DTOAdmOperaciones op = new DTOAdmOperaciones();
                op.setIdOperacion(idOperacion);
                op.setUsuario(usuario);
                op.setMontoTotal(total);
                op.setFecha(String.valueOf(fecha));
                ops.add(op);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return ops;
    }

    public ArrayList<DTOAdmDetalleOperacion> ObtenerOperacion(int id) {
        ArrayList<DTOAdmDetalleOperacion> ops = new ArrayList<>();
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("SELECT o.Fecha, do.IdOperacion, c.Usuario, a.Articulo, do.PrecioUnitario, do.Cantidad, do.Monto\n"
                    + "FROM DetalleOperaciones do\n"
                    + "INNER JOIN Operaciones o\n"
                    + "ON o.IdOperacion = do.IdOperacion\n"
                    + "INNER JOIN Parejas p\n"
                    + "ON p.IdPareja = o.IdPareja\n"
                    + "INNER JOIN Cuentas c\n"
                    + "ON c.IdCuenta = p.IdCuenta\n"
                    + "INNER JOIN Articulos a\n"
                    + "ON a.IdArticulo = do.IdArticulo\n"
                    + "WHERE o.IdOperacion = ? \n"
                    + "GROUP BY o.Fecha, do.IdOperacion, c.Usuario, a.Articulo, do.PrecioUnitario, do.Cantidad, do.Monto\n"
                    + "ORDER BY o.fecha desc, do.IdOperacion desc");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idOperacion = rs.getInt("IdOperacion");
                String usuario = rs.getString("Usuario");
                double total = rs.getDouble("Monto");
                Object fecha = rs.getDate("Fecha");
                String articulo = rs.getString("Articulo");
                double preUnitario = rs.getDouble("PrecioUnitario");
                int cantidad = rs.getInt("Cantidad");

                DTOAdmDetalleOperacion op = new DTOAdmDetalleOperacion();
                op.setIdOperacion(idOperacion);
                op.setUsuario(usuario);
                op.setMontoTotal(total);
                op.setFecha(String.valueOf(fecha));
                op.setArticulo(articulo);
                op.setPrecioUnitario(preUnitario);
                op.setCantidad(cantidad);
                op.setTotalFacturado(ObtenerTotalFacturadoPorId(idOperacion));
                ops.add(op);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return ops;
    }

    public double ObtenerTotalFacturadoPorId(int id) {
        double total = 0;
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("SELECT sum(monto) as Total\n"
                    + "FROM DetalleOperaciones\n"
                    + "WHERE IdOperacion = ? ");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
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

    public ArrayList<DTOAdmTop5Ventas> ObtenerTop5Ventas() {
        ArrayList<DTOAdmTop5Ventas> ops = new ArrayList<>();
        try {
            con.abrirConexion();
            Statement st = con.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT TOP 5 a.IdArticulo, a.Articulo, count(do.IdArticulo) as Ventas\n"
                    + "FROM DetalleOperaciones do\n"
                    + "INNER JOIN Articulos a\n"
                    + "ON a.IdArticulo = do.IdArticulo\n"
                    + "GROUP BY a.IdArticulo, a.Articulo\n"
                    + "ORDER BY Ventas desc");
            while (rs.next()) {
                int idArticulo = rs.getInt("IdArticulo");
                String articulo = rs.getString("Articulo");
                int cantidad = rs.getInt("Ventas");
                DTOAdmTop5Ventas top = new DTOAdmTop5Ventas(idArticulo, articulo, cantidad);
                ops.add(top);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return ops;
    }

}
