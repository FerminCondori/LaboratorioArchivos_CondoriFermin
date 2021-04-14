/*
LABORATORIO 1-ARCHIVOS
EST. FERMIN CONDORI PAUCARA
 */
package com.mycompany.laboratorio1_condori;

import java.util.Scanner;

public class PrincipalMaterial {
    public static void main(String[] args) {
        MaterialBibliografico libro=new Libro();
        MaterialBibliografico proyecto=new ProyectoGrado();
        OperacionesLibroProyecto obj=new OperacionesLibroProyecto();
        Scanner leer=new Scanner(System.in);
        boolean continuar=true;
        int opcion;
        do{
            System.out.println("----MENU DE OPCIONES----");
            System.out.println("1. Crear Archivo");
            System.out.println("2. Registrar Libro");
            System.out.println("3. Registrar Proyecto de Grado");
            System.out.println("4. Guardar los registros");
            System.out.println("5. Mostrar datos de Material Bibliografico");
            System.out.println("6. Buscar un determinado libro por titulo");
            System.out.println("7. Eliminar un Libro o Proyecto de Grado ");
            //System.out.println("8. Mostrar Material");
            System.out.println("8. Salir");
            System.out.println("Digite la opcion");
            opcion=leer.nextInt();
            switch(opcion){
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    obj.registrarMaterial(libro);
                    break;
                case 3:
                    obj.registrarMaterial(proyecto);
                    break;
                case 4:
                    obj.guardarObjetos();
                    break;
                case 5:
                    obj.leerMaterial();
                    obj.mostrarMaterial();
                    break;
                case 6:
                    obj.leerMaterial();
                    obj.buscarLibroTitulo();
                    break;
                case 7:
                    obj.leerMaterial();
                    obj.eliminarLibroProyecto();
                    break;
//                case 8:
//                    obj.mostrarMaterial();
//                    break;
                default:
                    continuar=false;
                    break;
            }
        }while(continuar);
    }
    
    
}
