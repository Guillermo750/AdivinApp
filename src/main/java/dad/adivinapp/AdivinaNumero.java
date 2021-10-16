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

public class AdivinaNumero extends Application {
	
	private TextField numeroText;
	private Label numeroLabel;
	private Button ComprobarButton;
	
	
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
		int aleatorio=(int)(Math.random()*100);
		
		int numero=0;
		
		int intentos=0;

		if(aleatorio==numero) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("¡Has ganado!");
			alert.setContentText("Sólo has necesitado " +intentos+ " intentos");
			alert.setContentText("Vuelve a jugar y hazlo mejor");
			alert.showAndWait();
			intentos++;
				
		}else if(aleatorio>numero) {
			Alert alert1 = new Alert(AlertType.INFORMATION);
			alert1.setHeaderText("¡Has fallado!");
			alert1.setContentText("El número a adivinar es mayor que " +numero);
			alert1.setContentText("Vuelve a intentarlo");
			alert1.showAndWait();
			intentos++;
				
		}else{
			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setHeaderText("Error");
			alert2.setContentText("El número introducido no es válido");
			alert2.showAndWait();
			intentos++;
		}	
	}

	public static void main(String[] args) {
		launch(args);
	}
}