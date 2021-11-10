package multithreadingpragram;

class CallMe1{

    void call(String msg){
        System.out.print(" [ "+msg);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println(" ] ");
    }
}

class Caller1 implements Runnable{

    String msg;
    CallMe1 target;
    Thread thread;

    Caller1(CallMe1 target, String msg){
        this.target = target;
        this.msg = msg;
        thread = new Thread(this);
    }

    public void run(){
        // Synchronized block----------------
        synchronized (target){
            target.call(msg);
        }
    }
}


public class SynchronizedBlock {
    public static void main(String[] args) {
        CallMe1 target = new CallMe1();
        Caller1 obj1 = new Caller1(target,"Hello");
        Caller1 obj2 = new Caller1(target,"Synchronized");
        Caller1 obj3 = new Caller1(target,"World");

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
