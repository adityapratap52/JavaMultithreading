package multithreadingpragram;

public class InterruptMethod extends Thread{
    public void run() {
        try {
        for(int i=1; i<6; i++){
            System.out.println(i);
            Thread.sleep(1000);
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        InterruptMethod interruptMethod = new InterruptMethod();
        interruptMethod.start();
        interruptMethod.interrupt();        // It is work only waiting methods-> sleep(),wait(),resume()
    }
}
