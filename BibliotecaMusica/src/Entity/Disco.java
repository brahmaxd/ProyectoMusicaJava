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
    private int idArtista;

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
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

    public Disco(int id, String nombre,int idArtista) {
       setId(id);
        setNombre(nombre);   
        setIdArtista(idArtista);
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
        return "Disco{" + "id=" + id + ", nombre=" + nombre + ", idArtista=" + idArtista + '}';
    }

   
}
