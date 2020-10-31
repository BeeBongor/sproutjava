package dataStructure;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author dengmingliang
 * @Description
 * @ClassName MyStack
 * @Date 2019/11/28 5:21 下午
 */
public class MyStack<T> {

    T[] elements ;

    int index;

    int size;

    public MyStack(Class<T> type) {
        rebuild(type);
//        index = 0;
        size = 0;
    }

    private void rebuild(Class<T> type) {


        elements = (T[]) Array.newInstance(type, 10);;
    }

    /**
     * 使用但不出栈
     * @return
     */
    public Object peek() {
        return elements[size];
    }

    public T[] push(T element) {
        if((size+1)==elements.length){
            elements = Arrays.copyOf(elements,elements.length+elements.length>>>1);
        }
//        Array.newInstance()
        elements[++size]=element;
        return elements;
    }


    public T pop() {
        if(size==0){
            return null;
        }
        T result = elements[size];
        elements[size--] = null;
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size<=0;
    }


    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack(Integer.TYPE);
//        for()
    }


}
