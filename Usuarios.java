package model;

public class Usuarios {
    private int idUsu;
    private String nombre_usuario;
    private String password;
    private int tipo_usuario;
    private int idDependencia;
    private int estado;
    
    private String sucursal;

    public Usuarios() {
    }

    public Usuarios(int idUsu, String nombre_usuario, String password, int tipo_usuario, int idDependencia, int estado) {
        this.idUsu = idUsu;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.tipo_usuario = tipo_usuario;
        this.idDependencia = idDependencia;
        this.estado = estado;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }
       
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public int getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(int idDependencia) {
        this.idDependencia = idDependencia;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    
}
