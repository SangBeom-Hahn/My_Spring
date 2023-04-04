package gamelevel;

public class Player {
    //필드
    private PlayerLevel level;

    //생성자
    public Player(){
        level = new BeginnerPlayer();
        level.showLevelMessage();
    }

    //메서드
    public void upgradeLevel(PlayerLevel level){
        this.level = level;
        this.level.showLevelMessage();
    }

    public void play(int count){
        level.go(count);
    }
}


