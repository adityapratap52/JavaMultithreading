package multithreadingpragram;

public class UseRunnableInterface implements Runnable{
    Thread thread;

    UseRunnableInterface(){
//        super("MyThread");          // Runnable interface has no constructor it is throw error

        thread = new Thread(this,"MyThread");
        System.out.println("Child Thread : "+thread);
    }

    public void run(){
        try {
            for (int num = 5; num>0; num--){
                System.out.println(num);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println("Child Thread Exception Occur");
        }
        System.out.println("Child Thread exiting--");
    }

    public static void main(String[] args) {

        // Step 1- First create to object of implemented class
        UseRunnableInterface myRunnable = new UseRunnableInterface();

        // Step 2- Second create to object of Thread class and put reference of implemented class in Thread constructor
        Thread myThread = new Thread(myRunnable);
        myThread.start();

        try {
            for (int num = 5; num>0; num--){
                System.out.println(num);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Main Thread Exception Occur");
        }

        System.out.println("Main Thread exiting");
    }
}
