import java.util.Stack;

public class ST{
    public ST() {
    }
    public static Stack<Integer> rev(Stack<Integer> stack)
    {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = stack;
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return stack1;
    }
    public static String PlayST(int[] firstPlayer, int[] secondPlayer) {

        Stack<Integer> firstPlayerST = new Stack<>();
        Stack<Integer> secondPlayerST = new Stack<>();

        int counter;
        for(counter = 0; counter < 5; ++counter) {
            firstPlayerST.push(firstPlayer[counter]);
            secondPlayerST.push(secondPlayer[counter]);
        }

        counter = 0;

        while(counter < 106 && !firstPlayerST.isEmpty() && !secondPlayerST.isEmpty()) {
            ++counter;
            Stack<Integer> firstPlayerSTH = rev(firstPlayerST);
            Stack<Integer> secondPlayerSTH = rev(secondPlayerST);
            if (((Integer)secondPlayerSTH.peek() == 0 && (Integer)firstPlayerSTH.peek() == 9) || (Integer)firstPlayerSTH.peek() <= (Integer)secondPlayerSTH.peek()){
                System.out.println("2 wins: " + firstPlayerSTH.peek() + " " + secondPlayerSTH.peek());
                firstPlayerST = rev(firstPlayerST);
                int a = firstPlayerST.pop();
                secondPlayerST = rev(secondPlayerST);
                int b = secondPlayerST.pop();
                firstPlayerST = rev(firstPlayerST);
                secondPlayerST = rev(secondPlayerST);
                secondPlayerST.push((Integer)a);
                secondPlayerST.push((Integer)b);
            } else if (((Integer)secondPlayerSTH.peek() == 9 && (Integer)firstPlayerSTH.peek() ==0) || (Integer)firstPlayerSTH.peek() >= (Integer)secondPlayerSTH.peek()){
                System.out.println("1 wins: " + firstPlayerSTH.peek() + " " + secondPlayerSTH.peek());
                firstPlayerST = rev(firstPlayerST);
                int a = firstPlayerST.pop();
                secondPlayerST = rev(secondPlayerST);
                int b = secondPlayerST.pop();
                firstPlayerST = rev(firstPlayerST);
                secondPlayerST = rev(secondPlayerST);
                firstPlayerST.push((Integer)a);
                firstPlayerST.push((Integer)b);
            }
            System.out.println("1 - "+firstPlayerST);
            System.out.println("2 - "+secondPlayerST);
        }

        if (!firstPlayerST.isEmpty() && !secondPlayerST.isEmpty()) {
            return "botva";
        } else {
            return !firstPlayerST.isEmpty() && secondPlayerST.isEmpty() ? "first " + counter : "second " + counter;
        }
    }
}
