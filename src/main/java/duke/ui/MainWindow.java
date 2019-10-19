package duke.ui;

import duke.DukeCore;
import duke.command.Executor;
import duke.data.PatientMap;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Main UI window of the application.
 * Acts as a container for child UI elements.
 */
class MainWindow extends UiElement<Stage> {
    private static final String FXML = "MainWindow.fxml";

    @FXML
    private AnchorPane commandWindowHolder;
    @FXML
    private TabPane contextWindowHolder;
    @FXML
    private AnchorPane homeWindowHolder;

    private Stage primaryStage;
    private DukeCore core;
    private UiContext context;
    private PatientMap patientMap;
    private Executor executor;

    private CommandWindow commandWindow;

    /**
     * Constructs the main UI window to house child UI elements.
     *
     * @param primaryStage Main stage of the application.
     * @param core         Core of Dr. Duke.
     */
    MainWindow(Stage primaryStage, DukeCore core) {
        super(FXML, primaryStage);

        this.primaryStage = primaryStage;
        this.core = core;
        this.context = core.context;
        this.patientMap = core.patientMap;
        this.executor = new Executor(core);

        placeChildUiElements();
    }

    /**
     * Places child UI elements in the main UI window.
     */
    private void placeChildUiElements() {
        commandWindow = new CommandWindow(executor);
        commandWindowHolder.getChildren().add(commandWindow.getRoot());

        HomeWindow homeWindow = new HomeWindow(patientMap, commandWindow);
        Tab homeTab = new Tab("Home", homeWindow.getRoot());
        contextWindowHolder.getTabs().add(homeTab);

        PatientWindow patientWindow = new PatientWindow();
        Tab patientTab = new Tab("Patient", patientWindow.getRoot());
        contextWindowHolder.getTabs().add(patientTab);

        // TODO: Add contexts here.
        context.addListener(evt -> {
            switch ((UiContext.Context) evt.getNewValue()) {
            case HOME:
                contextWindowHolder.getSelectionModel().select(homeTab);
                break;
            case PATIENT:
                contextWindowHolder.getSelectionModel().select(patientTab);
                break;
            default:
                break;
            }
        });
    }

    /**
     * Shows the main UI window.
     */
    void show() {
        primaryStage.show();
    }

    /**
     * {@inheritDoc}
     */
    void print(String message) {
        commandWindow.print(message);
    }

    Stage getPrimaryStage() {
        return primaryStage;
    }
}
