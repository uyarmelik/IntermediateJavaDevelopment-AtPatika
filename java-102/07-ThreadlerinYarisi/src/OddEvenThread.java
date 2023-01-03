import java.util.ArrayList;

public class OddEvenThread implements Runnable {
    private int firstNumber = 0;

    private final Object LOCK = new Object();
    private final ArrayList<Integer> dividedList = new ArrayList<>();
    private final ArrayList<Integer> dividedList2 = new ArrayList<>();
    private final ArrayList<Integer> dividedList3 = new ArrayList<>();
    private final ArrayList<Integer> dividedList4 = new ArrayList<>();
    public final static ArrayList<Integer> oddNumbers = new ArrayList<>();
    public final static ArrayList<Integer> evenNumber = new ArrayList<>();

    public OddEvenThread() {
    }

    @Override
    public void run() {

        synchronized (LOCK) {
            System.out.println(this.firstNumber);

            if (this.firstNumber <= 2500) this.dividedList.add(this.firstNumber);
            else if (this.firstNumber <= 5000) this.dividedList2.add(this.firstNumber);
            else if (this.firstNumber <= 7500) this.dividedList3.add(this.firstNumber);
            else this.dividedList4.add(this.firstNumber);

            if (this.firstNumber % 2 == 0) {
                evenNumber.add(this.firstNumber);
                System.out.println(this.firstNumber + " " + "added to Even Number List by " + Thread.currentThread().getName());
            } else {
                oddNumbers.add(this.firstNumber);
                System.out.println(this.firstNumber + " " + "added to Odd Number List by "+ Thread.currentThread().getName());
            }
            this.firstNumber++;
        }

    }

}