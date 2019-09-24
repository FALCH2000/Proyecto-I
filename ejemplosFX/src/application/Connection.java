package application;

import java.util.Random;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import logic.*;


public class Connection {
	
	private static Line line;
	private static double PosX;
	private static double PosY;
	private static double newPosX;
	private static double newPosY;
	private static Pane root;
	private static ImageView node1=null;
	private static ImageView node2= null; 
	public static Nodes nodoNext;
	public static Nodes nodoPrev;
	
	public void inicialize(ImageView image, Pane root) {
		Connection.root= root;
		image.setOnMouseClicked(MouseClickedEventHandler);
	}

	public static EventHandler<MouseEvent> MouseClickedEventHandler = 
	        new EventHandler<MouseEvent>() {
	 
	        @Override
	        public void handle(MouseEvent t) {
	            if (t.getSource().getClass()== ImageView.class) {
	            	if(node1 == null) {	            		
	            		PosX= t.getSceneX();
		            	PosY= t.getSceneY();
		            	
		            	node1= (ImageView)t.getSource();
		            	//System.out.println(node1.getId());
		            
		            	String parts[]= node1.getId().split("-");
		            	int count= Integer.parseInt(parts[1]);
		            	System.out.println("La posición del nodo que acaba de clickear es: " +count);
		            	nodoNext= Lista.getNodo(count);	
		            	
	            	}
	            	else if(node2 == null && t.getSource()!= node1) {
	            		
	            		node2= (ImageView) t.getSource();
	            		String parts[]= node2.getId().split("-");
		            	int count= Integer.parseInt(parts[1]);
		            	//nodoNext= Lista.getNodo(count); CASI ME LA PELO
		            	
	            		newPosX= t.getSceneX();
		            	newPosY= t.getSceneY();
		       

		            	
		            	nodoPrev= Lista.getNodo(count);
		            
		            	
		            	if(Validation.validate(node1, node2, nodoNext, nodoPrev)) {
		            		
		            		line= new Line(PosX, PosY, newPosX, newPosY);
		            		line.setStrokeWidth(2);
			                line.setStrokeLineCap(StrokeLineCap.BUTT);
			                line.getStrokeDashArray().setAll(1.0, 1.0);
			            	line.setStroke(randomColor());
			            	//System.out.println(node2.getId());
			            	
			            	root.getChildren().add(line);
		            	} 
		            	
		            	
		            	
		            	
		            	
		            	node1= null;
		            	node2= null;
	            	}else {
	            		node1=null;
		            	node2=null;
	            	}
	            	
	            }
	        }
	    };
	    
	public static void validate(Pane root, ImageView node1, ImageView node2) {
		
	}
		     

	
	public static Paint randomColor() {
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return Color.rgb(r, g, b);
    }
	
	
}
