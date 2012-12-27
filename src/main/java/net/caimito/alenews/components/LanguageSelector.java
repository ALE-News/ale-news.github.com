package net.caimito.alenews.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import net.caimito.alenews.pages.Index;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;

public class LanguageSelector {

	private static Map<String, String> flagNames = new HashMap<String, String>() ;
	
	static {
		flagNames.put("en", "flag_rotate-02.png") ;
		flagNames.put("de", "flag_rotate-03.png") ;
		flagNames.put("es", "flag_rotate-12.png") ;
	}
	
	@Property
	private String language ;
	
	@Inject
	private PersistentLocale persistentLocale ;
	
	public List<String> getAvailableLanguages() {
		List<String> languages = new ArrayList<String>() ;
		languages.add(Locale.ENGLISH.getLanguage()) ;
		languages.add(Locale.GERMAN.getLanguage()) ;
		languages.add("es") ;
		return languages ;
	}
	
	public Object onActionFromSelectLanguage(String language) {
		persistentLocale.set(new Locale(language)) ;
		
		return Index.class ;
	}
	
	public int getGridFillerIndex() {
		return 12 - getAvailableLanguages().size() ;
	}
	
	public String getFlagName() {
		return flagNames.get(language) ;
	}

}
