package elements;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

import java.util.HashMap;
import java.util.List;

public class Boxes {
    private String selectedFunction;
    private String selectedMethod;
    private String name;
    private final ChoiceBox<String> functionChoose;
    private final ChoiceBox<String> methodChoose;
    private final ChoiceBox<String> systemChoose;
    public HashMap<String,String> functions= new HashMap<>();
    public HashMap<String,String> systems= new HashMap<>();
    public HashMap<String,String> methods= new HashMap<>();
    public Boxes(ChoiceBox<String> functionChoose,ChoiceBox<String> systemChoose,ChoiceBox<String>  methodChoose){
        this.systemChoose=systemChoose;
        this.functionChoose=functionChoose;
        this.methodChoose=methodChoose;
        setChoiceBox();
        setSelectedFunction();
        setSelectedMethod();

    }

    private void setChoiceBox(){
        functions.put("","");
        functions.put("f(x)=x^2-1","firstFunction");
        functions.put("f(x)=x^3+x^2-1","secondFunction");
        functions.put("f(x)=1/x+1","thirdFunction");
        systems.put("","");
        systems.put("f(x)=x^2-1"+"\n"+"f(x)=sin(x^2)/x","firstSystem");
        systems.put("f(x)=x^2-1"+"\n"+"f(x)=sin(x^3)/x","secondSystem");
        systems.put("f(x)=x^2-1"+"\n"+"f(x)=sin(x^4)/x","thirdSystem");
        methods.put("деления пополам","деления пополам");
        methods.put("простой итерации","простой итерации");
        functionChoose.getItems().addAll(functions.keySet());
        systemChoose.getItems().addAll(systems.keySet());
        methodChoose.getItems().addAll(methods.keySet());
    }
    public void setSelectedFunction(){
        functionChoose.setOnAction(actionEvent -> {
            if(functionChoose.valueProperty().getValue()==null&&systemChoose.valueProperty().getValue()==null){
                System.err.println("выберете нужную функцию или систему");

            }
            if (functionChoose.valueProperty().getValue()!=null&&!functionChoose.valueProperty().getValue().equals("")){
                systemChoose.setVisible(false);
                selectedFunction=functions.get(functionChoose.getValue());
                name=functionChoose.getValue();
            }
            else {
                selectedFunction=null;
                systemChoose.setVisible(true);
            }
        });
        systemChoose.setOnAction(actionEvent -> {
            if(functionChoose.valueProperty().getValue()==null&&systemChoose.valueProperty().getValue()==null){

            }
            if (systemChoose.valueProperty().getValue()!=null&&!systemChoose.valueProperty().getValue().equals("")){
                functionChoose.setVisible(false);
                selectedFunction=systems.get(systemChoose.getValue());
            }
            else  {
                selectedFunction=null;
                functionChoose.setVisible(true);
            }
        });

    }
    public void setSelectedMethod(){
        methodChoose.setOnAction(actionEvent -> {
            selectedMethod=methods.get(methodChoose.getValue());
        });
    }
    public String getSelectedFunction(){
        return selectedFunction;
    }
    public String getSelectedMethod(){
        return selectedMethod;
    }
    public String getName(){
        return name;
    }

}
