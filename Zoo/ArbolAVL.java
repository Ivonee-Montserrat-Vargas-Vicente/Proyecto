
/**
 * Write a description of class Arbol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArbolAVL {
    public NodoAVL raiz;

    private int altura(NodoAVL nodo) {
        return (nodo == null) ? 0 : nodo.altura;
    }

    private int obtenerFactorBalance(NodoAVL nodo) {
        return (nodo == null) ? 0 : altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    private NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.izquierdo;
        NodoAVL T2 = x.derecho;

        x.derecho = y;
        y.izquierdo = T2;

        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;

        return x; 
    }

    private NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.derecho;
        NodoAVL T2 = y.izquierdo;

        y.izquierdo = x;
        x.derecho = T2;

        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;

        return y;
    }

    public NodoAVL insertar(NodoAVL nodo, Zoologico animal) {
        if (nodo == null) {
            return new NodoAVL(animal);
        }

        if (animal.getedad() < nodo.animal.getedad()) {
            nodo.izquierdo = insertar(nodo.izquierdo, animal);
        } else if (animal.getedad() > nodo.animal.getedad()) {
            nodo.derecho = insertar(nodo.derecho, animal);
        } else {
            return nodo; 
        }

        nodo.altura = Math.max(altura(nodo.izquierdo), altura(nodo.derecho)) + 1;

        int balance = obtenerFactorBalance(nodo);

        if (balance > 1 && animal.getedad() < nodo.izquierdo.animal.getedad()) {
            return rotarDerecha(nodo);
        }

        if (balance < -1 && animal.getedad() > nodo.derecho.animal.getedad()) {
            return rotarIzquierda(nodo);
        }

        if (balance > 1 && animal.getedad() > nodo.izquierdo.animal.getedad()) {
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);
        }

        if (balance < -1 && animal.getedad() < nodo.derecho.animal.getedad()) {
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    public void insertar(Zoologico animal) {
        raiz = insertar(raiz, animal);
    }

    public void enOrden(NodoAVL nodo) {
        if (nodo != null) {
            enOrden(nodo.izquierdo);
            System.out.println("Animal: " + nodo.animal.getnombreAnimal() + ", Edad: " + nodo.animal.getedad());
            enOrden(nodo.derecho);
        }
    }

    public void imprimirEnOrden() {
        enOrden(raiz);
    }

    public Zoologico buscar(int edad) {
        return buscar(raiz, edad);
    }

    private Zoologico buscar(NodoAVL nodo, int edad) {
        if (nodo == null) {
            return null; 
        }

        if (nodo.animal.getedad() == edad) {
            return nodo.animal; 
        }

        if (edad < nodo.animal.getedad()) {
            return buscar(nodo.izquierdo, edad);
        } else {
            return buscar(nodo.derecho, edad);
        }
    }
}




