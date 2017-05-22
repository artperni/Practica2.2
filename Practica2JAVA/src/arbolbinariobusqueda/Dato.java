package arbolbinariobusqueda;

public class Dato {
    
    private String titulo;
    private float coste;
    private float ingreso;

    /* Constructor */
    public Dato(String titulo, float coste, float ingreso) {
        this.titulo = titulo;
        this.coste = coste;
        this.ingreso = ingreso;
    }
    
    public Dato(Dato dato){
        this.titulo = dato.getTitulo();
        this.coste = dato.getCoste();
        this.ingreso = dato.getIngreso();
    }

  
    public String getTitulo() {
        return titulo;
    }
    
    public float getCoste(){
        return coste;
    }
 
    public float getIngreso() {
        return ingreso;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setCoste(float coste) {
        this.coste = coste;
    }    
 
    public void setIngreso(float ingreso) {
        this.ingreso = ingreso;
    } 
    
    //Sobreescritura del metodo toString
    //Si sobreescribimos este metodo, cuando un objeto de tipo Dato
    //aparezca en una instruccion de System.out.println se visualizara
    //en la forma aqui indicada
    public String toString(){
        return "Titulo: "+titulo+"\nCoste: "+coste+
                "\nIngreso: "+ingreso;
    }
    
    public int compareTo(Dato d){
        return titulo.compareTo(d.getTitulo());
    }
}
