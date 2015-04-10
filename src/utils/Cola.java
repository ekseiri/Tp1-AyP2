package utils;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;


public class Cola {
	private ArrayList datos;
	
	/**
	 * Cola generica FIFO
	 * Si hay espacio en memoria siempre permite
	 * agregar elementos
	 */
	public Cola(){
		datos=new ArrayList();
	}
	
	/**
	 * Cola con tamaño específico
	 * Si tamanio es negativo levanta una excepcion
	 * Si se desea controlar el tamaño de la Cola, lo debe
	 * hacer el que usa la clase Cola
	 */
	public Cola(int tamanio) throws ColaException{
		try{
			datos=new ArrayList(tamanio);
		} catch (IllegalArgumentException e) {
			throw new ColaException("Tamaño Invalido: No se puede crear la cola");
		}
	}
	
	/**
	 * Devuelve verdadero si la cola está vacía
	 */
	public boolean colaVacia(){
		return datos.isEmpty();
	}
	
	/**
	 * Encola un objeto
	 * Si el objeto a encolar es nulo, levanta una excepcion
	 */
	public void encolar(Object o) throws ColaException{
		if (o == null){
			throw new ColaException("Dato inválido: No se puede encolar un dato nulo");
		}
		datos.add(o);
	}
	
	/**
	 * Desencola un objeto
	 * Si la cola esta vacía, levanta una excepcion
	 */
	public Object desencolar() throws ColaException{
		
		if (this.colaVacia()){
			throw new ColaException("Desencolar: La cola esta vacia");
		}
		return(datos.remove(0));
		
	}

}
