/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.BD;
import Entity.Artista;
import java.util.ArrayList;

/**
 *
 * @author Abraham
 */
public class DAOArtista {
    
     public static boolean sqlInsertar(Artista artista){
        String stSql = "insert into artista (id, nombre) values ('" + artista.getId() + "','" + artista.getNombre() + "')";
        BD.getInstance().sqlEjecutar(stSql);
        return true;
    } 
    public static boolean sqlUpdate(Artista artista){
        String stSql = "update artista set nombre = '" + artista.getNombre() +"' where id = '" + artista.getId() + "'";
        BD.getInstance().sqlEjecutar(stSql);
        return true;
    } 
    public static boolean sqlEliminar(Artista artista){
        String stSql = "delete from artista where id = '" + artista.getId() + "'";
        BD.getInstance().sqlEjecutar(stSql);
        return true;
    } 
    public static boolean sqlLeer(Artista artista){
        String stSql = "select * from artista where id = '" + artista.getId() +"'";
        if (!BD.getInstance().sqlSelect(stSql)) return false;
        if (!BD.getInstance().sqlFetch()) return false; 
        //int id = BD.getInstance().getInt("id");
        String nombre = BD.getInstance().getString("nombre");
        artista.setNombre(nombre);
        //Log.rutea("Pais Leer " + pais.toString());
        return true;
    } 
    public static ArrayList<Artista> sqlSelectTodos(Artista artista){
        ArrayList<Artista> array = new ArrayList<Artista>();
        String sql = "select * from artista where 1 = 1";
        
        if(artista.getNombre()!= null){
            
            if(!artista.getNombre().trim().equals("")){
                sql+=" and nombre like'%"+artista.getNombre()+"%'";
            }
        }
        if(!BD.getInstance().sqlSelect(sql)) return array;
        while (BD.getInstance().sqlFetch())
        {
            array.add(new Artista(BD.getInstance().getInt("id"), BD.getInstance().getString("nombre")));
        }
        return array;
    }
    
}
