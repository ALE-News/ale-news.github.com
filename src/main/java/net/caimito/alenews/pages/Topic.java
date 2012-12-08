package net.caimito.alenews.pages;

import org.apache.tapestry5.annotations.Property;

public class Topic {

	@Property
	private String topic ;
	
	public void onActivate(String topic) {
		this.topic = topic ;
	}
	
	public String onPassivate() {
		return topic ;
	}
	
}
