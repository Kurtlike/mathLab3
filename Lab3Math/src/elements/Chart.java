package elements;
import javafx.scene.chart.XYChart;

public class Chart {
    public XYChart.Series<Number,Number> setChart(double[][] dots){
        XYChart.Series<Number,Number> series = new XYChart.Series<>();
        for(double []k:dots){
            series.getData().add(new XYChart.Data<>(k[0], k[1]));
        }
        return  series;
    }
}
