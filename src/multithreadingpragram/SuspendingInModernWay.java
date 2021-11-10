package multithreadingpragram;

// After Deprecate suspend(),resume() and stop() method, we can use modern way
class NewThread implements Runnable{
    String name;
    Thread thread;
    boolean suspendFlag;

    NewThread(String threadName){
        name = threadName;
        thread = new Thread(this,name);
        System.out.println("New Thread : "+thread);
        suspendFlag = false;
    }

    // This is the entry point of Thread
    public void run(){
        try {
            for (int i=15; i>0; i--){
                System.out.println(name+" "+i);
                Thread.sleep(200);
                synchronized (this){
                    while (suspendFlag){
                        wait();
                    }
                }
            }
        }catch (InterruptedException e){
            System.out.println(name+" Interrupted");
        }
        System.out.println(name+" exiting");
    }
    synchronized void mySuspend(){
        suspendFlag = true;
    }
    synchronized void myResume(){
        suspendFlag = false;
        notify();
    }
}

public class SuspendingInModernWay {
    public static void main(String[] args) {
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");

        ob1.thread.start();
        ob2.thread.start();

        try {
            Thread.sleep(1000);
            ob1.mySuspend();
            System.out.println("Suspending Thread One");
            Thread.sleep(1000);
            ob1.myResume();
            System.out.println("Resuming Thread One");
            ob2.mySuspend();
            System.out.println("Suspending Thread Two");
            Thread.sleep(1000);
            ob2.myResume();
            System.out.println("Resuming Thread Two");
        }catch (InterruptedException e){
            System.out.println("Main Thread Interrupted");
        }

        // Wait for threads to finish
        try {
            System.out.println("Waiting for Thread to finish");
            ob1.thread.join();
            ob2.thread.join();
        }catch (InterruptedException e){
            System.out.println("Main Thread Interruption");
        }
        System.out.println("Main Thread Exiting");
    }
}
