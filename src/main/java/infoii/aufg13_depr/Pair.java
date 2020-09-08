package infoii.aufg13_depr;

public class Pair<T1, T2> {
  protected T1 fst;
  protected T2 snd;

  public Pair(T1 x, T2 y) {
    fst = x;
    snd = y;
  }

  public T1 getFirst() {
    return fst;
  }

  public T2 getSecond() {
    return snd;
  }

  public String toString() {
    return "Pair(" + fst + "," + snd + ")";
  }
}
