package net.caimito.alenews.pages;

import java.util.Collection;
import java.util.Locale;

import net.caimito.alenews.services.SectionService;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;


public class Index {
	
	@Inject
	private SectionService sectionService ;
	
	@Property
	private String topicSection ;
	
	@Inject
	private Locale currentLocale ;
	
	private String language ;
	
	public String onPassivate() {
		return language ;
	}
	
	public void onActivate(String language) {
		this.language = language ;
	}
	
	public Collection<String> getTopicSections() {
		return sectionService.listSections(currentLocale) ;
	}
	
	public String getCurrentLanguage() {
		return currentLocale.getLanguage() ;
	}
}
