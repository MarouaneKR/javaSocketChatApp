package M2SChat;

public class StartBlockThread {
    public synchronized void waitAndListen() throws InterruptedException {
        this.wait();
    }

    public synchronized void startMoving() throws InterruptedException {
        this.notifyAll();
    }

}
