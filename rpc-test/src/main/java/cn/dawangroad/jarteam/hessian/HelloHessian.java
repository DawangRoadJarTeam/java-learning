package cn.dawangroad.jarteam.hessian;

import java.io.InputStream;

/**
 * 1. 如果你不需要很多语言相互调用， 希望保持清晰的java接口代码（无任何业务不相关的接口继承和方法，属性定义），减少开放工作量，推荐Hessian。
 * <p>
 * 2. 如果你的系统之间传输的数据量不是很大(<2M都不算大)， 推荐Hessian。
 * <p>
 * 3. 如果需要支持大数据量的传输，多语言调用，极高的并发支持，推荐使用thrift/protocol buffer。 通常我们并发很难超过1000 req/s，如果超过1000 req/s，在国内互联网排名绝对前5，那么恭喜你。因此一般而言，用Hessian就够了。
 *
 * @author zhiyingyang
 * @version 2018-06-19 14:53
 */
public interface HelloHessian {
    public String sayHello();

    public String sayHello(String name);

//    public List<Person> getPersons();
//
//    public Person getPersonById(int id);

    public boolean uploadFile(String fileName, InputStream data);

    public byte[] downloadFile(String fileName);

}
