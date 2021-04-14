/*
 LABORATORIO 1-ARCHIVOS
 EST. FERMIN CONDORI PAUCARA
 */
package com.mycompany.laboratorio1_condori;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FERMIN
 */
public class OperacionesLibroProyecto {
    List<MaterialBibliografico> listaMaterial;
    Scanner lee=new Scanner(System.in);

    public OperacionesLibroProyecto() {
        listaMaterial=new ArrayList<>();
    }
    
    public void registrarMaterial(MaterialBibliografico mat){
        if(mat instanceof Libro){
            //instanciando el objeto Libro()
            Libro lb=new Libro();
            System.out.println("Digite titulo");
            String titulo=lee.nextLine();
            System.out.println("Digite autor");
            String autor=lee.nextLine();
            System.out.println("Digite la edicion");
            int edicion=lee.nextInt();
            lee.nextLine();
            System.out.println("Digite el area");
            String area=lee.nextLine();
            lb=new Libro(edicion,area,titulo,autor);
            listaMaterial.add(lb);
            System.out.println("Libro Registrado!!...");
        }
        if(mat instanceof ProyectoGrado){
            //instanciando el objeto ProyectoGrado()
            ProyectoGrado  proy=new ProyectoGrado();
            System.out.println("Digite titulo");
            String titulo=lee.nextLine();
            System.out.println("Digite autor");
            String autor=lee.nextLine();
            System.out.println("Digite tutor");
            String tutor=lee.nextLine();
            System.out.println("Digite revisor");
            String revisor=lee.nextLine();
            proy=new ProyectoGrado(tutor,revisor,titulo,autor);
            listaMaterial.add(proy);
            System.out.println("Proyecto de grado Registrado!!...");
        }
    }
    
    
    public void mostrarMaterial(){
        if(listaMaterial!=null){
            System.out.println("-------MATERIAL BIBLIOGRAFICO------");
            for(MaterialBibliografico mate:listaMaterial){
                if(mate instanceof Libro){
                    //System.out.println("-----MATERIAL LIBRO-----");
                    Libro lb=(Libro) mate;
                    lb.mostrar();
                }
                if(mate instanceof ProyectoGrado){
                    //System.out.println("-----MATERIAL PROYECTO DE GRADO-----");
                    ProyectoGrado proy=(ProyectoGrado) mate;
                    proy.mostrar();
                }
            }
        }
    }
    
     public void buscarLibroTitulo(){
        if(listaMaterial!=null){
            int sw=0;
            System.out.println("----BUSCAR LIBRO POR TITULO---");
            System.out.println("Digite titulo: ");
            String lbt=lee.nextLine();
            for(MaterialBibliografico lbtitulo:listaMaterial){
                if(lbtitulo instanceof Libro){
                    Libro lb=(Libro)lbtitulo;
                    if(lb.getTitulo().equalsIgnoreCase(lbt)){
                        lb.mostrar();
                        System.out.println("----------------------");
                        sw=1;
                    }
                }
            }
            if(sw==0){
                System.out.println("No existe el material!!");
            }
            System.out.println("----------------------------");
        }    
    }
     
      public void eliminarLibroProyecto(){
        //int sw=0,i=-1;
        
        if(listaMaterial!=null){
            int sw=0,i=-1;
            System.out.println("----ELIMINAR LIBRO O PROYECTO---");
            System.out.println("Digite nombre de material: ");
            String mat=lee.nextLine();
            for(MaterialBibliografico material:listaMaterial){
                i++;
                if(material instanceof Libro){
                    Libro lb=(Libro)material;
                    if(lb.getTitulo().equalsIgnoreCase(mat)){
                        sw=1;
                        listaMaterial.remove(i);
                        System.out.println("Libro eliminado...");
                        break;
                    }
                }
                else{
                    ProyectoGrado proy=(ProyectoGrado)material;
                    if(proy.getTitulo().equalsIgnoreCase(mat)){
                        sw=1;
                        listaMaterial.remove(i);
                        System.out.println("Proyecto de grado eliminado...");
                        break;
                    }
                }
            }
            guardarObjetos();
            if(sw==0){
                System.out.println("No existe el material!!");
            }
            System.out.println("----------------------------");
        } 
        else{
            System.out.println("Lista vacia...");
        }  
    } 
    
    //CREANDO ARCHIVO
    public void crearArchivo(){
        Path path=Paths.get("E:\\programacionIII\\archivoMaterial.txt");
        try{
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("El archivo se creo correctamente");
            }
            else{
                System.out.println("Ya existe el archivo");
            }
        }catch(Exception e){
        }
    }
    
    //guardando la lista material dentro de un archivo con anterioridad
    public void guardarObjetos(){
        String ruta="E:\\programacionIII\\archivoMaterial.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listaMaterial);
            oos.close();
            System.out.println("Material Bibliográfico guardado...");
            //archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesLibroProyecto.class.getName()).log(Level.SEVERE,null, ex);
        }catch(IOException em){
            Logger.getLogger(OperacionesLibroProyecto.class.getName()).log(Level.SEVERE,null, em);
        }
    }
    
    public void leerMaterial(){
        String ruta="E:\\programacionIII\\archivoMaterial.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listaMaterial=(List<MaterialBibliografico>)ois.readObject();
            }
            else{
                System.out.println("El objeto es nulo");
            }
        }catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesLibroProyecto.class.getName()).log(Level.SEVERE,null, e);
        
        }catch(IOException ex){
            Logger.getLogger(OperacionesLibroProyecto.class.getName()).log(Level.SEVERE,null, ex);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(OperacionesLibroProyecto.class.getName()).log(Level.SEVERE,null, ex);
        }
   }
    
}
