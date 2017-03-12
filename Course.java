/**
 * 
 */
package week5;
import java.util.*;

/**
 * @author beast
 * Ex 11_5
 */
public class Course {

    String courseName;
    ArrayList<String> classList = new ArrayList<>();

    public Course(String Name) {
        courseName = Name;
    }

    public void addStudent(String student) {

    	classList.add(student);
    }

    public String[] getClassList() {
        return classList.toArray(new String[classList.size()]);
    }

    public int getClassSize() {
        return classList.size();
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {

    	classList.remove(student);

    }

    public void clear(){
    	classList.clear();
    }

}