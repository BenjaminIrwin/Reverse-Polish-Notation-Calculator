package ic.doc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class CalculatorTest {

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  UserInterface ui = context.mock(UserInterface.class);

  @Test
  public void storeAValue() {

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
    calc.addObserver(ui);

    calc.store(2);
    calc.store(3);
    calc.store(5);

    calc.apply("AC");
  }

  @Test
  public void addTwoValues() {

    context.checking(new Expectations() {{
      exactly(1).of(ui).showNumber(2);
      exactly(1).of(ui).showNumber(3);
      exactly(1).of(ui).showNumber(5);
    }});

    Calculator calc = new Calculator();
    calc.addObserver(ui);
    calc.store(2);
    calc.store(3);

    calc.apply("+");
  }

  @Test
  public void subtractWithTwoValues() {

    context.checking(new Expectations() {{
      exactly(1).of(ui).showNumber(6);
      exactly(1).of(ui).showNumber(3);
      exactly(1).of(ui).showNumber(3);
    }});

    Calculator calc = new Calculator();
    calc.addObserver(ui);

    calc.store(6);
    calc.store(3);
    calc.apply("-");

  }

  @Test
  public void multiplyTwoValues() {

    context.checking(new Expectations() {{
      exactly(1).of(ui).showNumber(2);
      exactly(1).of(ui).showNumber(5);
      exactly(1).of(ui).showNumber(10);
    }});

    Calculator calc = new Calculator();
    calc.addObserver(ui);

    calc.store(2);
    calc.store(5);
    calc.apply("x");

  }

  @Test
  public void divideWithTwoValues() {

    context.checking(new Expectations() {{
      exactly(1).of(ui).showNumber(10);
      exactly(1).of(ui).showNumber(5);
      exactly(1).of(ui).showNumber(2);
    }});

    Calculator calc = new Calculator();
    calc.addObserver(ui);

    calc.store(10);
    calc.store(5);
    calc.apply("/");

  }

  @Test
  public void addSubtractDivideMultiply() {

    context.checking(new Expectations() {{
      exactly(2).of(ui).showNumber(5);
      exactly(1).of(ui).showNumber(7);
      exactly(3).of(ui).showNumber(1);
      exactly(1).of(ui).showNumber(2);
      exactly(2).of(ui).showNumber(3);

    }});

    Calculator calc = new Calculator();
    calc.addObserver(ui);

    calc.store(5);
    calc.store(7);
    calc.store(1);
    calc.store(1);
    calc.apply("+");
    calc.apply("-");
    calc.apply("/");
    calc.store(3);
    calc.apply("x");



  }

  @Test
  public void operationWithStackSizeZeroAndOneDoesNothing() {

    context.checking(new Expectations() {{
      exactly(1).of(ui).showNumber(3);
    }});

    Calculator calc = new Calculator();
    calc.addObserver(ui);

    calc.apply("+");
    calc.apply("-");
    calc.apply("/");
    calc.apply("x");
    calc.store(3);
    calc.apply("+");
    calc.apply("-");
    calc.apply("/");
    calc.apply("x");

  }

}
