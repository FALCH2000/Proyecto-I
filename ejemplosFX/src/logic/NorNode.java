package logic;

public class NorNode extends Nodes{
	private Boolean val1;
	private Boolean val2;
	private Boolean result; //Este es el valor de salida el nodo AND
	public Nodes next;
	public Nodes prev;
	public Nodes prev1;
	public Nodes prev2;
	public int NodeID;
	public int connections;
	
	public NorNode() {
		this.next= null;
		this.prev= null;
		this.prev1=null;
		this.prev2=null;
	}
	public void setValue1(boolean value) {
		this.val1= value;
	}
	
	public void setValue2(boolean value) {
		this.val2= value;
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
		try {
			if(this.val1 || this.val2) {
				this.result= false;
			}else {
				this.result= true;
			}
		}catch(Exception e) {
			System.out.println("Un nodo apunta a nulo");
			
		}
		return result;
	} 

	public Boolean getValue() {
		Result();
		if(Result()==null) {
			return null;
		}
		return this.result;
	}
}
