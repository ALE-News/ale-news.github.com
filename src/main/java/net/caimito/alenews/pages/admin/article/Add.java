package net.caimito.alenews.pages.admin.article;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import net.caimito.alenews.pages.Index;
import net.caimito.alenews.services.Article;
import net.caimito.alenews.services.ArticleStore;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

public class Add {

	@Property
	private Article article ;
	
	@Inject
	private ArticleStore articleStore ;
	
	public List<String> getAvailableLanguages() {
		List<String> languages = new ArrayList<String>() ;
		languages.add(Locale.ENGLISH.getISO3Language()) ;
		languages.add(Locale.GERMAN.getISO3Language()) ;
		return languages ;
	}
	
	public Object onSuccess() {
		articleStore.add(article) ;
		return Index.class ;
	}
}
