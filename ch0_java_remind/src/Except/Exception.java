package Except;
public class Exception {
    public Class loadClass(String className) throws ClassNotFoundException {
        Class c = Class.forName(className);
        return c;
    }
    public static void main(String[] args) {
        Exception exception = new Exception();
        try{
            exception.loadClass("java.lang.string");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("런타임 에러");
        }
    }
}
