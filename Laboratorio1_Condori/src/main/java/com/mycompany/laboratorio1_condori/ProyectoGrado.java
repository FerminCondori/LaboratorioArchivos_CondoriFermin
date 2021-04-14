/*
 LABORATORIO 1-ARCHIVOS
 EST. FERMIN CONDORI PAUCARA
 */
package com.mycompany.laboratorio1_condori;

public class ProyectoGrado extends MaterialBibliografico{

   //atributos
    private String tutor;
    private String revisor;
    //constructores
    
    //metodos
    //********METODO SOBREESCRITO**********

    public ProyectoGrado() {
    }

    public ProyectoGrado(String tutor, String revisor, String titulo, String autor) {
        super(titulo, autor);
        this.tutor = tutor;
        this.revisor = revisor;
    }
    
    
    public void mostrar(){
        super.mostrar();
        System.out.println("Tutor: "+this.tutor);
        System.out.println("Revisor: "+this.revisor);
        System.out.println("------------------------------------");
    }
    //********FIN METODO SOBREESCRITO*******
    
    //getter y setter

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }
}