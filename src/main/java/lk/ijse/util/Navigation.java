package lk.ijse.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Navigation {
    public static void switchPaging(Pane ChangePane, String path, String name) throws IOException {
//        pane.getChildren().clear();
        Parent parent = FXMLLoader.load(Navigation.class.getResource("/view/"+path));
        ChangePane.getChildren().clear();
        ChangePane.getChildren().add(parent);
    }
}
