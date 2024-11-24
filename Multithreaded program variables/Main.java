import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] texts = new String[100_000];

        for (int i = 0; i < texts.length; i++) {
            texts[i] = TextGenerator.generateText("abc", 3 + random.nextInt(3));
        }

        Thread palindromeThread = new Thread(() -> {
            for (String text : texts) {
                if (TextChecker.isPalindrome(text)) {
                    Counter.incrementCounter(text.length());
                }
            }
        });

        Thread sameLettersThread = new Thread(() -> {
            for (String text : texts) {
                if (TextChecker.isAllSame(text)) {
                    Counter.incrementCounter(text.length());
                }
            }
        });

        Thread ascendingThread = new Thread(() -> {
            for (String text : texts) {
                if (TextChecker.isAscending(text)) {
                    Counter.incrementCounter(text.length());
                }
            }
        });

        palindromeThread.start();
        sameLettersThread.start();
        ascendingThread.start();

        palindromeThread.join();
        sameLettersThread.join();
        ascendingThread.join();

        System.out.printf("Красивых слов с длиной 3: %d шт%n", Counter.getCountLength3());
        System.out.printf("Красивых слов с длиной 4: %d шт%n", Counter.getCountLength4());
        System.out.printf("Красивых слов с длиной 5: %d шт%n", Counter.getCountLength5());
    }
}