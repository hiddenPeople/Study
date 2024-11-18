package org.example.lambda;

import java.util.Random;
import java.util.function.Function;

/***
 *
 *
 * @author Swei
 * @description
 * @date 2024/11/15 16:00
 **/
public class FunctionSample {
    /***
     * 在数字和字母中随机生成指定长度的字符串
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/11/15 16:08
     * @return void
     */
    public static void main(String[] args) {
        Function<Integer, String> function = i -> {
            String source = "abcdefghijklmnopjrstuvwxyz0123456789";
            StringBuffer sb = new StringBuffer();
            Random random = new Random();
            for (int j = 0; j < i; j++) {
                int position = random.nextInt(source.length());
                sb.append(source.charAt(position));
            }
            return sb.toString();
        };
        String result = function.apply(10);
        System.out.println(result);
    }
}
