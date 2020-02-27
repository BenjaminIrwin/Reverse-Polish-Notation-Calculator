package ic.doc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {

  String[] signs = {"+", "-", "/", "x"};

  private void display() {
    JFrame frame = new JFrame("Example App");
    frame.setSize(300,200);

    JPanel panel = new JPanel();

    JTextField textField = new JTextField(10);
    panel.add(textField);

    for(int n = 1; n <= 9; n++)
    {
      String number = Integer.toString(n);

      JButton button = new JButton(number);
      button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
          textField.setText(number);
        //(number);
        }
      });
      panel.add(button);
    }

    JButton addition = new JButton("+");
    addition.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {

      }
    });
    panel.add(new JButton("+"));
    panel.add(new JButton("-"));
    panel.add(new JButton("x"));
    panel.add(new JButton("/"));

    frame.add(panel);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    new UI().display();
  }

}
