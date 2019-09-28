package logic;

public class NandNode extends Nodes{
	
	private Boolean val1;
	private Boolean val2;
	private Boolean result; //Este es el valor de salida el nodo NAND
	public Nodes next;
	public Nodes prev;
	public Nodes prev1;
	public Nodes prev2; 
	public int NodeID;
	public int connections;
	
	/**
	 * Constructor de la clase
	 * Cuando se construye el objeto se instancia al constructor
	 */
	public NandNode() {
		this.next= null;
		this.prev= null;
		this.prev1= null;
		this.prev2= null;
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
			if(this.val1 && this.val2) {
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
