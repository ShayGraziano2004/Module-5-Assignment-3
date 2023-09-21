import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TextColorSelectorApp extends Application {

    private Label textLabel;
    private Slider redSlider;
    private Slider greenSlider;
    private Slider blueSlider;
    private Slider opacitySlider;

    @Override
    public void start(Stage primaryStage) {
        textLabel = new Label("Color Me!"); // Initial text
        textLabel.setFont(new Font(24));

        redSlider = createColorSlider("Red:");
        greenSlider = createColorSlider("Green:");
        blueSlider = createColorSlider("Blue:");
        opacitySlider = createOpacitySlider("Opacity:");

        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateTextColor());
        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateTextColor());
        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateTextColor());
        opacitySlider.valueProperty().addListener((observable, oldValue, newValue) -> updateTextColor());

        VBox root = new VBox(10);
        root.setStyle("-fx-background-color: lightgray; -fx-padding: 10px;");
        root.getChildren().addAll(textLabel, redSlider, greenSlider, blueSlider, opacitySlider);

        Scene scene = new Scene(root, 400, 250);
        primaryStage.setTitle("Text Color Selector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Slider createColorSlider(String labelText) {
        Slider slider = new Slider(0, 255, 0);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(64);
        slider.setBlockIncrement(1);

        Label label = new Label(labelText);
        label.setStyle("-fx-text-fill: darkslategray;");

        VBox sliderBox = new VBox(5);
        sliderBox.getChildren().addAll(label, slider);

        return slider;
    }

    private Slider createOpacitySlider(String labelText) {
        Slider slider = new Slider(0, 1, 1);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(0.1);
        slider.setBlockIncrement(0.01);

        Label label = new Label(labelText);
        label.setStyle("-fx-text-fill: darkslategray;");

        VBox sliderBox = new VBox(5);
        sliderBox.getChildren().addAll(label, slider);

        return slider;
    }

    private void updateTextColor() {
        double red = redSlider.getValue() / 255.0;
        double green = greenSlider.getValue() / 255.0;
        double blue = blueSlider.getValue() / 255.0;
        double opacity = opacitySlider.getValue();

        textLabel.setTextFill(new Color(red, green, blue, opacity));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
