package DTOs;

import Modelos.Conyugue;
import java.util.ArrayList;

public class DTOCuenta {
    private int idCuenta;
    private int idPareja;
    private ArrayList<Conyugue> conyugues;
    private String usuario;
    private double monto;
    private int cantidadRegalos;
    private boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    

    public int getCantidadRegalos() {
        return cantidadRegalos;
    }

    public void setCantidadRegalos(int cantidadRegalos) {
        this.cantidadRegalos = cantidadRegalos;
    }
    
    public ArrayList<Conyugue> getConyugues() {
        return conyugues;
    }

    public void setConyugues(ArrayList<Conyugue> conyugues) {
        this.conyugues = conyugues;
    }
    

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(int idPareja) {
        this.idPareja = idPareja;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
}
