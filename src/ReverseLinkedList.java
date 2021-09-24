
import java.util.Stack;
/*
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 */
public class ReverseLinkedList {
    public static void main(String args[]){
        Reverse reverse = new Reverse();
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        head.next=one;
        reverse.reverseBetween(head,1,2);
    }
}
class Reverse{
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            // special case no reversing required
            return head;
        }
        ListNode head_p =head;
        ListNode start = new ListNode();
        ListNode end = new ListNode();
        ListNode prev_start = new ListNode();
        ListNode prev = new ListNode();
        boolean start_node=false;
        boolean end_node =false;
        int count =0;
        int count_start =1;
        int count_end =1;

        while (head!=null && (!start_node || !end_node)){
            // get the start & end node values.
            if(start_node){
                count++;
            }
            if(count_start == left){
                start =head;
                start_node =true;
                prev_start = prev;
            }
            if(count_end == right){
                end=head;
                end_node=true;
            }
            prev =head;
            head =head.next;
            count_start++;
            count_end++;


        }
        Stack<ListNode> stack = new Stack<>();
        ListNode start_p =start;
        ListNode end_p =end;
        ListNode end_next = end.next;
        while(count!=0){
            stack.push(start);
            start =start.next;
            count--;
        }
        // Perform the swap until stack is empty
        if(prev_start.next !=null){
            prev_start.next=end;
        }
        while(!stack.empty()){
            end.next =stack.pop();
            end = end.next;
        }
        end.next =end_next;
        if(prev_start.next!=null){
            return  head_p;
        }else{
            return end_p;
        }
    }
}
class ListNode{
    int value;
    ListNode next;
    ListNode(){

    }
    ListNode(int value){
        this.value =value;
        this.next=null;
    }
    ListNode(int val, ListNode next) { this.value = val; this.next = next; }

}
