/*
 * "MyGreatLove"
 * Modelo Operación.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */

package Modelos;

public class Operacion {
    private int idOperacion;
    private int idPareja;
    private String fecha;
    private boolean Flag;

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public int getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(int idPareja) {
        this.idPareja = idPareja;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isFlag() {
        return Flag;
    }

    public void setFlag(boolean Flag) {
        this.Flag = Flag;
    }

    

    
}
