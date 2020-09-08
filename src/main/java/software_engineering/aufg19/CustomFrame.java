package software_engineering.aufg19;

public class CustomFrame {
  public CustomFrame(int frameworkId) {
    if (frameworkId == 0) {
      new WindowAWT();
    } else if (frameworkId == 1) {
      new WindowSWT();
    }
  }
}