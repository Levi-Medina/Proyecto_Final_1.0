package model;

import configuration.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDao {
    private Conexion conexion;
    private Connection connection;
    private int res;
    
    public Usuarios login(String usu, String pass) throws SQLException {
        conexion = new Conexion();
        connection = conexion.getConexion();
        Usuarios users = new Usuarios();
        int tipo_user = 0;
        String sql = "select * from login where Nombre_Usuario=? and Contraseña=? and Estado=1";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usu);
        statement.setString(2, pass);
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            users.setNombre_usuario(rs.getString("Nombre_Usuario"));
            System.out.println("nombre:" + users.getNombre_usuario());
            users.setPassword(rs.getString("Contraseña"));
            System.out.println("pass:" + users.getPassword());
            users.setTipo_usuario(rs.getInt("Tipo_Usuario"));
        }
        return users;
    }
    
    public Usuarios recoverPassword(String usu) throws SQLException {
        conexion = new Conexion();
        connection = conexion.getConexion();
        Usuarios us = new Usuarios();
        String sql = "select Nombre_Usuario, Tipo_Usuario, Contraseña from login where Nombre_Usuario = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usu);
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            us.setNombre_usuario(rs.getString("Nombre_Usuario"));
            us.setPassword(rs.getString("Contraseña"));
            us.setTipo_usuario(rs.getInt("Tipo_Usuario"));
        }
        return us;
    }
    
    //operaciones CRUD
    public List listar() throws SQLException {
        conexion = new Conexion();
        connection = conexion.getConexion();
        List<Usuarios> usus = new ArrayList<>();
        String sql = "select login.idUsuario, login.Nombre_Usuario, login.Contraseña, login.Tipo_Usuario, login.Estado, sucursal.Sucursal from dyjamir.login, dyjamir.sucursal where login.idDependencia = sucursal.idDependencia and login.Estado = 1;";
//        String sql = "SELECT idUsuario, Nombre_Usuario, Contraseña, Tipo_Usuario, Sucursal FROM dyjamir.login a inner join dyjamir.sucursal b on a.idDependencia = b.idDependencia";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            Usuarios users = new Usuarios();
            users.setIdUsu(rs.getInt("idUsuario"));
            //System.out.println("id:" + users.getIdUsu());
            users.setNombre_usuario(rs.getString("Nombre_Usuario"));
            //System.out.println("nombre:" + users.getNombre_usuario());
            users.setPassword(rs.getString("Contraseña"));
            users.setTipo_usuario(rs.getInt("Tipo_Usuario"));
            users.setEstado(rs.getInt("Estado"));
            //System.out.println("estado:" + users.getEstado());
            users.setSucursal(rs.getString("Sucursal"));
            usus.add(users);
        }
       return usus;      
    }
    
    public Usuarios listarId(int id) throws SQLException {
        Usuarios user = new Usuarios();
        conexion = new Conexion();
        connection = conexion.getConexion();
        String sql = "select *from login where idUsuario="+id;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            user.setNombre_usuario(rs.getString("Nombre_Usuario"));
            //System.out.println("nombre:" + users.getNombre_usuario());
            user.setPassword(rs.getString("Contraseña"));
            user.setTipo_usuario(rs.getInt("Tipo_Usuario"));
            //System.out.println("estado:" + users.getEstado());
            user.setIdDependencia(rs.getInt("idDependencia"));
            user.setEstado(rs.getInt("Estado"));
        }
        return user;
    }

    public int add(Usuarios user) throws SQLException {
        int estado = 1;
        conexion = new Conexion();
        connection = conexion.getConexion();
        String sql = "insert into login (Nombre_Usuario, Contraseña, Tipo_Usuario, idDependencia, Estado) values (?, ?, ?, ?, ?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getNombre_usuario());
        statement.setString(2, user.getPassword());
        statement.setInt(3, user.getTipo_usuario());
        statement.setInt(4, user.getIdDependencia());
        statement.setInt(5, estado);
        statement.executeUpdate();
        return res;
    }

    public int update (Usuarios user) throws SQLException {
        conexion = new Conexion();
        connection = conexion.getConexion();
        String sql = "update login set Nombre_Usuario=?, Contraseña=?, Tipo_Usuario=?, idDependencia=?, Estado=? where idUsuario=? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getNombre_usuario());
        statement.setString(2, user.getPassword());
        statement.setInt(3, user.getTipo_usuario());
        statement.setInt(4, user.getIdDependencia());
        statement.setInt(5, user.getEstado());
        statement.setInt(6, user.getIdUsu());
        statement.executeUpdate();
        return res;
    }

    public int delete(int id) throws SQLException {
        conexion = new Conexion();
        connection = conexion.getConexion();
        String sql = "update login set Estado=0 where idUsuario="+id;
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        return res;
    }
    
    public boolean checkUser(String user) throws SQLException {
        conexion = new Conexion();
        connection = conexion.getConexion();
        String sql = "select Nombre_Usuario from login where Nombre_Usuario = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user);
        ResultSet rs = statement.executeQuery();
        if(rs.next()) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) throws SQLException {
        UsuariosDao dao = new UsuariosDao();
        if(dao.checkUser("@super")) {
            System.out.println("usuario existe");
            
        } else {
            System.out.println("Usuario no existe");
        }
    }
}