package ic.doc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class CalculatorTest {

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  UserInterface ui = context.mock(UserInterface.class);

  @Test
  public void storesAValue() {

    context.checking(new Expectations() {{
      exactly(1).of(ui).showNumber(24);
    }});

    Calculator calc = new Calculator();
    calc.addObserver(ui);
    calc.store(24);

  }

  @Test
  public void storeThreeAndAllClear() {

    context.checking(new Expectations() {{
      exactly(1).of(ui).showNumber(2);
      exactly(1).of(ui).showNumber(3);
      exactly(1).of(ui).showNumber(5);
      exactly(1).of(ui).clear();

    }});

    Calculator calc = new Calculator();
    calc.store(2);
    calc.store(3);
    calc.store(5);

    calc.apply("AC");

    assertTrue(calc.isEmpty());
  }

  @Test
  public void addTwoValues() {

    context.checking(new Expectations() {{
      exactly(1).of(ui).showNumber(2);
      exactly(1).of(ui).showNumber(3);
      exactly(1).of(ui).showNumber(5);
    }});

    Calculator calc = new Calculator();
    calc.store(2);
    calc.store(3);

    calc.apply("+");
  }

  @Test
  public void subtractWithTwoValues() {

    context.checking(new Expectations() {{
      ignoring(ui);
    }});

    Calculator calc = new Calculator();
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

    Calculator calc = new Calculator();
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

    Calculator calc = new Calculator();
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

    Calculator calc = new Calculator();
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

    Calculator calc = new Calculator();

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
