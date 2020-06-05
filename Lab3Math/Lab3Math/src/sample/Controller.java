package sample;

import MainMethods.WorkWithData;
import elements.Boarders;
import elements.Boxes;
import elements.Chart;
import elements.Logger;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.concurrent.atomic.AtomicBoolean;

public class Controller {
    @FXML
    private TextField accuracy;
    @FXML
    private ChoiceBox<String> systemChoose;

    @FXML
    private ChoiceBox<String> functionChoose;

    @FXML
    private TextField leftBorder;

    @FXML
    private TextField rightBorder;

    @FXML
    private Button performButton;

    @FXML
    private TextArea logArea;
    @FXML
    private ChoiceBox<String> methodChoose;
    @FXML
    private LineChart<Number, Number> graph;
    @FXML
    private NumberAxis x;
    @FXML
    private NumberAxis y;
    @FXML
    void initialize(){
        Logger logger=new Logger(logArea);
        Boxes boxes=new Boxes(functionChoose,systemChoose,methodChoose);

        Chart chart=new Chart();
        performButton.setOnAction(actionEvent -> {
            graph.getData().clear();
            Boarders boarders=new Boarders(leftBorder,rightBorder,accuracy,logger);
            WorkWithData workWithData=new WorkWithData(logger,boxes.getSelectedMethod(),boxes.getSelectedFunction(),boarders.getValueOfLeftBorder(),boarders.getValueOfRightBorder(),boarders.getValueOfaccuracy());
            logger.setLogs();
            graph.getData().addAll(chart.setChart(workWithData.getDots(),boxes.getName()));
        });


    }


}
