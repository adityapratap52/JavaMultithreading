package multithreadingpragram;

public class IsInterruptedAndInterrupted extends Thread{
    public void run(){
        try {
            for (int i=1; i<6; i++){
                System.out.println(Thread.currentThread().isInterrupted());      // public boolean isInterrupted();->true,true,true,... or false,false,...
//                System.out.println(Thread.interrupted());               // public static boolean interrupted();->true,false,... or false,false..
                Thread.sleep(1000);                                 // loop always run if you use interrupted
            }
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
    }
    public static void main(String[] args) {
        IsInterruptedAndInterrupted in = new IsInterruptedAndInterrupted();
        in.start();
        in.interrupt();
    }
}
