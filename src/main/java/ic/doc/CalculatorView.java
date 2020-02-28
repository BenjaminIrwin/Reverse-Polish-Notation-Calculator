package ic.doc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorView implements UserInterface {

  String[] signs = {"+", "-", "/", "x", "AC"};
  JTextField textField = new JTextField(10);

  @Override
  public void display(GuiApp calculatorApp) {
    JFrame frame = new JFrame("Example App");
    frame.setSize(300, 200);

    JPanel panel = new JPanel();

    panel.add(textField);

    makeNumberButtons(panel, calculatorApp);
    makeSignButtons(panel, calculatorApp);

    frame.add(panel);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void makeSignButtons(JPanel panel, GuiApp calculatorApp) {
    for (String s : signs) {
      JButton button = new JButton(s);

      button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
          calculatorApp.interact(s);
        }
      });

      panel.add(button);

    }
  }

  @Override
  public void makeNumberButtons(JPanel panel, GuiApp calculatorApp) {

    for (int n = 1; n <= 9; n++) {
      String number = Integer.toString(n);

      JButton button = new JButton(number);
      button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
          calculatorApp.interact(number);
        }
      });

      panel.add(button);

    }
  }

  @Override
  public void updateUI(String toDisplay) {
    textField.setText(toDisplay);
  }

}
