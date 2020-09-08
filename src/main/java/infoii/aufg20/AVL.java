package infoii.aufg20;

public class AVL<K extends Comparable<K>, D> implements MyCollection<K, D> {
  protected Node root = null;
  private boolean flag = false; // Hilfsvariable fuer Einfuegen u. Loeschen

  public D find(K key) throws Exception {
    if (root == null)
      throw new Exception("nicht gefunden");
    else
      return root.findNode(key);
  }

  public void insert(K key, D data) {
    if (root == null)
      root = new Node(key, data, null, null, 0);
    else
      root = root.insertNode(key, data);
  }

  public void delete(K key) {
    if (root != null)
      root = root.deleteNode(key);
  }

  public String toString() {
    if (root != null)
      return root.toString("");
    else
      return "Baum ist leer";
  }

  class Node {
    K key;
    D content;
    Node left;
    Node right;
    int balance; // -1, 0, oder 1

    Node(K k, D c, Node l, Node r, int b) {
      key = k;
      content = c;
      left = l;
      right = r;
      balance = b;
    }

    Node insertNode(K k, D d) {
      Node current;
      if (key.compareTo(k) < 0) { // rechts einfuegen
        if (right != null) {
          right = right.insertNode(k, d);
          if (flag)
            switch (balance) {
            case -1:
              balance = 0;
              flag = false;
              return this;
            case 0:
              balance = 1;
              return this;
            // flag bleibt true
            case 1:
              if (right.balance == 1) {
                // Links-Rotation
                current = rotateLeft();
                current.left.balance = 0;
              } else {
                // Rechtslinks-Rotation
                int grandchildBal = right.left.balance;
                right = right.rotateRight();
                current = rotateLeft();
                current.right.balance = (grandchildBal == -1) ? 1 : 0;
                current.left.balance = (grandchildBal == 1) ? -1 : 0;
              }
              current.balance = 0;
              flag = false;
              return current;
            }
          else
            return this;
        } else {
          right = new Node(k, d, null, null, 0);
          balance++;
          flag = (balance >= 1);
          return this;
        }
      } else { // links einfuegen (analog)
        if (left != null) {
          left = left.insertNode(k, d);
          if (flag)
            switch (balance) {
            case 1:
              balance = 0;
              flag = false;
              return this;
            case 0:
              balance = -1;
              return this; // flag bleibt true
            case -1:
              if (left.balance == -1) { // Rechtsrotation
                current = rotateRight();
                current.right.balance = 0;
              } else {
                // Linksrechts-Rotation
                int b = left.right.balance;
                left = left.rotateLeft();
                current = rotateRight();
                current.right.balance = (b == -1) ? 1 : 0;
                current.left.balance = (b == 1) ? -1 : 0;
              }
              current.balance = 0;
              flag = false;
              return current;
            }
          else
            return this;
        } else {
          left = new Node(k, d, null, null, 0);
          balance--;
          flag = (balance <= -1);
          return this;
        }
      }
      return null;
    }

    private Node rotateLeft() {
      Node current = right;
      right = right.left;
      current.left = this;
      return current;
    }

    private Node rotateRight() {
      Node current = left;
      left = left.right;
      current.right = this;
      return current;
    }

    Node deleteNode(K k) {
      if (key.compareTo(k) < 0) {
        if (right != null) {
          right = right.deleteNode(k);
          if (flag)
            return rebalanceRight();
        }
        return this;
      } else if (k.compareTo(key) < 0) {
        if (left != null) {
          left = left.deleteNode(k);
          if (flag)
            return rebalanceLeft();
        }
        return this;
      } else if (left == null) {
        flag = true;
        return right;
      } else if (right == null) {
        flag = true;
        return left;
      } else {
        Node max = left.findMax();
        key = max.key;
        content = max.content;
        left = left.deleteNode(key);
        if (flag)
          return rebalanceLeft();
        return this;
      }
    }

    private Node findMax() {
      if (right == null)
        return this;
      else
        return right.findMax();
    }

    private Node rebalanceRight() {
      switch (balance) {
      case 1:
        balance = 0;
        return this; // flag bleibt true
      case 0:
        balance = -1;
        flag = false;
        return this;
      case -1:
        int childBal = left.balance;
        if (childBal <= 0) {
          Node current = rotateRight();
          if (childBal == 0) {
            current.balance = 1;
            flag = false;
            return current;
          } else {
            balance = 0;
            current.balance = 0;
            return current;
          }
        } //flag bleibt true
        else {
          int b = left.right.balance;
          left = left.rotateLeft();
          Node current = rotateRight();
          current.balance = 0;
          current.left.balance = (b == 1) ? -1 : 0;
          current.right.balance = (b == -1) ? 1 : 0;
          return current;
        }
      } //flag bleibt true
      return null;
    }

    private Node rebalanceLeft() {
      switch (balance) {
      case -1:
        balance = 0;
        return this;
      // flag bleibt true
      case 0:
        balance = 1;
        flag = false;
        return this;
      case 1:
        int childBal = right.balance;
        if (childBal >= 0) {
          Node current = rotateLeft();
          if (childBal == 0) {
            current.balance = -1;
            flag = false;
            return current;
          } else {
            balance = 0;
            current.balance = 0;
            return current;
          }
        } // flag bleibt
        else {
          int b = right.left.balance;
          right = right.rotateRight();
          Node current = rotateLeft();
          current.balance = 0;
          current.right.balance = (b == -1) ? 1 : 0;
          current.left.balance = (b == 1) ? -1 : 0;
          //flag bleibt
          return current;
        }
      }
      return null;
    }

    D findNode(K k) throws Exception {
      if (key.compareTo(k) < 0) {
        if (right == null)
          throw new Exception("nicht gefunden");
        else
          return right.findNode(k);
      } else if (k.compareTo(key) < 0) {
        if (left == null)
          throw new Exception("nicht gefunden");
        else
          return left.findNode(k);
      } else
        return content;
    }

    public String toString(String margin) {
      String newmargin = margin + "  ";
      String result = margin + "(" + key.toString() + "," + content.toString() + ")\n";
      if (left != null)
        result += left.toString(newmargin);
      else
        result += newmargin + "-\n";
      if (right != null)
        result += right.toString(newmargin);
      else
        result += newmargin + "-\n";
      return result;
    }

  } // Ende von class Node

} // Ende von class AVL
