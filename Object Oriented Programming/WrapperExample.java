public class WrapperExample {
    public static void main(String[] args) {
        // int a = 10;
        // int b = 20;

        // Integer num = 45;

        Integer a = 10;
        Integer b = 20;

        swap(a, b);
        System.out.println(a + "" + b);

        final int bonus = 2;
        // bonus = 3;this will give error. because final variable can't be changed.
        // Always intilize it while declaring.

        final A irfan = new A("Irfan");
        irfan.name = "new name";

        // when a non primitive is final you cannot reassign it.
        // irfan = new A("new object");this will throw an error
        A obj;
        for (int i = 0; i < 10000000; i++) {
            obj = new A("rnadondks");
        }
    }

    static void swap(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }

}

class A {
    final int num = 10;
    String name;

    public A(String name) {
        System.out.println("object created");
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method called");
    }
}
