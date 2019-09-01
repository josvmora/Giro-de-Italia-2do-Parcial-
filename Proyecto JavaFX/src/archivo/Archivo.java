
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

import entidades.Ciclista;
import entidades.Equipos;
import entidades.Rutas;
import java.io.IOException;
import java.util.ArrayList;
//import utilidades.Validacion;

/**
 *
 * @author VR
 */
public class Archivo{
    
    
    public static boolean crear(String RUTA_ARCHIVO){
        EscribirArchivo archivo = new EscribirArchivo();
        try{            
            archivo.abrir(RUTA_ARCHIVO);
            archivo.cerrar();
        }catch(IOException e){
            return false;
        }
        return true;
    }
    
    public static boolean borrar_contenido(String RUTA_ARCHIVO){
        try{
            EscribirArchivo archivo = new EscribirArchivo();
            archivo.borrar_contenido(RUTA_ARCHIVO);
            archivo.cerrar();
        }catch(IOException e){
            return false;
        }
        return true;
    }
    
    public static ArrayList<Ciclista> obtener_registros(String RUTA_ARCHIVO)throws Exception{
        ArrayList<Ciclista> ciclistas;
        try{
            LeerArchivo archivo = new LeerArchivo();
            archivo.abrir(RUTA_ARCHIVO);
            ciclistas = archivo.obteniendo_objetos();
            archivo.cerrar();
        }catch(Exception e){
            throw e;
        }    
        return ciclistas;        
    }
    
    
    
      public static ArrayList<Equipos> obtener_registros_equipos(String RUTA_ARCHIVO)throws Exception{
        ArrayList<Equipos> ciclistas;
        try{
            LeerArchivo archivo = new LeerArchivo();
            archivo.abrir(RUTA_ARCHIVO);
            ciclistas = archivo.obteniendo_objetos();
            archivo.cerrar();
        }catch(Exception e){
            throw e;
        }    
        return ciclistas;        
    }
    
      public static ArrayList<Rutas> obtener_registros_rutas(String RUTA_ARCHIVO)throws Exception{
        ArrayList<Rutas> ciclistas;
        try{
            LeerArchivo archivo = new LeerArchivo();
            archivo.abrir(RUTA_ARCHIVO);
            ciclistas = archivo.obteniendo_objetos();
            archivo.cerrar();
        }catch(Exception e){
            throw e;
        }    
        return ciclistas;        
    }
      
      
      
      
      
    
    //falta el de rutas 
    
    public static boolean insertar_registro(String RUTA_ARCHIVO,Ciclista c){
        EscribirArchivo archivo = new EscribirArchivo();
        try{
            archivo.abrir(RUTA_ARCHIVO);
            archivo.insertar_objeto(c);
            archivo.cerrar(); 
        }catch(Exception e){
            return false;
        }                          
        return true;
    }
    
    
      public static boolean insertar_registro_Rutas(String RURTA_ARCHIVO,Rutas r){
        EscribirArchivo archivo = new EscribirArchivo();
        try{
            archivo.abrir(RURTA_ARCHIVO);
            archivo.insertar_objeto(r);
            archivo.cerrar();
            
        }catch(Exception e){
            return false;
        }
        return true;
    }
      
      public static boolean insertar_registro_Equipos(String RURTA_ARCHIVO,Equipos eq){
        EscribirArchivo archivo = new EscribirArchivo();
        try{
            archivo.abrir(RURTA_ARCHIVO);
            archivo.insertar_objeto(eq);
            archivo.cerrar();
            
        }catch(Exception e){
            return false;
        }
        return true;
    }
      
      
      
    // se puede usar el mismo metodo de arriba cuando se quiera hacer con rutas
    
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
    
    public static boolean actualizar_registros(String RUTA_ARCHIVO,ArrayList ciclistas){
        borrar_contenido(RUTA_ARCHIVO);
        EscribirArchivo archivo = new EscribirArchivo();
        try{            
            archivo.abrir(RUTA_ARCHIVO);
            for(int i=0;i<ciclistas.size();i++)
                archivo.insertar_objeto(ciclistas.get(i));
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




