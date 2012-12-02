package net.caimito.alenews.services;

public class Article {

	private String section ;
	private String summary ;
	private String destinationUrl ;
	private String title ;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSection() {
		return section ;
	}
	
	public void setSection(String section) {
		this.section = section;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDestinationUrl() {
		return destinationUrl;
	}

	public void setDestinationUrl(String destinationUrl) {
		this.destinationUrl = destinationUrl;
	}

}
