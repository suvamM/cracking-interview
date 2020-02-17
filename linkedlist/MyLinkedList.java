class MyLinkedList
{
    Node head;

    public MyLinkedList ()
    {
        head = null;
    }

    public MyLinkedList (int x)
    {
        head = new Node(x, null);
    }

    // Insert an element at head of list
    public void insertAtHead (int x)
    {
        Node n = new Node (x, null);
        if (head == null)
        {
            head = n;
            return;
        }
        n.setNext(head);
        head = n;
    }

    // Insert an element at tail of list
    public void insertAtTail (int x)
    {
        if (head == null)
        {
            insertAtHead(x);
        }
        else
        {
            Node n = head;

            while (n.getNext() != null)
            {
                n = n.getNext();
            }

            Node temp = new Node (x, null);
            n.setNext(temp);
        }
    }

    public void printList ()
    {
        if (head == null)
        {
            System.out.println("List empty!");
        }
        else
        {
            Node n = head;

            while (n != null)
            {
                System.out.print(n.getData() + " --> ");
                n = n.getNext();
            }

            System.out.print("null");
            System.out.println("");
        }
    }

    public void reverseList ()
    {
        Node prev = null;
        Node curr = this.head;
        Node next = null;

        while (curr != null)
        {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }

        this.head = prev;
    }
}