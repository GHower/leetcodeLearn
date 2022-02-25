package TEST;

public class BaseClass {
    private String baseName = "father";
    public BaseClass() {
    callName();
    }
    public void callName() {
        System.out.println(baseName);
    }
    static class SubClass extends BaseClass {
        private String baseName = "son";
        public void callName() {
            System.out.println("sub:"+baseName);
        }
    }
    public static void main(String[] args) {
        BaseClass b = new SubClass();
    }
}