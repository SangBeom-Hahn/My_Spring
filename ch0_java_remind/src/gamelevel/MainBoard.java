package gamelevel;

public class MainBoard {
    public static void main(String[] args) {
        Player player1 = new Player();
        player1.play(5);

        player1.upgradeLevel(new SuperPlayer());
        player1.play(3);
    }
}
