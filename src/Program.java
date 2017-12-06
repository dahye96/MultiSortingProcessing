import processing.core.PApplet;

public class Program extends PApplet{

    private int[] unSortedBar;

    private BubbleSortThread bubbleThread;
    private SelectionSortThread selectionThread;
    private QuickSortThread quickThread;
    private MergeSortThread mergeThread;

    public static void main(String[] args) {
        PApplet.main("Program");
    }

    @Override
    public void settings() {
        this.size(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        init();
    }

    @Override
    public void setup() {
        this.background(0);
    }

    @Override
    public void draw() {
        this.background(0);

        this.fill(255);
        this.text("Bubble Sort", 220, 20);
        this.text("Selection Sort", 700, 20);
        this.text("Quick Sort", 220, 330);
        this.text("Merge Sort", 700, 330);

        this.rect(0,0, 120, 50);
        this.fill(0);
        this.text("Ascending Order", 16, 28);

        this.fill(255);
        this.rect(0,60, 120, 50);
        this.fill(0);
        this.text("Descending Order", 12, 90);

        bubbleThread.drawBar(5, 315);
        selectionThread.drawBar(485, 315);
        quickThread.drawBar(5, 635);
        mergeThread.drawBar(485, 635);
    }

    public void init() {
        makeUnSortedBar((Constants.WINDOW_WIDTH/2 - Constants.BAR_MARGIN*2)/Constants.BAR_WIDTH, Constants.WINDOW_HEIGHT / 2 - 10);

        int[] bubbleBar = new int[unSortedBar.length];
        int[] selectionBar = new int[unSortedBar.length];
        int[] quickBar = new int[unSortedBar.length];
        int[] MergeBar = new int[unSortedBar.length];

        for(int i = 0 ; i < unSortedBar.length ; i++) {
            bubbleBar[i] = unSortedBar[i];
            selectionBar[i] = unSortedBar[i];
            quickBar[i] = unSortedBar[i];
            MergeBar[i] = unSortedBar[i];
        }

        bubbleThread = new BubbleSortThread(this, bubbleBar);
        selectionThread = new SelectionSortThread(this, selectionBar);
        quickThread = new QuickSortThread(this, quickBar);
        mergeThread = new MergeSortThread(this, MergeBar);

        bubbleThread.start();
        selectionThread.start();
        quickThread.start();
        mergeThread.start();
    }

    public void makeUnSortedBar(int number, int maxHeight) {
        unSortedBar = new int[number];
        for(int i = 0 ; i < number ; i++) {
            unSortedBar[i] = (int)(Math.random() * maxHeight);
        }
    }

    @Override
    public void mouseClicked() {
        bubbleThread.setI(1);
        bubbleThread.setJ(0);

        selectionThread.setI(0);
        selectionThread.setJ(0);

        quickThread.setClicked(true);

        mergeThread.setClicked(true);


        if(mouseX >= 0 && mouseX <= 120 && mouseY >= 0 && mouseY <= 50) {
            bubbleThread.setOrderType(Constants.ASC_ORDER);
            selectionThread.setOrderType(Constants.ASC_ORDER);
            quickThread.setOrderType(Constants.ASC_ORDER);
            mergeThread.setOrderType(Constants.ASC_ORDER);
        } else if(mouseX >= 0 && mouseX <= 120 && mouseY >= 60 && mouseY <= 110) {
            bubbleThread.setOrderType(Constants.DESC_ORDER);
            selectionThread.setOrderType(Constants.DESC_ORDER);
            quickThread.setOrderType(Constants.DESC_ORDER);
            mergeThread.setOrderType(Constants.DESC_ORDER);
        }
    }
}
