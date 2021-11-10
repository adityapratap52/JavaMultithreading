package multithreadingpragram;

public class IsAliveAndJoin implements Runnable{
    Thread thread;
    String name;

    IsAliveAndJoin(String name){
        this.name = name;
        thread = new Thread(this,name);
        System.out.println("New Thread : "+thread);
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
        IsAliveAndJoin myClass1 = new IsAliveAndJoin("One");
        IsAliveAndJoin myClass2 = new IsAliveAndJoin("Two");
        IsAliveAndJoin myClass3 = new IsAliveAndJoin("Three");

        myClass1.thread.start();        // If you use again myClass1 then IllegalThreadStateException occur
        myClass2.thread.start();
        myClass3.thread.start();

        System.out.println("Thread One is Alive : "+myClass1.thread.isAlive());
        System.out.println("Thread Two is Alive : "+myClass2.thread.isAlive());
        System.out.println("Thread Three is Alive : "+myClass3.thread.isAlive());

        try {
            System.out.println("Waiting for thread for finish....");
            myClass1.thread.join();
            myClass2.thread.join();
            myClass3.thread.join();
        }catch (InterruptedException e){
            System.out.println("Main Thread Interrupted");
        }
        System.out.println("Thread One is Alive : "+myClass1.thread.isAlive());
        System.out.println("Thread Two is Alive : "+myClass2.thread.isAlive());
        System.out.println("Thread Three is Alive : "+myClass3.thread.isAlive());

        System.out.println("Main Thread Exiting");
    }
}
