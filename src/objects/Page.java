package objects;

public class Page {
	private String title;
	private String link;
	
	public Page(String t, String l) {
		title = t;
		link = l;
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
