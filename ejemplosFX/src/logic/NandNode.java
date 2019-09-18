package logic;

public class NandNode implements Node{
	
private static int result; //Este es el valor de salida el nodo AND
	
	/**
	 * Constructor de la clase
	 * privado porque para crear el nodo se deben hacer validaciones
	 * en otro metodo publico que accede a el
	 */
	private NandNode() {
		
	}
	
	
	/**
	 * para crear el nodo AND se debe acceder a este metodo
	 * que hace las validaciones necesarias para que sea una entrada correcta
	 * 
	 */
	
	public void createNodeAnd(int a, int b) {
		NandNode nand= new NandNode(); //llama al constructor
		nand.setValue(a,b); //obtiene el valor resultante
		
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
	private void setValue(int value1, int value2) {
		if((value1==1 || value1== 0) && (value2 ==1 || value2==0)) {
			if(value1==1 && value2==1) {
				result= 0;
			}else {
				result= 1;
			}
		} else {
			result= 2;
		}
	}

	/**
	 *Retorna el valor resultante del AND
	 */
	@Override
	public int getValue(){
		return result;
	}
}
