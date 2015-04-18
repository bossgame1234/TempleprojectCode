package camt.se331.templeProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course implements Comparable{
    @Id
    @GeneratedValue
    long id;
    String course_id;
    String name;
    int credit;
    String section;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseId() {
        return course_id;
    }

    public void setCourseId(String id) {
        this.course_id = id;
    }


    public Course(){
    }


    public Course(String id,String name, int credit ,String section) {
        this.name = name;
        this.section = section;
        this.credit = credit;
        this.course_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (credit != course.credit) return false;
        if (course_id != null ? !course_id.equals(course.id) : course.course_id != null) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        if (section != null ? !section.equals(course.section) : course.section != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = course_id != null ? course_id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + credit;
        result = 31 * result + (section != null ? section.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        return  (int) (this.getId() - ((Course)o).getId());
    }
}
