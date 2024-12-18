
public class ListaLigada {
    private NodoListaLigada cabeza;

    public ListaLigada() {
        this.cabeza = null;
    }

    public void agregarInicio(Zoologico animal) {
        NodoListaLigada nuevoNodo = new NodoListaLigada(animal);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    public void agregarFinal(Zoologico animal) {
        NodoListaLigada nuevoNodo = new NodoListaLigada(animal);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoListaLigada actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public boolean eliminarPorNombre(String nombre) {
        if (cabeza == null) {
            return false; 
        }

        if (cabeza.animal.getnombreAnimal().equals(nombre)) {
            cabeza = cabeza.siguiente;
            return true;
        }

        NodoListaLigada actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.animal.getnombreAnimal().equals(nombre)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente == null) {
            return false; 
        }

        actual.siguiente = actual.siguiente.siguiente; 
        return true;
    }

    public void mostrarLista() {
        NodoListaLigada actual = cabeza;
        if (actual == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.println("Animales en la lista ligada:");
        while (actual != null) {
            System.out.println("- " + actual.animal.getnombreAnimal() + " (Edad: " + actual.animal.getedad() + ")");
            actual = actual.siguiente;
        }
    }
}
