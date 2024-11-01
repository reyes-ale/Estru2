/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebafuncionalidad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lenovo
 */

public class PruebaFuncionalidad {

    /**
     * @param args the command line arguments
     */
    
    static ArrayList<Slot> contenido = new ArrayList<>();
    static ArrayList<Integer> availist = new ArrayList<>();
    static Scanner papoy = new Scanner(System.in);
   
    public static void main(String[] args) {
        System.out.println("Construccion Avail List\nRegistros ---");
        LeerArchivo();
        for (int i = 0; i < contenido.size(); i++) {
            System.out.println(i+". "+contenido.get(i).getCampo()+"(Tamano - "+contenido.get(i).getTam());
        }
        System.out.println("Ingrese el byte off set que desee eliminar - ");
        int entrada = papoy.nextInt();
        while (entrada < 0 || entrada > 10) {            
            System.out.println("Ingrese un numero que este en el rango de registros del 1 al 10 - ");
            entrada = papoy.nextInt();
        }
        Slot slot = contenido.get(entrada);
        delete(entrada, slot.getTam());
        System.out.println("Slot Eliminado Correctamente!");
       
    }
    
    public static void EscribirArchivo(String line) {
        File archivo = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            archivo = new File("PruebaAvailist.txt");
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            bw.write(line);
            bw.flush();
            fw.close();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void LeerArchivo(){
        //ArrayList campos = new ArrayList();
        FileReader archivo;
        BufferedReader buffer;
        
        try {
            archivo = new FileReader("PruebaAvailist.txt");
            
            if(archivo.ready()){
                buffer = new BufferedReader(archivo);
                String cad;
                int cont = 0;
                while ((cad =buffer.readLine()) != null){
                    //System.out.println(cad);     
                    String [] campos = cad.split("\\|");
                    int bytes = 0;
                    for (int i = 0; i < campos.length; i++) {
                        bytes += campos[i].length();
                    }
                    Slot slot = new Slot(bytes, cont, cad);
                    contenido.add(slot);
                    cont++;
                }

            }
        } catch (Exception e) {
        }
    }
    
    public static int delete(int byteoffset, int tam){
        Slot slot = contenido.get(byteoffset);
        if (slot.getTam() == tam) {
            slot.setCampo("*|");
            availist.add(byteoffset);
            String line = "";
            for (int i = 0; i < contenido.size(); i++) {
                line+= contenido.get(i).getCampo()+"\n";
            }
            EscribirArchivo(line);
            //.System.out.println("Eliminado Correctamente!");
            System.out.println("Avail List ----->" +"\n");
            for (int i = 0; i < availist.size(); i++) {
                System.out.println(availist.get(i));
            }
        }
        return 0;
    }
}


