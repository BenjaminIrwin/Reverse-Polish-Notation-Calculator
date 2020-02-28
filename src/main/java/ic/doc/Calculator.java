package ic.doc;

import java.util.Stack;

public class Calculator {

  private Stack<Integer> numbersEntered = new Stack<>();
  private UserInterface ui;

  public void store(int number) {
    numbersEntered.push(number);

    ui.showNumber(numbersEntered.peek());

  }

  public void apply(String operation) {

    if (operation.equals("AC")) {

      numbersEntered.clear();
      ui.clear();
      return;
    }

    if (numbersEntered.empty() || numbersEntered.size() == 1) {
      return;
    }

    if (operation.equals("+")) {

      numbersEntered.push(numbersEntered.pop() + numbersEntered.pop());

    } else if (operation.equals("-")) {

      int subtrahend = numbersEntered.pop();
      int minuend = numbersEntered.pop();

      numbersEntered.push(minuend - subtrahend);

    } else if (operation.equals("/")) {

      int denominator = numbersEntered.pop();
      int numerator = numbersEntered.pop();
      numbersEntered.push(numerator / denominator);

    } else if (operation.equals("x")) {

      numbersEntered.push(numbersEntered.pop() * numbersEntered.pop());

    }

    ui.showNumber(numbersEntered.peek());
  }

  public void addObserver(UserInterface ui) {
    this.ui = ui;
  }
}
