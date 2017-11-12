package objects;

import java.io.Serializable;

public class videoDemo extends Demo  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5446995988714862792L;
	private String video;
	public videoDemo(String ty, String ti, String v) {
		super(ty, ti);
		video = v;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
}
