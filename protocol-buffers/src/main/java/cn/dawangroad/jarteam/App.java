package cn.dawangroad.jarteam;

import com.example.tutorial.AddressBookProtos;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        new ThreadPoolExecutor(20, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder().build();
        System.out.println("Hello World!");
    }
}
