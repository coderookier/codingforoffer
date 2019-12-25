package designpattern;

/**
 * @author gutongxue
 * @date 2019/12/25 19:37
 * 单例模式
 **/
public class Singleton {

    //volatile关键字保证uniqueInstance被初始化为Singleton实例对象时，多个线程可以正确处理uniqueIntance
    private static volatile Singleton uniqueInstance;

    //私有化构造函数保证用户不能通过new创建实例对象
    private Singleton() {

    }

    /**
     * 获取唯一的实例
     */
    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            //uniqueInstance不为空时则加synchronized锁保证线程安全，创建实例
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
