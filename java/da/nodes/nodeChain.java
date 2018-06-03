public class nodeChain{
    public static class Node{
        public int value;
        public Node next;
    }
    public static  void main(String[] args){
            Node first = new Node();
            first.value = 4;
            Node middle = new Node();
            first.next= middle;
            middle.value = 5;
            Node last = new Node();
            last.value = 8;
            middle.next = last;
            PrintList(first);
        }
    private static void PrintList(Node node){
        while(node !=null){
               System.out.println(node.value);
              node = node.next;
        }
    }

}