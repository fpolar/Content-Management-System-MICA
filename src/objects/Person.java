package objects;

import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5355611415009047509L;
	private String name, img, title, school, contact;
	
	public Person(String n, String i, String t, String s, String c) {
		name = n;
		img = i;
		title = t;
		school = s;
		contact = c;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return name+", "+title+", "+school+", "+contact;
	}
}
