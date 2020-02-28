package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CalculatorView implements UserInterface {

  String[] signs = {"+", "-", "/", "x", "AC"};
  JTextField textField = new JTextField(10);

  private CalculatorController calculatorApp;

  public CalculatorView(CalculatorController calculatorApp) {
    this.calculatorApp = calculatorApp;
  }

  @Override
  public void display() {
    JFrame frame = new JFrame("Example App");
    frame.setSize(300, 200);

    JPanel panel = new JPanel();

    panel.add(textField);

    makeNumberButtons(panel);
    makeSignButtons(panel);

    frame.add(panel);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void makeSignButtons(JPanel panel) {
    for (String s : signs) {
      JButton button = new JButton(s);

      button.addActionListener(actionEvent -> calculatorApp.respondTo(s));

      panel.add(button);

    }
  }

  public void makeNumberButtons(JPanel panel) {

    for (int n = 1; n <= 9; n++) {
      String number = Integer.toString(n);

      JButton button = new JButton(number);
      button.addActionListener(actionEvent -> calculatorApp.respondTo(number));

      panel.add(button);
    }
  }

  @Override
  public void showNumber(Integer toDisplay) {
    textField.setText(String.valueOf(toDisplay));
  }

  @Override
  public void clear() {
    textField.setText("");
  }

}
