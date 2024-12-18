
/**
 * Write a description of class NA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NodoListaLigada {
    public Zoologico animal;
    public NodoListaLigada siguiente;

    public NodoListaLigada(Zoologico animal) {
        this.animal = animal;
        this.siguiente = null;
    }
}
