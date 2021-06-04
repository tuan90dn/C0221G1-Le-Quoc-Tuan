package model.bean.employee_class;

public class EmployeeEducationDegree {
    public int education_degree_id;
    public String education_degree_name;

    public EmployeeEducationDegree() {
    }

    public EmployeeEducationDegree(int education_degree_id, String education_degree_name) {
        this.education_degree_id = education_degree_id;
        this.education_degree_name = education_degree_name;
    }

    public int getEducation_degree_id() {
        return education_degree_id;
    }

    public void setEducation_degree_id(int education_degree_id) {
        this.education_degree_id = education_degree_id;
    }

    public String getEducation_degree_name() {
        return education_degree_name;
    }

    public void setEducation_degree_name(String education_degree_name) {
        this.education_degree_name = education_degree_name;
    }
}
