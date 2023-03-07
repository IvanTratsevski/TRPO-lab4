public abstract class Student {
    protected String name;
    protected String group;
    protected double avgMark;
    protected int listNumber;
    public Student(String name, String group, Double avgMark, int listNumber){
        this.name = name;
        this.group = group;
        this.avgMark = avgMark;
        this.listNumber = listNumber;
    }
    public static Double getAvgMarkOfAllStudents(Student[] students){
        double sumOfMarks = 0.0;
        for(int i = 0; i< students.length;i++){
            sumOfMarks += students[i].getAvgMark();
        }
        return sumOfMarks/students.length;
    }
    public Double getAvgMark() {return avgMark;}
    public String getName(){return name;}
    public String getGroup(){return group;}
    public int getListNumber(){return listNumber;}
    public abstract String getStudentInfo();
}

