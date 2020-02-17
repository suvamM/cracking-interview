public class Driver
{
    public static void main(String[] args)
    {
        MyLinkedList list = new MyLinkedList();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);

        list.printList();

        list.reverseList();

        list.printList();
    }
}