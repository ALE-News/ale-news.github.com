package net.caimito.alenews.pages;

import java.util.Collection;

import net.caimito.alenews.services.SectionService;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;


public class Index {
	
	@Inject
	private SectionService sectionService ;
	
	@Property
	private String topicSection ;
	
	@Inject
	private PersistentLocale persistentLocale ;
	
	private String language ;
	
	public String onPassivate() {
		return language ;
	}
	
	public void onActivate(String language) {
		this.language = language ;
	}
	
	public Collection<String> getTopicSections() {
		return sectionService.listSections(persistentLocale.get()) ;
	}
}
