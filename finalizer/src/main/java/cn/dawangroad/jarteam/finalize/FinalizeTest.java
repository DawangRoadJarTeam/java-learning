package cn.dawangroad.jarteam.finalize;

/**
 * Hello world!
 */
public class FinalizeTest {
    byte[] mem = new byte[1024 * 1024 * 20];

    public void parentPrint() {
        System.out.println("parent:" + mem.length);
    }

    public static void main(String[] args) {
        new FinalizeTest().parentPrint();
        new SonFinalizeTest().parentPrint();
        new SonFinalizeTest().print();
    }

//    @Override
//    protected void finalize() throws Throwable {
//        super.finalize();
//        System.out.println("i'm in finalize");
//    }
}
