package javafxbug.javafxbug;

import org.w3c.dom.Document;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
 
public class App extends Application {
 
    @Override
    public void start(final Stage stage) {
 
        Button buttonCrash = new Button("Crash it!");
 
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        webEngine.loadContent("<html><h1>Hello</h1></html>");
        buttonCrash.setOnAction(event -> {
          Document document = webEngine.getDocument();
          System.out.println(document.getClass());
          document.createAttribute("/test"); // THIS LEADS TO THE CRASH
        });
 
        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(5);
        root.getChildren().addAll(buttonCrash, browser);
 
        Scene scene = new Scene(root);
 
        stage.setTitle("JavaFX Crash");
        stage.setScene(scene);
        stage.setWidth(450);
        stage.setHeight(300);
 
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
 
}
