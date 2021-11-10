package multithreadingpragram;

public class MultipleThread implements Runnable{
    Thread thread;
    String name;

    MultipleThread(String name){
        this.name = name;
        thread = new Thread(this,name);
        System.out.println("Current Thread name : "+thread);
    }

    public void run(){
        try {
            for (int num=5; num>0; num--){
                System.out.println(name+" "+num);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println(name+" Interrupted");
        }
        System.out.println(name+" thread exiting");
    }

    public static void main(String[] args) {
        MultipleThread myThread1 = new MultipleThread("One");
        MultipleThread myThread2 = new MultipleThread("Two");
        MultipleThread myThread3 = new MultipleThread("Three");

        myThread1.thread.start();
        myThread2.thread.start();
        myThread3.thread.start();

        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            System.out.println("Main Thread Interrupted");
        }

        System.out.println("Main Thread Exiting");
    }
}
