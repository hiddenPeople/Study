package org.example.reflect.i18n.language;

import org.example.reflect.i18n.I18n;

/***
 *
 *
 * @author Swei
 * @description
 * @date 2024/11/14 09:49
 **/
public class ChineseLanguage implements I18n {

    public Integer age = 18;

    private String sex;

    /***
     * 无参构造方法
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/14 09:55
     * @return
     */
    public ChineseLanguage() {

    }

    /***
     * 有参构造方法
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/14 09:56
     * @return
     */
    public ChineseLanguage(Integer age, String sex) {
        this.age = age;
        this.setSex(sex);
    }

    @Override
    public String getMessage() {
        this.consoleSelf();
        return "我是中国话";
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private void consoleSelf() {
        System.out.println("🇨🇳🇨🇳🇨🇳🇨🇳🇨🇳🇨🇳🇨🇳🇨🇳🇨🇳🇨🇳🇨🇳🇨🇳🇨🇳🇨🇳🇨🇳🇨🇳🇨🇳🇨🇳");
    }
}
