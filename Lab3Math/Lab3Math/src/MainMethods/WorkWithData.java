package MainMethods;

import MainMethods.Bisection;
import MainMethods.Newton;
import MainMethods.SimpleIteration;
import elements.Logger;

public class WorkWithData {
    private Logger logger;
    private String method;
    private String numberOfFunction;
    private double leftBorder;
    private double rightBorder;
    private double accuracy;
    private String message="";
    public WorkWithData(Logger logger,String method,String numberOfFunction,double leftBorder,double rightBorder,double accuracy) {
        this.logger = logger;
        this.method=method;
        this.numberOfFunction=numberOfFunction;
        this.leftBorder=leftBorder;
        this.rightBorder=rightBorder;
        this.accuracy=accuracy;
        logger.addToLogs("Ответ:"+prepare());
        if(message.equals("Необходимое условие существования корня не выполнено")){
            logger.clearAll();
        }
        logger.addToLogs(message);
    }
    private double[][] dots;
    Bisection bisection;
    Newton newton;
    SimpleIteration simpleIteration;
    private double prepare(){
        switch (method){
            case "деления пополам":
                bisection=new Bisection(numberOfFunction,leftBorder,rightBorder,accuracy);
                dots=bisection.getDots();
                message=bisection.getMessage();
                return bisection.getAnswer();
            case "простой итерации":
                simpleIteration=new SimpleIteration(numberOfFunction,leftBorder,rightBorder,accuracy);
                dots=simpleIteration.getDots();
                message=simpleIteration.getMessage();
                return simpleIteration.getAnswer();
            case "Ньютона":
                return 0;
            default:
                return 0;
        }

    }
    public double[][]getDots(){
        return dots;
    }
}
