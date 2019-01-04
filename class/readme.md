# 类初始化顺序

## 试验

### 普通类初始化

##### 代码
```
package ervin.me;

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

```
##### 输出
```
1. 静态初始化块
静态变量
静态初始化块
1. 初始化块
变量
初始化块
构造器
``` 

### 父子类初始化
##### 代码
```
package ervin.me;

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

        static {
            System.out.println("子类--before construct");
            instant = new SubClass();
            instant.task();
            System.out.println("子类--after construct");
        }

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
            SubClass instant = SubClass.instant;
        }

        public SubClass task() {
            System.out.println("task: i=" + i + ",j=" + j);
            return this;
        }
    }
}

```
##### 输出
```
父类--静态变量
父类--静态初始化块
子类--静态变量
子类--静态初始化块
子类--before construct
父类--变量
父类--初始化块
父类--构造器
i=9, j=0
子类--变量
子类--初始化块
子类--构造器
i=9,j=20
task: i=10,j=21
子类--after construct
子类main方法
```

## 结论
1. （静态变量、静态初始化块）>（变量、初始化块）> 构造器
2. 各种类型的代码分别按照编写的先后顺序初始化，如
	
	```
	static { // 第一个初始化
        System.out.println("1. 静态初始化块");
    }
    /* 静态变量 */
    public static String staticField = "静态变量"; // 第二个初始化

    /* 静态初始化块 */
    static { // 第三个初始化
        System.out.println(staticField);
        System.out.println("静态初始化块");
    }

	``` 
3. 父类的静态代码先于子类的
4. 父类的其他整体（变量、初始化块、构造器）先于子类的