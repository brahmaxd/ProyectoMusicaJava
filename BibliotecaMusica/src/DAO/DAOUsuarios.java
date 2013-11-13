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
 * 
 * */
public class DAOUsuarios {   
    /*public static boolean sqlInsertar(Usuarios usuarios){
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
 */   
    public static Boolean sqlInsert(Usuarios usuario)
        {
            String sql = "Insert into usuarios (usuario, clave, esAdmin) values ('" + usuario.getUsuario() + "','" + usuario.getClave() + "','" + usuario.getEsAdmin() + "')";
            BD bd = Conexion.BD.getInstance();
            bd.sqlEjecutar(sql);
            return true;
        }

        public static Boolean sqlDelete(Usuarios usuario)
        {
            String sql = "Delete from usuarios where usuario = '" + usuario.getUsuario() + "'";
            BD bd = Conexion.BD.getInstance();
            bd.sqlEjecutar(sql);
            return true;
        }

        public static Boolean sqlUpdate(Usuarios usuario)
        {
            String sql = "Update usuarios set clave '" + usuario.getClave() + "', esAdmin = '" + usuario.getEsAdmin() + "' where usuario = '" + usuario.getUsuario() + "'";
            BD bd = Conexion.BD.getInstance();
            bd.sqlEjecutar(sql);
            return true;
        }

        public static Usuarios sqlLeer(Usuarios usuario)
        {
            String sql = "Select * from usuarios where usuario = '" + usuario.getUsuario() + "'";
            BD bd = Conexion.BD.getInstance();
            bd.sqlEjecutar(sql);
            return usuario;
        }

       /* public static Boolean esAdmin(Usuarios usuario)
        {
            String sql = "Select esAdmin from usuarios where usuario = '" + usuario.getUsuario() + "'";
            BD bd = Conexion.BD.getInstance();
            DataTable dt = bd.sqlSelect(sql);
            if (dt.Rows.Count == 0)
            {
                return false;
            }
            
            int admin = int.Parse(dt.Rows[0]["esAdmin"].ToString());
            if (admin == 0)
            {
                return false;
            }
            return true;
        }

        public static Boolean login(Usuarios usuario)
        {
            String sql = "Select * from usuarios where usuario = '" + usuario.getUsuario()+ "' and clave = '" + usuario.getClave() + "'";
            BD bd = Conexion.BD.getInstance();
            DataTable dt = bd.sqlSelect(sql);
            if (dt.Rows.Count == 0)
            {
                return false;
            }
            return true;
        }*/
}
