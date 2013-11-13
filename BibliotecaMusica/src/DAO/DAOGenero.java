/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.BD;
import Entity.Genero;
import java.util.ArrayList;

/**
 *
 * @author Abraham
 */
public class DAOGenero {
     public static boolean sqlInsertar(Genero genero){
        String stSql = "insert into genero (id, nombre) values ('" + genero.getId() + "','" + genero.getNombre() + "')";
        BD.getInstance().sqlEjecutar(stSql);
        return true;
    } 
    public static boolean sqlUpdate(Genero genero){
        String stSql = "update genero set nombre = '" + genero.getNombre() +"' where id = '" + genero.getId() + "'";
        BD.getInstance().sqlEjecutar(stSql);
        return true;
    } 
    public static boolean sqlEliminar(Genero genero){
        String stSql = "delete from genero where id = '" + genero.getId() + "'";
        BD.getInstance().sqlEjecutar(stSql);
        return true;
    } 
    public static boolean sqlLeer(Genero genero){
        String stSql = "select * from genero where id = '" + genero.getId() +"'";
        if (!BD.getInstance().sqlSelect(stSql)) return false;
        if (!BD.getInstance().sqlFetch()) return false; 
        //int id = BD.getInstance().getInt("id");
        String nombre = BD.getInstance().getString("nombre");
        genero.setNombre(nombre);
        //Log.rutea("Pais Leer " + pais.toString());
        return true;
    } 
    /*public static ArrayList<Genero> sqlSelectTodos(Genero genero){
        ArrayList<Genero> array = new ArrayList<Genero>();
        String sql = "select * from cancion where 1 = 1";
        
        if(genero.getNombre()!= null){
            
            if(!genero.getNombre().trim().equals("")){
                sql+=" and nombre like'%"+genero.getNombre()+"%'";
            }
        }
        if(!BD.getInstance().sqlSelect(sql)) return array;
        while (BD.getInstance().sqlFetch())
        {
            array.add(new Genero(BD.getInstance().getInt("id"), BD.getInstance().getString("nombre")));
        }
        return array;
    }*/
    public static ArrayList<Genero> sqlSelectTodos(Genero genero){
        ArrayList<Genero> array = new ArrayList<Genero>();
        String sql = "select * from genero where 1 = 1 ";
        
        /*if(String.valueOf(inicio) != null)
        {
            if(String.valueOf(fin) != null)
            {
                sql+= " and eq_nombre like '%" + genero.getNombre() + "%'";
                //sql+= " and eq_cantidad_jugadores '%" + genero.getCantidad_jugadores() + "'%";//cambiar
            }
        }*/
        if(!BD.getInstance().sqlSelect(sql)) return array;
        while (BD.getInstance().sqlFetch())
        {
            array.add(new Genero(BD.getInstance().getInt("id"), BD.getInstance().getString("nombre"), BD.getInstance().getInt("idArtista")));
        }
        return array;
    }
}
