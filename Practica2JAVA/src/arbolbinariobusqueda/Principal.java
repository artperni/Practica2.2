/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinariobusqueda;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author sonia
 */
public class Principal {
    public static void main(String args[]){
        //Al crear el arbol, su raiz se pone a null
        ArbolBusquedaBinaria miArbol=new ArbolBusquedaBinaria();
        
        //Dos datos a insertar en el arbol
        Dato d1=new Dato("Titanic",10000000f, 2000000f);
        Dato d2=new Dato("PiratasDelCaribe", 1200000f,200000f);
        Dato d3=new Dato("Ameli", 1200000f,200000f);
        
        
        //Añado los datos al arbol
        miArbol.addNodo(d1); 
        miArbol.addNodo(d2);
        miArbol.addNodo(d3);
        
        
        //Visualizo en preorden
        miArbol.printPreOrder();
        miArbol.printPostOrder();
        miArbol.printInOrder();
        System.out.println(" ");
     
        int opcion;
        do{
         Scanner sc = new Scanner(System.in);
            System.out.println("\nElija una opción:\n\t1.- Buscar datos de las"
                    + " peliculas por su titulo\n\t2.- Buscar pelicula con "
                    + "menor coste de produccion\n\t3.- Buscar pelicula con "
                    + "mayor coste de produccion\n\t4.- Eliminar"
                    + "\n\t0.- Fin programa");
            System.out.print("\nIntroduzca una opcion: ");
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    //Busqueda peliculas
                        System.out.print("\nIntroduzca un titulo: ");
                        sc = new Scanner(System.in);
                        String titulo = sc.next();
                        System.out.println(miArbol.find(titulo));
                    break;
                case 2:
                    //Menor coste
                        System.out.println("\nPelicula con "
                    + "menor coste: "+miArbol.findMin());
                    break; 
                case 3:
                    //Mayor coste
                        System.out.println("\nPelicula con "
                    + "mayor coste: "+miArbol.findMax());
                    break;
                case 4:
                    //Eliminar
                    break;
                case 0:
                        System.out.println("FIN.");
                    break;
                default:
                    if(opcion!=0){
                        System.out.println("Indique otra opcion.");
                    }
            }
        }while(opcion != 0);
                
    }
}
