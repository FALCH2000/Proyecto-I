package logic;

public class Lista {
	private static Nodes last;
	private static Nodes first;
	private static int size= 0;
	
	public static void add(Nodes node) {
		
		if(first== null) {
			first= node;
			last=node;
			size +=1;
		}else {
			Nodes temp= node;
			last.next= temp;
			temp.prev= last;
			last= temp;
			size+=1;
		}
	}
	
	public static int getSize() {
		return size;
	}

	public static boolean getNodeVal(int Id) {
		Nodes temp= first;
		for(int i=0; i< Id; i ++) {
			temp= temp.next;
		}
		
		return temp.getValue();
	}
	public static Nodes getNodo(int Id) {
		Nodes temp= first;
		for(int i=0; i< Id; i ++) {
			temp= temp.next;
		}
		return temp;
	}
	
}
