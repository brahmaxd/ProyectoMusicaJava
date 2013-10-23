/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.BD;
import Entity.Usuarios;
import java.util.ArrayList;

/**
 *
 * @author Abraham
 */
public class DAOUsuarios {
     public static boolean sqlInsertar(Usuarios usuarios){
        String stSql = "insert into usuarios (usuarios,clave,esAdmin) values ('" + usuarios.getUsuario() + "','" + usuarios.getClave() + "')";
        BD.getInstance().sqlEjecutar(stSql);
        return true;
    } 
    public static boolean sqlUpdate(Usuarios usuarios){
        String stSql = "update usuarios set clave = '" + usuarios.getClave() +"' where usuario = '" + usuarios.getUsuario() + "'";
        BD.getInstance().sqlEjecutar(stSql);
        return true;
    } 
    public static boolean sqlEliminar(Usuarios usuarios){
        String stSql = "delete from usuarios where usuario = '" + usuarios.getUsuario() + "'";
        BD.getInstance().sqlEjecutar(stSql);
        return true;
    } 
    public static boolean sqlLeer(Usuarios usuarios){
        String stSql = "select * from usuarios where usuario = '" + usuarios.getUsuario() +"'";
        if (!BD.getInstance().sqlSelect(stSql)) return false;
        if (!BD.getInstance().sqlFetch()) return false; 
        //int id = BD.getInstance().getInt("id");
        String clave = BD.getInstance().getString("clave");
        usuarios.setClave(clave);
        //Log.rutea("Pais Leer " + pais.toString());
        return true;
    } 
    public static ArrayList<Usuarios> sqlSelectTodos(Usuarios usuarios){
        ArrayList<Usuarios> array = new ArrayList<Usuarios>();
        String sql = "select * from cancion where 1 = 1";
        
        if(usuarios.getClave()!= null){
            
            if(!usuarios.getClave().trim().equals("")){
                sql+=" and nombre like'%"+usuarios.getClave()+"%'";
            }
        }
        if(!BD.getInstance().sqlSelect(sql)) return array;
        while (BD.getInstance().sqlFetch())
        {
            array.add(new Usuarios(BD.getInstance().getInt("usuario"), BD.getInstance().getString("clave")));
        }
        return array;
    }
    
}
