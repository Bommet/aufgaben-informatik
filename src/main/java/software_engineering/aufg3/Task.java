package software_engineering.aufg3;

import java.util.ArrayList;
import java.util.List;

public class Task {
  private String identifier = "v";
  private int worktime = 0;
  private List<Task> subtasks = new ArrayList<Task>();

  public Task(String identifier, int worktime) {
    this.identifier = identifier;
    this.worktime = worktime;
  }

  public String getIdentifier() {
    return identifier;
  }

  public int getWorktime() {
    return worktime;
  }

  public List<Task> getSubtasks() {
    return subtasks;
  }

  public void appendTask(Task newTask) throws IllegalArgumentException {
    if (newTask == null) {
      throw new IllegalArgumentException("Task may not be null");
    }
    this.subtasks.add(newTask);
  }
}