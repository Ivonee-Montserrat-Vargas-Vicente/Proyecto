
/**
 * Write a description of class j here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NodoAVL {
    public Zoologico animal; 
    public NodoAVL izquierdo; 
    public NodoAVL derecho;   
    public int altura;       

    public NodoAVL(Zoologico animal) {
        this.animal = animal;
        this.izquierdo = null;
        this.derecho = null;
        this.altura = 1; 
    }

    public Zoologico getAnimal() {
        return animal;
    }

    public void setAnimal(Zoologico animal) {
        this.animal = animal;
    }

    public NodoAVL getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoAVL izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoAVL getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoAVL derecho) {
        this.derecho = derecho;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
