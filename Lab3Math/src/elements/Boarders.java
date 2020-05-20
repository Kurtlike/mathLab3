package elements;

import javafx.scene.control.TextField;

public class Boarders {
    private double valueOfLeftBorder;
    private double valueOfRightBorder;
    private double valueOfaccuracy;
    private final TextField leftBorder;
    private final TextField rightBorder;
    private final TextField accuracy;
    private final Logger logger;
    public Boarders(TextField leftBorder,TextField rightBorder,TextField accuracy,Logger logger){
        this.leftBorder=leftBorder;
        this.rightBorder=rightBorder;
        this.accuracy=accuracy;
        this.logger=logger;
        readBoarder();
    }
    public void readBoarder(){
        try {
            valueOfLeftBorder=Double.parseDouble(leftBorder.getText());
            valueOfRightBorder=Double.parseDouble(rightBorder.getText());
            valueOfaccuracy=Double.parseDouble(accuracy.getText());
            logger.addToLogs("Левая граница="+valueOfLeftBorder+"\n" +"Правая граница="+valueOfRightBorder+"\n" +"Точность="+valueOfaccuracy);
        }
        catch (Exception e){
            logger.setLog("Границы введены не верно");
        }
    }
    public double getValueOfLeftBorder(){
        return valueOfLeftBorder;
    }
    public double getValueOfRightBorder(){
        return valueOfRightBorder;
    }
    public double getValueOfaccuracy(){
        return valueOfaccuracy;
    }


}
