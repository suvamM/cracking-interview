class Node
{
    private int data;
    private Node next;

    public Node (int data, Node next)
    {
        this.data = data;
        this.next = next;
    }

    public void setNext (Node n)
    {
        this.next = n;
    }

    public Node getNext ()
    {
        return this.next;
    }

    public void setData (int x)
    {
        this.data = x;
    }

    public int getData ()
    {
        return this.data;
    }
}
