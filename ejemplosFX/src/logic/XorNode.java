package logic;

public class XorNode extends Nodes{
	private Boolean val1;
	private Boolean val2;
	private boolean result; //Este es el valor de salida el nodo Xor
	public Nodes next;
	public Nodes prev;
	public Nodes prev1;
	public Nodes prev2; 
	
	public XorNode() {
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
			if(this.val1 ^ this.val2) {
				this.result= true;
			}else {
				this.result= false;
			}
			return result;
		}catch(Exception e) {
			System.out.println("Existe un nodo nulo");
			return null;
		}
	} 


	public Boolean getValue() {
		Result();
		return this.result;
	}
}
