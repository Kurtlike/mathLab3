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
        switch (numberOfFunction){
            case "firstFunction":
                prepareFirstFunction();
                break;
            case "secondFunction":

            case "thirdFunction":

            case "forthFunction":

            case "fifthFunction":
        }
    }
    //f(x)=x^2-1
    private void prepareFirstFunction(){
        checkUniquenessCondition();
        dots=new double[(int)((rightBorder-leftBorder)/0.5+2)][2];
        double dot=leftBorder;
        for(int i=0;i<(int)(rightBorder-leftBorder)/0.5+2;i++){
            dots[i][0]=dot;
            dots[i][1]=Math.pow(dot,2)-1;
            dot+=0.5;
        }
        while (currentAccuracy>accuracy){
            answer=(rightBorder+leftBorder)/2;
            if((Math.pow(answer,2)-1>0&&Math.pow(rightBorder,2)-1>0)||(Math.pow(answer,2)-1<0&&Math.pow(rightBorder,2)-1<0)||Math.pow(answer,2)-1==0) rightBorder=answer;
            else leftBorder=answer;
            currentAccuracy=Math.abs(rightBorder-leftBorder);
        }

    }
    private void prepareSecondFunction(){}
    private void prepareThirdFunction(){}
    private void prepareforthFunction(){}
    private void prepareFifthFunction(){}
    public double getAnswer(){
        return answer;
    }
    private void checkUniquenessCondition(){
        if((leftBorder*leftBorder-1>0&&rightBorder*rightBorder-1>0||leftBorder*leftBorder-1<0&&rightBorder*rightBorder-1<0)&&(2*leftBorder>0&&2*rightBorder<0||2*leftBorder<0&&2*rightBorder>0))
            message+="\n"+"Достаточное условие единственности корня не выполненно"+"\n"+"Ответ может быть не корректен";
    }
    public double[][] getDots(){
        return dots;
    }
    public String getMessage(){return message;}
}
