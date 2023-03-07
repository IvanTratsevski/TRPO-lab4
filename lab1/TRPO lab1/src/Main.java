import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RepositoryClass rc = new RepositoryClass();
        rc.addNewStudent();
        rc.addNewStudent();
        System.out.println("Обновление");
        rc.getStudents();
        Boolean isExit = false;
        Student[] students = new Student[0];
        Student[] studentsExample = {
                new ContractStudent("Bob","ITP-11",6.1,1,1200),
                new ContractStudent("Mike","ITI-11",9.1,2,1350),
                new ScholarshipStudent("Jim","ITP-21",6.1,3,true),
                new ScholarshipStudent("Bob","ITP-11",5.0,4,true),
                new ScholarshipStudent("David","IPT-11",9.4,5,true),
                new ScholarshipStudent("Jordan","IPT-11",3.7,6,true),
                new ScholarshipStudent("Jim","IPT-11",9.4,5,false)
        };

        while(!isExit){
            System.out.println("Выберите действие:");
            System.out.println("1 - Добавить студента");
            System.out.println("2 - Получить информацию о студенте");
            System.out.println("3 - Получить информацию о всех студентах");
            System.out.println("4 - Получить информацию о студентах-платниках");
            System.out.println("5 - Получить информацию о студентах-бюджетниках");
            System.out.println("6 - Получить средний балл по итогам сессии по всем студентам");
            System.out.println("7 - Закончить работу");
            Scanner userChoiseScaner = new Scanner(System.in);
            if (userChoiseScaner.hasNextInt()) {
                int userChoise = userChoiseScaner.nextInt();
                switch(userChoise){
                    case (1) :
                        Scanner studentAddInput = new Scanner(System.in);
                        System.out.println("Введите имя студента");
                        String studentName = studentAddInput.nextLine();
                        System.out.println("Введите группу студента");
                        String studentGroup = studentAddInput.nextLine();
                        System.out.println("Введите средний балл студента");
                        Double studentAvgMark = studentAddInput.nextDouble();
                        System.out.println("Введите тип студента (1 - на бюджете/2 - платный)");
                        int studentType = studentAddInput.nextInt();
                        Student[] array = Arrays.copyOf(students, students.length + 1);
                        if(studentType == 1){
                            System.out.println("Студент сдал сессию в срок? (1 - да, 2 - нет)");
                            int examPassTimeNumber = studentAddInput.nextInt();
                            Boolean examPassConfirm;
                            if(examPassTimeNumber == 1){
                                examPassConfirm = true;
                            } else{
                                examPassConfirm = false;
                            }
                            array[students.length] = new ScholarshipStudent(studentName,studentGroup,studentAvgMark,array.length,examPassConfirm);
                            students = array;
                        }else if(studentType == 2){
                            System.out.println("Введите стоимость оплаты за обучение");
                            Double studentEduCost = studentAddInput.nextDouble();
                            array[students.length] = new ContractStudent(studentName,studentGroup,studentAvgMark,array.length,studentEduCost);
                            students = array;
                        }
                        break;
                    case 2:
                        Scanner studentSearchInput = new Scanner(System.in);
                        System.out.println("Введите номер студента по списку");
                        int studentListNumber = studentSearchInput.nextInt()-1;
                        System.out.println(studentsExample[studentListNumber].getStudentInfo());
                        break;
                    case 3:
                        for (Student student: studentsExample) {
                            System.out.println(student.getStudentInfo());
                        }
                        break;
                    case 4:
                        System.out.println("Студенты обучающиеся на платной основе");
                        for (Student student: studentsExample) {
                            if(student instanceof ContractStudent){
                                System.out.println(student.getStudentInfo());
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Студенты обучающиеся на бюджете");
                        for (Student student: studentsExample) {
                            if(student instanceof ScholarshipStudent){
                                System.out.println(student.getStudentInfo());
                            }
                        }
                        break;
                    case 6:
                        System.out.println("Средний балл всех студентов по итогу сессии: " + Student.getAvgMarkOfAllStudents(studentsExample));
                        break;
                    case 7:
                        isExit = true;
                        break;
                }
            } else {
                System.out.println("Извините, но это явно не число.");
            }
        }
    }
}