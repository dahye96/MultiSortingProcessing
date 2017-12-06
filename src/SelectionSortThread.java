import processing.core.PApplet;

public class SelectionSortThread extends SortThread {
    private int i;
    private int j;

    public SelectionSortThread(PApplet applet, int[] bar) {
        super(applet, bar);
    }

    @Override
    public void run() {
        int extremeIdx;
        for(i = 0 ; i < bar.length ; i++) {
            extremeIdx = i;
            for(j = i ; j < bar.length ; j++) {
                if(orderType == Constants.ASC_ORDER) {
                    if(bar[j] < bar[extremeIdx]) {
                        extremeIdx = j;
                    }
                } else {
                    if(bar[j] > bar[extremeIdx]) {
                        extremeIdx = j;
                    }
                }
                try {
                    sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int temp = bar[i];
            bar[i] = bar[extremeIdx];
            bar[extremeIdx] = temp;
        }
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public void drawBar(int startX, int endY) {
        for(int k = 0 ; k < bar.length ; k++) {
            if (k == j) {
                applet.fill(255, 0, 0);
            } else if (k < i) {
                applet.fill(0, 255, 0);
            } else {
                applet.fill(255);
            }
            super.drawBar(startX, endY, k);
        }
    }
}
