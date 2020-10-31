package dataStructure;

import java.util.Stack;

/**
 * @author dengmingliang
 * @Description
 * @ClassName StackQueue
 * @Date 2019/12/7 4:12 下午
 */
public class StackQueue {


    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (stack2.size() > 0) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while (stack1.peek() != null) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }

    public int NumberOf1(int n) {
        int count = 0;
        if(n<0&&n%2==0&&n!=Integer.MIN_VALUE) count++;
        while (n != 0) {
            System.out.println(n%2);
            if ((n % 2) != 0) {

                System.out.println(count+"count++");
                count++;
            }
            System.out.println(Integer.toBinaryString(n));
            n = n >>> 1;
        }

        return count;
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
//        System.out.println(stackQueue.NumberOf1(-2147483648));
        System.out.println(stackQueue.NumberOf1(-1));

    }



    public void reOrderArray(int [] array) {
        int[] copyArray = new int[array.length];
        int i=0,j=0;
        for(;i<array.length;i++){
            int ox = 0;
            if(array[i]%2==0){
                ox = array[i];
                for(;j<array.length;j--){
                    if(array[j]%2==1){
                        array[i] = array[j];
                        array[j] = ox;
                        continue;
                    }
                }
            }

        }
    }

}
