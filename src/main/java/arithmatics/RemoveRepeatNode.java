package arithmatics;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mingliangdeng
 * @date: 2021/3/23
 */
public class RemoveRepeatNode {

  @AllArgsConstructor
  public static class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int value) {
      this.val = value;
    }
  }

  public static void main(String[] args) {
    ListNode root = new ListNode(0);
    ListNode current = root.next = new ListNode(0);
    current = current.next = new ListNode(1);
    current = current.next = new ListNode(2);
    current = current.next = new ListNode(3);
    current = current.next = new ListNode(3);
    ListNode res = removeRepeatNode2(root);
    while (res != null) {
      System.out.println(res.val);
      res = res.next;
    }
  }

  public ListNode removeRepeatNode1(ListNode head) {
    if (head == null) {
      return head;
    }
    Map<Integer, Integer> nodeValueCountMap = new HashMap<>();
    ListNode toRepeat = head;
    while (head != null) {
      nodeValueCountMap.compute(head.val, (k, v) -> v == null ? 1 : v + 1);
      head = head.next;
    }
    ListNode result = null;
    ListNode currentNode = null;
    while (toRepeat != null) {
      if (nodeValueCountMap.get(toRepeat.val) == 1) {
        if (currentNode == null) {
          currentNode = toRepeat;
          result = currentNode;
        } else {
          currentNode.next = toRepeat;
        }
      }
      toRepeat = toRepeat.next;
    }
    return result;
  }

  public static ListNode removeRepeatNode2(ListNode head) {
    ListNode result = new ListNode(-1, null);
    ListNode slowPointer = result;
    while (head != null) {
      while (head != null && head.next != null && head.val == head.next.val) {
        head = head.next.next;
      }
      if (head != null) {
        slowPointer.next = head;
        slowPointer = slowPointer.next;
        head = head.next;
      }
    }
    return result.next;
  }

  public static ListNode delete(ListNode head) {
    ListNode pre = new ListNode(-1, null);
    pre.next = head;
    ListNode first = pre;
    ListNode second = pre.next;
    while (second != null) {
      while (second.next != null && second.val == second.next.val) {
        second = second.next;
      }
      if (first.next == second) {
        first = second;
      } else {
        first.next = second.next;
      }
      second = second.next;
    }
    return pre.next;
  }
}
