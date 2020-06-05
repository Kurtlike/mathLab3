package elements;
import javafx.scene.chart.XYChart;

public class Chart {
    public XYChart.Series<Number,Number> setChart(double[][] dots,String name){
        XYChart.Series<Number,Number> series = new XYChart.Series<>();
        series.setName(name);
        for(double []k:dots){
            series.getData().add(new XYChart.Data<>(k[0], k[1]));
        }
        return  series;
    }
}
