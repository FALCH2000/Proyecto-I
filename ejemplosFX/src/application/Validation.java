package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.Nodes;

/**
 * @author fatimaleiva
 *Esta clase es la encargada de validar las conexiones entre nodos
 *y crea una ventana emergente que hace las validaciones
 */
public class Validation {
	static Stage stage;
	static Scene scene;
	static Pane root;
	public static Nodes nodoNext;
	public static Nodes nodoPrev;
	private static boolean answer;
	
	
	public static boolean validate(ImageView node1, ImageView node2, Nodes Nodo1, Nodes Nodo2) {
		stage= new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		root= new Pane();
		scene= new Scene(root);
		answer=false;
		
		System.out.println("El Id del primer nodo en validacion es: " +Nodo1);
		System.out.println("El Id del segundo nodo en validacion es: " +Nodo2);
		
		String parts1[]= node1.getId().split("-");
		int sum1= Integer.parseInt(parts1[1]) + 1;
		String part1= Integer.toString(sum1);
		
		String parts2[]= node2.getId().split("-");
		int sum2= Integer.parseInt(parts2[1]) + 1;
		String part2= Integer.toString(sum2);
		
		//Lo que respecta a la interfaz
		
		Label PrimNodo= new Label("Elija el nodo del que se obtiene el valor: ");
		PrimNodo.setLayoutX(20);
		PrimNodo.setLayoutY(20);
		
		Button prim1= new Button("Nodo " + part1);
		prim1.setOnAction(e -> {
			nodoPrev= Nodo1;
		});
		prim1.setLayoutX(20);
		prim1.setLayoutY(40);
		
		Button prim2= new Button("Nodo " + part2);
		prim2.setOnAction(e -> {
			nodoPrev= Nodo2;
		});
		prim2.setLayoutX(90);
		prim2.setLayoutY(40);
		
		Label SegNodo= new Label("Elija el nodo al que llega el valor: ");
		SegNodo.setLayoutX(20);
		SegNodo.setLayoutY(80);
		

		
		Button seg1= new Button("Nodo " + part1);
		seg1.setOnAction(e -> {
			nodoNext= Nodo1;
			answer=valuate(parts1, parts2, answer, stage);
			stage.close();
		});
		seg1.setLayoutX(20);
		seg1.setLayoutY(100);
		
		Button seg2= new Button("Nodo " + part2);
		seg2.setOnAction(e -> {
			nodoNext= Nodo2;
			answer= valuate(parts1, parts2, answer, stage);
			stage.close();
		});
		seg2.setLayoutX(90);
		seg2.setLayoutY(100);
		
		Button cancel= new Button("Cancelar");
		cancel.setOnAction(e -> stage.close());
		cancel.setLayoutX(50);
		cancel.setLayoutY(170);
		
		//Lo que respect a la logica
		
		

		
		root.setPrefSize(300, 200);
		
		root.getChildren().addAll(PrimNodo, prim1, prim2, SegNodo, seg1, seg2, cancel);
		root.setStyle("-fx-background-color: white");
		stage.setScene(scene);
		stage.showAndWait();
		System.out.println(answer);
		return answer;
	}
	
	public static boolean valuate(String parts1[], String parts2[], boolean answer, Stage stage) {
		String type1= parts1[0];
		String type2= parts2[0];
		
		if(type1== "not" || type2== "not") { //la validacion es diferente
			//agregar codigo al type not
			return answer;
		}else {
			System.out.println(nodoNext.connections);
			
			if(nodoNext== nodoPrev) {
				System.out.println("opcion 1");
				answer=false;
			}else if(nodoNext.connections >= 2) {
				System.out.println("opcion 2");
				answer= false;
			}else {
				System.out.println("opcion 3");
				if (nodoNext.connections==0) {
					nodoNext.prev1= nodoPrev;
					nodoNext.connections +=1;
				}else {
					nodoNext.prev2= nodoPrev;
					nodoNext.connections +=1;
					
				}
				return answer=true;
			}
		}
		return answer;
	}
}
