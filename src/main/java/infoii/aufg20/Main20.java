package infoii.aufg20;

public class Main20 {
  public static void main(String[] args) {
    GewichtSuchbaum<Integer, String> baum = new GewichtSuchbaum<Integer, String>((float) 0.25, (float) 0.75);
    baum.insert(14, "Sam");
    baum.insert(18, "Max");
    baum.insert(11, "Ian");
    System.out.println(baum.toString());
    baum.insert(9, "Tom");
    System.out.println(baum.toString());
    baum.insert(13, "Han");
    baum.insert(5, "Tim");
    baum.insert(10, "Jay");
    baum.insert(4, "May");
    System.out.println(baum.toString());
  }
}