package cn.dawangroad.jarteam.initialorder;

/**
 * @author ervin
 * @version 2018-05-24 16:22
 */
public class ParentSonInitOrderTest {
    static class Parent {
        /* 静态变量 */
        public static String p_StaticField = "父类--静态变量";

        /* 静态初始化块 */
        static {
            System.out.println(p_StaticField);
            System.out.println("父类--静态初始化块");
        }

        /* 变量 */
        public String p_Field = "父类--变量";
        protected int i = 9;
        protected int j = 0;

        /* 初始化块 */ {
            System.out.println(p_Field);
            System.out.println("父类--初始化块");
        }

        /* 构造器 */
        public Parent() {
            System.out.println("父类--构造器");
            System.out.println("i=" + i + ", j=" + j);
            j = 20;
        }
    }

    static class SubClass extends Parent {
        /* 静态变量 */
        public static String s_StaticField = "子类--静态变量";
        public static SubClass instant;

        /* 静态初始化块 */
        static {
            System.out.println(s_StaticField);
            System.out.println("子类--静态初始化块");
        }

//        static {
//            System.out.println("子类--before construct");
////            instant = new SubClass();
////            instant.task();
//            System.out.println("子类--after construct");
//        }

        /* 变量 */
        public String s_Field = "子类--变量";

        /* 初始化块 */ {
            System.out.println(s_Field);
            System.out.println("子类--初始化块");
        }

        /* 构造器 */
        public SubClass() {
            System.out.println("子类--构造器");
            System.out.println("i=" + i++ + ",j=" + j++);
        }

        /* 程序入口 */
        public static void main(String[] args) {
            System.out.println("子类main方法");
            new SubClass();
        }

        public SubClass task() {
            System.out.println("task: i=" + i + ",j=" + j);
            return this;
        }
    }
}
