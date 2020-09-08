package infoi.aufgabe_nr11;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;

public class TaschenrechnerFrame extends Frame implements ActionListener {

  private static final long serialVersionUID = 1L;
  protected TextField textX = new TextField("0");
  protected TextField textY = new TextField("0");
  protected Button add = new Button("Addieren");
  protected Button sub = new Button("Subtrahieren");
  protected Button mul = new Button("Multiplizieren");
  protected Button div = new Button("Dividieren");
  protected Button sinX = new Button("Sinus X");
  protected TextField result = new TextField("0");

  public TaschenrechnerFrame() {
    setTitle("Taschenrechner");
    setBounds(400, 400, 500, 500);
    setLayout(new GridBagLayout());
    put(this, new Label("x: "), 0, 0, 2);
    put(this, new Label("y: "), 0, 1, 2);
    put(this, textX, 3, 0, 2);
    put(this, textY, 3, 1, 2);
    put(this, add, 0, 2, 2);
    put(this, sub, 0, 3, 2);
    put(this, mul, 3, 2, 2);
    put(this, div, 3, 3, 2);
    put(this, sinX, 3, 4, 2);
    put(this, result, 0, 4, 2);
    add.addActionListener(this);
    sub.addActionListener(this);
    mul.addActionListener(this);
    div.addActionListener(this);
    sinX.addActionListener(this);
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

  public void actionPerformed(ActionEvent event) {
    double eingabeX = Double.parseDouble(textX.getText());
    double eingabeY = Double.parseDouble(textY.getText());
    if (event.getSource() == add) {
      result.setText("" + (eingabeX + eingabeY));
    } else if (event.getSource() == sub) {
      result.setText("" + (eingabeX - eingabeY));
    } else if (event.getSource() == mul) {
      result.setText("" + (eingabeX * eingabeY));
    } else if (event.getSource() == div) {
      result.setText("" + (eingabeX / eingabeY));
    } else {
      result.setText("" + (Math.sin(eingabeX)));
    }
  }

  public static void main(String[] args) {
    new TaschenrechnerFrame();
  }
}
