package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * @author fatimaleiva
 * esta es la case Main que inicializa  todas las clases a utilizar 
 * 
 */
public class Main extends Application {

	
	@Override
	public void start(Stage primaryStage) {
		Stage principal;
		Scene scene;
		
		principal= primaryStage;
		Pane root = new Pane();
		
		
		VBox second= new VBox();
		Canvas canvas= new Canvas(60,300);
		second.setLayoutX(885);
		second.setLayoutY(0);
		

		
		//Cargar las imágenes, fue la única manera en que funcionó
		Image imagen1= new Image(getClass().getResource("and.png").toExternalForm());
		ImageView img1= new ImageView(imagen1);
		
		Image imagen2= new Image(getClass().getResource("nand.png").toExternalForm());
		ImageView img2= new ImageView(imagen2);
		
		Image imagen3= new Image(getClass().getResource("or.png").toExternalForm());
		ImageView img3= new ImageView(imagen3);
		
		Image imagen4= new Image(getClass().getResource("nor.png").toExternalForm());
		ImageView img4= new ImageView(imagen4);
		
		Image imagen5= new Image(getClass().getResource("xnor.png").toExternalForm());
		ImageView img5= new ImageView(imagen5); 
		
		Image imagen6= new Image(getClass().getResource("xor.png").toExternalForm());
		ImageView img6= new ImageView(imagen6);
		
		//ESTA IMAGEN NO SE VE HAY QUE REDIMENSIONAR TODAS LAS IMAGENES
		Image imagen7= new Image(getClass().getResource("not.png").toExternalForm());
		ImageView img7= new ImageView(imagen7);
		
		//Se llama al metodo drag de la clase DragandDrop para inicializarlo
		
		DragandDrop.drag(img1, root, second);
		DragandDrop.drag(img2, root, second);
		DragandDrop.drag(img3, root, second);
		DragandDrop.drag(img4, root, second);
		DragandDrop.drag(img5, root, second);
		DragandDrop.drag(img6, root, second);
		DragandDrop.drag(img7, root, second);
		
		
		
		
		//Disenno final del stage principal 
		second.getChildren().addAll(img1,img2, img3, img4, img5, img6, img7, canvas);
		
		second.setStyle("-fx-background-color: orange");
		root.getChildren().addAll(second);
		root.setStyle("-fx-background-color: white");
		scene= new Scene(root,1000,700);
		principal.setScene(scene);
		principal.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
