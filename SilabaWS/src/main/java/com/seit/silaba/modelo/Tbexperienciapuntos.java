package com.seit.silaba.modelo;
// Generated 19-jul-2017 6:40:16 by Hibernate Tools 4.3.1.Final



/**
 * Tbexperienciapuntos generated by hbm2java
 */
public class Tbexperienciapuntos  implements java.io.Serializable {


     private Integer consecutivo;
     private Tbcatalogoexperienciaaprendizaje tbcatalogoexperienciaaprendizaje;
     private Tbcatalogopuntossilaba tbcatalogopuntossilaba;

    public Tbexperienciapuntos() {
    }

    public Tbexperienciapuntos(Integer consecutivo, Tbcatalogoexperienciaaprendizaje tbcatalogoexperienciaaprendizaje, Tbcatalogopuntossilaba tbcatalogopuntossilaba) {
       this.consecutivo = consecutivo;
       this.tbcatalogoexperienciaaprendizaje = tbcatalogoexperienciaaprendizaje;
       this.tbcatalogopuntossilaba = tbcatalogopuntossilaba;
    }
   
    public Integer getConsecutivo() {
        return this.consecutivo;
    }
    
    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }
    public Tbcatalogoexperienciaaprendizaje getTbcatalogoexperienciaaprendizaje() {
        return this.tbcatalogoexperienciaaprendizaje;
    }
    
    public void setTbcatalogoexperienciaaprendizaje(Tbcatalogoexperienciaaprendizaje tbcatalogoexperienciaaprendizaje) {
        this.tbcatalogoexperienciaaprendizaje = tbcatalogoexperienciaaprendizaje;
    }
    public Tbcatalogopuntossilaba getTbcatalogopuntossilaba() {
        return this.tbcatalogopuntossilaba;
    }
    
    public void setTbcatalogopuntossilaba(Tbcatalogopuntossilaba tbcatalogopuntossilaba) {
        this.tbcatalogopuntossilaba = tbcatalogopuntossilaba;
    }




}

