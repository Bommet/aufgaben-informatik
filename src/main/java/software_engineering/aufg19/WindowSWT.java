package software_engineering.aufg19;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class WindowSWT {

  public WindowSWT() {
    Display display = new Display();
    buildWindow(display);
    display.dispose();
  }

  public void buildWindow(Display display) {
    Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);

    RowLayout layout = new RowLayout();
    layout.marginLeft = 50;
    layout.marginTop = 50;
    shell.setLayout(layout);

    addButton(shell, 30, 0);
    addTextfield(shell, 30, 20);

    shell.setText("Fenster");
    shell.setSize(250, 200);
    shell.open();

    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
  }

  public void addButton(Shell shell, int x, int y) {
    Button button = new Button(shell, SWT.PUSH);
    button.setText("Knopf");
    button.setLayoutData(new RowData(x, y));
  }

  public void addTextfield(Shell shell, int x, int y) {
    Text text = new Text(shell, SWT.BORDER_SOLID);
    text.setText("Hier Text eingeben.");
    text.setLayoutData(new RowData(0, 0));
  }
}