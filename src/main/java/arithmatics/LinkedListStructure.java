package arithmatics;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author dengmingliang
 * @Description
 * @ClassName LinkedListStructure
 * @Date 2019/12/11 12:09 下午
 */
public class LinkedListStructure {


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public Object getNodeOfReIndex(ListNode list, int i) {
        return getTheExpect(list, i);
    }

    private Map<Integer, Object> getTheExpect(ListNode list, int i) {
        if (list.next == null) {
            HashMap map = new HashMap<>();
            map.put(1,list.val);
            return map;
        }


        Integer expect = new Integer(0);
        getTheExpect(list, expect);
//        if (i) return null;
        return null;
    }


}
