package multithreadingpragram;

public class UseOfMainThread {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();              // Provide Current Thread name
        System.out.println("Current Thread : "+t);

        t.setName("MyThread");                          // changed Current Thread name
        System.out.println("Changed Thread Name : "+t);

        try {
            for (int i=5; i>0; i--){
                System.out.println(i);
                Thread.sleep(1000);             // Interrupt Execution for 1000 milliseconds
            }
        }catch (InterruptedException e){
            System.out.println("Main Thread Exception Occur");
        }
    }
}
