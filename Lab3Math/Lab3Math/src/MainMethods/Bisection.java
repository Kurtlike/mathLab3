package MainMethods;

public class Bisection {
    private double accuracy;
    private double leftBorder;
    private double rightBorder;
    private double currentAccuracy=100;
    private double answer;
    private double[][] dots;
    String message="";
    public Bisection(String numberOfFunction,double leftBorder,double rightBorder,double accuracy){
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
        checkUniquenessCondition(getFunction(numberF,leftBorder),getFunction(numberF,rightBorder),getDerivative(numberF,leftBorder),getDerivative(numberF,rightBorder));
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
            answer=(rightBorder+leftBorder)/2;
            if((getFunction(numberF,answer)>0&&getFunction(numberF,rightBorder)>0)||(getFunction(numberF,answer)<0&&getFunction(numberF,rightBorder)<0)||getFunction(numberF,answer)==0) rightBorder=answer;
            else leftBorder=answer;
            currentAccuracy=Math.abs(rightBorder-leftBorder);
        }

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
    public double getAnswer(){
        return answer;
    }
    private void checkUniquenessCondition(double functionLeftBorder,double functionRightBorder,double derivativeLeftBorder, double derivativeRightBorder) {
        if((functionLeftBorder>0&&functionRightBorder>0||functionLeftBorder<0&&functionRightBorder<0)&&(derivativeLeftBorder>0&&derivativeRightBorder<0||derivativeLeftBorder<0&&derivativeRightBorder>0))
            message+="\n"+"Достаточное условие единственности корня не выполненно"+"\n"+"Ответ может быть некорректен";
    }
    private void verifyExistenceRoot(double functionLeftBorder,double functionRightBorder){
        if(functionLeftBorder*functionRightBorder>0) message="Необходимое условие существования корня не выполнено";
    }
    public double[][] getDots(){
        return dots;
    }
    public String getMessage(){return message;}
}
