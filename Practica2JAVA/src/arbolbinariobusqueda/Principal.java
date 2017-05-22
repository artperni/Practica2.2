/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinariobusqueda;

/**
 *
 * @author arturogp
 */
public class Principal {
    public static void main(String args[]){
        //Al crear el arbol, su reaiz se pone a null
        ArbolBusquedaBinaria miArbol=new ArbolBusquedaBinaria();//Estoy llamando a un constructor ArbolBusquedaBinaria con la raiz vacia
        
        //Dos datos a insertar en el arbol
        Dato d1=new Dato("Titanic",10000000f,20000000f);
        Dato d2=new Dato("PiratasDelCAribe",1200000f,200000f);
        Dato d3=new Dato("Ameli",1200000f,200000f);
        
        //Añado los datos del Arbol
        miArbol.addNodo(d1);
        miArbol.addNodo(d2);
        miArbol.addNodo(d3);
        
        //Visualizo en preorden
        miArbol.printPreOrder();
        miArbol.printPostOrder();
        miArbol.printInOrder();
    }
    
}
