
public class PilaDi
{
    private Nodo tope;
    public PilaDi(){
        this.tope=null;
    }
    public boolean EstaVacia(){
        return this.tope==null;
        
    }
    public boolean push(Zoologico valor){
        if(EstaVacia()){
            Nodo n=new Nodo(valor);
            tope=n;
            return true;
        }
        else{
            Nodo n=new Nodo(valor);
            n.setSiguiente(tope);
            tope=n;
            return true;
        }
    }
    public Zoologico pop() throws Exception {
        if(EstaVacia()){
            throw new Exception("pila Vacia");
        }
        else{
            Zoologico valor=tope.getValor();
            this.tope=this.tope.getSiguiente();
            return valor;
        }
        
    }
     public void mostrarPila() {
        Nodo actual = tope;
        while (actual != null) {
            System.out.println("Animal: " + actual.getValor().getnombreAnimal() + ", Edad: " + actual.getValor().getedad());
            actual = actual.getSiguiente();
        }
    }
}
    

