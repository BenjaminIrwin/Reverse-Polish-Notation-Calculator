package ic.doc;

import javax.swing.*;

public interface UserInterface {
  void display(GuiApp calculatorApp);

  void makeSignButtons(JPanel panel, GuiApp calculatorApp);

  void makeNumberButtons(JPanel panel, GuiApp calculatorApp);

  void updateUI(String toDisplay);
}
