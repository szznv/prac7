import java.util.ArrayDeque;

public class AD{
    public AD() {
    }

    public static String Play(int[] firstPlayer, int[] secondPlayer) {
        ArrayDeque<Integer> firstPlayerAD = new ArrayDeque();
        ArrayDeque<Integer> secondPlayerAD = new ArrayDeque();

        int counter;
        for(counter = 0; counter < 5; ++counter) {
            firstPlayerAD.add(firstPlayer[counter]);
            secondPlayerAD.add(secondPlayer[counter]);
        }

        counter = 0;

        while(counter < 106 && !firstPlayerAD.isEmpty() && !secondPlayerAD.isEmpty()) {
            ++counter;
            if (((Integer)secondPlayerAD.getFirst() == 0 && (Integer)firstPlayerAD.getFirst() == 9) || (Integer)firstPlayerAD.getFirst() <= (Integer)secondPlayerAD.getFirst()){
                System.out.println("2 wins: " + firstPlayerAD.getFirst() + " " + secondPlayerAD.getFirst());
                secondPlayerAD.addLast((Integer)firstPlayerAD.pollFirst());
                secondPlayerAD.addLast((Integer)secondPlayerAD.pollFirst());
            } else if (((Integer)secondPlayerAD.getFirst() == 9 && (Integer)firstPlayerAD.getFirst() ==0) || (Integer)firstPlayerAD.getFirst() >= (Integer)secondPlayerAD.getFirst()){
                System.out.println("1 wins: " + firstPlayerAD.getFirst() + " " + secondPlayerAD.getFirst());
                firstPlayerAD.addLast((Integer)firstPlayerAD.pollFirst());
                firstPlayerAD.addLast((Integer)secondPlayerAD.pollFirst());
            }
            System.out.println("1 - "+firstPlayerAD);
            System.out.println("2 - "+secondPlayerAD);
        }

        if (!firstPlayerAD.isEmpty() && !secondPlayerAD.isEmpty()) {
            return "botva";
        } else {
            return !firstPlayerAD.isEmpty() && secondPlayerAD.isEmpty() ? "first " + counter : "second " + counter;
        }
    }
}
