package Arithmatic;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author dengmingliang
 * @Description
 * @ClassName SubArray
 * @Date 2019/11/27 11:01 下午
 */
public class SubArray {


    /**
     * 暴力拆解
     * @param A
     * @param K
     * @return
     */
    @Test
    public int subarraysWithKDistinct(int[] A, int K) {
        if(K<0||A==null||A.length==0){
            return 0;
        }
        int size = A.length;
        int count = 0;
        int distinctNumberSubArray = 0;
        for(int i=0;i<A.length;i++){
            int j = i;
            Set<Integer> distinctNumbers = new HashSet<>();
            while(distinctNumbers.size()<=K){
                distinctNumbers.add(A[j]);
                if(distinctNumbers.size()==K){
                    distinctNumberSubArray++;
                }
                j++;
                if(j>=A.length){
                    distinctNumbers = new HashSet<>();
                    break;
                }
            }
        }
        return distinctNumberSubArray;
    }


    /**
     * 一遍
     * @param A
     * @param K
     * @return
     */
    public int subarraysWithKDistinct2(int[] A, int K) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        boolean stopj = false;
        for (int i = 0, j = 0; i < A.length && j < A.length; ) {
            if (!stopj) {
                map.compute(A[j], (key, v) -> v == null ? 1 : v + 1);
            }
            int num = map.size();
            if (num == K) {
                count++;
                int k = j + 1;
                while (k < A.length && map.containsKey(A[k])) {
                    count++;
                    k++;
                }

                map.compute(A[i], (key, v) -> v == null ? 0 : v - 1);
                if (map.get(A[i]) == 0) {
                    map.remove(A[i]);
                }
                i++;
                stopj = true;
            } else {
                stopj = false;
                j++;
            }
        }
        return count;
    }
}
