package ic.doc;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CalculatorTest {

  Mockery context = new Mockery();
  UserInterface ui = context.mock(UserInterface.class);

  @Test
  public void storesAValue() {

    context.checking(new Expectations() {{
      ignoring(ui);
    }});

    Calculator calc = new Calculator(ui);
    calc.store(24);

    Stack<Integer> stack = new Stack<Integer>();
    stack.push(24);

    assertThat(calc.getNumbersEntered(), is(stack));
  }

  @Test
  public void storeThreeAndAllClear() {

    context.checking(new Expectations() {{
      ignoring(ui);
    }});

    Calculator calc = new Calculator(ui);
    calc.store(24);
    calc.store(30);
    calc.store(33);

    calc.apply("AC");

    assertTrue(calc.isEmpty());
  }

  @Test
  public void addTwoValues() {

    context.checking(new Expectations() {{
      ignoring(ui);
    }});

    Calculator calc = new Calculator(ui);
    calc.store(24);
    calc.store(30);

    calc.apply("+");

    assertEquals(54, calc.getTop());
  }

  @Test
  public void subtractWithTwoValues() {

    context.checking(new Expectations() {{
      ignoring(ui);
    }});

    Calculator calc = new Calculator(ui);
    calc.store(60);
    calc.store(30);

    calc.apply("-");

    assertEquals(30, calc.getTop());
  }

  @Test
  public void multiplyTwoValues() {

    context.checking(new Expectations() {{
      ignoring(ui);
    }});

    Calculator calc = new Calculator(ui);
    calc.store(24);
    calc.store(2);

    calc.apply("x");

    assertEquals(48, calc.getTop());
  }

  @Test
  public void divideWithTwoValues() {

    context.checking(new Expectations() {{
      ignoring(ui);
    }});

    Calculator calc = new Calculator(ui);
    calc.store(24);
    calc.store(2);

    calc.apply("/");

    assertEquals(12, calc.getTop());
  }

  @Test
  public void addSubtractDivideMultiply() {

    context.checking(new Expectations() {{
      ignoring(ui);
    }});

    Calculator calc = new Calculator(ui);
    calc.store(15);
    calc.store(7);
    calc.store(1);
    calc.store(1);
    calc.apply("+");
    calc.apply("-");
    calc.apply("/");
    calc.store(3);
    calc.apply("x");

    assertEquals(9, calc.getTop());
  }

  @Test
  public void arithmeticWithStackSizeZeroAndOneDoesNothing() {

    context.checking(new Expectations() {{
      ignoring(ui);
    }});

    Calculator calc = new Calculator(ui);

    calc.apply("+");
    calc.apply("-");
    calc.apply("/");
    calc.apply("x");
    calc.store(3);
    calc.apply("+");
    calc.apply("-");
    calc.apply("/");
    calc.apply("x");

    Stack<Integer> stack = new Stack<>();
    stack.push(3);

    assertEquals(stack, calc.getNumbersEntered());

  }

}
