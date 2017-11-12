package objects;

import java.io.Serializable;

public class iframeDemo extends Demo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5222431365999229528L;
	private String iframe;
	public iframeDemo(String ty, String ti,String i) {
		super(ty, ti);
		iframe=i;
	}
	public String getIframe() {
		return iframe;
	}
	public void setIframe(String iframe) {
		this.iframe = iframe;
	}
	public String printHTML() {
		return super.printHTML()+iframe;
	}
}
