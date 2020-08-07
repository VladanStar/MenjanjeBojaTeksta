package sample;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

public class ColorChooser extends VBox {

    TextArea editor;
    ListView<String> list = new ListView<String>();
    ObservableList<String> data = FXCollections.observableArrayList(
            "chocolate", "salmon", "gold", "coral", "darkorchid",
            "darkgoldenrod", "lightsalmon", "black", "rosybrown", "blue",
            "blueviolet", "brown", "red", "green", "gray", "pink", "orange",
            "skyblue", "darkgray", "plum", "indigo", "lime");

    public ColorChooser(final TextArea editor) {
        this.editor = editor;
        list.setItems(data);

        // postavlja se da svaka celija bude objekat unutrasnje klase ColorRectCell
        list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
                                @Override
                                public ListCell<String> call(ListView<String> list) {
                                    return new ColorRectCell();
                                }
                            }
        );

        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
                editor.setStyle("-fx-text-fill: " + new_val + "; "
                        + "-fx-font-weight: bold;");
            }
        });

        getChildren().add(list);
    }

    // kreiranje unutrasnje klase koja predstavlja jednu celiju unutar ListView objekta
    private class ColorRectCell extends ListCell<String> {

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            Rectangle rect = new Rectangle(100, 20);
            if (item != null) {
                rect.setFill(Color.web(item));
                setGraphic(rect);
            }
        }
    }

}