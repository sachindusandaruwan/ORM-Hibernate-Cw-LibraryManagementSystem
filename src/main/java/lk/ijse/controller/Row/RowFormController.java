package lk.ijse.controller.Row;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RowFormController {

    @FXML
    private Label lblidAndAvailability;

    public void setData(String data){
        lblidAndAvailability.setText(data);
    }

}
