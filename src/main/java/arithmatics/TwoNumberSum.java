package arithmatics;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author dengmingliang
 * @Description
 * @ClassName TwoNumberSum
 * @Date 2019/11/28 11:26 上午
 */
public class TwoNumberSum {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int value){
            val = value;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = null;
        ListNode result = newNode;
        int left = 0;
        while(l1!=null&&l2!=null){
            int now = l1.val+l2.val;
            now +=left;
            if(newNode==null){
                newNode = new ListNode(now%10);
                left = now/10;
                // continue;
            }else if(left>0){
                newNode.next  = new ListNode(now%10);
                left = now>9?1:0;
            }
            newNode = newNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        //
        while(l1!=null){
            int now = left+l1.val;
            if(now<10){
                newNode.next = l1;
                break;
            }
            newNode.next = new ListNode(now%10);
            newNode = newNode.next;
            left = 1;
            l1 = l1.next;
        }
        while(l2!=null){
            int now = left+l2.val;
            if(now<10){
                newNode.next = l2;
                break;
            }
            newNode.next = new ListNode(now%10);
            newNode = newNode.next;
            left = 1;
            l2 = l2.next;
        }
        return result;
    }

    public static void main(String[] args) {
        TwoNumberSum twoNumberSum = new TwoNumberSum();
        ListNode head = twoNumberSum.new ListNode(1);
        ListNode head2 = head;
        for(int i =0;i<5;i++){
            head.next = twoNumberSum.new ListNode(i);
            head = head.next;
        }
//        ListNode node = twoNumberSum.ReverseList(head2);
        twoNumberSum.Merge(head2,head2);
        LinkedList<Integer> t = new LinkedList();
        t.remove();
//        System.out.println(node.val);
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        List<String> movies =
                new ArrayList<>(
                        Arrays.asList(
                                "Forrest Gump",
                                "Titanic",
                                "Spirited Away",
                                "The Shawshank Redemption",
                                "Zootopia",
                                "Farewell ",
                                "Joker",
                                "Crawl"));
        List<String> results =
                movies.stream().filter(movie -> movie.startsWith("/")).collect(Collectors.toList());
        int length = array.length;
        HashMap<Integer,Integer> numberCount = new HashMap();
        for(int i=0;i<length;i++){
            int index = array[i];
            int count = numberCount.get(index);
            count = (count==0)?1:count+1;
            if(count>length/2){
                return index;
            }
            numberCount.put(index,count);
        }
        return 0;
    }

    public ListNode FindKthToTail(ListNode head,int k) {
//        ListNode node = new ;
//        recurse(head,k,node);
//        return node;
        return null;
    }

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA==null||popA==null){return false;}
        if(pushA.length!=popA.length){return false;}
        Stack<Integer> stack = new Stack();
        int j = 0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while(j<popA.length&&stack.peek()==popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.empty()?true:false;

    }

    public int recurse(ListNode node, int k,ListNode toOut){
        if(node.next==null){
            if(k==1){
                toOut.val = node.val;
            }
            return 1;
        }
        int result = recurse(node.next,k,toOut)+1;
        if(result == k){
            toOut = new ListNode(node.val);
        }
        return result;
    }

    public ListNode ReverseList(ListNode head) {
        ListNode root = new ListNode(0);
        reverse2(head,root);
        return root.next;
    }

    public ListNode reverse2(ListNode head,ListNode node){
        if(head.next==null){
            node.next = head;
            node = node.next;
            return node;
        }
        node = reverse2(head.next,node);
        node.next = head;
        return head;
    }




    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null)return list2;
        if(list2==null)return list1;
        ListNode root = new ListNode(0);
        ListNode result = root;
        while(list1!=null&&list2!=null){
            if(list1.val>list2.val){
                root.next = new ListNode(list2.val);
                list2 = list2.next;
            }else{
                root.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            root = root.next;
        }
        while(list1!=null){
            root.next = list1;
        }
        while(list2!=null){
            root.next = list2;
        }
        return result.next;
    }





}
