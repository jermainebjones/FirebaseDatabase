package com.jermainebjonesgmail.firebasedatabase;

public class Students {

    private String studentId;
    private String studentName;
    private String studentClass;

    public Students() {

    }

    public Students(String studentId, String studentName, String studentClass) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
}
