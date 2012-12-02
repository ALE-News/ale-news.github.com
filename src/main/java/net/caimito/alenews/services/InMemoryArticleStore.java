package net.caimito.alenews.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

public class InMemoryArticleStore implements ArticleStore {

	private HashMap<Locale, Collection<Article>> articles = new HashMap<Locale, Collection<Article>>() ; 

	public Collection<Article> listArticlesByTopic(Locale locale, String topic) {
		Collection<Article> selectedArticles = new ArrayList<Article>() ;
		
		if (articles.get(locale) == null)
			return selectedArticles ;
		else {
			for (Article article : articles.get(locale)) {
				if (topic.equalsIgnoreCase(article.getTopic()))
					selectedArticles.add(article) ;
			}
		}
		
		return selectedArticles ;
	}

	public void add(Article article) {
		Locale articleLocale = new Locale(article.getLanguage()) ;
		
		if (articles.get(articleLocale) == null)
			articles.put(articleLocale, new HashSet<Article>()) ;
		
		articles.get(articleLocale).add(article) ;
	}

	public Collection<Article> listArticles(Locale locale) {
		if (articles.get(locale) == null) {
			articles.put(locale, new HashSet<Article>()) ;
		}
		
		Collection<Article> selectedArticles = articles.get(locale) ;
		return selectedArticles ;
	}

}
