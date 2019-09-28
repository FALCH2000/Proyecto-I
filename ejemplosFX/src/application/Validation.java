package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
		prim1.setStyle("-fx-background-color: linear-gradient(#6712C2, #985DD6);\n" + 
				"    -fx-background-radius: 30;\n" + 
				"    -fx-background-insets: 0;\n" + 
				"    -fx-text-fill: white;");
		
		Button prim2= new Button("Nodo " + part2);
		prim2.setOnAction(e -> {
			nodoPrev= Nodo2;
		});
		prim2.setLayoutX(90);
		prim2.setLayoutY(40);
		prim2.setStyle("-fx-background-color: linear-gradient(#0027AD, #3461FE);\n" + 
				"    -fx-background-radius: 30;\n" + 
				"    -fx-background-insets: 0;\n" + 
				"    -fx-text-fill: white;");
		
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
		seg1.setStyle("-fx-background-color: linear-gradient(#6712C2, #985DD6);\n" + 
				"    -fx-background-radius: 30;\n" + 
				"    -fx-background-insets: 0;\n" + 
				"    -fx-text-fill: white;");
		
		Button seg2= new Button("Nodo " + part2);
		seg2.setOnAction(e -> {
			nodoNext= Nodo2;
			answer= valuate(parts1, parts2, answer, stage);
			stage.close();
		});
		seg2.setLayoutX(90);
		seg2.setLayoutY(100);
		seg2.setStyle("-fx-background-color: linear-gradient(#0027AD, #3461FE);\n" + 
				"    -fx-background-radius: 30;\n" + 
				"    -fx-background-insets: 0;\n" + 
				"    -fx-text-fill: white;");
		
		Button cancel= new Button("Cancelar");
		cancel.setOnAction(e -> stage.close());
		cancel.setLayoutX(50);
		cancel.setLayoutY(170);
		cancel.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\n" + 
				"    -fx-background-radius: 30;\n" + 
				"    -fx-background-insets: 0;\n" + 
				"    -fx-text-fill: white;");
		
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
				answer=false;
				AlertBox("Misma compuerta asignada \n"
						+ "La compuerta asignada de entrada y de salida \n"
						+ "corresponden a la misma compuerta");
				
			}else if(nodoNext.connections >= 2) {
				answer= false;
				AlertBox("Más de dos compuertas asignadas \n"
						+ "La compuerta elegida como nodo al que llega el valor \n"
						+ "ya tiene dos compuertas de entrada asignadas");
				
			}else {
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
	
	public static void AlertBox(String text) {
		Stage stage= new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		Pane root= new Pane();
		Scene scene= new Scene(root);
		
		Label label1= new Label(text);
		label1.setLayoutX(30);
		label1.setLayoutY(40);
		
		Label label2= new Label("ERROR");
		label2.setTextFill(Color.INDIANRED);
		label2.setLayoutX(80);
		label2.setLayoutY(10);
		label2.setFont(new Font("Arial", 40));
		
		Button ok= new Button("Entendido");
		ok.setOnAction(e -> stage.close());
		ok.setLayoutX(100);
		ok.setLayoutY(80);
		ok.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\n" + 
				"    -fx-background-radius: 30;\n" + 
				"    -fx-background-insets: 0;\n" + 
				"    -fx-text-fill: white;");
		
		root.setPrefSize(400, 150);
		
		root.getChildren().addAll(label1, ok, label2);
		
		root.setStyle("-fx-background-color: white");
		stage.setScene(scene);
		stage.showAndWait();
	}
}
