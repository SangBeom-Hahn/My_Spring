package hi;

public class Circle {
    //필드
    private int radius;
    Point point;

    //생성자
    public Circle(int radius){
        this.radius = radius;
        point = new Point(5, 7);
    }

    //메서드
    public void showPoint(){
        System.out.println(point.getX()+point.getY());
    }

    public static void main(String[] args) {
        Circle[] c = new Circle[5];
        for(int i = 0; i < c.length; i++){
            c[i] = new Circle(5);
        }
    }
}
