package lesson8;

public class CalcAction {
    /*  public static class MathematicalOperations{
          MathematicalOperations addition = new MathematicalOperations();
          MathematicalOperations subtraction = new MathematicalOperations();
          MathematicalOperations multiplication = new MathematicalOperations();
          MathematicalOperations division = new MathematicalOperations();
      }

      public CalcAction(MathematicalOperations mathAction, int firstOperator, int secondOperator){
          this.mathAction = mathAction;
          this.firstOperator = firstOperator;
          this.secondOperator = secondOperator;
      }

      MathematicalOperations mathAction;
      int firstOperator;
      int secondOperator;
  */
    int addition(int firstOperator, int secondOperator){
        return firstOperator + secondOperator;
    }

    int subtraction(int firstOperator, int secondOperator){
        return firstOperator - secondOperator;
    }

    int multiplication(int firstOperator, int secondOperator){
        return firstOperator * secondOperator;
    }

    int division(int firstOperator, int secondOperator){
        return firstOperator / secondOperator;
    }


/*    int execute(){
        return null;
    }
*/
    /** Будет работать с двумя операторами
     *
     */
}
