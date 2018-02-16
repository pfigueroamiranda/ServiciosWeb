package com.seit.silaba.modelo;
// Generated 19-jul-2017 6:40:16 by Hibernate Tools 4.3.1.Final


import java.util.HashSet;
import java.util.Set;

/**
 * Tbelementosdidacticos generated by hbm2java
 */
public class Tbelementosdidacticos  implements java.io.Serializable {


     private Integer consecutivo;
     private Tbsocio tbsocio;
     private String descripcion;
     private Integer cantidad;
     private Set<Tbestimulosdidacticossilaberxcompetencias> tbestimulosdidacticossilaberxcompetenciases = new HashSet<Tbestimulosdidacticossilaberxcompetencias>(0);

    public Tbelementosdidacticos() {
    }

	
    public Tbelementosdidacticos(Integer consecutivo, Tbsocio tbsocio) {
        this.consecutivo = consecutivo;
        this.tbsocio = tbsocio;
    }
    public Tbelementosdidacticos(Integer consecutivo, Tbsocio tbsocio, String descripcion, Integer cantidad, Set<Tbestimulosdidacticossilaberxcompetencias> tbestimulosdidacticossilaberxcompetenciases) {
       this.consecutivo = consecutivo;
       this.tbsocio = tbsocio;
       this.descripcion = descripcion;
       this.cantidad = cantidad;
       this.tbestimulosdidacticossilaberxcompetenciases = tbestimulosdidacticossilaberxcompetenciases;
    }
   
    public Integer getConsecutivo() {
        return this.consecutivo;
    }
    
    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }
    public Tbsocio getTbsocio() {
        return this.tbsocio;
    }
    
    public void setTbsocio(Tbsocio tbsocio) {
        this.tbsocio = tbsocio;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public Set<Tbestimulosdidacticossilaberxcompetencias> getTbestimulosdidacticossilaberxcompetenciases() {
        return this.tbestimulosdidacticossilaberxcompetenciases;
    }
    
    public void setTbestimulosdidacticossilaberxcompetenciases(Set<Tbestimulosdidacticossilaberxcompetencias> tbestimulosdidacticossilaberxcompetenciases) {
        this.tbestimulosdidacticossilaberxcompetenciases = tbestimulosdidacticossilaberxcompetenciases;
    }




}


