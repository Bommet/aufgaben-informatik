package software_engineering.aufg3;

public class Main {
  public static void main(String[] args) {
    Project project = new Project("project");

    Task v1 = new Task("v1", 10);
    Task v2 = new Task("v2", 25);
    Task v3 = new Task("v3", 15);
    Task v4 = new Task("v4", 15);
    Task v5 = new Task("v5", 24);
    Task v6 = new Task("v6", 42);
    Task v7 = new Task("v7", 89);
    Task v8 = new Task("v8", 1337);
    Task v9 = new Task("v9", 1);

    try {
      project.appendTask(v1);
      v1.appendTask(v2);
      v1.appendTask(v3);
      v2.appendTask(v5);
      v2.appendTask(v6);
      v3.appendTask(v4);
      v4.appendTask(v8);
      v5.appendTask(v8);
      v6.appendTask(v7);
      v7.appendTask(v9);
      v8.appendTask(v9);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    System.out.println("Worktime cumulated: " + project.calculateWorktimeWithSubtasks(project));
    project.displayTaskTree(project, "");
  }
}