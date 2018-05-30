package cn.dawangroad.jarteam;

/**
 * @author ervin
 * @version 2018-05-24 16:15
 */
public class InitialOrderTest {
    static {
        System.out.println("1. 静态初始化块");
    }
    /* 静态变量 */
    public static String staticField = "静态变量";

    /* 静态初始化块 */
    static {
        System.out.println(staticField);
        System.out.println("静态初始化块");
    }

    {
        System.out.println("1. 初始化块");
    }

    /* 变量 */
    public String field = "变量";

    /* 初始化块 */ {
        System.out.println(field);
        System.out.println("初始化块");
    }

    /* 构造器 */
    public InitialOrderTest() {
        System.out.println("构造器");
    }


    public static void main(String[] args) {
        new InitialOrderTest();
    }
}
