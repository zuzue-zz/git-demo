package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorFXController implements Initializable {

	double temp = 0d;
	double num = 0d;
	boolean opecode;
	String sign = "";

	@FXML
	private TextField textfield;

	@FXML
	private void numButton(ActionEvent event) {

		if (event.getSource() instanceof Button) {
			Button btn = (Button) event.getSource();
			if (opecode) {
				textfield.setText(btn.getText().trim());
			} else {
				textfield.setText(textfield.getText().trim() + btn.getText().trim());
			}
			opecode = false;
		}

	}

	@FXML
	private void OpeButton(ActionEvent event) {
		if (event.getSource() instanceof Button) {
			
			Button btn = (Button) event.getSource();
			if (!textfield.getText().isEmpty()) {
				temp = Double.valueOf(textfield.getText());
				if (btn.getText(). equals("%")) {
					temp = num * temp / 100;
				}
				switch (sign) {
				case "+":
					num = num + temp;

					break;
				case "-":
					num = num - temp;

					break;
				case "x":
					num = num * temp;

					break;
				case "/":
					num = num / temp;

					break;

				default:
					num = temp;
				}
			}
			if (btn.getText().equals("=")) {
				textfield.setText(String.valueOf(num));
				sign = "";

			} else {
				textfield.setText("");
				sign = btn.getText().trim();
			}
			opecode = true;
		}

	}

	@FXML
	private void cButton(ActionEvent event) {
		
			textfield.setText("");
		

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Call Initialize");

	}
}
