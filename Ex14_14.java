package week5;

import java.util.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Ex14_14 extends Application {
	 @Override
	    public void start(Stage primaryStage) {

	        Pane pane = new Pane();
	        ArrayList<Shape> shapes = new ArrayList<>();

	        Rectangle Front = new Rectangle(0,0, Color.TRANSPARENT);
	        Front.setStroke(Color.BLUE);
	        Front.xProperty().bind(pane.widthProperty().divide(3).subtract(20));
	        Front.yProperty().bind(pane.heightProperty().divide(3).add(20));
	        Front.widthProperty().bind(pane.widthProperty().divide(3));
	        Front.heightProperty().bind(pane.widthProperty().divide(3));
	        shapes.add(Front);
	        Rectangle Back = new Rectangle(0,0, Color.TRANSPARENT);
	        Back.setStroke(Color.BLUE);
	        Back.xProperty().bind(pane.widthProperty().divide(3).add(20));
	        Back.yProperty().bind(pane.heightProperty().divide(4).subtract(20));
	        Back.widthProperty().bind(pane.widthProperty().divide(3));
	        Back.heightProperty().bind(pane.widthProperty().divide(3));
	        shapes.add(Back);

	        Line line1 = new Line();
	        line1.setStroke(Color.BLUE);
	        line1.startXProperty().bind(Front.xProperty());
	        line1.startYProperty().bind(Front.yProperty());
	        line1.endXProperty().bind(Back.xProperty());
	        line1.endYProperty().bind(Back.yProperty());
	        shapes.add(line1);
	        Line line2 = new Line();
	        line2.setStroke(Color.BLUE);
	        line2.startXProperty().bind(Front.xProperty());
	        line2.startYProperty().bind(Front.yProperty().add(Front.heightProperty()));
	        line2.endXProperty().bind(Back.xProperty());
	        line2.endYProperty().bind(Back.yProperty().add(Front.heightProperty()));
	        shapes.add(line2);
	        Line line3 = new Line();
	        line3.setStroke(Color.BLUE);
	        line3.startXProperty().bind(Front.xProperty().add(Front.widthProperty()));
	        line3.startYProperty().bind(Front.yProperty().add(Front.heightProperty()));
	        line3.endXProperty().bind(Back.xProperty().add(Front.widthProperty()));
	        line3.endYProperty().bind(Back.yProperty().add(Front.heightProperty()));
	        shapes.add(line3);
	        Line line4 = new Line();
	        line4.setStroke(Color.BLUE);
	        line4.startXProperty().bind(Front.xProperty().add(Front.widthProperty()));
	        line4.startYProperty().bind(Front.yProperty());
	        line4.endXProperty().bind(Back.xProperty().add(Front.widthProperty()));
	        line4.endYProperty().bind(Back.yProperty());
	        shapes.add(line4);

	        pane.getChildren().addAll(shapes);
	        Scene scene = new Scene(pane, 500, 500);
	        scene.xProperty().add(scene.yProperty());
	        primaryStage.setTitle("Welcome to Java");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }
	    public static void main(String[] args) {
	        Application.launch(args);
	    }
	}