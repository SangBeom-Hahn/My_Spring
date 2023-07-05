package class_adv;

class AAA {
    int i = 100;

    class BBB {
//        static int cv = 100;
        final static int cv = 100;

        void method() {
            System.out.println(i);
        }
    }

    static class StaticInner {
        int iv = 100;
        static int cv = 100;

        void method() {
//            System.out.println(i);
        }
    }

    void myMethod() {
        class LocalInner {
            int iv = 400;
        }
    }
}

public class Inner {
    public static void main(String[] args) {
        AAA aaa = new AAA();
        AAA.BBB bbb = aaa.new BBB();

        AAA.StaticInner staticInner = new AAA.StaticInner();
    }
}
