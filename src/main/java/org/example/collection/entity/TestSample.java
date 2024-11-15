package org.example.collection.entity;

import java.util.HashMap;

/***
 * @author Swei
 * @description
 * @date 2024/10/23 18:13
 **/
public class TestSample {

    private String name;

    private Integer age;


    @Override
    public String toString() {
        return this.age.hashCode() + "={name==>" + this.name + ",age==>" + this.age + "]";
    }

    /***
     * 重写构造方法
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/10/23 18:19
     * @return
     */
    public TestSample(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /***
     * 重新生成哈希值
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/10/23 18:15
     * @return int
     */
    @Override
    public int hashCode() {
        return this.age.hashCode();
    }

    /***
     * 重写equal方法
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/10/23 18:15
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TestSample) {
            TestSample sample = (TestSample) obj;
            if (this.age.equals(sample.age)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int getAge() {
        return this.age;
    }
}
