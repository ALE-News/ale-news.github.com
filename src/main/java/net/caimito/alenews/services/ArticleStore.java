package net.caimito.alenews.services;

import java.util.Collection;
import java.util.Locale;

public interface ArticleStore {

	Collection<Article> listArticles(Locale locale);
	
	Collection<Article> listArticlesByTopic(Locale locale, String topic) ;

	void add(Article article);

}
