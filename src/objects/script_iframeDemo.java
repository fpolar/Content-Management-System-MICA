package objects;

import java.io.Serializable;

public class script_iframeDemo extends Demo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6748191025887146555L;
	private String iframe;
	private String script;
	public script_iframeDemo(String ty, String ti,String i, String sc) {
		super(ty, ti);
		iframe=i;
		script=sc;
	}
	public String getIframe() {
		return iframe;
	}
	public void setIframe(String iframe) {
		this.iframe = iframe;
	}
	public String getScript() {
		return script;
	}
	public void setScript(String script) {
		this.script = script;
	}
	public String printHTML() {
		return super.printHTML()+iframe+"<script src=\""+script+"\"></script>";
	}
}
