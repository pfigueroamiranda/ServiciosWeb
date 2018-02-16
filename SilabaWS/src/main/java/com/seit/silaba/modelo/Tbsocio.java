package com.seit.silaba.modelo;
// Generated 19-jul-2017 6:40:16 by Hibernate Tools 4.3.1.Final


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Tbsocio generated by hbm2java
 */
public class Tbsocio  implements java.io.Serializable {


     private Integer consecutivo;
     private String nombre;
     private String apellido;
     private Date fechaNacimiento;
     private String telefonoFijo;
     private String telefonoCelular;
     private Date fechaCreacion;
     private String usuarioCreacion;
     private Set<Tbsociospuntosilaba> tbsociospuntosilabas = new HashSet<Tbsociospuntosilaba>(0);
     private Set<Tbelementosdidacticos> tbelementosdidacticoses = new HashSet<Tbelementosdidacticos>(0);

    public Tbsocio() {
    }

	
    public Tbsocio(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }
    public Tbsocio(Integer consecutivo, String nombre, String apellido, Date fechaNacimiento, String telefonoFijo, String telefonoCelular, Date fechaCreacion, String usuarioCreacion, Set<Tbsociospuntosilaba> tbsociospuntosilabas, Set<Tbelementosdidacticos> tbelementosdidacticoses) {
       this.consecutivo = consecutivo;
       this.nombre = nombre;
       this.apellido = apellido;
       this.fechaNacimiento = fechaNacimiento;
       this.telefonoFijo = telefonoFijo;
       this.telefonoCelular = telefonoCelular;
       this.fechaCreacion = fechaCreacion;
       this.usuarioCreacion = usuarioCreacion;
       this.tbsociospuntosilabas = tbsociospuntosilabas;
       this.tbelementosdidacticoses = tbelementosdidacticoses;
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
    public Set<Tbsociospuntosilaba> getTbsociospuntosilabas() {
        return this.tbsociospuntosilabas;
    }
    
    public void setTbsociospuntosilabas(Set<Tbsociospuntosilaba> tbsociospuntosilabas) {
        this.tbsociospuntosilabas = tbsociospuntosilabas;
    }
    public Set<Tbelementosdidacticos> getTbelementosdidacticoses() {
        return this.tbelementosdidacticoses;
    }
    
    public void setTbelementosdidacticoses(Set<Tbelementosdidacticos> tbelementosdidacticoses) {
        this.tbelementosdidacticoses = tbelementosdidacticoses;
    }




}


