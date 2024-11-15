package org.example.reflect.i18n;

import cn.hutool.core.util.StrUtil;
import org.example.reflect.i18n.language.ChineseLanguage;

import java.io.IOException;
import java.lang.reflect.*;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.Properties;

/***
 * java中的反射（reflect）机制
 *
 * @author Swei
 * @description
 * @date 2024/11/14 09:57
 **/
public class I18nApplication {
    public static void main(String[] args) {
        Properties properties = new Properties();
//        获取properties文件地址
        String configPath = Objects.requireNonNull(I18nApplication.class.getResource("/i18n-config.properties")).getPath();
        if (StrUtil.hasBlank(configPath)) {
            return;
        }
//        处理路径中的空格等转义
        configPath = URLDecoder.decode(configPath);
        try {
            properties.load(Files.newInputStream(Paths.get(configPath)));
            String language = properties.getProperty("language");
//            获取ChineseLanguage类
            Class languageClass = Class.forName(language);
//            利用无参构造函数反射创建构造对象
            I18n i18n = (I18n) languageClass.newInstance();
//            获取有参构造函数
            Constructor constructor = languageClass.getConstructor(Integer.class, String.class);
//            利用无参构造函数反射创建构造对象
            ChineseLanguage chineseLanguage = (ChineseLanguage) constructor.newInstance(18, "男");
//            利用反射获取类中getMessage方法（必须是public修饰）
            Method method = languageClass.getMethod("getMessage");
//            执行getMessage方法
            System.out.println(method.invoke(chineseLanguage, new Object[]{}));
//            利用反射回去类中所有字段，必须是Public修饰
            Field[] fileds = languageClass.getFields();
            for (Field field : fileds) {
//                利用反射为字段赋值
                field.set(i18n, 30);
//                field.set("age", 20);
            }
//            获取所有构造函数（public,private都有）
            Constructor<?>[] constructors = languageClass.getDeclaredConstructors();
            if (constructors.length > 0) {
                Arrays.stream(constructors).forEach(s -> {
//                    判断当前构造函数是否为public
                    if (s.getModifiers() == Modifier.PUBLIC) {
                        System.out.println("public Constructor==>" + s.getName());
                    } else if (s.getModifiers() == Modifier.PRIVATE) {
                        System.out.println("private Constructor==>" + s.getName());
                    }
                });
            }

//            获取所有方法（public,private都有）
            Method[] declaredMethods = languageClass.getDeclaredMethods();
            if (declaredMethods.length > 0) {
                Arrays.stream(declaredMethods).forEach(m -> {
                    if (m.getModifiers() == Modifier.PUBLIC) {
                        System.out.println("public Method==>" + m.getName());
                    } else if (m.getModifiers() == Modifier.PRIVATE) {
                        System.out.println("private Method==>" + m.getName());
                    }
                });
            }

//            获取所有成员属性（public,private都有）
            Field[] declaredFields = languageClass.getDeclaredFields();
            Arrays.stream(declaredFields).forEach(f -> {
                if (f.getModifiers() == Modifier.PUBLIC) {
                    System.out.println("public Filed==>" + f.getName());
                } else if (f.getModifiers() == Modifier.PRIVATE) {
                    System.out.println("private Filed==>" + f.getName());
                    try {
                        Method privateMethod = languageClass.getMethod("get" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1));
                        System.out.println(privateMethod.invoke(chineseLanguage, new Object[]{}));
                    } catch (NoSuchMethodException e) {
//                        没有找对应的方法报错
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
//                        执行方法报错
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
//                        非法访问异常，当在作用域外访问对象方法或成员变量时报错
                        throw new RuntimeException(e);
                    }
                }
            });


        } catch (IOException | ClassNotFoundException e) {
//            IOE流异常，读取文件异常
//            类名与类路径书写错误抛出的“类无法找到"”异常
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
//            对象无法被实例化异常
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
//            非法访问异常，当在作用域外访问对象方法或成员变量时报错
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
//            没有找对应的方法报错
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
//            执行方法报错
            throw new RuntimeException(e);
        }

    }
}
