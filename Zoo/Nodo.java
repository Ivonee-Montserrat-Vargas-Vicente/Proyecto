
/**
 * Write a description of class Nodo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nodo
{
   private Zoologico valor;
   private Nodo siguiente;
   private Nodo anterior;
   public Nodo(Zoologico valor){
       this.valor=valor;
       this.siguiente=siguiente;
       
   }
   public Zoologico getValor(){
       return this.valor;
   }
   public void setValor(Zoologico v){
       this.valor=v;
   }
   public Nodo getSiguiente(){
       return this.siguiente;
   }
   public void setSiguiente(Nodo s){
       this.siguiente=s;
   }
   
   //DOblemente
    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}

