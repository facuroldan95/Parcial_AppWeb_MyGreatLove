package DTOs;


public class DTOArticulo {
    private int idarticulo;
    private String articulo;
    private String categoria;
    private double precio;
    private int cantidad;
    private boolean estado;
    private String linkImagen;
    private String descripcion;
    private boolean promocion;

    public int getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(int idarticulo) {
        this.idarticulo = idarticulo;
    }

    

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getLinkImagen() {
        return linkImagen;
    }

    public void setLinkImagen(String linkImagen) {
        this.linkImagen = linkImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isPromocion() {
        return promocion;
    }

    public void setPromocion(boolean promocion) {
        this.promocion = promocion;
    }

    public DTOArticulo(int idArticulo, String articulo, String categoria, double precio, int cantidad, boolean estado, String linkImagen, String descripcion, boolean promocion) {
        this.idarticulo = idArticulo;
        this.articulo = articulo;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
        this.estado = estado;
        this.linkImagen = linkImagen;
        this.descripcion = descripcion;
        this.promocion = promocion;
    }

    
    
}
