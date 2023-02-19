package lesson8.listener;

import lesson8.components.CalcBuffer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcResultButtonListener implements ActionListener {

    private JTextField inputField;

    public CalcResultButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CalcBuffer.transferInputBuffer();

   //     inputField.setText("");
   //     inputField.setText("CalcBuffer.getResult()");
        CalcBuffer.calculateResult();
        inputField.setText(CalcBuffer.getResult());
        CalcBuffer.setExpressionStatus(CalcBuffer.ExpressionStatus.endExpression);



    }
}
