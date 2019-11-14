package designPattern.createobject;

/**
 * �����ص���ģʽ��
 * ע��synchronized������
 * ��volatile�ؼ��ֵ�����
 */
public class Singleton {


    private volatile Singleton singleton;

    private Singleton(){

    }

    public Singleton getSingleton(){
        if(singleton==null){
            synchronized(Singleton.class){
                if(singleton ==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
