package application;
	
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.Lista;


/**
 * @author fatimaleiva
 * esta es la case Main que inicializa  todas las clases a utilizar 
 * 
 */
public class Main extends Application {

	
	/**
	 *Este metodo es el start del programa.
	 *Lo que hace es iniciar la parte gráfica del programa,
	 *inicializando las clases que se llamen dentro de este.
	 *
	 */
	@Override
	public void start(Stage primaryStage) {
		Stage principal;
		Scene scene;
		
		principal= primaryStage;
		Pane root = new Pane();
		
		Pane first= new Pane();
		first.setPrefSize(1000, 50);		
		
		VBox second= new VBox(75);
		Canvas canvas1= new Canvas(100,100);
				
		second.setLayoutX(1000);
		second.setLayoutY(0);
		second.setAlignment(Pos.CENTER);
		
		
		Button show= new Button("Mostrar Resultado");
		show.setLayoutX(250);
		show.setLayoutY(12);
		show.setStyle("-fx-background-color: \n" + 
				"        #c3c4c4,\n" + 
				"        linear-gradient(#d6d6d6 50%, white 100%),\n" + 
				"        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" + 
				"    -fx-background-radius: 30;\n" + 
				"    -fx-background-insets: 0,1,1;\n" + 
				"    -fx-text-fill: black;\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
		show.setOnAction(e -> Result.ShowResult());
		
		Button result= new Button("Ingresar resultados");
		result.setLayoutX(450);
		result.setLayoutY(12);
		result.setOnAction(e -> Result.setResult());
		result.setStyle("-fx-background-color: \n" + 
				"        #c3c4c4,\n" + 
				"        linear-gradient(#d6d6d6 50%, white 100%),\n" + 
				"        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" + 
				"    -fx-background-radius: 30;\n" + 
				"    -fx-background-insets: 0,1,1;\n" + 
				"    -fx-text-fill: black;\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
		
		Button delete= new Button("Borrar circuito");
		delete.setLayoutX(650);
		delete.setLayoutY(12);
		delete.setOnAction(e -> {
			root.getChildren().clear();
			Lista.deleteList();
			root.getChildren().addAll(second, first);
			
		});
		delete.setStyle("-fx-background-color: \n" + 
				"        #c3c4c4,\n" + 
				"        linear-gradient(#d6d6d6 50%, white 100%),\n" + 
				"        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" + 
				"    -fx-background-radius: 30;\n" + 
				"    -fx-background-insets: 0,1,1;\n" + 
				"    -fx-text-fill: black;\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
		
		
		//Cargar las imágenes, fue la única manera en que funcionó
		Image imagen1= new Image(getClass().getResource("and.png").toExternalForm());
		ImageView img1= new ImageView(imagen1);
		img1.setId("and");
		
		
		
		Image imagen2= new Image(getClass().getResource("nand.png").toExternalForm());
		ImageView img2= new ImageView(imagen2);
		img2.setId("nand");
		
		Image imagen3= new Image(getClass().getResource("or.png").toExternalForm());
		ImageView img3= new ImageView(imagen3);
		img3.setId("or");
		
		Image imagen4= new Image(getClass().getResource("nor.png").toExternalForm());
		ImageView img4= new ImageView(imagen4);
		img4.setId("nor");
		
		Image imagen5= new Image(getClass().getResource("xnor.png").toExternalForm());
		ImageView img5= new ImageView(imagen5);
		img5.setId("xnor");
		
		Image imagen6= new Image(getClass().getResource("xor.png").toExternalForm());
		ImageView img6= new ImageView(imagen6);
		img6.setId("xor");
		
		Image imagen7= new Image(getClass().getResource("not.png").toExternalForm());
		ImageView img7= new ImageView(imagen7);
		img7.setId("not");
		
		//Se llama al metodo drag de la clase DragandDrop para inicializarlo
		List<ImageView> images= new ArrayList<ImageView>(7);
		images.add(img1);
		images.add(img2);
		images.add(img3);
		images.add(img4);
		images.add(img5);
		images.add(img6);
		images.add(img7);
		
		DragandDrop.drag(root, second, images); 
		
		
		
		//Disenno final del stage principal 
		first.getChildren().addAll(show, result, delete);
		
		second.getChildren().addAll(img1,img2, img3, img4, img5, img6, img7, canvas1);
		
		root.setPrefSize(1100, 700);
		
		
		
		first.setStyle("-fx-background-color: linear-gradient(from 10% 10% to 100% 100%, #07F0C2, #C97AB8);");
		second.setStyle("-fx-background-color: linear-gradient(from 10% 10% to 100% 100%, #C97AB8, #07F0C2);");
		root.getChildren().addAll(second, first);
		root.setStyle("-fx-background-color: white");
		scene= new Scene(root);
		principal.setScene(scene);
		principal.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
