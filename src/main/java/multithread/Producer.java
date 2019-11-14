package multithread;

import java.util.Random;

public class Producer extends Thread {

    MyStack myStack;

    String producerName;

    public Producer(MyStack myStack1, String name) {
        super(name);
        this.myStack = myStack1;

        this.producerName = name;
    }

    @Override
    public void run() {
        while (true) {
            String produce = getRandomString(5);
            System.out.println(producerName + "ѹ��:" + produce);
            myStack.push(produce);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }

    //length�û�Ҫ������ַ����ĳ���
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
