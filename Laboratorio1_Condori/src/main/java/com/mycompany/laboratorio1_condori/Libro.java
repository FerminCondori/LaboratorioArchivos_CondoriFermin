/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorio1_condori;

/**
 *
 * @author FERMIN
 */
//Clase Libro
public class Libro extends MaterialBibliografico{

    private double sueldo;
 
   private int edicion;
    private String area;
    
    //constructores

    public Libro() {
    }

    public Libro(int edicion, String area, String titulo, String autor) {
        super(titulo, autor);
        this.edicion = edicion;
        this.area = area;
    }
    
    
    
    //metodos
    
    public void mostrar(){
        super.mostrar();
        System.out.println("Edicion: "+this.edicion);
        System.out.println("Area: "+this.area);
    }
    //********FIN METODO SOBREESCRITO*******
    
    //getter y setter

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}