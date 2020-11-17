/*
 * "MyGreatLove"
 * Modelo Pareja.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */
package Modelos;


public class Pareja {
    private int idPareja;
    private double monto;
    private boolean estado;
    private int idCuenta;

    public int getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(int idPareja) {
        this.idPareja = idPareja;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    /*
    public Pareja(double monto, boolean estado, int idCuenta) {
        this.monto = monto;
        this.estado = estado;
        this.idCuenta = idCuenta;
    }
    */
    
}
