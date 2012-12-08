package net.caimito.alenews.services;

import java.util.List;
import java.util.Locale;

public interface ArticleStore {

	int NO_LIMIT = -1 ;

	List<Article> listArticles(Locale locale, int limitNumberOfArticles);
	
	List<Article> listArticlesByTopic(Locale locale, String topic, int limitNumberOfArticles) ;

	void add(Article article);

}
