package software_engineering.aufg3;

public class Project extends Task {
  public Project(String projectName) {
    super(projectName, 0);
  }

  public int calculateWorktimeWithSubtasks(Task task) throws IllegalArgumentException {
    if (task == null) {
      throw new IllegalArgumentException("Task may not be null");
    }

    int maxSubtaskWorktime = 0;

    if (task.getSubtasks() != null) {
      for (Task subTask : task.getSubtasks()) {
        int calculatedWorktime = this.calculateWorktimeWithSubtasks(subTask);
        if (calculatedWorktime > maxSubtaskWorktime) {
          maxSubtaskWorktime = calculatedWorktime;
        }
      }
    }

    return maxSubtaskWorktime + task.getWorktime();
  }

  public void displayTaskTree(Task task, String indentation) {
    System.out.println(
        indentation + task.getIdentifier() + " - " + task.getWorktime() + " - " + calculateWorktimeWithSubtasks(task));

    for (int i = 0; i < task.getSubtasks().size(); i++) {
      this.displayTaskTree(task.getSubtasks().get(i), indentation + "    ");
    }
  }
}