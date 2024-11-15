package org.example.singleton;

/***
 *  饿汉式单例
 *
 * @author Swei
 * @description
 * @date 2024/10/25 14:31
 **/
public class SingletonOne {

    /***
     * 创建静态该类的实例对象
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/10/25 14:37
     * @return
     */
    private static SingletonOne instance = new SingletonOne();

    /**
     * 创建私有的构造方法
     *
     * @param
     * @return
     * @description
     * @author Swei
     * @date 2024/10/25 14:35
     */
    private SingletonOne() {

    }

    /***
     * 创建公有静态方法提供给实例对象
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/10/25 14:36
     * @return org.example.singleton.SingletonOne
     */
    public static SingletonOne getInstance() {
        return instance;
    }
}
