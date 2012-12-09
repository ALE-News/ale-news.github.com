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
	
	@Inject
	private Locale currentLocale ;
	
	public List<String> getAvailableLanguages() {
		List<String> languages = new ArrayList<String>() ;
		languages.add(Locale.ENGLISH.getLanguage()) ;
		languages.add(Locale.GERMAN.getLanguage()) ;
		return languages ;
	}
	
	public void onPrepare() {
		article = new Article() ;
		article.setLanguage(currentLocale.getLanguage()) ;
	}
	
	public Object onSuccess() {
		articleStore.add(article) ;
		return Index.class ;
	}
}
