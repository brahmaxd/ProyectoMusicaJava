/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Abraham
 */
public class Cancion {
    private int id;
    private String nombre;
    private int idDisco;

    public int getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(int idDisco) {
        this.idDisco = idDisco;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cancion(int id, String nombre,int idDisco) {
       setId(id);
        setNombre(nombre); 
        setIdDisco(idDisco);
               
    }
    public Cancion(String nombre)
    {
        setNombre(nombre);
    }
    
    public Cancion (int id )
    {
        setId(id);
    }

    @Override
    public String toString() {
        return "Cancion{" + "id=" + id + ", nombre=" + nombre + ", idDisco=" + idDisco + '}';
    }

 
    
}
