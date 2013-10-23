/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Abraham
 */
public class Usuarios {
    
    private String usuario;
    private String clave;
    private int esAdmin; 

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(int esAdmin) {
        this.esAdmin = esAdmin;
    }

    public Usuarios(String usuario, String clave, int esAdmin) {
        setUsuario(usuario);
        setClave(clave);
        setEsAdmin(esAdmin);
    }

    @Override
    public String toString() {
        return "Usuarios{" + "usuario=" + usuario + ", clave=" + clave + ", esAdmin=" + esAdmin + '}';
    }
    
}
