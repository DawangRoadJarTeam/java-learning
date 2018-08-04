package cn.dawangroad.jarteam.finalize;

/**
 * Hello world!
 */
public class SonFinalizeTest extends FinalizeTest{
    byte[] mem = new byte[1024 * 1024 * 30];

    public void print() {
        System.out.println("son:" + mem.length);
    }


    @Override
    protected void finalize() throws Throwable {
//        super.finalize();
//        System.out.println("i'm in finalize");
    }
}
