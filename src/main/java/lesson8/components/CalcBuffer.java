package lesson8.components;

import java.util.ArrayList;

import static lesson8.components.MathOperation.Priority.high;
import static lesson8.components.MathOperation.Priority.low;

public class CalcBuffer {
    public static class ExpressionStatus{
        public final static ExpressionStatus newExpression = new ExpressionStatus();
        public final static ExpressionStatus endExpression = new ExpressionStatus();

    }

    public static void setExpressionStatus(ExpressionStatus expressionStatus) {
        CalcBuffer.expressionStatus = expressionStatus;
    }

    public static ExpressionStatus getExpressionStatus() {
        return expressionStatus;
    }

    static ExpressionStatus expressionStatus = ExpressionStatus.newExpression;
    static ArrayList<Math> expression2 = new ArrayList<>();
    static private String inputBuffer = "";
    static private ArrayList<String> numbersBuffer = new ArrayList<>();
    static CalcBuffer calcBuffer = new CalcBuffer();
    static private ArrayList<MathOperation> operationsBuffer = new ArrayList<>();

    static private String result = "jjjj";

 /*   public static void addInCalcBuffer(Math mathe){
        Math internalBuffer = expression.get(expression.size());
        if (math instanceof Digits){

        }
    }
*/
    public static void transferInputBuffer(){

        String i = inputBuffer;
        numbersBuffer.add(i);
        inputBuffer = "";

    }

    public static void calculateResult(){
        System.out.println("создание numbers");
        int[] numbers = new int[numbersBuffer.size()];
        int resultInt = 0;

        System.out.println("заполнение numbers");
        for(int i = 0; i < numbers.length; i++){
            try{numbers[i] = Integer.parseInt (numbersBuffer.get(i));
            }catch (NumberFormatException e){
                if(numbersBuffer.get(i) == ""){
                    numbers[i] = 0;
                }else {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
        int start = 0;

        System.out.println("начат анализ");
        System.out.println("operationsBuffer.size(): " + operationsBuffer.size());
        if(operationsBuffer.size() > 1) {
            System.out.println("количество операторов больше 1 ("+ operationsBuffer.size()+")");
            do {





                //Начать вычисление выражения
                System.out.println("начато вычисление выражения");
                for (int j = 0; j < operationsBuffer.size(); j++) {

                    //ПРОСМОТР МАССИВА ДЕЙСТВИЙ
                    for (int z = 0; z < operationsBuffer.size(); z++){
                        System.out.printf("%s ",operationsBuffer.get(z).getName());
                    }
                    System.out.println();

                    //определить позицию старта
                    System.out.print ("позиция для старта определена: действие ");
                    start = 0;
                    for (int i = 0; i < operationsBuffer.size(); i++) {
                        if (operationsBuffer.get(i).getPriority() == high) {
                            start = i;
                            break;
                        }
                    }
                    System.out.println((start+1)+" "+operationsBuffer.get(start).getName());

                    //выполнить приоритетное действие
                    System.out.println("приоритетное действие " + operationsBuffer.get(start).getName() + " " + numbers[start] + " " + numbers[start + 1]);
                    resultInt = numbers[start];
                    resultInt = operationsBuffer.get(start).execute(resultInt, numbers[start + 1]);
                    System.out.println("результат " + resultInt);


                    //переформировать массивы с учетом промежуточного результата. Список операций
                    System.out.println("переформирование массива операций");
                    ArrayList<MathOperation> transientOperationBuffer = new ArrayList<>();
                    System.out.println("прежнее количество действий"+ operationsBuffer.size());
                    System.out.println("новое количество действий"+ (operationsBuffer.size()-1));
                    for (int i = 0; i < (operationsBuffer.size() - 1); i++) {
                        if (i < start) {
                            transientOperationBuffer.add(operationsBuffer.get(i));
                        } else {
                            transientOperationBuffer.add(operationsBuffer.get(i+1));
                        }
                    }
                    operationsBuffer = transientOperationBuffer;
                    System.out.println("проверка количества действий в новом operationsBuffer" + operationsBuffer.size() );
                            //ПРОСМОТР МАССИВА ДЕЙСТВИЙ
                            for (int z = 0; z < operationsBuffer.size(); z++){
                                System.out.printf("%s ",operationsBuffer.get(z).getName());
                                System.out.println();
                            }

                    //переформировать массивы с учетом промежуточного результата. Список аргументов
                    System.out.println("Начато переформирование числового массива");
                    System.out.println("прежнее количество аргументов"+ numbersBuffer.size());
                    System.out.println("новое количество аргументов"+ (numbersBuffer.size()-1));
                    ArrayList<String> transientNumberBuffer = new ArrayList<>();
                    for (int i = 0; i < (numbersBuffer.size() - 1); i++) {
                        if (i < start) {
                            transientNumberBuffer.add(numbersBuffer.get(i));
                        } else if (i == start) {
                            transientNumberBuffer.add(String.valueOf(resultInt));
                        } else {
                            transientNumberBuffer.add(numbersBuffer.get(i + 1));
                        }
                    }
                    numbersBuffer = transientNumberBuffer;
                    System.out.println("проверка количества аргументов новом numbersBuffer " + numbersBuffer.size() );
                    //ПРОСМОТР МАССИВА ДЕЙСТВИЙ
                        for (int z = 0; z < numbersBuffer.size(); z++){
                            System.out.printf("%s ",numbersBuffer.get(z));
                            System.out.println();
                        }


                    numbers = new int[numbersBuffer.size()];
                    System.out.println("заполнение numbers");
                    for(int i = 0; i < numbers.length; i++){
                        try{numbers[i] = Integer.parseInt (numbersBuffer.get(i));
                        }catch (NumberFormatException e){
                            if(numbersBuffer.get(i) == ""){
                                numbers[i] = 0;
                            }else {
                                e.printStackTrace();
                                System.exit(1);
                            }
                        }
                    }



                }
                System.out.println("ЦИКЛ_____________________________________________________________________");
            } while (operationsBuffer.size() > 1);
        }else if(operationsBuffer.size() == 1){
            start = 0;
            resultInt = numbers[start];
            resultInt = operationsBuffer.get(start).execute(resultInt, numbers[start + 1]);
        }else {
            System.out.println("новых действий не введено");
        }





  //      for(int i = 0; i < operationsBuffer.size(); i++){

  //      }

        result = String.valueOf(resultInt);

        numbersBuffer = new ArrayList<>();
        operationsBuffer = new ArrayList<>();

  //      numbersBuffer.add(result);
        inputBuffer = result;
  //      transferInputBuffer();
    }

    public static void addInputBuffer(String addition){
        System.out.println("input digital addition "+addition);
        inputBuffer += addition;
    }
    public static void addOperationBuffer(MathOperation operationMath){

            System.out.println("operation addition "+operationMath.getName());
            operationsBuffer.add(operationMath);
    }

    public static String getInputBuffer(){
        return inputBuffer;
    }

    public static String getResult() {
        return result;


    }

    public static void setResult(String result) {
        CalcBuffer.result = result;
    }

    public static void setInputBuffer(String inputBuffer) {
        CalcBuffer.inputBuffer = inputBuffer;
    }
}
