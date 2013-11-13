/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Abraham
 */
public class Genero {
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

    public Genero(int id, String nombre,int IdArtista) {
       setId(id);
        setNombre(nombre); 
        setIdArtista(idArtista);
               
    }
    public Genero(String nombre)
    {
        setNombre(nombre);
    }

    public Genero (int id)
    {
        setId(id);
    }
    @Override
    public String toString() {
        return "Genero{" + "id=" + id + ", nombre=" + nombre + ", idArtista=" + idArtista + '}';
    }

  
    
}
