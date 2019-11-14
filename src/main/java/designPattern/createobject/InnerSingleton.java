package designPattern.createobject;

/**
 * ��̬�ڲ���ʵ�ֵ���ģʽ
 *
 * �ӳٳ�ʼ���ĺô��������� JVM �ṩ�˶��̰߳�ȫ��֧�֡�
 */
public class InnerSingleton {

    private  InnerSingleton(){}

    private static class InnerClass{
        private static final InnerSingleton instance = new InnerSingleton();
    }

    public InnerSingleton getInstance(){
        return InnerClass.instance;
    }

}
