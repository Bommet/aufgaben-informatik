package infoii.aufg12;

import java.util.NoSuchElementException;
import aufg12.Doublylinkedlist.DoublylinkedlistElem;

public class Doublylinkedlist_Iterator<E> {

  protected DoublylinkedlistElem<E> current;
  protected DoublylinkedlistElem<E> first;
  protected DoublylinkedlistElem<E> last;

  public Doublylinkedlist_Iterator(DoublylinkedlistElem<E> head, DoublylinkedlistElem<E> tail) {
    current = head;
    first = head;
    last = tail;
  }

  public boolean hasNext() {
    return (current != null) && (!current.equals(last.succ));
  }

  public boolean hasPrevious() {
    return (current != null) && (!current.equals(first.prev));
  }

  public E next() throws NoSuchElementException {
    assert current != null;
    E value = current.content;
    current = current.succ;
    return value;
  }

  public E previous() throws NoSuchElementException {
    assert current != null;
    E value = current.content;
    current = current.prev;
    return value;
  }
}