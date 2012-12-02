package net.caimito.alenews.services;

import java.util.Collection;

public interface ArticleStore {

	Collection<Article> listArticles();
	
	Collection<Article> listArticlesByTopic(String topic) ;

	void add(Article article);

}
