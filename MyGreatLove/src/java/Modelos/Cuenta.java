/*
 * "MyGreatLove"
 * Modelo Cuenta.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */

package Modelos;


public class Cuenta {
    private int idCuenta;
    private String usuario;
    private String password;
    private boolean admin;
    private boolean estado;

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    

    @Override
    public String toString() {
        return "Cuenta{" + "idCuenta=" + idCuenta + ", usuario=" + usuario + ", password=" + password + ", admin=" + admin + ", estado=" + estado + '}';
    }
    
    
}
