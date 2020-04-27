package mixalismpakas2995;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *
 * @author Michail Bakas
 * Software Programmer
 * mixalis.mpakas@gmail.com
 */
public class FXMLDocumentController implements Initializable {
    
    int clearPrevious = 0;
    int firstButton = 1;
    String firstValue;
    String firstID;
    String currentID;
    String currentValue;

    @FXML
    private Button firstBtn;
    private Button secondBtn;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws InterruptedException {
        if (clearPrevious == 1) {
                firstBtn.setText("");
                secondBtn.setText("");
                firstBtn.setDisable(false);
                secondBtn.setDisable(false);
                clearPrevious = 0;
        }
        Button currBtn = (Button) event.getSource();
        currentID = currBtn.getId();
        currentValue = currentID.substring(0,1);
        currBtn.setText(currentValue.toUpperCase());
        currBtn.setDisable(true);
        if (firstButton == 1){
            firstValue = currentValue;
            // firstID = currentID;            
            firstButton = 0;
            firstBtn = currBtn;
        }else if (firstButton == 0){
            if (!(firstValue.equals(currentValue))){
                secondBtn = currBtn;
                clearPrevious = 1;
            }
            firstButton = 1;
            firstValue = "";
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
