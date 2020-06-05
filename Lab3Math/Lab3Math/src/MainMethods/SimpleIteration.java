package MainMethods;

public class SimpleIteration {
    private double accuracy;
    private double leftBorder;
    private double rightBorder;
    private double currentAccuracy=100;
    private double answer;
    private double[][] dots;
    String message="";
    public SimpleIteration(String numberOfFunction,double leftBorder,double rightBorder,double accuracy){
        this.accuracy=accuracy;
        this.leftBorder=leftBorder;
        this.rightBorder=rightBorder;
        switch (numberOfFunction) {
            case "firstFunction" -> prepareFunction(1);
            case "secondFunction" -> prepareFunction(2);
            case "thirdFunction" -> prepareFunction(3);
        }
    }
    private void prepareFunction(int numberF){
        checkConvergence(numberF);
        verifyExistenceRoot(getFunction(numberF,leftBorder),getFunction(numberF,rightBorder));
        dots=new double[(int)((rightBorder-leftBorder)/0.01)][2];
        double dot=leftBorder;
        for(int i=0;i<(int)((rightBorder-leftBorder)/0.01);i++){
            dots[i][0]=dot;
            if(getFunction(numberF,dot)>1000)dots[i][1]=1000;
            else if(getFunction(numberF,dot)<-1000)dots[i][1]=-1000;
            else dots[i][1]=getFunction(numberF,dot);
            dot+=0.01;
        }
        while (currentAccuracy>accuracy){
            answer=leftBorder+findLambda(numberF)*getFunction(numberF,leftBorder);
            currentAccuracy=Math.abs(answer-leftBorder);
            leftBorder=answer;
        }
    }
    private double findLambda(int numberF){
        double value=Math.max(getDerivative(numberF,rightBorder),getDerivative(numberF,leftBorder));
        if(value==0&&leftBorder<0) value= -0.0001;
        if(value==0&&leftBorder>0) value= 0.0001;
        return -1/value;
    }
    private double getFunction(int numberF,double value){
        return switch (numberF) {
            case 1 -> Math.pow(value, 2) - 1;
            case 2 -> Math.pow(value, 3) + Math.pow(value, 2) - 1;
            case 3 -> 1/value+1;
            default -> 0;
        };
    }
    private double getDerivative(int numberF,double value){
        return switch (numberF) {
            case 1 -> 2*value;
            case 2 -> 3*Math.pow(value, 2) + 2*value;
            case 3 -> -1/Math.pow(value, 2);
            default -> 0;
        };
    }
    private double getmodifiedDerivative(int numberF,double value){
        return switch (numberF) {
            case 1 -> -1/Math.pow(value,2);
            case 2 -> (2*value/3)*Math.pow((Math.pow(value,2)-0.5),-2/3);
            case 3 -> 0;
            default -> 0;
        };
    }
    public void checkConvergence(int numberF){
        if(Math.abs(getmodifiedDerivative(numberF,leftBorder))>1 || Math.abs(getmodifiedDerivative(numberF,rightBorder))>1) message+="\n"+"Достаточное условие сходимости не выполненно"+"\n"+"Ответ может быть некорректен";
    }
    private void verifyExistenceRoot(double functionLeftBorder,double functionRightBorder){
        if(functionLeftBorder*functionRightBorder>0) message="Необходимое условие существования корня не выполнено";
    }
    public double[][] getDots(){
        return dots;
    }
    public double getAnswer(){
        return answer;
    }
    public String getMessage(){return message;}
}
