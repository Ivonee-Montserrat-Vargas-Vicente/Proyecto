
/**
 * Write a description of class aa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */public class NodoGrafo {
    private Object dato;
    private Lista listaAdyacencia;
    private NodoGrafo siguiente;

    public NodoGrafo(Object dato) {
        this.dato = dato;
        this.listaAdyacencia= new Lista();
        this.siguiente=null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Lista getListaAdyacencia() {
        return listaAdyacencia;
    }

    public void setListaAdyacencia(Lista listaAdyacencia) {
        this.listaAdyacencia = listaAdyacencia;
    }

    public NodoGrafo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoGrafo siguiente) {
        this.siguiente = siguiente;
    }
     @Override
    public String toString() {
        // Devuelve el dato (nombre del área) y la representación de la lista de adyacencia
        return "Nodo: " + dato.toString() + " | Animales: " + listaAdyacencia.toString();
    }
    
}

