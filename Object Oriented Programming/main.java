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

        Student irfan = new Student();
        System.out.println(irfan.rno);

    }

    class Student {
        int[] rno = new int[5];
        String[] name2 = new String[5];
        float[] marks = new float[5];
    }

}
