import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import processing.core.PApplet;

public class QuickSortThread extends SortThread {
    private int i;
    private int j;
    private boolean isClicked = false;

    public QuickSortThread(PApplet applet, int[] bar) {
        super(applet, bar);
    }

    @Override
    public void run() {
        i = 0;
        j = bar.length - 1;
        quickSort(0, bar.length - 1);
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public void quickSort(int left, int right) {

        if (isClicked) {
            isClicked = false;
            quickSort(0, bar.length - 1);
            return;
        }

        if (left < right) {
            int pivotPoint = (left + right) / 2;
            i = left;
            j = right - 1;
            int pivot = bar[pivotPoint];

            int temp = bar[pivotPoint];
            bar[pivotPoint] = bar[right];
            bar[right] = temp;

            pivotPoint = right;

            if(orderType == Constants.ASC_ORDER) {
                while (i < j) {

                    while (i < right - 1 && bar[i] < pivot)
                        i++;
                    while (j > 0 && bar[j] > pivot)
                        j--;


                    if (i < j) {
                        temp = bar[i];
                        bar[i] = bar[j];
                        bar[j] = temp;

                        i++;
                        j--;
                    }

                    try {
                        sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (i == j && bar[i] < bar[pivotPoint])
                    i++;

                temp = bar[i];
                bar[i] = bar[pivotPoint];
                bar[pivotPoint] = temp;

                quickSort(left, i - 1);
                quickSort(i + 1, right);
            } else {
                while (i < j) {

                    while (i < right - 1 && bar[i] > pivot)
                        i++;
                    while (j > 0 && bar[j] < pivot)
                        j--;


                    if (i < j) {
                        temp = bar[i];
                        bar[i] = bar[j];
                        bar[j] = temp;

                        i++;
                        j--;
                    }

                    try {
                        sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (i == j && bar[i] > bar[pivotPoint])
                    i++;

                temp = bar[i];
                bar[i] = bar[pivotPoint];
                bar[pivotPoint] = temp;

                quickSort(left, i - 1);
                quickSort(i + 1, right);
            }
        }

    }

    public void drawBar(int startX, int endY) {
        for (int k = 0; k < bar.length; k++) {
            if (k == j || k == i) {
                applet.fill(255, 0, 0);
            }else {
                applet.fill(255);
            }
            super.drawBar(startX, endY, k);
        }
    }
}
