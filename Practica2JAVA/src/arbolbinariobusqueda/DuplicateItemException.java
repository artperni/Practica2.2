/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinariobusqueda;

/**
 *
 * @author sonia
 */
public class DuplicateItemException extends Exception{
    public DuplicateItemException(){
        
    }
    public DuplicateItemException(String msg){
        super(msg+" Elemento duplicado");
    }
    
}
