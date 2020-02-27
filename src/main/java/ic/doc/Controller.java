package ic.doc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

  String[] signs = {"+", "-", "/", "x", "AC"};
  Calculator calc = new Calculator();


  public static void main(String[] args) {


    UI calculatorUI = new UI();
    calc.ui = calculatorUI;
    calculatorUI.display();
  }

  public void store(String number) {
    calc.store();
  }

  public void apply(String sign) {
    calc.apply(sign);
  }

}
