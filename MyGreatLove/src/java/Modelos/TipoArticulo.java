/*
 * "MyGreatLove"
 * Modelo TipoArticulo.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */
package Modelos;


public class TipoArticulo {
    private int idTipoArticulo;
    private String tipo;

    public int getIdTipoArticulo() {
        return idTipoArticulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setIdTipoArticulo(int idTipoArticulo) {
        this.idTipoArticulo = idTipoArticulo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TipoArticulo(int idTipoArticulo, String tipo) {
        this.idTipoArticulo = idTipoArticulo;
        this.tipo = tipo;
    }

    
    
    
    
}
