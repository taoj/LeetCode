package Issues;

import java.util.HashMap;
import java.util.Map;

public class Q146 implements IIssueTemplate {

	int _cap;
    int size;
    Map<Integer, Node> map;
    Node head;
    Node tail;
    
    class Node{
        public int key;
        public int value;
        public Node pre;
        public Node next;
        public Node(){}
        public Node(int k, int v){
            key = k;
            value = v;
        }
        
    };
    
    public Q146(int capacity) {
        
        _cap = capacity;
        size = 0;
        map = new HashMap();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
           Node node = map.get(key);
           takeOut(node);
           insertHead(node);
           return node.value;
       }
       return -1;
    }
    
    public void put(int key, int value) {
        if(_cap == 0){
          return;
      }
      
      if(map.containsKey(key)){
          Node node = map.get(key);
          node.value = value;
          takeOut(node);
          insertHead(node);
      }else{
          Node newNode = new Node(key, value);
          map.put(key, newNode);
          if(size < _cap){
              size++;
          }else{
              Node last = tail.pre;
              takeOut(last);
              map.remove(last.key);
          }
            insertHead(newNode);
      }
    }
    
      private void takeOut(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    private void insertHead(Node node){
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }
	@Override
	public void go() {
		put(2,1);
		get(2);
		put(3,2);
		get(2);
		get(3);
	}

}
