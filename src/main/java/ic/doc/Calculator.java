package ic.doc;

import java.util.Stack;

public class Calculator {

  private Stack<Integer> numbersEntered = new Stack<Integer>();

  public void store(int number) {
    numbersEntered.push(number);
  }

  public void apply(String sign) {

    if(isEmpty() || numbersEntered.size() == 1)
      return;

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

    } else if (sign == "AC") {

      numbersEntered.clear();

    }
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
