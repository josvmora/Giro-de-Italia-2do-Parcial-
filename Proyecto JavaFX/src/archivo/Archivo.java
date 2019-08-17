
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

import entidades.Ciclista;
import java.io.IOException;
import java.util.ArrayList;
//import utilidades.Validacion;

/**
 *
 * @author VR
 */
public class Archivo{
    private static final String RUTA_ARCHIVO = "Ciclista.dat";
    
    public static boolean crear(){
        EscribirArchivo archivo = new EscribirArchivo();
        try{            
            archivo.abrir(RUTA_ARCHIVO);
            archivo.cerrar();
        }catch(IOException e){
            return false;
        }
        return true;
    }
    
    public static boolean borrar_contenido(){
        try{
            EscribirArchivo archivo = new EscribirArchivo();
            archivo.borrar_contenido(RUTA_ARCHIVO);
            archivo.cerrar();
        }catch(IOException e){
            return false;
        }
        return true;
    }
    
    public static ArrayList<Ciclista> obtener_registros()throws Exception{
        ArrayList<Ciclista> personas;
        try{
            LeerArchivo archivo = new LeerArchivo();
            archivo.abrir(RUTA_ARCHIVO);
            personas = archivo.obteniendo_objetos();
            archivo.cerrar();
        }catch(Exception e){
            throw e;
        }    
        return personas;        
    }
    
    public static boolean insertar_registro(Ciclista p){
        EscribirArchivo archivo = new EscribirArchivo();
        try{
            archivo.abrir(RUTA_ARCHIVO);
            archivo.insertar_objeto(p);
            archivo.cerrar(); 
        }catch(Exception e){
            return false;
        }                          
        return true;
    }
    
   /* public static boolean actualizar_registro(Persona p){
         ArrayList<Persona> personas = null;
         try{
            personas = Archivo.obtener_registros();
            int indice = Validacion.existePersona(personas,p);
            personas.set(indice, p);
         }catch(Exception e){
             return false;
         }
         return Archivo.actualizar_registros(personas);         
    }*/
    
    public static boolean actualizar_registros(ArrayList personas){
        borrar_contenido();
        EscribirArchivo archivo = new EscribirArchivo();
        try{            
            archivo.abrir(RUTA_ARCHIVO);
            for(int i=0;i<personas.size();i++)
                archivo.insertar_objeto(personas.get(i));
            archivo.cerrar();
        }catch(Exception e){
            return false;
        }                 
        return true;
    }
    
//    public static boolean actualizarDatosPersona(Persona p){        
//        ArrayList<Persona> registros = null;
//        
//        try{
//            registros = Archivo.obtener_registros();
//            for(int i=0;i<registros.size();i++){
//                Persona tmp = registros.get(i); 
//                if(tmp.getCedula().equals(p.getCedula())){                
//                    p.setCedula(tmp.getCedula());
//                    p.setNombres(tmp.getNombres());
//                    p.setApellidos(tmp.getApellidos());
//                    p.setEdad(tmp.getEdad());
//                    return true;
//                }
//            }
//        }catch(Exception e){
//            return false;
//        }    
//        return false;
//    }
    
}




