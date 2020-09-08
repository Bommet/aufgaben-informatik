package infoii.aufg12;

public class Doublylinkedlist<E> {
  protected DoublylinkedlistElem<E> head = null;
  protected DoublylinkedlistElem<E> tail = null;

  public static class DoublylinkedlistElem<E> {
    DoublylinkedlistElem<E> prev;
    DoublylinkedlistElem<E> succ;
    E content;

    DoublylinkedlistElem(E cont, DoublylinkedlistElem<E> previous, DoublylinkedlistElem<E> next) {
      content = cont;
      prev = previous;
      succ = next;
    }
  }

  public Doublylinkedlist() {
  }

  public Doublylinkedlist_Iterator<E> getIterator() {
    return new Doublylinkedlist_Iterator<E>(head, tail);
  }

  public void insertAt(E item, int pos) {
    DoublylinkedlistElem<E> previousNode = head;
    for (int i = 0; i < pos; i++) {
      if (previousNode != null) {
        previousNode = previousNode.succ;
      }
    }
    DoublylinkedlistElem<E> newNode = new DoublylinkedlistElem<E>(item, previousNode.prev, previousNode);
    previousNode.prev.succ = newNode;
    previousNode.prev = newNode;
  }

  public void insertFront(E item) {
    if (head != null) {
      head = new DoublylinkedlistElem<E>(item, null, head);
      head.succ.prev = head;
    } else {
      head = new DoublylinkedlistElem<E>(item, null, null);
      tail = head;
    }
  }

  public void insertBack(E item) {
    if (tail != null) {
      tail = new DoublylinkedlistElem<E>(item, tail, null);
      tail.prev.succ = tail;
    } else {
      tail = new DoublylinkedlistElem<E>(item, null, null);
      head = tail;
    }
  }

  public void removeAt(int pos) {
    DoublylinkedlistElem<E> previousNode = head;
    for (int i = 0; i < pos; i++) {
      if (previousNode != null) {
        previousNode = previousNode.succ;
      }
    }
    previousNode.prev.succ = previousNode.succ;
    previousNode.succ.prev = previousNode.prev;
    previousNode.succ = null;
    previousNode.prev = null;
  }

  public void removeFront() {
    assert head != null;
    DoublylinkedlistElem<E> newHead = head.succ;
    head.succ = null;
    newHead.prev = null;
    head = newHead;
  }

  public void removeBack() {
    assert tail != null;
    DoublylinkedlistElem<E> newTail = tail.prev;
    tail.prev = null;
    newTail.succ = null;
    tail = newTail;
  }
}
