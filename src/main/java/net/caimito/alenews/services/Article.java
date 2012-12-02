package net.caimito.alenews.services;

import org.apache.tapestry5.beaneditor.Validate;

public class Article {

	@Validate("required")
	private String topic ;
	
	@Validate("required")
	private String summary ;
	
	@Validate("required")
	private String destinationUrl ;
	
	@Validate("required")
	private String title ;
	
	private String language ;
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTopic() {
		return topic ;
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
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
