/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.BD;
import Entity.Cancion;
import java.util.ArrayList;

/**
 *
 * @author Abraham
 */
public class DAOCancion {
     public static boolean sqlInsertar(Cancion cancion){
        String stSql = "insert into cancion (id, nombre) values ('" + cancion.getId() + "','" + cancion.getNombre() + "')";
        BD.getInstance().sqlEjecutar(stSql);
        return true;
    } 
    public static boolean sqlUpdate(Cancion cancion){
        String stSql = "update cancion set nombre = '" + cancion.getNombre() +"' where id = '" + cancion.getId() + "'";
        BD.getInstance().sqlEjecutar(stSql);
        return true;
    } 
    public static boolean sqlEliminar(Cancion cancion){
        String stSql = "delete from cancion where id = '" + cancion.getId() + "'";
        BD.getInstance().sqlEjecutar(stSql);
        return true;
    } 
    public static boolean sqlLeer(Cancion cancion){
        String stSql = "select * from cancion where id = '" + cancion.getId() +"'";
        if (!BD.getInstance().sqlSelect(stSql)) return false;
        if (!BD.getInstance().sqlFetch()) return false; 
        //int id = BD.getInstance().getInt("id");
        String nombre = BD.getInstance().getString("nombre");
        cancion.setNombre(nombre);
        //Log.rutea("Pais Leer " + pais.toString());
        return true;
    } 
    public static ArrayList<Cancion> sqlSelectTodos(Cancion cancion){
        ArrayList<Cancion> array = new ArrayList<Cancion>();
        String sql = "select * from cancion where 1 = 1";
        
        if(cancion.getNombre()!= null){
            
            if(!cancion.getNombre().trim().equals("")){
                sql+=" and nombre like'%"+cancion.getNombre()+"%'";
            }
        }
        if(!BD.getInstance().sqlSelect(sql)) return array;
        while (BD.getInstance().sqlFetch())
        {
            array.add(new Cancion(BD.getInstance().getInt("id"), BD.getInstance().getString("nombre")));
        }
        return array;
    }
}
