package application;

import java.net.URL;
import java.util.ResourceBundle;

import bean.Fermata;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class SampleController {
	
	private Model m = new Model();
	public void setModel(Model m ){
		this.m=m;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Fermata> comboPartenza;

    @FXML
    private ComboBox<Fermata> comboArrivo;

    @FXML
    private Button btnPartenza;

    @FXML
    private TextArea txtResult;

    @FXML
    void doPartenza(ActionEvent event) {
    	txtResult.clear();
    	Fermata partenza = comboPartenza.getValue();
    	Fermata arrivo = comboArrivo.getValue();
    	if(partenza==null || arrivo==null){
    		txtResult.appendText("Seleziona due fermate !\n");
    		return;
    	}
    	if(partenza.equals(arrivo)){
    		txtResult.appendText("Seleziona due fermate diverse!\n");
    		return;
    	}

    }

    @FXML
    void initialize() {
        assert comboPartenza != null : "fx:id=\"comboPartenza\" was not injected: check your FXML file 'Sample.fxml'.";
        assert comboArrivo != null : "fx:id=\"comboArrivo\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnPartenza != null : "fx:id=\"btnPartenza\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Sample.fxml'.";

        comboPartenza.getItems().addAll(m.getAllF());
        comboArrivo.getItems().addAll(m.getAllF());
    }
}
