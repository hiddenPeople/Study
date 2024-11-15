package org.example.singleton;

/***
 * 懒汉式单例
 *
 * @author Swei
 * @description
 * @date 2024/10/25 14:41
 **/
public class SingletonTwo {

    /***
     * 创建静态该类的对象
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/10/25 14:41
     * @return
     */
    private static SingletonTwo instance;

    /***
     * 创建私有的构造方法
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/10/25 14:42
     * @return
     */
    private SingletonTwo() {
    }

    /***
     * 提供公有的获取该实例化对象的方法
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/10/25 14:42
     * @return
     */
    public static SingletonTwo getInstance() {
        if (instance == null) {
            //增加锁保护线程安全
            synchronized (SingletonTwo.class) {
                if (instance == null) {
                    instance = new SingletonTwo();
                }
            }
        }
        return instance;
    }
}
