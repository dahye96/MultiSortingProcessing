import processing.core.PApplet;

public class MergeSortThread extends SortThread {
    private int i = 0;
    private int j = bar.length - 1;
    private  boolean isClicked = false;

    public MergeSortThread(PApplet applet, int[] bar) {
        super(applet, bar);
    }

    @Override
    public void run() {
        mergeSort();
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public void mergeSort() {
        int[] temp = new int[bar.length];
        i = 0;
        j = bar.length - 1;
        mSort(temp, i, j);

    }

    public void mSort(int temp[], int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            mSort(temp, start, mid);
            mSort(temp, mid + 1, end);
            merge(temp, start, mid + 1, end);
        }
    }

    public void merge(int temp[], int startA, int startB, int endB) {
        int aptr = startA;
        int bptr = startB;

        int idx = startA;

        if(isClicked) {
            isClicked = false;
            mergeSort();
        }

        if(orderType == Constants.ASC_ORDER) {
            while(aptr < startB && bptr < endB + 1){
                if(bar[aptr] < bar[bptr]){
                    temp[idx++] = bar[aptr++];
                }
                else{
                    temp[idx++] = bar[bptr++];
                }

                try {
                    sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            while(aptr < startB && bptr < endB + 1){
                if(bar[aptr] > bar[bptr]){
                    temp[idx++] = bar[aptr++];
                } else{
                    temp[idx++] = bar[bptr++];
                }

                try {
                    sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        while(aptr < startB){
            temp[idx++] = bar[aptr++];
            try {
                sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while(bptr < endB + 1){
            temp[idx++] = bar[bptr++];
            try {
                sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(int i = startA; i <= endB; i++){
            bar[i] = temp[i];
        }


    }

    public void drawBar(int startX, int endY) {
        for(int k = 0 ; k < bar.length ; k++) {
            applet.fill(255);
            super.drawBar(startX, endY, k);
        }
    }
}
