import processing.core.PApplet;

public class SortThread extends Thread{
    public PApplet applet;
    public int[] bar;
    public int orderType;

    public SortThread(PApplet applet, int[] bar) {
        this.applet = applet;
        this.bar = bar;
        orderType = Constants.ASC_ORDER;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    @Override
    public void run() {  }

    public void drawBar(int startX, int endY, int k) {
        applet.rect(Constants.BAR_WIDTH * k + startX, endY - bar[k], Constants.BAR_WIDTH, bar[k]);
    }
}
