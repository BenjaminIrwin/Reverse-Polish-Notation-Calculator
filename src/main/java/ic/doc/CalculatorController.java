package ic.doc;

//Structure of Model-View-Controller

//How do you associate the model view and controller (as member variables of each other?
//Does there need to be consistency?

//Testing - ignoring mock object

public class CalculatorController {

  private Calculator calc;

  public CalculatorController() {
    calc = new Calculator();
    CalculatorView uiCalc = new CalculatorView(this);
    calc.addObserver(uiCalc);
    uiCalc.display();
  }

  public static void main(String[] args) {
    new CalculatorController();
  }

  public void respondTo(String input) {

    try {
      int number = Integer.parseInt(input);
      calc.store(number);
    } catch (NumberFormatException nfe) {
      calc.apply(input);
    }

  }

}
