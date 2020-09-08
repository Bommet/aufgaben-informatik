package infoii.aufg12;

public class Main12 {
  public static void main(String[] args) {
    Doublylinkedlist<Integer> myList = new Doublylinkedlist<Integer>();
    myList.insertFront(1);
    myList.insertFront(2);
    myList.insertBack(4);
    myList.insertBack(3);
    myList.insertAt(5, 2);
    printMyList(myList);
    myList.removeFront();
    myList.removeBack();
    myList.removeAt(1);
    myList.insertAt(5, 1);
    myList.insertBack(3);
    myList.insertFront(2);
    printMyList(myList);
  }

  public static void printMyList(Doublylinkedlist<Integer> list) {
    Doublylinkedlist_Iterator<Integer> listIterator = list.getIterator();
    while (listIterator.hasNext()) {
      System.out.println(listIterator.next());
    }
  }

  public static void printMyListBack(Doublylinkedlist<Integer> list) {
    Doublylinkedlist_Iterator<Integer> listIterator = list.getIterator();
    listIterator.next();
    listIterator.next();
    listIterator.next();
    listIterator.next();
    while (listIterator.hasPrevious()) {
      System.out.println(listIterator.previous());
    }
  }
}