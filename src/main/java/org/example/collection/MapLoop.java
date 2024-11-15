package org.example.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/****
 * 关于Map的遍历方式
 *
 * @description
 * @param
 * @author Swei
 * @date 2024/10/23 18:52
 * @return
 */
public class MapLoop {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Swei");
        map.put("age", 18);
        map.put("sex", "男");
        MapLoop loop = new MapLoop();
        loop.doForLoop(map);
    }

    /***
     * 普通的for循环
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/10/23 18:49
     * @return void
     */
    private void doForLoop(Map<String, Object> map) {
        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
    }

    /***
     * 利用forEach循环
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/10/23 18:49
     * @return void
     */
    private void doForeachLoop(Map<String, Object> map) {
        map.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
    }

    /***
     * 利用迭代器循环
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/10/23 18:49
     * @return void
     */
    private void doIteratorLoop(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
