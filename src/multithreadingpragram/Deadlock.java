package multithreadingpragram;

// An example of Deadlock
class A{
    synchronized void foo(B b){
        String name = Thread.currentThread().getName();
        System.out.println(name+" entered A.foo");

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("A Interrupted");
        }
        System.out.println(name+" trying to call B.last()");
        b.last();
    }
    synchronized void last(){
        System.out.println("Inside A.last");
    }
}
class B{
    synchronized void bar(A a){
        String name = Thread.currentThread().getName();
        System.out.println(name+" entered B.bar");

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("B Interrupted");
        }
        System.out.println(name+" trying to call A.last()");
        a.last();
    }
    synchronized void last(){
        System.out.println("Inside B.last");
    }
}
public class Deadlock implements Runnable{
    A a = new A();
    B b = new B();
    Thread thread;

    Deadlock(){
        Thread.currentThread().setName("MainThread");
        thread = new Thread(this,"RacingThread");
    }
    void deadLockStart(){
        thread.start();
        a.foo(b);       // get lock on a in other thread
        System.out.println("Back in Main Thread");
    }
    public void run(){
        b.bar(a);       // get lock on b in other thread
        System.out.println("Back in other Thread");
    }
    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();

        deadlock.deadLockStart();
    }
}
