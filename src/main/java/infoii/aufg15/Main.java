package infoii.aufg15;

public class Main {
  public static void main(String[] args) {
    InhomogenerSuchbaum<Integer, String> tree = new InhomogenerSuchbaum<Integer, String>();
    tree.insert(42, "Sam");
    tree.insert(72, "Jim");
    tree.insert(16, "Bob");
    System.out.println(tree.toString());
    tree.delete(72);
    tree.insert(72, "Jim");
    System.out.println(tree.toString());
    try {
      System.out.println(tree.find(42));
      System.out.println(tree.find(72));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    tree.delete(16);
    System.out.println(tree.toString());
  }
}