package cn.dawangroad.jarteam.finalize;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {

//        final WeakHashMap<Object, Object> weakHashMap = new WeakHashMap<>();
        FinalizeTest yzyTest = new FinalizeTest();
        ReferenceQueue<FinalizeTest> referenceQueue = new ReferenceQueue<>();
        PhantomReference<FinalizeTest> finalizeTestWeakReference = new PhantomReference<>(yzyTest,referenceQueue);
        finalizeTestWeakReference = null;

//        TestWeakReference<FinalizeTest> finalizeTestWeakReference = new TestWeakReference<>(yzyTest, new FinalizeTest(), referenceQueue);
//        weakHashMap.put(yzyTest, new FinalizeTest());
//        yzyTest = null;

//        FinalizeTest yzyTest1 = new FinalizeTest();
//        yzyTest1 = null;
//
//        FinalizeTest yzyTest2 = new FinalizeTest();
//        yzyTest2 = null;
//

        System.gc();
        TimeUnit.SECONDS.sleep(2);
//        TestWeakReference<FinalizeTest> reference = (TestWeakReference<FinalizeTest>) referenceQueue.poll();
//        reference.value = null;
//        reference = null;
//
//        weakHashMap.size();
//        System.gc();
//        TimeUnit.SECONDS.sleep(2);

/*
        List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<WeakHashMap<byte[][], byte[][]>>();
        for (int i = 0; i < 1000; i++) {
            WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();
            d.put(new byte[1000][1000], new byte[1000][1000]);
            maps.add(d);
            System.gc();
            System.err.println(i);
        }
*/

    }

    static class TestWeakReference<T> extends WeakReference<T> {
        private Object value;

        public TestWeakReference(T referent, Object value) {
            super(referent);
            this.value = value;
        }

        public TestWeakReference(T referent, Object value, ReferenceQueue<? super T> q) {
            super(referent, q);
            this.value = value;
        }
    }
}