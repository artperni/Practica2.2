package arbolbinariobusqueda;

public class Nodo {
 
    private Dato dato;
 
    private Nodo hojaIzquierda;
    private Nodo hojaDerecha;
 
    /* Constructores */
    public Nodo(){
        this(null,null,null);
        //La linea superior es lo mismo que esto:
        //this.dato=null;
        //this.hojaIzquierda=null;
        //this.hojaDerecha=null;
    }
    public Nodo(Dato dato){
        this(dato,null,null);
    }
    public Nodo(Dato dato, Nodo hojaIzquierda, Nodo hojaDerecha) {
        this.dato = dato;
        this.hojaIzquierda = hojaIzquierda;
        this.hojaDerecha = hojaDerecha;
    }
 
    /* Setters y Getters */
    public Dato getValor() {
       return dato;
    }
  
    public Nodo getHojaIzquierda() {
        return hojaIzquierda;
    }
    
    public Nodo getHojaDerecha() {
        return hojaDerecha;
    }
 
    public void setValor(Dato dato) {
        this.dato = dato;
    } 

    public void setHojaIzquierda(Nodo hojaIzquierda) {
        this.hojaIzquierda = hojaIzquierda;
    }
        
    public void setHojaDerecha(Nodo hojaDerecha) {
        this.hojaDerecha = hojaDerecha;
    }
    
    //Declaramos static las funciones size y height para poder 
    //ser llamadas
    //usando directamente el nombre de la clase Nodo: Nodo.size() 
    // o Nodo.height, 
    //sin necesidad de crear un objeto
    public static int size(Nodo raiz){
        if (raiz == null) {
            return 0;
        }else{
            return 1 + size (raiz.getHojaIzquierda()) + 
                    size(raiz.getHojaDerecha());
        }
    }
    
    public static int height(Nodo raiz){
        if (raiz == null) {
            return -1;
        }else{
            return 1 + Math.max(height(raiz.getHojaIzquierda()), 
                    height(raiz.getHojaDerecha()));
        }
    }
    
    
    //VISUALIZAR EN PREORDEN
    /*1º se trata el nodo actual
    * 2º se trata el hijo izquierdo del nodo actual
    * 3º se trata el hijo derecho del nodo actual
    * Es decir, 1º se procesa el nodo y luego recursivamente sus hijos
    */
    public void printPreOrder(){
        System.out.println(dato);
        if(hojaIzquierda!=null){
            hojaIzquierda.printPreOrder();
        }
        if(hojaDerecha!=null){
            hojaDerecha.printPreOrder();
        }
                
    }
    
    //VISUALIZAR EN POSTORDEN
    /*1º se trata el hijo izquierdo del nodo actual
    * 2º se trata el hijo derecho del nodo actual
    * 3º se trata el nodo actual
    * Es decir, el nodo se procesa despues de procesar 
    recursivamente sus hijos
    */
    public void printPostOrder(){
        if(hojaIzquierda!=null){
            hojaIzquierda.printPostOrder();
        }
        if(hojaDerecha!=null){
            hojaDerecha.printPostOrder();
        }
        System.out.println(dato);
    }
    
    //VISUALIZAR EN ORDEN
    /*1º se trata el hijo izquierdo del nodo actual
    * 2º se trata el nodo actual
    * 3º se trata el hijo derecho del nodo actual
    * Es decir, se procesa recursivamente el hijo izquierdo, 
    luego el nodo actual
    * y luego se procesa recursivamente el hijo derecho
    */
    public void printInOrder(){
        if(hojaIzquierda!=null){
            hojaIzquierda.printInOrder();
        }
        System.out.println(dato); 
        if(hojaDerecha!=null){
            hojaDerecha.printInOrder();
        }
    }
}