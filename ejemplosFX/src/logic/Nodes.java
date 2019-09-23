package logic;

/**
 * @author fatimaleiva
 *Esta clase abstracta lo que hace es definir atributos y metodos
 *
 */
public abstract class Nodes {
	
	Nodes next;
	Nodes prev;
	Nodes prev1;
	Nodes prev2;
	boolean revision;
	abstract Boolean getValue();
	
}
