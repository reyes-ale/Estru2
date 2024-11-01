/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebafuncionalidad;

/**
 *
 * @author lenovo
 */
public class Slot {
    int tam;
    int b_offset;
    String campo;

    public Slot(int tam, int b_offset) {
        this.tam = tam;
        this.b_offset = b_offset;
    }

    public Slot(int tam, int b_offset, String campo) {
        this.tam = tam;
        this.b_offset = b_offset;
        this.campo = campo;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public int getB_offset() {
        return b_offset;
    }

    public void setB_offset(int b_offset) {
        this.b_offset = b_offset;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }
    
    
    
    
}
