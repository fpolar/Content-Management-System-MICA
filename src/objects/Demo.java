package objects;

import java.io.Serializable;

public class Demo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3409914694347427302L;
	private String type, title, id;

	public Demo(String ty, String ti, String i) {
		type = ty;
		title = ti;
		id = i;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return title+" ("+type+")";
	}

	public String printHTML() {
		return "<h3>"+title+"</h3>";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
