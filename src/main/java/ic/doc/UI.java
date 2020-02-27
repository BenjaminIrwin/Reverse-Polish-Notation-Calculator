package ic.doc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {

  String[] signs = {"+", "-", "/", "x", "AC"};
  JTextField textField = new JTextField(10);

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

  private void makeSignButtons(JPanel panel) {
    for (String s : signs) {
      JButton button = new JButton(s);

      button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
          calc.apply(s);
        }
      });

      panel.add(button);

    }
  }

  private void makeNumberButtons(JPanel panel) {

    for (int n = 1; n <= 9; n++) {
      String number = Integer.toString(n);

      JButton button = new JButton(number);
      int finalN = n;
      button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
          calc.store(finalN);
        }
      });

      panel.add(button);

    }
  }

  public void updateUI(String numberToDisplay) {
    textField.setText(numberToDisplay);
  }

}
