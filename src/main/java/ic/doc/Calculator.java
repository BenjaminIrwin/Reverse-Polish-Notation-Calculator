package ic.doc;

import java.util.Stack;

public class Calculator {

  private Stack<Integer> numbersEntered = new Stack<>();
  public UserInterface ui;

  public Calculator(UserInterface ui) {
    this.ui = ui;
  }

  public void store(int number) {
    numbersEntered.push(number);

    ui.uiUpdate(Integer.toString(numbersEntered.peek()));

  }

  public void apply(String sign) {

    if (sign.equals("AC")) {

      numbersEntered.clear();
      ui.uiUpdate(".");

    }

    if (isEmpty() || numbersEntered.size() == 1) {
      return;
    }

    switch (sign) {
      case "+":

        numbersEntered.push(numbersEntered.pop() + numbersEntered.pop());

        break;
      case "-":

        int subtrahend = numbersEntered.pop();
        int minuend = numbersEntered.pop();

        numbersEntered.push(minuend - subtrahend);

        break;
      case "/":

        int denominator = numbersEntered.pop();
        int numerator = numbersEntered.pop();
        numbersEntered.push(numerator / denominator);

        break;
      case "x":

        numbersEntered.push(numbersEntered.pop() * numbersEntered.pop());

        break;
    }

    ui.uiUpdate(Integer.toString(numbersEntered.peek()));
  }

  public Stack<Integer> getNumbersEntered() {
    return numbersEntered;
  }

  public int getTop() {
    return numbersEntered.peek();
  }

  public void remove() {
    numbersEntered.pop();
  }

  public boolean isEmpty() {
    return numbersEntered.isEmpty();
  }

}
