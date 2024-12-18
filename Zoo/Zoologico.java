
/**
 * Write a description of class Animal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zoologico
{
    private String nombreAnimal;
    private int edad;
    private String sexo;
    private double peso;
    private String alimento;
    private String area;
    public Zoologico(String nombreAnimal,int edad,String sexo ,double peso,String alimento,String area)
    {
        this.nombreAnimal= nombreAnimal;
        this.edad=edad;
        this.sexo=sexo;
        this.peso=peso;
        this.alimento=alimento;
        this.area=area;
    }
    
    public String getnombreAnimal()
    {
        return nombreAnimal;
    }
    
    public void setnombreAnimal(String nombreAnimal)
    {
        this.nombreAnimal=nombreAnimal;
    }
    
    public int getedad()
    {
        return edad;
    }
    
    public void setedad(int edad)
    {
        this.edad=edad;
    }
    
    public String getsexo()
    {
        return sexo;
    }
    
    public void set(String sexo)
    {
        this.sexo=sexo;
    }
    
    public double getPeso()
    {
        return peso;
    }
    
    public void setPeso(double peso)
    {
        this.peso=peso;
    }

    public String getalimento()
    {
        return alimento;
    }
    
    public void setalimento(String alimento)
    {
        this.alimento=alimento;
    }
    
    public void crearsonido()
    {
        System.out.println("el animal hace");
    }
    
    public void comer()
    {
        System.out.println("el animal come:");
    }
    
    public String getArea()
    {
        return area;
    }
    
    public void setArea(String Area)
    {
        this.area=Area;
    }

     @Override
    public String toString() {
        return "Zoologico{" + 
                "nombreAnimal='" + nombreAnimal + '\'' + 
                ", edad=" + edad + 
                ", sexo='" + sexo + '\'' + 
                ", peso=" + peso + 
                ", alimento='" + alimento + '\'' + 
                ", area='" + area + '\'' + 
                '}';
    }
}

