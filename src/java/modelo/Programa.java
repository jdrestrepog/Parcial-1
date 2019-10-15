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
public class Programa {

    Integer Id_programa;
    String Programa;

    public Programa() {
    }

    public Programa(Integer Id_programa, String Programa) {
        this.Id_programa = Id_programa;
        this.Programa = Programa;
    }

    public Integer getId_programa() {
        return Id_programa;
    }

    public String getPrograma() {
        return Programa;
    }

    public void setId_programa(Integer Id_programa) {
        this.Id_programa = Id_programa;
    }

    public void setPrograma(String Programa) {
        this.Programa = Programa;
    }
    
    

}
