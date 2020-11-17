package DTOs;

public class DTOAdmTop5Ventas {
    private int idArticulo;
    private String Articulo;
    private int cantidad;

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getArticulo() {
        return Articulo;
    }

    public void setArticulo(String Articulo) {
        this.Articulo = Articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public DTOAdmTop5Ventas(int idArticulo, String Articulo, int cantidad) {
        this.idArticulo = idArticulo;
        this.Articulo = Articulo;
        this.cantidad = cantidad;
    }
    
    
    
}
