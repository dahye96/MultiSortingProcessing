import processing.core.PApplet;

public class BubbleSortThread extends SortThread{
    private int i;
    private int j;

    public BubbleSortThread(PApplet applet, int[] bar) {
        super(applet, bar);
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    public void run() {
        for (i = 1; i < bar.length ; i++) {
            for (j = 0; j < bar.length - i ; j++) {
                if(orderType == Constants.ASC_ORDER) {
                    if (bar[j] > bar[j + 1]) {
                        int temp = bar[j];
                        bar[j] = bar[j + 1];
                        bar[j + 1] = temp;
                    }
                } else {
                    if (bar[j] < bar[j + 1]) {
                        int temp = bar[j];
                        bar[j] = bar[j + 1];
                        bar[j + 1] = temp;
                    }
                }
                try {
                    sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void drawBar(int startX, int endY) {
        for (int k = 0; k < bar.length; k++) {
            if (k == j) {
                applet.fill(255, 0, 0);
            } else if (k > bar.length - i) {
                applet.fill(0, 255, 0);
            } else {
                applet.fill(255);
            }
            super.drawBar(startX, endY, k);
        }
    }
}
