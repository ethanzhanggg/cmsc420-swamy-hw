/**
 * ValleyTraveler class represents a magical map that can identify and modify
 * valley points in the landscape of Numerica.
 * 
 * @author Ethan Zhang
 */
public class ValleyTraveler {
    
    // Create instance variables here.
    Node head;
    Node tail;
    /**
     * Constructor to initialize the magical map with the given landscape of
     * Numerica.
     * 
     * @param landscape An array of distinct integers representing the landscape.
     */
    public ValleyTraveler(int[] landscape) {
        head = new Node(Integer.MAX_VALUE);
        tail = head;
        for (int value : landscape) {
            Node newNode = new Node(value);
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
     * Checks if the entire landscape is excavated (i.e., there are no landforms
     * left).
     * 
     * @return true if the landscape is empty, false otherwise.
     */
    public boolean isEmpty() {
        // TODO: Implement the isEmpty method.
        return head.next == null;
    }

    /**
     * Locates the first valley point in the landscape of Numerica.
     * 
     * @return The first valley point in the landscape.
     */
    public int getFirst() {
       return this.getNodeBeforeFirstLocation().next.value;
    }
    public Node getNodeBeforeFirstLocation(){
        Node first = head;
        Node second = head.next;
        while (second != tail){
            if (second.value < second.next.value)
                return first;
            first = first.next;
            second = second.next;
        }
        return first;
    }
    /**
     * Excavates the first valley point, removing it from the landscape of Numerica.
     * 
     * @return The excavated valley point.
     */
    public int remove() {
        Node pointer = this.getNodeBeforeFirstLocation();
        Node output = pointer.next;
        if (output == tail)
            tail = pointer;
        pointer.next = output.next;
        return output.value;
    }

    /**
     * Creates a new landform at the first valley point.
     * 
     * @param num The height of the new landform.
     */
    public void insert(int height) {
        //Case where its empty
        if (head == tail) {
            head.next = new Node(height);
            tail = head.next;
            return;
        }
        Node temp = new Node(height);
        Node pointer = this.getNodeBeforeFirstLocation();
        temp.next = pointer.next;
        pointer.next = temp;
        
    }

    public class Node {
        int value;
        Node next;
    
        public Node(int x){
            value = x; 
            next = null;
        }
    }
}