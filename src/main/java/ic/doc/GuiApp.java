package ic.doc;

public class GuiApp {

  private static GuiApp calculatorApp = new GuiApp();
  private static CalculatorView calcUI = new CalculatorView();
  private static Calculator calc = new Calculator(calcUI);

  public static void main(String[] args) {

    calcUI.display(calculatorApp);

  }

  public void interact(String input) {

    try {
      int number = Integer.parseInt(input);
      calc.store(number);
    } catch (NumberFormatException nfe) {
      calc.apply(input);
    }


  }

}
