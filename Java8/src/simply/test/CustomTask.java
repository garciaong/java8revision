package simply.test;

public class CustomTask implements Runnable{

    private int count = 0;
    
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            count++;
            System.out.println(String.format("Current result : %d", count));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public int result() {
        return this.count;
    }

}
