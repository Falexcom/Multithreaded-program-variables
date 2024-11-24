import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private static final AtomicInteger countLength3 = new AtomicInteger(0);
    private static final AtomicInteger countLength4 = new AtomicInteger(0);
    private static final AtomicInteger countLength5 = new AtomicInteger(0);

    public static void incrementCounter(int length) {
        switch (length) {
            case 3 -> countLength3.incrementAndGet();
            case 4 -> countLength4.incrementAndGet();
            case 5 -> countLength5.incrementAndGet();
        }
    }

    public static int getCountLength3() {
        return countLength3.get();
    }

    public static int getCountLength4() {
        return countLength4.get();
    }

    public static int getCountLength5() {
        return countLength5.get();
    }
}
