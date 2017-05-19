/*
 * Sonia Garrote Fernandez
 * Estructuras de Datos
 * 24/04/2017
 * 
 * Esta clase representa el TAD Arbol de busqueda Binaria
 * En los arboles binarios ningun nodo puede tener mas de dos hijos
 * Si ademas es un arbol de busqueda binaria se satisface la propiedad de
 * busqueda ordenada, es decir para todo nodo X del arbol, los valores de todas
 * las claves contenidas en el subarbol izquierdo son menores que la clave X y 
 * los valores de todas las claves contenidas en el subarbol derecho son mayores
 * que la clave X
 *
 * Los arboles de busqueda binaria son una buena alternativa a las listas
 * enlazadas, permiten cargar grandes cantidades de datos en memoria de forma
 * ordenada y hacen que muchas de las operaciones sobre ellos, presenten
 * mejores tiempo de proceso que si se implementa con listas
 */
package arbolbinariobusqueda;
    
public class ArbolBusquedaBinaria {
 
    // Atributos
    private Nodo raiz;
 
    // Contructores   
    public ArbolBusquedaBinaria() {
        this.raiz = null;
    }

    public ArbolBusquedaBinaria( Dato dato ) {
        this.raiz = new Nodo( dato,null,null );
    }
 

    // Setters y Getters
    public Nodo getRaiz() {
        return raiz;
    }
 
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    //El tamaño de un arbol es el numero de nodos que contiene
    public int size(){
        return Nodo.size(raiz);
    }
    
    //La altura de un arbol es el numero de niveles que tiene
    public int height(){
        return Nodo.height(raiz);
    }
    
    public void printPreOrder(){
        if (raiz != null) raiz.printPreOrder();
    }
    public void printPostOrder(){
        if (raiz != null) raiz.printPostOrder();
    }
    public void printInOrder(){
        if (raiz != null) raiz.printInOrder();
    } 
    
    public void makeEmpty(){
        raiz = null;
    }
    
    public boolean isEmpty(){
        return raiz == null;
    }
    
    //AÑADIR NODOS
    /* El método addNodo esta sobrecargado, por un lado se presenta como
    publico, para poder ser llamado desde la clase que contiene 
    el main, por otro lado como private, para ser llamado internamente
    */  
    private Nodo addNodo( Dato dato, Nodo raiz ) 
            throws DuplicateItemException{
        Nodo aux=new Nodo(dato);
      
        if (raiz == null)
            raiz = aux;
        else if (dato.compareTo(raiz.getValor()) < 0)        
            raiz.setHojaIzquierda(addNodo(dato,raiz.getHojaIzquierda()));
        else if (dato.compareTo(raiz.getValor()) > 0) 
            raiz.setHojaDerecha(addNodo(dato,raiz.getHojaDerecha()));
        else
            throw new DuplicateItemException(dato.toString());
        return raiz;
    }
 
    public void addNodo( Dato dato ) {
        try{
            raiz=this.addNodo( dato , this.raiz );
        }
        catch(DuplicateItemException die)
        {
            System.out.println(die.toString());
        };
    }
    
    //BUSCAR LOS DATOS DE UNA PELICULA A PARTIR DEL TITULO PROPORCIONADO
    /* La funcion find devuelve el nodo del arbol que contiene los datos
    de una pelicula a partir del titulo de la pelicula. El titulo de la pelicula
    se pasa a la funcion find como argumento.
    */
    private Nodo find(String titulo, Nodo raiz) 
        throws NotFoundException {
        
        if (raiz == null)
            throw new NotFoundException(titulo);   
        else if (titulo.compareTo(raiz.getValor().getTitulo()) < 0)        
            return find(titulo, raiz.getHojaIzquierda());
        else if (titulo.compareTo(raiz.getValor().getTitulo()) > 0) 
            return find(titulo, raiz.getHojaDerecha());
        
        return raiz;
        
    }
    
    public Dato find(String titulo){
        try{
            return find(titulo,raiz).getValor();
        }catch(NotFoundException nfe){
            System.out.println(nfe.toString());
            return null;
        }
    }
    
