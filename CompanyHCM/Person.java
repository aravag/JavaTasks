package CompanyHCM;
public class Person {
    protected String department;
    protected String name;
    protected String age;
    protected String jobTitle;
    protected String phone;
    protected String email;

    public Person(String department, String name, String age, String jobTitle, String phone, String email) {
        this.department = department;
        this.name = name;
        this.age = age;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "\nDepartment: " + department + "\nName: " + name + "\nAge: " + age + "\nJob Title: " + jobTitle
                + "\nPhone: " + phone + "\nEmail: " + email;
    }

}
