package multithreadingpragram;

public class UseThreadClass extends Thread{

    UseThreadClass(){
        super("MyThread");                  // It is call Thread class constructor
        System.out.println("Child Thread : "+this);
    }

    public void run(){
        try {
            for (int i = 5; i>0; i--){
                System.out.println(i);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println("Child Thread Exception Occur");
        }
        System.out.println("Child Thread exiting--");
    }

    public static void main(String[] args) {
        UseThreadClass myThread = new UseThreadClass();
        myThread.start();

        try {
            for (int i = 5; i>0; i--){
                System.out.println(i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Main Thread Exception Occur");
        }

        System.out.println("Main Thread exiting");
    }
}
