package lesson8.listener;

import lesson8.components.CalcBuffer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private JTextField inputField;

    public ButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        inputField.setText(inputField.getText()+ " " + btn.getText());

        //CalcBuffer.addInputBuffer(btn.getText());

    }

    JTextField getInputField(){
        return inputField;
    }
}
