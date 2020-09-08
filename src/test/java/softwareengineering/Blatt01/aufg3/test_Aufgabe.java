package Aufgaben.Blatt01.aufg3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class test_Aufgabe {
  Task task = new Task("task", 10);
  Task subTask = new Task("subTask", 20);

  @Test
  public void test_getWorktime() {
    assertEquals(10, task.getWorktime());
  }

  @Test
  public void test_getIdentifier() {
    assertEquals("task", task.getIdentifier());
  }

  @Test
  public void test_getSubtasks() {
    task.appendTask(subTask);
    assertTrue(task.getSubtasks() != null && task.getSubtasks().size() > 0);
    assertTrue(task.getSubtasks().get(0).getIdentifier() == "subTask");
  }

  @Test
  public void test_appendTask() {
    task.appendTask(subTask);
    assertEquals("subTask", task.getSubtasks().get(0).getIdentifier());
    assertTrue(task.getSubtasks() != null && task.getSubtasks().size() != 0);
  }
}