package software_engineering.aufg19;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;

public class WindowAWT extends Frame {
  private static final long serialVersionUID = 1L;

  private TextField textEingabe = new TextField("Hier Text eingeben.");
  private Button knopf = new Button("Knopf");

  public WindowAWT() {
    buildWindow();
  }

  public void buildWindow() {
    setTitle("Fenster");
    setBounds(200, 200, 200, 200);
    setLayout(new GridBagLayout());

    put(this, knopf, 0, 1, 4);
    put(this, textEingabe, 0, 0, 4);

    setVisible(true);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        dispose();
      }
    });
  }

  public static void put(Container ctr, Component comp, int x, int y, int w) {
    GridBagLayout g = (GridBagLayout) ctr.getLayout();
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.BOTH;
    c.gridx = x;
    c.gridy = y;
    c.gridwidth = w;
    c.gridheight = 1;
    c.weightx = 0.0;
    c.weighty = 0.0;
    ctr.add(comp);
    g.setConstraints(comp, c);
  }
}