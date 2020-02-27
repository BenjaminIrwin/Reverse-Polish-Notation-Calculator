package ic.doc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {

  String[] signs = {"+", "-", "/", "x", "AC"};
  Calculator calc = new Calculator();

  private void display() {
    JFrame frame = new JFrame("Example App");
    frame.setSize(300,200);

    JPanel panel = new JPanel();

    JTextField textField = new JTextField(10);
    panel.add(textField);

    makeNumberButtons(panel, textField);
    makeSignButtons(panel, textField);

    frame.add(panel);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private void makeSignButtons(JPanel panel, JTextField textField) {
    for(String s : signs) {
      JButton button = new JButton(s);

      button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
          calc.apply(s);
          if(s == "AC") {
            textField.setText(".");
          } else {
            textField.setText(Integer.toString(calc.getTop()));

          }

        }
      });

      panel.add(button);

    }
  }

  private void makeNumberButtons(JPanel panel, JTextField textField) {

    for(int n = 1; n <= 9; n++)
    {
      String number = Integer.toString(n);

      JButton button = new JButton(number);
      int finalN = n;
      button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
          calc.store(finalN);
          textField.setText(Integer.toString(calc.getTop()));
        //(number);
        }
      });
      panel.add(button);
    }
  }

  public static void main(String[] args) {
    new UI().display();
  }

}
