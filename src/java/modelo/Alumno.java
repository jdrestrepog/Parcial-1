/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author juan
 */
public class Alumno {

    String  Identificación;
    String  NombreCompleto;
    Integer Semestre;
    Integer Id_programa;
    Boolean Estado;

    public Alumno() {
    }

    public Alumno(String Identificación, String NombreCompleto, Integer Semestre, Integer Id_programa, Boolean Estado) {
        this.Identificación = Identificación;
        this.NombreCompleto = NombreCompleto;
        this.Semestre = Semestre;
        this.Id_programa = Id_programa;
        this.Estado = Estado;
    }

    public String getIdentificación() {
        return Identificación;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public Integer getSemestre() {
        return Semestre;
    }

    public Integer getId_programa() {
        return Id_programa;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setIdentificación(String Identificación) {
        this.Identificación = Identificación;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public void setSemestre(Integer Semestre) {
        this.Semestre = Semestre;
    }

    public void setId_programa(Integer Id_programa) {
        this.Id_programa = Id_programa;
    }

    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
    }
    
    
    
}
