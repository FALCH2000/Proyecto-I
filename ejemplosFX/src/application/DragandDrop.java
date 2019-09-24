package application;

import java.util.List;

//import javax.lang.model.type.IntersectionType; 

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import logic.Factory;
import logic.Lista;
import logic.Nodes;

/**
 * @author fatimaleiva
 *
 *Esta clase es la encargada de realizar el drag and drop de los nodos
 *representados como las imagenes 
 *
 */
public class DragandDrop {
	
	protected static String Id = null;
	static double PosX, PosY;
    static double newPosX, newPosY;
    protected static int countId=0;
    
	
	/**
	 * Este es el metodo que realiza el drag and drop y unicamente se podra realizar
	 * un drag and drop a un objeto de tipo ImageView
	 * 
	 * @param image- es el parametro que recibe unicamente el ImageView al que se hace la referencia
	 * @param root- recibe el Pane donde se debe permitir soltar el objeto del drag and drop 
	 * @param second- es el pane (VBox) de la ubicacion actual del objeto del drag and drop
	 * 
	 */
	public static void drag(Pane root, VBox second, List<ImageView> images){
		for(ImageView image: images) {
			
			image.setOnDragDetected(new EventHandler <MouseEvent> (){
				/**
				 *Este metodo es el que inicia con el drag and drop de la imagen
				 *y se establece el tipo de transferencia que se va a permitir
				 *en este caso va a ser copiar la imagen
				 */
				public void handle(MouseEvent event) {
					
					Dragboard drag= image.startDragAndDrop(TransferMode.COPY);
					
					//System.out.println(image.getId());
					//Anadir el contenido de la imagen a copiar al nuevo objeto
					ClipboardContent content= new ClipboardContent();
					content.putImage(image.getImage());
					drag.setContent(content);
					Id= image.getId(); 
									
					event.consume();
				}
			});
			
			root.setOnDragOver(new EventHandler <DragEvent>() {
				/**
				 *Este metodo establece el lugar o la fuente en donde el nuevo
				 *objeto puede ser soltado
				 */
				public void handle(DragEvent event) {
					if(event.getGestureSource() != root && event.getDragboard().hasImage() 
							&& event.getTarget()!= second) { //para saber donde se puede poner la imagen
						
						event.acceptTransferModes(TransferMode.COPY);
					}
					event.consume();
				}
			});
			
			root.setOnDragEntered(new EventHandler <DragEvent>() {
				/**
				 *Metodo principalmente de disenno y lo que hace es cambiar el color de la ruta
				 *donde el objeto puede ser soltado para guiar al usuario
				 */
				public void handle(DragEvent event) {
					if(event.getGestureSource() != root && event.getDragboard().hasImage()) {
						root.setStyle("-fx-background-color: #AAECE0");
					}
					event.consume();
				}
			});
			
			//crea la nueva imagen en el root
			root.setOnDragExited(new EventHandler<DragEvent>() {
				/**
				 *Este metodo junto con el setOnDragEntered lo que hace es volver nuevamente
				 *la pantalla donde el objeto puede ser soltado a su color original en dos ocasiones
				 *La primera es cuando a la hora del arrastre el objeto se sale de la ruta donde puede
				 *ser soltado o cuando finalmente elobjeto es soltado
				 */
				public void handle(DragEvent event) {
					root.setStyle("-fx-background-color: white");
					event.consume();
				}
			});
			
			//this method make the new one img1
			root.setOnDragDropped(new EventHandler <DragEvent>(){
				/**
				 * Este metodo lo que hace es convertir la imagen
				 * en un ImageView y lo agrega a la ruta donde se puede
				 * observar la imagen
				 */
				public void handle(DragEvent event) {
					Dragboard drag= event.getDragboard();
					double x= event.getSceneX();
					double y=event.getSceneY();
					int nodoId; 
					
					ImageView nueva= new ImageView();
					nueva.setImage(drag.getImage());
					boolean succes= false; //indicador del proceso
					if(drag.hasImage()) {
						Connection make= new Connection();
						nueva.setOnMousePressed(MousePressedEventHandler);
						nueva.setOnMouseDragged(MouseDraggedEventHandler);
						
						nueva.setId(Id); 
						
						Factory.newNode(nueva.getId()); //Crea el nuevo nodo en la lista enlazada
						
						nueva.setId(Id +"-" + Integer.toString(countId));
						
						nodoId= Lista.getSize();
						
						countId += 1; //Aumenta para que el ID de la imagen vaya cambiando
						
						
						Label nodonum= new Label(Integer.toString(nodoId));
						
						make.inicialize(nueva, root);
						
						//especifica las posiciones X y Y del objeto en la nueva ruta 
						nueva.setX(x - 30);
						nueva.setY(y - 30);
						nodonum.setLayoutX(x);
						nodonum.setLayoutY(y + 3);

						root.getChildren().addAll(nueva, nodonum);
						
						succes= true;
						
					}else {
						succes=false;
						}
					
					//Indica si el drag and drop fue exitoso o no
					event.setDropCompleted(succes);
					
					event.consume();
				}
			});
			
			image.setOnDragDone(new EventHandler <DragEvent>() {
				public void handle(DragEvent event) {
					if (event.getTransferMode()== TransferMode.COPY) {					
					}
					
				}
			});
		}
		
	}
	
	/**
	 * Metodo que permite mover los nodos en la ruta en donde se encuentran
	 * 
	 * Es el que inicializa la accion al presionar con el mouse sobre la imagen
	 * que se quiere mover
	 */
	
	public static EventHandler<MouseEvent> MousePressedEventHandler = 
	        new EventHandler<MouseEvent>() {
	 
	        @Override
	        public void handle(MouseEvent t) {
	            PosX = t.getSceneX();
	            PosY = t.getSceneY();
	            newPosX = ((ImageView)(t.getSource())).getTranslateX();
	            newPosY = ((ImageView)(t.getSource())).getTranslateY();
	        }
	    };
	     
	 public static EventHandler<MouseEvent> MouseDraggedEventHandler = 
	        new EventHandler<MouseEvent>() {
	 
	        @Override
	        public void handle(MouseEvent t) {
	            double positionX = t.getSceneX() - PosX;
	            double positionY = t.getSceneY() - PosY;
	            double finalX = newPosX + positionX;
	            double finalY = newPosY + positionY;
	             
	            ((ImageView)(t.getSource())).setTranslateX(finalX);
	            ((ImageView)(t.getSource())).setTranslateY(finalY);
	        }
	    };
	    
	    

}
