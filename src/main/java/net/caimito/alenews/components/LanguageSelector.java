package net.caimito.alenews.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import net.caimito.alenews.pages.Index;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;

public class LanguageSelector {

	@Property
	private String language ;
	
	@Inject
	private PersistentLocale persistentLocale ;
	
	public List<String> getAvailableLanguages() {
		List<String> languages = new ArrayList<String>() ;
		languages.add(Locale.ENGLISH.getLanguage()) ;
		languages.add(Locale.GERMAN.getLanguage()) ;
		return languages ;
	}
	
	public Object onActionFromSelectLanguage(String language) {
		persistentLocale.set(new Locale(language)) ;
		
		return Index.class ;
	}

}
