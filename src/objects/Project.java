package objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Project implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 466132100907586276L;
	private String title;
	private String description;
	private ArrayList<String> instructions;
	private ArrayList<Demo> demos;
	public Project(String t, String d) {
		title = t;
		description = d;
		instructions = new ArrayList<String>();
		demos = new ArrayList<Demo>();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<String> getInstructions() {
		return instructions;
	}
	public void setInstructions(ArrayList<String> instructions) {
		this.instructions = instructions;
	}
	public ArrayList<Demo> getDemos() {
		return demos;
	}
	public void setDemos(ArrayList<Demo> demos) {
		this.demos = demos;
	}
	@Override
	public String toString() {
		return title+", "+description.substring(0, 15)+"... (instructions-"+instructions.size()+", demos-"+demos.size()+")";
	}
}
