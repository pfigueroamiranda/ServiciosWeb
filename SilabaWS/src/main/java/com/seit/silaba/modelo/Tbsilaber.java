package com.seit.silaba.modelo;
// Generated 19-jul-2017 6:40:16 by Hibernate Tools 4.3.1.Final


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Tbsilaber generated by hbm2java
 */
public class Tbsilaber  implements java.io.Serializable {


     private Integer consecutivo;
     private String nombre;
     private String apellido;
     private Date fechaNacimiento;
     private String telefonoFijo;
     private String telefonoCelular;
     private Date fechaCreacion;
     private String usuarioCreacion;
     private String usuario;
     private String contrasena;
     private Set<Tbrutaexperienciaaprendizaje> tbrutaexperienciaaprendizajes = new HashSet<Tbrutaexperienciaaprendizaje>(0);
     private Set<Tbprogramacionexperienciasilaber> tbprogramacionexperienciasilabers = new HashSet<Tbprogramacionexperienciasilaber>(0);

    public Tbsilaber() {
    }

	
    public Tbsilaber(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }
    public Tbsilaber(Integer consecutivo, String nombre, String apellido, Date fechaNacimiento, String telefonoFijo, String telefonoCelular, Date fechaCreacion, String usuarioCreacion, String usuario, String contrasena, Set<Tbrutaexperienciaaprendizaje> tbrutaexperienciaaprendizajes, Set<Tbprogramacionexperienciasilaber> tbprogramacionexperienciasilabers) {
       this.consecutivo = consecutivo;
       this.nombre = nombre;
       this.apellido = apellido;
       this.fechaNacimiento = fechaNacimiento;
       this.telefonoFijo = telefonoFijo;
       this.telefonoCelular = telefonoCelular;
       this.fechaCreacion = fechaCreacion;
       this.usuarioCreacion = usuarioCreacion;
       this.usuario = usuario;
       this.contrasena = contrasena;
       this.tbrutaexperienciaaprendizajes = tbrutaexperienciaaprendizajes;
       this.tbprogramacionexperienciasilabers = tbprogramacionexperienciasilabers;
    }
   
    public Integer getConsecutivo() {
        return this.consecutivo;
    }
    
    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getTelefonoFijo() {
        return this.telefonoFijo;
    }
    
    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }
    public String getTelefonoCelular() {
        return this.telefonoCelular;
    }
    
    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public String getUsuarioCreacion() {
        return this.usuarioCreacion;
    }
    
    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
    public Set<Tbrutaexperienciaaprendizaje> getTbrutaexperienciaaprendizajes() {
        return this.tbrutaexperienciaaprendizajes;
    }
    
    public void setTbrutaexperienciaaprendizajes(Set<Tbrutaexperienciaaprendizaje> tbrutaexperienciaaprendizajes) {
        this.tbrutaexperienciaaprendizajes = tbrutaexperienciaaprendizajes;
    }
    public Set<Tbprogramacionexperienciasilaber> getTbprogramacionexperienciasilabers() {
        return this.tbprogramacionexperienciasilabers;
    }
    
    public void setTbprogramacionexperienciasilabers(Set<Tbprogramacionexperienciasilaber> tbprogramacionexperienciasilabers) {
        this.tbprogramacionexperienciasilabers = tbprogramacionexperienciasilabers;
    }


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}




}


