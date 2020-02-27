package ic.doc;

import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

  @Test
  public void storesAValue() {
    Calculator calc = new Calculator();
    calc.store(24);

    Stack<Integer> stack = new Stack<Integer>();
    stack.push(24);

    assertThat(calc.getNumbersEntered(), is(stack));
  }

  @Test
  public void storeFiveAndRemoveTwo() {
    Calculator calc = new Calculator();
    calc.store(24);
    calc.store(30);
    calc.store(33);
    calc.store(-1);
    calc.store(2);

    calc.apply("UNDO");
    calc.apply("UNDO");

    Stack<Integer> stack = new Stack<Integer>();
    stack.push(24);
    stack.push(30);
    stack.push(33);

    assertEquals(stack, calc.getNumbersEntered());
  }

  @Test
  public void addTwoValues() {
    Calculator calc = new Calculator();
    calc.store(24);
    calc.store(30);

    calc.apply("+");

    assertEquals(54, calc.getTop());
  }

  @Test
  public void multiplyTwoValues() {
    Calculator calc = new Calculator();
    calc.store(24);
    calc.store(2);

    calc.apply("x");

    assertEquals(48, calc.getTop());
  }

  @Test
  public void divide() {
    Calculator calc = new Calculator();
    calc.store(24);
    calc.store(2);

    calc.apply("/");

    assertEquals(12, calc.getTop());
  }

}
