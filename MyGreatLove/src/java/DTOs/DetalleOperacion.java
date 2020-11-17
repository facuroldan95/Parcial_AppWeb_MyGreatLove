package DTOs;

public class DetalleOperacion {
    private int idOperacion;
    private String articulo;
    private double precioUnitario;
    private int cantidad;
    private double montoTotal;

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public DetalleOperacion(int idOperacion, String articulo, double precioUnitario, int cantidad, double montoTotal) {
        this.idOperacion = idOperacion;
        this.articulo = articulo;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.montoTotal = montoTotal;
    }
    
    
}
