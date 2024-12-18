import javax.swing.JOptionPane;
import java.util.Vector;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args) throws java.io.IOException {
        String archivoEntrada = "animales.csv";

        ArbolAVL arbolAnimales= new ArbolAVL();
        Vector<Zoologico> animal= new Vector<>();
        PilaDi pila= new PilaDi();
        Scanner sc= new Scanner(System.in);
        Grafo grafo = new Grafo();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada))) {
            String linea;

            String encabezado = br.readLine();
            System.out.println("Encabezado: " + encabezado);

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");
                String nombres = datos[0];
                int edad=Integer.parseInt(datos[1]);
                int peso=Integer.parseInt(datos[3]);
                String area= datos[5];
                nombres = nombres.replaceAll("\\s+", "").toLowerCase();
                animal.add(new Zoologico(nombres, edad, datos[2],peso,datos[4],area));
                grafo.agregarNodo(nombres + " (" + area + ")"); 
               

            }

            for (Zoologico animalo :animal) {
                arbolAnimales.insertar(animalo);
                //grafo.agregarArista(animalo.getArea(), animalo.getnombreAnimal());
                //grafo.agregarNodo(animalo);
                System.out.println(animalo.toString());
            }
            int opcion;
            do {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Menú del Zoológico\n" +
                        "2. Conectar Áreas\n" +
                        "3. Mostrar Grafo\n" +
                        "4. Ordenar por Edad en Arbol\n" +
                        "5. Crea una pila en Orden en el que se Alimentan los animales\n" +
                        "6. Eliminar en Pila\n"+
                        "7.Ordenar edad por Quicksort\n"+
                        "8.Muestra la Pila\n"+
                        "9. Salir\n"+

                        "Elige una opción:"
                    ));

                switch (opcion) {
                    case 1:
                        String nombreArea = JOptionPane.showInputDialog("Nombre del área:");
                        if (grafo.agregarNodo(nombreArea)) {
                            JOptionPane.showMessageDialog(null, "Área '" + nombreArea + "' agregada con éxito.");
                        } else {
                            JOptionPane.showMessageDialog(null, "El área '" + nombreArea + "' ya existe.");
                        }
                        break;
                    case 2:
                        String area1 = JOptionPane.showInputDialog("Nombre del área 1:");
                        String area2 = JOptionPane.showInputDialog("Nombre del área 2:");
                        grafo.agregarAristas(area1, area2);

                        JOptionPane.showMessageDialog(null, "Áreas conectadas con éxito.");
                        break;
                    case 3:
                        System.out.println("Grafo de Áreas:\n" + grafo.toString());
                        break;

                    case 4: 
                        arbolAnimales.imprimirEnOrden();
                        break;

                    case 5: 
                        try {
                            int num = Integer.parseInt(JOptionPane.showInputDialog("Cuántos animales deseas agregar a la pila?"));
                            for (int i = 0; i < num; i++) {
                                String eda= JOptionPane.showInputDialog("ingrese la edad:");
                                int edad=Integer.parseInt(eda);
                                Zoologico animalead=arbolAnimales.buscar(edad);
                                if (animalead != null ) {
                                    pila.push(animalead);
                                    JOptionPane.showMessageDialog(null, "Animal " + animalead + " agregado a la pila.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "la edad del animal no puede estar vacía.");
                                }
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Por favor, introduce un número válido.");
                        }
                        break;

                    case 6:

                        try
                        {
                            JOptionPane.showMessageDialog(null, pila.pop());

                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                        break;

                    case 7:
                        JOptionPane.showMessageDialog(null, "Ordenando edades por Quicksort...");
                        quicksort q = new quicksort();
                        int[] edadesArray = new int[animal.size()];
                        for (int i = 0; i < animal.size(); i++) {
                            edadesArray[i] = animal.get(i).getedad(); 
                        }
                        q.quickSort(edadesArray);
                        System.out.println("Edades ordenadas: " + Arrays.toString(edadesArray));
                        break;
                    case 8:
                        JOptionPane.showMessageDialog(null, "Muestra la pila");
                        pila.mostrarPila();

                        break;
                    case 9:
                        JOptionPane.showMessageDialog(null, "¡Saliendo del programa!");
                        break;

                    case 10:
                        String areaNombre = JOptionPane.showInputDialog("Ingrese el nombre del área para ver sus animales:");
                        NodoGrafo nodoArea = grafo.obtenerNodo(areaNombre);
                        if (nodoArea != null) {
                            String animalesEnArea = nodoArea.getListaAdyacencia().toString();
                            if (!animalesEnArea.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Animales en el área '" + areaNombre + "':\n" + animalesEnArea);
                            } else {
                                JOptionPane.showMessageDialog(null, "No hay animales en el área '" + areaNombre + "'.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El área '" + areaNombre + "' no existe.");
                        }
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida.");

                }
            } while (opcion != 9);
        }
    }

}

