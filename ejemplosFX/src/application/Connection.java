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
		            	System.out.println(t.getSceneX());
		            	
		            	node1= (ImageView)t.getSource();
		            	//node1.getId();
		            	System.out.println(node1.getId());
	            	}
	            	else if(node2 == null && t.getSource()!= node1) {
	            		newPosX= t.getSceneX();
		            	newPosY= t.getSceneY();
		            	node2= (ImageView) t.getSource();
		            	line= new Line(PosX, PosY, newPosX, newPosY);
		            	//System.out.println(t.getSource());
		            	
		            	line.setStrokeWidth(2);
		                line.setStrokeLineCap(StrokeLineCap.BUTT);
		                line.getStrokeDashArray().setAll(1.0, 1.0);
		            	line.setStroke(randomColor());
		            	System.out.println(node2.getId());
		            	
		            	root.getChildren().add(line);
		            	
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
