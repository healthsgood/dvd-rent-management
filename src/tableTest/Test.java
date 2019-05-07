package tableTest;

import java.util.Arrays;

/**
 * @author HaoKangkang healthhealthgood@gmail.com
 * @version 2019-05-0716:57
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println("aa\ta");
//        System.out.println("aba\ta");
//        System.out.println("abda\ta");
//        System.out.println("abcda\ta");
//        System.out.println("测\ta");
//        System.out.println("测试\ta");
//        System.out.println("测试类\ta");
//        System.out.println("测试对象\ta");

        String string = "一二，四五六；八？十";
//        String string = "一二三四五六七八九十";
        String[] split = string.split("");
        for (String s :
                split) {
            if(s.getBytes().length > 1){
                System.out.println(s + "  " + s.getBytes().length);
            }
        }


    }
}
