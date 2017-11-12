package objects;

import java.io.Serializable;

public class Slide  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7309197798824820392L;
	private String title, img, desc;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Slide(String n, String i,String d) {
		title = n;
		img = i;
		desc = d; 
	}
	@Override
	public String toString() {
		return title+", "+desc.substring(0, 15)+"...";
	}

}
 