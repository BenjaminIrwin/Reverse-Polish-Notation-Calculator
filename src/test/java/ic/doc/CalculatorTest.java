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

    assertThat(calc.getStack(), is(stack));
  }


  }

}
