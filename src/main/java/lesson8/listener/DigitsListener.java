package lesson8.listener;

import lesson8.components.CalcBuffer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static lesson8.components.CalcBuffer.ExpressionStatus.endExpression;
import static lesson8.components.CalcBuffer.ExpressionStatus.newExpression;

public class DigitsListener extends ButtonListener implements ActionListener {
    public DigitsListener(JTextField inputField) {
        super(inputField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(CalcBuffer.getExpressionStatus() == endExpression){
            getInputField().setText("");
            CalcBuffer.setExpressionStatus(newExpression);
        }

        JButton btn = (JButton) e.getSource();
        getInputField().setText(getInputField().getText()+ " " + btn.getText());

        //inputField.setText(inputField.getText()+ " " + btn.getText());

        CalcBuffer.addInputBuffer(btn.getText());

    }
}
