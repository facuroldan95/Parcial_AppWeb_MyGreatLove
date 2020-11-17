/*
 * "MyGreatLove"
 * Conexion a la Tabla Articulos.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50.
 */
package Gestores;

import DTOs.DTOArticulo;
import Modelos.Articulo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sumit
 */
public class DBArticulos {

    private Conexion con = new Conexion();

    public void AgregarArticulo(Articulo articulo) {
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("INSERT INTO Articulos (Articulo, Precio, Cantidad, IdTipoArticulo, Estado, LinkImagen, Descripcion, Promocion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, articulo.getArticulo());
            ps.setDouble(2, articulo.getPrecio());
            ps.setInt(3, articulo.getCantidad());
            ps.setInt(4, articulo.getIdTipoArticulo());
            ps.setBoolean(5, articulo.isEstado());
            ps.setString(6, articulo.getLinkImagen());
            ps.setString(7, articulo.getDescripcion());
            ps.setBoolean(8, articulo.isPromocion());
            ps.executeUpdate();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
    }

    public ArrayList<Articulo> ObtenerArticulos() {
        ArrayList<Articulo> lista = new ArrayList<Articulo>();
        try {
            con.abrirConexion();
            Statement st = con.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Articulos");
            while (rs.next()) {
                int idArticulo = rs.getInt("IdArticulo");
                String articulo = rs.getString("Articulo");
                Double precio = rs.getDouble("Precio");
                int cantidad = rs.getInt("Cantidad");
                int idTipoProducto = rs.getInt("IdTipoArticulo");
                boolean estado = rs.getBoolean("Estado");
                String linkImagen = rs.getString("LinkImagen");
                String descripcion = rs.getString("Descripcion");
                boolean promocion = rs.getBoolean("Promocion");

                Articulo a = new Articulo(articulo, precio, cantidad, idTipoProducto, estado, linkImagen, descripcion, promocion);
                a.setIdArticulo(idArticulo);
                lista.add(a);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return lista;

    }

    public ArrayList<Articulo> ObtenerArticulosPorEstado(boolean estate) {
        ArrayList<Articulo> lista = new ArrayList<Articulo>();
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("SELECT * FROM Articulos WHERE Estado = ?");
            ps.setBoolean(1, estate);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idArticulo = rs.getInt("IdArticulo");
                String articulo = rs.getString("Articulo");
                Double precio = rs.getDouble("Precio");
                int cantidad = rs.getInt("Cantidad");
                int idTipoProducto = rs.getInt("IdTipoArticulo");
                boolean estado = rs.getBoolean("Estado");
                String linkImagen = rs.getString("LinkImagen");
                String descripcion = rs.getString("Descripcion");
                boolean promocion = rs.getBoolean("Promocion");

                Articulo a = new Articulo(articulo, precio, cantidad, idTipoProducto, estado, linkImagen, descripcion, promocion);
                a.setIdArticulo(idArticulo);
                lista.add(a);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return lista;

    }

    public Articulo ObtenerArticuloPorId(int idArticulo) {
        Articulo a = null;
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("SELECT * FROM Articulos WHERE IdArticulo = ?");
            ps.setInt(1, idArticulo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("IdArticulo");
                String articulo = rs.getString("Articulo");
                Double precio = rs.getDouble("Precio");
                int cantidad = rs.getInt("Cantidad");
                int idTipoProducto = rs.getInt("IdTipoArticulo");
                boolean estado = rs.getBoolean("Estado");
                String linkImagen = rs.getString("LinkImagen");
                String descripcion = rs.getString("Descripcion");
                boolean promocion = rs.getBoolean("Promocion");

                a = new Articulo(articulo, precio, cantidad, idTipoProducto, estado, linkImagen, descripcion, promocion);
                a.setIdArticulo(idArticulo);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return a;

    }

    public void ActualizarArticulo(Articulo articulo) {
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("UPDATE Articulos SET Articulo = ?, Precio = ?, Cantidad = ?, IdTipoArticulo = ?, Estado = ?, LinkImagen = ?, Descripcion = ?, Promocion = ? WHERE IdArticulo = ?");
            ps.setString(1, articulo.getArticulo());
            ps.setDouble(2, articulo.getPrecio());
            ps.setInt(3, articulo.getCantidad());
            ps.setInt(4, articulo.getIdTipoArticulo());
            ps.setBoolean(5, articulo.isEstado());
            ps.setString(6, articulo.getLinkImagen());
            ps.setString(7, articulo.getDescripcion());
            ps.setBoolean(8, articulo.isPromocion());
            ps.setInt(9, articulo.getIdArticulo());
            ps.executeUpdate();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
    }

    public ArrayList<DTOArticulo> ObtenerDTOArticulos() {
        ArrayList<DTOArticulo> lista = new ArrayList<DTOArticulo>();
        try {
            con.abrirConexion();
            Statement st = con.getCon().createStatement();
            ResultSet rs = st.executeQuery("exec sprDTOArticulos");
            while (rs.next()) {
                int idArticulo = rs.getInt("IdArticulo");
                String articulo = rs.getString("Articulo");
                String categoria = rs.getString("Categoria");
                Double precio = rs.getDouble("Precio");
                int cantidad = rs.getInt("Cantidad");
                boolean estado = rs.getBoolean("Estado");
                String linkImagen = rs.getString("LinkImagen");
                String descripcion = rs.getString("Descripcion");
                boolean promocion = rs.getBoolean("Promocion");

                DTOArticulo a = new DTOArticulo(idArticulo, articulo, categoria, precio, cantidad, estado, linkImagen, descripcion, promocion);
                lista.add(a);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return lista;

    }

    public DTOArticulo ObtenerDTOArticuloPorId(int idArticulo) {
        DTOArticulo a = null;
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("SELECT a.IdArticulo IdArticulo, a.Articulo as Articulo, ta.Tipo as Categoria, a.Precio as Precio, a.Cantidad as Cantidad,\n"
                    + "a.Estado as Estado, a.LinkImagen as LinkImagen, a.Descripcion as Descripcion, a.Promocion as Promocion\n"
                    + "FROM Articulos a\n"
                    + "INNER JOIN TipoArticulos ta\n"
                    + "ON a.IdTipoArticulo = ta.IdTipoArticulo WHERE IdArticulo = ?");
            ps.setInt(1, idArticulo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("IdArticulo");
                String articulo = rs.getString("Articulo");
                String TipoProducto = rs.getString("Categoria");
                Double precio = rs.getDouble("Precio");
                int cantidad = rs.getInt("Cantidad");
                boolean estado = rs.getBoolean("Estado");
                String linkImagen = rs.getString("LinkImagen");
                String descripcion = rs.getString("Descripcion");
                boolean promocion = rs.getBoolean("Promocion");

                a = new DTOArticulo(idArticulo, articulo, TipoProducto, precio, cantidad, estado, linkImagen, descripcion, promocion);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return a;

    }

    public void ActualizarCantidad(int cantidad, int idArticulo, boolean Estado) {
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("UPDATE Articulos SET Cantidad = ?, Estado = ? WHERE IdArticulo = ?");
            ps.setInt(1, cantidad);
            ps.setBoolean(2, Estado);
            ps.setInt(3, idArticulo);
            ps.executeUpdate();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
    }

    public ArrayList<Articulo> ObtenerArticulosPorCategoriaNormal(int categoria) {
        ArrayList<Articulo> lista = new ArrayList<>();
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("SELECT * FROM Articulos WHERE IdTipoArticulo = ? and Estado = 1");
            ps.setInt(1, categoria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IdArticulo");
                String articulo = rs.getString("Articulo");
                Double precio = rs.getDouble("Precio");
                int cantidad = rs.getInt("Cantidad");
                int idTipoProducto = rs.getInt("IdTipoArticulo");
                boolean estado = rs.getBoolean("Estado");
                String linkImagen = rs.getString("LinkImagen");
                String descripcion = rs.getString("Descripcion");
                boolean promocion = rs.getBoolean("Promocion");

                Articulo a = new Articulo(articulo, precio, cantidad, idTipoProducto, estado, linkImagen, descripcion, promocion);
                a.setIdArticulo(id);
                lista.add(a);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return lista;
    }
    
    public ArrayList<Articulo> ObtenerArticulosPorCategoriaAdmin(int categoria) {
        ArrayList<Articulo> lista = new ArrayList<>();
        try {
            con.abrirConexion();
            PreparedStatement ps = con.getCon().prepareStatement("SELECT * FROM Articulos WHERE IdTipoArticulo = ?");
            ps.setInt(1, categoria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IdArticulo");
                String articulo = rs.getString("Articulo");
                Double precio = rs.getDouble("Precio");
                int cantidad = rs.getInt("Cantidad");
                int idTipoProducto = rs.getInt("IdTipoArticulo");
                boolean estado = rs.getBoolean("Estado");
                String linkImagen = rs.getString("LinkImagen");
                String descripcion = rs.getString("Descripcion");
                boolean promocion = rs.getBoolean("Promocion");

                Articulo a = new Articulo(articulo, precio, cantidad, idTipoProducto, estado, linkImagen, descripcion, promocion);
                a.setIdArticulo(id);
                lista.add(a);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return lista;
    }
}
