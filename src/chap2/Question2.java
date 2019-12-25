package chap2;

/**
 * @author gutongxue
 * @date 2019/12/25 16:57
 * 实现一个单例模式
 **/
public class Question2 {
    private static Question2 uniqueInstance;
    //私有化构造函数，确保用户无法通过new获得实例对象
    private Question2() {

    }

    //方法加锁确保线程安全
    private static synchronized Question2 getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Question2();
        }
        return uniqueInstance;
    }

    /**
     * 重量级锁synchronized直接放在getInstance()方法上，性能下降
     */
}
