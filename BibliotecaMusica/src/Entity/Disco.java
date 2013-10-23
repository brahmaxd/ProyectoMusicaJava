/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Abraham
 */
public class Disco {
    private int id;
    private String nombre;

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

    public Disco(int id, String nombre) {
       setId(id);
        setNombre(nombre);                
    }
    
    public Disco(int id)
    {
        setId(id);
    }
    
    public Disco(String nombre)
    {
        setNombre(nombre);
    }

    @Override
    public String toString() {
        return "Disco{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
}
