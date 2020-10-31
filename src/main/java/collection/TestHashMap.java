package collection;

import java.util.*;

/**
 * @author dengmingliang
 * @Description
 * @ClassName TestHashMap
 * @Date 2019/11/28 10:39 上午
 */
public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String,String> test = new HashMap<>();
        test.put("t1","1");
        test.put("t2","1");
        test.put("t3","1");
        test.put("t4","1");
        Iterator iterator = test.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
//        new String[]{}
        for(Map.Entry entry: test.entrySet()){
//            test.put("test","");
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        Set i = test.keySet();
        Iterator iterator1 = i.iterator();
        while(iterator1.hasNext()){
             String key = (String) iterator1.next();
            System.out.println(key);
        }

        Collection i2 = test.values();
        Iterator i3 = i2.iterator();
        while(i3.hasNext()){
            String key = (String) i3.next();
            System.out.println(key);
        }

//        test.entrySet().forEach(k);
    }
}
