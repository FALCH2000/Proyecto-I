package logic;

public class NotNode extends Nodes{
	private Boolean val1;
	private Boolean result; //Este es el valor de salida el nodo NOT
	public Nodes next;
	public Nodes prev;
	public Nodes prev1;
	public int NodeId;
	public int connections;
	
	public NotNode() {
		this.next= null;
		this.prev= null;
		this.prev1 = null;
	}
	
	public void setValue1(boolean value) {
		this.val1= value;
	}
	
	
	public void setValue2(boolean value) {
		//Hay que añadir el metodo, pero no utilizarlo
	}
	
	/**
	 * Este metodo es el que convierte al valor de salida
	 * a partir de los valores entrantes
	 * es privado para no poder acceder al setter desde fuera
	 * desde fuera
	 * 
	 * @param value1
	 * @param value2
	 */
	private Boolean Result() {
		try{
			if(this.val1) {
				this.result= false;
			}else {
				this.result= true;
			}
			return this.result;
		}catch(Exception e) {
			System.out.println("Hay un nodo nulo");
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
