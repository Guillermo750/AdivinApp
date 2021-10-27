package dad.adivinapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinaApp extends Application {
	
	private TextField numeroText;
	private Label numeroLabel;
	private Button ComprobarButton;
	private int aleatorio=(int)(Math.random()*100);
	private int intentos=1;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	
		numeroLabel = new Label();
		numeroLabel.setText("Introduce un número de 1 al 100");
		
		numeroText = new TextField();
	
		ComprobarButton = new Button("Comprobar");
		ComprobarButton.setOnAction(e -> ActionEvent(e));
		
		VBox root = new VBox(5, numeroText,numeroLabel, ComprobarButton);
		root.setAlignment(Pos.CENTER);
		root.setFillWidth(false);
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void ActionEvent(ActionEvent e) {
	
		int numeros = Integer.parseInt(numeroText.getText());

		if (numeros > 100) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Error");
			alert.setContentText("El número introducido debe ser menor que 100");
			alert.showAndWait();
			intentos++;
		} else if (numeros > aleatorio) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setHeaderText("¡Has fallado!");
			alert.setContentText("El número a adivinar es menor que " + numeros + "." + "Vuelve a intentarlo.");
			alert.showAndWait();
			intentos++;
		} else if (numeros < aleatorio) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setHeaderText("¡Has fallado!");
			alert.setContentText("El número a adivinar es mayor que " + numeros + "." + "Vuelve a intentarlo.");
			alert.showAndWait();
			intentos++;
		} else if (numeros == aleatorio) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText("¡Has ganado!");
			alert.setContentText("Sólo has necesitado " + intentos + " intentos." + "Vuelve a jugar y hazlo mejor");
			alert.showAndWait();
		}else{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Error");
			alert.setContentText("El número introducido no es válido");
			alert.showAndWait();
			intentos++;	
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}