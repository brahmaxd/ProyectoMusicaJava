/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Conexion.BD;
import Entity.Disco;
import java.util.ArrayList;

/**
 *
 * @author Juansho
 */
public class DAODisco {
    public static boolean sqlInsertar(Disco disco){
        String stSql = "insert into disco (id, nombre) values ('" + disco.getId() + "','" + disco.getNombre() + "')";
        BD.getInstance().sqlEjecutar(stSql);
        return true;
    } 
    public static boolean sqlUpdate(Disco disco){
        String stSql = "update disco set nombre = '" + disco.getNombre() +"' where id = '" + disco.getId() + "'";
        BD.getInstance().sqlEjecutar(stSql);
        return true;
    } 
    public static boolean sqlEliminar(Disco disco){
        String stSql = "delete from disco where id = '" + disco.getId() + "'";
        BD.getInstance().sqlEjecutar(stSql);
        return true;
    } 
    public static boolean sqlLeer(Disco disco){
        String stSql = "select * from disco where id = '" + disco.getId() +"'";
        if (!BD.getInstance().sqlSelect(stSql)) return false;
        if (!BD.getInstance().sqlFetch()) return false; 
        //int id = BD.getInstance().getInt("id");
        String nombre = BD.getInstance().getString("nombre");
        disco.setNombre(nombre);
        //Log.rutea("Pais Leer " + pais.toString());
        return true;
    } 
    public static ArrayList<Disco> sqlSelectTodos(Disco disco){
        ArrayList<Disco> array = new ArrayList<Disco>();
        String sql = "select * from disco where 1 = 1";
        
        if(disco.getNombre()!= null){
            
            if(!disco.getNombre().trim().equals("")){
                sql+=" and nombre like'%"+disco.getNombre()+"%'";
            }
        }
        if(!BD.getInstance().sqlSelect(sql)) return array;
        while (BD.getInstance().sqlFetch())
        {
            array.add(new Disco(BD.getInstance().getInt("id"), BD.getInstance().getString("nombre")));
        }
        return array;
    }
}
