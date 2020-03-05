package ca.bcit.comp2522.quizzes.quiz04;

/**
 * @author Chloe Glave A01166947
 * @author Clint Fernandes A01182058
 * @version 2020
 */
public class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    public Node findTail(Node current) {
        if (current.getNext() == null) {
            return current;
        }
        return findTail(current.getNext());
    }

    public void append(Node newNode) {
        Node lastNode = findTail(head);
        lastNode.setNext(newNode);
    }

    public void prepend(Node newNode) {
        newNode.setNext(head);
        head = newNode;
    }

    public int findEqualNodes(Node current, Object dataToCompare, int count) {
        if (current.getData().equals(dataToCompare)) {
            count++;
        }
        if (current.getNext() == null) { // base case
            return count;
        }
        return findEqualNodes(current.getNext(), dataToCompare, count);
    }

    public int count(Object o) throws IllegalArgumentException, EmptyListException {
        if (o == null) {
            throw new IllegalArgumentException("No object found!");
        } else if (head.getNext() == null) { // list is empty
            throw new EmptyListException("The list is empty!");
        }
        int count = 0;
        return findEqualNodes(head, o, count);
    }

    public static void main(String[] args) {
        String data = "hi";
        Node head = new Node(data);
        Node shoulders = new Node(data);
        LinkedList list = new LinkedList();
        list.append(head);
        list.append(shoulders);
        try {
            System.out.println(list.count(data));
        } catch (EmptyListException | IllegalArgumentException ele) {
            System.out.println("oh no");
        }
    }
}
