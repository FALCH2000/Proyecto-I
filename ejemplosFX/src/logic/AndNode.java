package logic;

/**
 * Esta clase es la parte logica del nodo AND
 * cuando se ejecuta debe tener como salida el 
 * resultado de su nodo
 * 
 * @author fatimaleiva
 *
 */

public class AndNode implements Node{
	
	private static int result; //Este es el valor de salida el nodo AND
	
	/**
	 * este metodo es el constructor de la clase
	 * es privado pues no se puede acceder directamente a este metodo
	 * desde fuera para poder hacer validaciones
	 * 
	 */
	private AndNode() {
		
	}
	
	
	/**
	 * para crear el nodo AND se debe acceder a este metodo
	 * que hace las validaciones necesarias para que sea una entrada correcta
	 * 
	 */
	
	public void createNodeAnd(int a, int b) {
		AndNode and= new AndNode(); //llama al constructor
		and.setValue(a,b); //obtiene el valor resultante
		
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
				result= 1;
			}else {
				result= 0;
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
