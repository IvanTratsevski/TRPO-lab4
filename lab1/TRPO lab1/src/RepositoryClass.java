import java.util.ArrayList;
import java.util.Scanner;

public class RepositoryClass {
    private ArrayList<Student> students = new ArrayList<Student>();
    public void getStudents(){
        for(Student student : students){
            System.out.println(student.getStudentInfo());
        }
    }
    public void addNewStudent(){
        Scanner studentAddInput = new Scanner(System.in);
        System.out.println("Введите имя студента");
        String studentName = studentAddInput.nextLine();
        System.out.println("Введите группу студента");
        String studentGroup = studentAddInput.nextLine();
        System.out.println("Введите средний балл студента");
        Double studentAvgMark = studentAddInput.nextDouble();
        System.out.println("Введите тип студента (1 - на бюджете/2 - платный)");
        int studentType = studentAddInput.nextInt();
        if(studentType == 1){
            System.out.println("Студент сдал сессию в срок? (1 - да, 2 - нет)");
            int examPassTimeNumber = studentAddInput.nextInt();
            Boolean examPassConfirm;
            if(examPassTimeNumber == 1)
                examPassConfirm = true;
            else
                examPassConfirm = false;
            students.add(new ScholarshipStudent(studentName,studentGroup,studentAvgMark, students.size()+1,examPassConfirm));
        }else if(studentType == 2){
            System.out.println("Введите стоимость оплаты за обучение");
            Double studentEduCost = studentAddInput.nextDouble();
            students.add(new ContractStudent(studentName,studentGroup,studentAvgMark, students.size()+1,studentEduCost));
        }
    }

    /**public void updateStudentInfo() {
        Scanner updateInput = new Scanner(System.in);
        System.out.println("Для редактирвоания введите номер студента по списку");
        int studentListNumber = updateInput.nextInt()-1;
        System.out.println("Введите имя студента");
        String studentName = updateInput.next();
        System.out.println("Введите группу студента");
        String studentGroup = updateInput.nextLine();
        System.out.println("Введите средний балл студента");
        Double studentAvgMark = updateInput.nextDouble();
        System.out.println("Введите тип студента (1 - на бюджете/2 - платный)");
        int studentType = updateInput.nextInt();
        if(studentType == 1){
            System.out.println("Студент сдал сессию в срок? (1 - да, 2 - нет)");
            int examPassTimeNumber = updateInput.nextInt();
            Boolean examPassConfirm;
            if(examPassTimeNumber == 1)
                examPassConfirm = true;
            else
                examPassConfirm = false;
            students.add(new ScholarshipStudent(studentName,studentGroup,studentAvgMark, students.size()+1,examPassConfirm));
        }else if(studentType == 2){
            System.out.println("Введите стоимость оплаты за обучение");
            Double studentEduCost = updateInput.nextDouble();
            students.add(new ContractStudent(studentName,studentGroup,studentAvgMark, students.size()+1,studentEduCost));
        }
    }**/
    public void removeStudent(){
        Scanner deleteInput = new Scanner(System.in);
        System.out.println("Для удаления введите номер студента по списку");
        int studentListNumber = deleteInput.nextInt();
        students.remove(studentListNumber-1);
    }
}
