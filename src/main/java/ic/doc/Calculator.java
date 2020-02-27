package ic.doc;

import java.util.Stack;

public class Calculator {

  private Stack<Integer> stack = new Stack<Integer>();

  public void store(int number) {
    stack.push(number);
  }

  public int apply(String sign) {
    return 1;
  }

  public Stack<Integer> getStack() {
    return stack;
  }

  public void remove() {
    stack.pop();
  }

}
