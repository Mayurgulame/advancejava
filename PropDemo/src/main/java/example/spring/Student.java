package example.spring;

public class Student {
private String name;
private String interestedCourse;
private String hobby;
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(String name, String interestedCourse, String hobby) {
	super();
	this.name = name;
	this.interestedCourse = interestedCourse;
	this.hobby = hobby;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getInterestedCourse() {
	return interestedCourse;
}
public void setInterestedCourse(String interestedCourse) {
	this.interestedCourse = interestedCourse;
}
public String getHobby() {
	return hobby;
}
public void setHobby(String hobby) {
	this.hobby = hobby;
}

}
