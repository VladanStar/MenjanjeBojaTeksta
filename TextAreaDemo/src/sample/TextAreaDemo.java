package sample;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class TextAreaDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 430, 430, Color.WHITE);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(10);

        final TextArea editorFld = new TextArea();
        ColorChooser colorChr = new ColorChooser(editorFld);
        editorFld.setPrefRowCount(10);
        editorFld.setPrefColumnCount(100);
        editorFld.setWrapText(true);
        editorFld.setPrefWidth(150);
        GridPane.setHalignment(editorFld, HPos.CENTER);
        gridpane.add(editorFld, 0, 1);
        gridpane.add(colorChr, 2, 1);

        editorFld.setStyle("-fx-text-fill: black;"
                + "-fx-font-weight: bold;");
        String cssDefault = "line1;\nline2;\n";
        editorFld.setText(cssDefault);

        root.getChildren().add(gridpane);
        primaryStage.setTitle("UI - Controls");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
