package logic;

/**
 * Esta clase es la parte logica del nodo AND
 * cuando se ejecuta debe tener como salida el 
 * resultado de su nodo
 * 
 * @author fatimaleiva
 *
 */

public class AndNode extends Nodes{
	
	private Boolean val1;
	private Boolean val2; 
	private Boolean result; //Este es el valor de salida el nodo AND
	public boolean revision;
	public Nodes next;
	public Nodes prev;
	public Nodes prev1;
	public Nodes prev2; 
	public int NodeID;
	public int connections;
	/**
	 * Este metodo es el constructor de la clase
	 * y lo que hace es permitir entonces crear el nodo
	 * Crea al objeto de la clase
	 * 
	 */
	
	public AndNode() {
		this.next=null;
		this.prev=null;
		this.prev1=null;
		this.prev2= null;
	}	
	
	/**
	 * Este metodo es el que convierte al valor de salida
	 * a partir de los valores entrantes
	 * es privado para no poder acceder al setter desde fuera
	 * 
	 * @param value1
	 * @param value2
	 */
	public void setValue1(boolean value) {
		this.val1= value;
	}
	
	public void setValue2(boolean value) {
		this.val2= value;
	}
	
	private Boolean Result() {
		try{
			if(this.val1 && this.val2) {
				this.result= true;
			}else {
				this.result= false;
			}
			return result;
		}catch(Exception e) {
			System.out.println("Exists a null Pointer");
			return null;
		}
	}
	
	public Boolean getValue() {
		Result();
		if(Result()==null) {
			return null;
		}
		return this.result;
	}
}
