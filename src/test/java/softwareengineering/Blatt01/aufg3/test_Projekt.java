package Aufgaben.Blatt01.aufg3;

import static org.junit.Assert.*;

import org.junit.Test;

public class test_Projekt {
  Project project = new Project("project");
  Task task = new Task("task", 10);
  Task subTask = new Task("subTask", 20);

  @Test
  public void test_calculateWorktimeWithSubtasks() {
    project.appendTask(task);
    task.appendTask(subTask);
    assertEquals(30, project.calculateWorktimeWithSubtasks(project));
  }
}