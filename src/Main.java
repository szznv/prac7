
public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        int[] firstPlayer = new int[]{0, 3, 5, 7, 9};
        int[] secondPlayer = new int[]{2, 4, 6, 8, 0};
        System.out.println(AD.Play(firstPlayer, secondPlayer));
    }
}
