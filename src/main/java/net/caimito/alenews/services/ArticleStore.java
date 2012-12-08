package net.caimito.alenews.services;

import java.util.Collection;
import java.util.Locale;

public interface ArticleStore {

	int NO_LIMIT = -1 ;

	Collection<Article> listArticles(Locale locale, int limitNumberOfArticles);
	
	Collection<Article> listArticlesByTopic(Locale locale, String topic, int limitNumberOfArticles) ;

	void add(Article article);

}
