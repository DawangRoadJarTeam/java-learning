package cn.dawangroad.jarteam;

import java.util.function.Function;

/**
 * 命令：
 * cd innerclass/src/main/java/
 * javac cn/dawangroad/jarteam/InnerClass.java
 * javap -verbose cn.dawangroad.jarteam.InnerClass
 */
@SuppressWarnings("unchecked")
public class InnerClass {
    private int j;

    public static void main(String[] args) {

        /**
         * 这些局部变量都没有显式final关键字，编译后字节码会自动添加final关键字，原因见
         * @see InnerClass.function(int k)
         */
        int i = 0;
        int k = 0;
        InnerClass innerClass = new InnerClass();
        /**
         * 匿名内部类
         */
        Function function = new Function<Object, Object>() {

            @Override
            public Object apply(Object o) {
                return i + k + innerClass.j;
            }
        };


        System.out.println(innerClass.function(1).apply(null));
        System.out.println(innerClass.j);
        System.out.println(innerClass.function(2).apply(null));
        System.out.println(innerClass.j);

        /**
         * 父类有构造器的匿名内部类
         */
        innerClass.new SonClass(2) {

            @Override
            void test() {

            }
        };

    }

    public int add(int h) {
        return j + h;
    }

    /**
     * 局部内部类
     *
     * @param k 看似不是final，反编译之后是final
     *          <p>
     *          Java 8语言上的lambda表达式只实现了capture-by-value，也就是说它捕获的局部变量都会拷贝一份到lambda表达式的实体里，然后在lambda表达式里要变也只能变自己的那份拷贝而无法影响外部原本的变量；但是Java语言的设计者又要挂牌坊不明说自己是capture-by-value，为了以后语言能进一步扩展成支持capture-by-reference留下后路，所以现在干脆不允许向捕获的变量赋值，而且可以捕获的也只有“效果上不可变”（effectively final）的参数/局部变量。
     * @link https://www.zhihu.com/question/28190927/answer/39786939
     */
    Function function(int k) {

        class FunctionImpl implements Function<Integer, Integer> {

            @Override
            public Integer apply(Integer o) {
                return k + o;
            }
        }

        return new FunctionImpl();
    }

    /**
     * 这个方法返回的函数对象和外部类的field j可以同时存在，且j相对于函数对象来说是外部的自由变量，所以可以认为此种实现是一种闭包
     */
    Function function() {

        class FunctionImpl implements Function<Integer, Integer> {

            @Override
            public Integer apply(Integer o) {
                j = j + o;
                return j;
            }
        }

        return new FunctionImpl();
    }

    /**
     * 有构造器的父类
     */
    abstract class SonClass {
        public SonClass(int i) {
        }

        abstract void test();
    }
}
