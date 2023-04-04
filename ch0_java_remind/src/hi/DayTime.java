package hi;

public class DayTime {
    //필드
    private int day;
    private int month;

    //생성자
    public DayTime(){}

    public void setDay(int day) {
        if(month == 2){
            if(day < 1 || day > 28){
                System.out.println("안돼요!!");
            }
            else{
                this.day = day;
            }
        }
    }

    //메서드
    public int getDay() {
        return day;
    }
}
