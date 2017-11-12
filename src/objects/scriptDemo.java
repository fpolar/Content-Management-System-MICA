package objects;

import java.io.Serializable;

public class scriptDemo extends Demo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5760901514870459853L;
	private String script;
	public scriptDemo(String ty, String ti, String sc) {
		super(ty, ti);
		script = sc;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}
	public String printHTML() {
		return super.printHTML()+"<script src=\""+script+"\"></script>";
	}
}