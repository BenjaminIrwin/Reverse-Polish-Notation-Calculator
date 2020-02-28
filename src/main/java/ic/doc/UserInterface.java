package ic.doc;

import javax.swing.JPanel;

public interface UserInterface {
  void display(GuiApp calculatorApp);

  void makeSignButtons(JPanel panel, GuiApp calculatorApp);

  void makeNumberButtons(JPanel panel, GuiApp calculatorApp);

  void uiUpdate(String toDisplay);
}
