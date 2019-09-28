package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic. *;


public class Result {
	
	static Stage stage;
	static Scene scene;
	static Pane root;

	
	public static void setResult() {
		
		int i= 0;
		
		while(i < Lista.getSize()) {
			Nodes node= Lista.getNodo(i);
			if(node.prev1== null && node.prev2== null) {
				getResult(node);
				i++;
			}else {
				i++;
			}
		}
		
		
	}
		
	public static void getResult(Nodes node) {
		Stage stage= new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		Pane root= new Pane();
		Scene scene= new Scene(root);
		
		Label l1= new Label("Para la primera entrada del nodo:");
		l1.setLayoutX(20);
		l1.setLayoutY(5);
		l1.setFont(new Font("Arial", 16));
		
		Button a1= new Button("False");
		a1.setOnAction(e -> node.setValue1(false));
		a1.setLayoutX(40);
		a1.setLayoutY(30);
		 a1.setStyle("-fx-background-color:\n" + 
				"        linear-gradient(#CFABD1, #CB80CF),\n" + 
				"        radial-gradient(center 50% -40%, radius 200%, #F9AAC7 45%, #F0709F 50%);\n" + 
				"    -fx-background-radius: 6, 5;\n" + 
				"    -fx-background-insets: 0, 1;\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" + 
				"    -fx-text-fill: #29052B;"); 
		
		Button b1= new Button("True");
		b1.setOnAction(e -> node.setValue1(true));
		b1.setLayoutX(170);
		b1.setLayoutY(30);
		b1.setStyle("-fx-background-color:\n" + 
				"        linear-gradient(#93AD8D, #6BC257),\n" + 
				"        radial-gradient(center 50% -40%, radius 200%, #889CF8 45%, #4D6BF5 50%);\n" + 
				"    -fx-background-radius: 6, 5;\n" + 
				"    -fx-background-insets: 0, 1;\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" + 
				"    -fx-text-fill: #0C2B05;"); 
		
		Label l2= new Label("Para la segunda entrada del nodo:");
		l2.setLayoutX(20);
		l2.setLayoutY(80);
		l2.setFont(new Font("Arial", 16));
		
		Button a2= new Button("False");
		a2.setOnAction(e -> node.setValue2(false));
		a2.setLayoutX(40);
		a2.setLayoutY(110);
		a2.setStyle("-fx-background-color:\n" + 
				"        linear-gradient(#CFABD1, #CB80CF),\n" + 
				"        radial-gradient(center 50% -40%, radius 200%, #F9AAC7 45%, #F0709F 50%);\n" + 
				"    -fx-background-radius: 6, 5;\n" + 
				"    -fx-background-insets: 0, 1;\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" + 
				"    -fx-text-fill: #29052B;"); 
		
		
		Button b2= new Button("True");
		b2.setOnAction(e -> node.setValue2(true));
		b2.setLayoutX(170);
		b2.setLayoutY(110);
		b2.setStyle("-fx-background-color:\n" + 
				"        linear-gradient(#f0ff35, #6BC257),\n" + 
				"        radial-gradient(center 50% -40%, radius 200%, #889CF8 45%, #4D6BF5 50%);\n" + 
				"    -fx-background-radius: 6, 5;\n" + 
				"    -fx-background-insets: 0, 1;\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" + 
				"    -fx-text-fill: #0C2B05;"); 
		
		Button close= new Button("Listo");
		close.setOnAction(e -> stage.close());
		close.setLayoutX(40);
		close.setLayoutY(155);
		close.setStyle("-fx-background-color:\n" + 
				"        linear-gradient(#8399E4, #5678EC),\n" + 
				"        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\n" + 
				"    -fx-background-radius: 6, 5;\n" + 
				"    -fx-background-insets: 0, 1;\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" + 
				"    -fx-text-fill: #132665;"); 
		
		root.getChildren().addAll(a1,b1, a2, b2, l1, l2, close);
		
		root.setPrefSize(300, 200);
		
		root.getChildren().addAll();
		root.setStyle("-fx-background-color: #9DF0FF");
		
		stage.setTitle("Convertir valor");
		stage.setScene(scene);
		stage.showAndWait();
	}
	
	public static Boolean Show() {
		Nodes last = null;
		int j= Lista.getSize() -1; 
		
		while(j >= 0) {
			j= Lista.getSize()-1;
			for(int i=0; i < Lista.getSize(); i++) { 
				Nodes node= Lista.getNodo(i);
				System.out.println("Estamos en el while");
				if(node.getValue() != null && node.prev1== null && node.prev2==null) {
					j-=1;
					
				} else if (node.prev1.getValue()!= null && node.prev2.getValue()!=null) {
					node.setValue1(node.prev1.getValue());
					node.setValue2(node.prev2.getValue());
					j-=1;
					last= node;
				} else{
					System.out.println("j es" + j);
				}
			}
			
		}
		return last.getValue();
	}
	
	public static void ShowResult() {
		Stage stage= new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		Pane root= new Pane();
		Scene scene= new Scene(root);

		Label l1= new Label("El resultado de su circuito es: ");
		l1.setLayoutX(80);
		l1.setLayoutY(10);
		
		
		Boolean result= Show();
		Label l2= new Label(Boolean.toString(result));
		l2.setLayoutX(150);
		l2.setLayoutY(85);
		l2.setFont(new Font("Arial", 45));
		
		
		root.getChildren().addAll(l1, l2);
		
		root.setPrefSize(300, 200);
		
		root.getChildren().addAll();
		root.setStyle("-fx-background-color: #CE8AF4");
		
		stage.setTitle("Convertir valor");
		stage.setScene(scene);
		stage.showAndWait();
	}
}
