package logic;

/**
 * @author fatimaleiva
 *Esta clase abstracta lo que hace es definir atributos y metodos
 *
 */
public abstract class Nodes {
	
	public int connections;
	public Nodes next;
	public Nodes prev;
	public Nodes prev1;
	public Nodes prev2;
	public int NodeID;
	boolean revision;
	abstract Boolean getValue();
	
}
