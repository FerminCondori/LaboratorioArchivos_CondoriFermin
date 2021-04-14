/*
LABORATORIO 1-ARCHIVOS
EST. FERMIN CONDORI PAUCARA
 */
package com.mycompany.laboratorio1_condori;

import java.io.Serializable;

public class MaterialBibliografico implements Serializable{

   static final long serialVersionUID=43L;
    //atributos
    private String titulo;
    private String autor;
    
    //constructores

    public MaterialBibliografico() {
    }

    public MaterialBibliografico(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    
    //metodos
    public void mostrar(){
        System.out.println("Titulo: "+this.titulo);
        System.out.println("Autor: "+this.autor);
    }
    
    //getter y setter

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}

