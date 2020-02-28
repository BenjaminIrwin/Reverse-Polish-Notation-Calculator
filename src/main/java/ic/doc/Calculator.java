package ic.doc;

import java.util.Stack;

public class Calculator {

  private Stack<Integer> numbersEntered = new Stack<Integer>();
  public UserInterface ui;

  public Calculator (UserInterface ui) {
    this.ui = ui;
  }

  public void store(int number) {
    numbersEntered.push(number);

    ui.updateUI(Integer.toString(numbersEntered.peek()));

  }

  public void apply(String sign) {

    if (sign == "AC") {

      numbersEntered.clear();
      ui.updateUI(".");

    }

    if(isEmpty() || numbersEntered.size() == 1) {
      return;
    }

    if (sign == "+") {

      numbersEntered.push(numbersEntered.pop() + numbersEntered.pop());

    } else if (sign == "-") {

      int subtrahend = numbersEntered.pop();
      int minuend = numbersEntered.pop();

      numbersEntered.push(minuend - subtrahend);

    } else if (sign == "/") {

      int denominator = numbersEntered.pop();
      int numerator = numbersEntered.pop();
      numbersEntered.push(numerator / denominator);

    } else if (sign == "x") {

      numbersEntered.push(numbersEntered.pop() * numbersEntered.pop());

    }

    ui.updateUI(Integer.toString(numbersEntered.peek()));
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
