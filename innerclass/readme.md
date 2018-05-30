# 内部类

> 内部类基础推荐：
> 
> [搞懂 JAVA 内部类](https://juejin.im/post/5a903ef96fb9a063435ef0c8)
> 
> [java提高篇(八)----详解内部类](https://www.cnblogs.com/chenssy/p/3388487.html)
> 
> [Java编程思想-7.6 内部类](https://java.quanke.name/7.6%20%E5%86%85%E9%83%A8%E7%B1%BB.html)

### 内部类编译后类名
* 内部类在编译阶段就被创建了出来，类名为：{FatherClass}${内部类名称}
	* 内部类名称命名规则（数字从1开始）：
		* 如果是匿名内部类则为：数字
		* 如果局部作用域内的类名相同，则为：数字+类名
		* 如果是类内部可见的内部类，则为：类名
		
### 内部类和普通类的区别
* 内部类在使用时，和其他类一样，也是被加载到了方法区（meta space）。
* 内部类和外部类的区别只是作用域不同而已。

### 静态内部类和非静态内部类的区别
* 在任何非静态内部类中，都不能有静态数据，静态方法或者又一个静态内部类
* 静态内部类没有了指向外部的引用

```
// 非静态内部类反编译之后的代码
class InnerClass$1FunctionImpl implements Function {
    InnerClass$1FunctionImpl(InnerClass var1) {
        this.this$0 = var1;
    }

    public Object apply(Object var1) {
        return null;
    }
}

// 静态内部类反编译之后的代码
public class InnerClass$SonClass {
    public InnerClass$SonClass() {
    }
}
```

### 内部类的作用
* 隐藏你不想让别人知道的操作，也即封装性。
* 一个内部类对象可以访问创建它的外部类对象的内容，甚至包括私有变量
* 通过内部类可以实现多重继承。一个类只能继承一个类，通过定义多个内部类，可以实现继承不止一个类。
* 若要实现的接口中有与类相同名字的方法，可通过内部类来实现这个接口，避免修改接口方法名。

### 内部类和final关键字
> [java为什么匿名内部类的参数引用时final？](https://www.zhihu.com/question/21395848)

* 内部类引用到外部的局部变量的时候，外部局部变量需要加final关键字

```
// 情况一：
        int i = 0;
        Function function = new Function<Object, Object>() {

            @Override
            public Object apply(Object o) {
                return i + o.toString();
            }
        };
        
// 情况二：
    Function function(final int k) {

        return new Function() {

            @Override
            public Object apply(Object o) {
                return k + o.toString();
            }
        };
    }

```

### 内部类和闭包
> [闭包的概念](https://zh.wikipedia.org/zh-hans/%E9%97%AD%E5%8C%85_(%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%A7%91%E5%AD%A6))：
> 
> 闭包（英语：Closure），又称词法闭包（Lexical Closure）或函数闭包（function closures），是引用了自由变量的函数。这个被引用的自由变量将和这个函数一同存在，即使已经离开了创造它的环境也不例外
> 
> [为什么Java闭包不能通过返回值之外的方式向外传递值？](https://www.zhihu.com/question/28190927/answer/39786939)
> 
> Java 8语言上的lambda表达式只实现了capture-by-value，也就是说它捕获的局部变量都会拷贝一份到lambda表达式的实体里，然后在lambda表达式里要变也只能变自己的那份拷贝而无法影响外部原本的变量；但是Java语言的设计者又要挂牌坊不明说自己是capture-by-value，为了以后语言能进一步扩展成支持capture-by-reference留下后路，所以现在干脆不允许向捕获的变量赋值，而且可以捕获的也只有“效果上不可变”（effectively final）的参数/局部变量。


