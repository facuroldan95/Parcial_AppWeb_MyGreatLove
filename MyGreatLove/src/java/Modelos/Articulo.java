
/*
 * "MyGreatLove"
 * Modelo Articulo.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */

package Modelos;

public class Articulo {
    private int idArticulos;
    private String articulo;
    private double precio;
    private int cantidad;
    private int idTipoArticulo;
    private boolean estado;
    private String linkImagen;
    private String descripcion;
    private boolean promocion;
    private int AuxCant;
    

    public boolean isPromocion() {
        return promocion;
    }

    public void setPromocion(boolean promocion) {
        this.promocion = promocion;
    }
    
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

    public String getLinkImagen() {
        return linkImagen;
    }

    public void setLinkImagen(String linkImagen) {
        this.linkImagen = linkImagen;
    }
    

    public int getIdArticulo() {
        return idArticulos;
    }

    public void setIdArticulo(int idArticulos) {
        this.idArticulos = idArticulos;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulos) {
        this.articulo = articulos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdTipoArticulo() {
        return idTipoArticulo;
    }

    public void setIdTipoArticulo(int idTipoArticulo) {
        this.idTipoArticulo = idTipoArticulo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getAuxCant() {
        return AuxCant;
    }

    public void setAuxCant(int AuxCant) {
        this.AuxCant = AuxCant;
    }
    
    

    public Articulo(String articulos, double precio, int cantidad, int idTipoArticulo, boolean estado, String linkImagen, String descripcion, boolean promocion) {
        this.articulo = articulos;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idTipoArticulo = idTipoArticulo;
        this.estado = estado;
        this.linkImagen = linkImagen;
        this.descripcion = descripcion;
        this.promocion = promocion;
    }
    
    
    
}
