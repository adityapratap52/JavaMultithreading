package multithreadingpragram;

class CallMe{
    // Synchronized method----------------
    synchronized void call(String msg){
        System.out.print(" [ "+msg);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println(" ] ");
    }
}

class Caller implements Runnable{

    String msg;
    CallMe target;
    Thread thread;

    Caller(CallMe target, String msg){
        this.target = target;
        this.msg = msg;
        thread = new Thread(this);
    }

    public void run(){
        target.call(msg);
    }
}

public class SynchronizationMethod {
    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller obj1 = new Caller(target,"Hello");
        Caller obj2 = new Caller(target,"Synchronized");
        Caller obj3 = new Caller(target,"World");

        obj1.thread.start();
        obj2.thread.start();
        obj3.thread.start();

        // Wait for thread to end
        try {
            obj1.thread.join();
            obj2.thread.join();
            obj3.thread.join();
        }catch (InterruptedException e){
            System.out.println("Main thread Interrupted");
        }
    }
}
