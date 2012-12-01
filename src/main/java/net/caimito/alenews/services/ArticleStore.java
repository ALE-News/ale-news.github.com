package net.caimito.alenews.services;

import java.util.Collection;

public interface ArticleStore {

	Collection<Article> listArticles();

	void add(Article article);

}
