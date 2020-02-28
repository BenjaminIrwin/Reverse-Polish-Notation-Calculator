package ic.doc;

import java.util.Stack;

public class Calculator {

  private Stack<Integer> numbersEntered = new Stack<>();
  private UserInterface ui;



  public void store(int number) {
    numbersEntered.push(number);

    ui.showNumber(numbersEntered.peek());

  }

  public void apply(String sign) {

    if (sign.equals("AC")) {

      numbersEntered.clear();
      ui.clear();
      return;
    }

    if (isEmpty() || numbersEntered.size() == 1) {
      return;
    }

    if (sign.equals("+")) {

      numbersEntered.push(numbersEntered.pop() + numbersEntered.pop());

    } else if (sign == "-") {

      int subtrahend = numbersEntered.pop();
      int minuend = numbersEntered.pop();

      numbersEntered.push(minuend - subtrahend);

    } else if (sign.equals("/")) {

      int denominator = numbersEntered.pop();
      int numerator = numbersEntered.pop();
      numbersEntered.push(numerator / denominator);

    } else if (sign.equals("x")) {

      numbersEntered.push(numbersEntered.pop() * numbersEntered.pop());

    }

    ui.showNumber(numbersEntered.peek());
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

  public void addObserver(UserInterface ui) {
    this.ui = ui;
  }
}
