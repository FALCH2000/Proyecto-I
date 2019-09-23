package logic;

public class Factory {
	
	public static void newNode(String nodo) {
		switch(nodo) {
			case "and":
				Lista.add(new AndNode());
				System.out.println("Se ha agregado exitosamente un and");
				break;
			case "nand":
				Lista.add(new NandNode());
				System.out.println("Se ha agregado exitosamente un nand");
				break;
			case "or":
				Lista.add(new OrNode());
				System.out.println("Se ha agregado exitosamente un or");
				break;
			case "nor":
				Lista.add(new NorNode());
				System.out.println("Se ha agregado exitosamente un nor");
				break;
			case "xor":
				Lista.add(new XorNode());
				System.out.println("Se ha agregado exitosamente un xor");
				break;
			case "xnor":
				Lista.add(new XnorNode());
				System.out.println("Se ha agregado exitosamente un xnor");
				break;
			case "not":
				Lista.add(new NotNode());
				System.out.println("Se ha agregado exitosamente un not");
				break;
			default:
				System.out.println("Not recognized Node");
		}
	}
}
