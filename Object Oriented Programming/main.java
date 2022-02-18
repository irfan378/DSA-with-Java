public class main {
    public static void main(String[] args) {
        // store 5 roll nos
        int[] roll = new int[5];

        // store 5 names
        String[] name = new String[5];

        // data of 5 students: {roll no,name,marks}
        int[] rno = new int[5];
        String[] name2 = new String[5];
        float[] marks = new float[5];

        Student[] students = new Student[5];
        // Student Irfan;
        // Irfan = new Student();

        Student irfan = new Student(12, "Irfan", 98);
        // irfan.rno = 2;
        // irfan.name2 = "Irfan";
        // irfan.marks = 90;

        // System.out.println(irfan.name2);
        // System.out.println(irfan.rno);
        // System.out.println(irfan.marks);

        // irfan.greeting();
        // irfan.changeName("bhat");
        // irfan.greeting();

        // System.out.println(irfan.name2);
        // System.out.println(irfan.rno);
        // System.out.println(irfan.marks);

        // Student random = new Student(irfan);
        // System.out.println(random.name2);
        // System.out.println(random.rno);
        // System.out.println(random.marks);

        Student random = new Student();
        System.out.println(random.name2);
        System.out.println(random.rno);
        System.out.println(random.marks);
    }

    static class Student {
        int rno;
        String name2;
        float marks;

        // we need a way to add the value of the above properties object by object.
        // we need one word to access every object.
        void greeting() {
            System.out.println("Hello my name is " + name2);
        }

        void changeName(String newName) {
            name2 = newName;
        }

        // Student() {
        // this.rno = 13;
        // this.name2 = "Irfan";
        // this.marks = 90;
        // }
        Student(int rno, String name2, float marks) {
            this.rno = 13;
            this.name2 = "Irfan";
            this.marks = 90;
        }

        Student() {
            // this is how you call a constructor in a constructor.
            // internally:new Student(13, "default person", 90);
            this(12, "Irfan", 98);
        }

        Student(Student other) {
            this.name2 = other.name2;
            this.rno = other.rno;
            this.marks = other.marks;
        }
    }

}
