package cn.dawangroad.jarteam;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int i = 0;
        long prev_time = System.currentTimeMillis();
        long time;

        for (i = 0; i < 1000000; i++) {
            String s = "Blah" + i + "Blah";
        }
        time = System.currentTimeMillis() - prev_time;

        System.out.println("Time after for loop " + time);

        prev_time = System.currentTimeMillis();
        for (i = 0; i < 1000000; i++) {
            String s = String.format("Blah %d Blah", i);
        }
        time = System.currentTimeMillis() - prev_time;
        System.out.println("Time after for loop " + time);

        prev_time = System.currentTimeMillis();
        for (i = 0; i < 1000000; i++) {
            new StringBuilder("Blah").append(i).append("Blah");
        }
        time = System.currentTimeMillis() - prev_time;
        System.out.println("Time after for loop " + time);
    }

//    private static void test() {
//        int i = 0;
//        long prev_time = System.currentTimeMillis();
//        long time;
//
//        for (i = 0; i < 1000000; i++) {
//            String s = "Blah" + i + "Blah";
//        }
//        time = System.currentTimeMillis() - prev_time;
//
//        System.out.println("Time after for loop " + time);
//
//        prev_time = System.currentTimeMillis();
//        for (i = 0; i < 1000000; i++) {
//            String s = String.format("Blah %d Blah", i);
//        }
//        time = System.currentTimeMillis() - prev_time;
//        System.out.println("Time after for loop " + time);
//
//        prev_time = System.currentTimeMillis();
//        for (i = 0; i < 1000000; i++) {
//            new StringBuilder("Blah").append(i).append("Blah");
//        }
//        time = System.currentTimeMillis() - prev_time;
//        System.out.println("Time after for loop " + time);
//    }
}
