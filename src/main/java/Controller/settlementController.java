package Controller;

import Entity.GameRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.Duration;
import java.time.ZonedDateTime;

@Slf4j

public class settlementController {
    @FXML
    private TableView<GameRecord> RecordTable;

    @FXML
    private TableColumn<GameRecord, String> player;

    @FXML
    private TableColumn<GameRecord, Integer> step;

    @FXML
    private TableColumn<GameRecord, Duration> playgame;

    @FXML
    private TableColumn<GameRecord, ZonedDateTime> Createtime;

    @FXML
    private void initialize(){
        log.debug("Loading Play record...");

        player.setCellValueFactory(new PropertyValueFactory<>("player"));
        step.setCellValueFactory(new PropertyValueFactory<>("steps"));
        playgame.setCellValueFactory(new PropertyValueFactory<>("duration"));
        Createtime.setCellValueFactory(new PropertyValueFactory<>("created"));
    }


    public void RestartButton(ActionEvent actionEvent) throws IOException {
        log.debug("{} is pressed", ((Button) actionEvent.getSource()).getText());
        log.info("Loading launch scene...");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/start.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
