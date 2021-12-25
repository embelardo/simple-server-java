public class SimpleServer {
    public static void main(String[] args) {
        for (int i = 0; i >= 0; i++) {
            System.out.printf("Second: 4%d\n", i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}