    //BUSCAR LA PELICULA CON MENOR COSTE DE PRODUCCION
    /* La funcion findMin debe mostrar el titulo de la pelicula
    que menos coste de produccion supuso.
    La idea de la función findMin es: comenzamos en la raiz y vamos
    bifurcandonos repetidamente a la izquierda, hata que deje de haber 
    un hijo izquierdo. El punto en el que nos detengamos sera el elemento 
    mas pequeño. Eso si estuviéramos buscando el título alfabéticamente
    mas pequeño, este sería el nodo hoja más a la izquierda del arbol.
    Recordemos que la clave de los nodos es el título y se insertan
    de forma ordenada en el árbol por esta clave.
    Pero como buscamos el de menor coste, debemos recorrer  todo
    el árbol hasta encontrarlo. Podemos elegir recorrerlo en Pre, Post o In
    Order.
    */
    
    private Nodo findMin(Nodo raiz, Nodo minimo){
        
        if(raiz.getValor().getCoste()<minimo.getValor().getCoste())
            minimo = raiz;
        if(raiz.getHojaIzquierda()!=null)
            minimo=findMin(raiz.getHojaIzquierda(),minimo);
        
        if(raiz.getHojaDerecha()!=null)
            minimo=findMin(raiz.getHojaDerecha(),minimo);
         
         return minimo;
    }
    
    public Dato findMin(){
        Nodo minimo = raiz;
        return findMin(raiz,minimo).getValor();
    }
    

    //BUSCAR LA PELICULA CON MAYOR COSTE DE PRODUCCION
    /* La funcion findMax debe mostrar el titulo de la pelicula
    que tuvo un mayor coste de produccion.
    La idea de la función finMax es la misma que la de findMin, pero se realiza
    hacia la derecha.  Eso si estuviéramos buscando el título alfabéticamente
    mas grande, este sería el nodo hoja más a la derecha del arbol.
    Pero como buscamos el de mayor coste, debemos recorrer  todo
    el árbol hasta encontrarlo. Podemos elegir recorrerlo en Pre, Post o In
    Order.
    */
    private Nodo findMax(Nodo raiz, Nodo maximo){
        
        if(raiz.getValor().getCoste()>maximo.getValor().getCoste())
            maximo = raiz;
        if(raiz.getHojaIzquierda()!=null)
            maximo=findMin(raiz.getHojaIzquierda(),maximo);
        
        if(raiz.getHojaDerecha()!=null)
            maximo=findMin(raiz.getHojaDerecha(),maximo);
         
         return maximo;
    }
    
    public Dato findMax(){
        Nodo maximo = raiz;
        return findMin(raiz,maximo).getValor();
    }
    
    //ELIMINAR UNA PELICULA
    /* La funcion remove debe eliminar el nodo que contiene los datos de la 
    pelicula cuyo titulo se pasa a la funcion remove.
    Para implementar esta funcion se puede llamar a la metodo find que nos
    encuentra el nodo del arbol que contiene la pelicuya con un determinado
    titulo. Una vez encontrada la posicion del nodo tendriamos que eliminarlo
    teniendo en cuenta los siguientes casos:
    - si el nodo es una hoja (no tiene hijos) se borra inmediatamente
    - si el nodo tiene solo un hijo, lo eliminamos despues de ajustar el enlace
    que su padre tiene para apuntar al hijo del nodo a eliminar
    con el fin de soslayar el nodo a eliminar
    - si el nodo tiene dos hijos, se reemplaza el elemento de este nodo por
    el elemento mas pequeño del subarbol derecho (usar la funcion findMin pasandole
    como raiz el subarbol derecho), luego eliminar ese elemento mas pequeño
    */
    private Nodo remove (String titulo, Nodo raiz) throws NotFoundException{
        
        //TODO: implementar el metodo
       
        return raiz;
    }
    
    public void remove(String titulo){
        try{
            raiz = remove(titulo, raiz);
        }catch(NotFoundException nfe){System.out.println(nfe.toString());}
    }

//TODO:MODIFICAR LOS METODOS QUE CORRESPONDA PARA EL CASO NotFoundException, 
//POR EJEMPLO find

}
