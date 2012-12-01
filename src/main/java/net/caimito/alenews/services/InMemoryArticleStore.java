package net.caimito.alenews.services;

import java.util.Collection;
import java.util.HashSet;

public class InMemoryArticleStore implements ArticleStore {

	private Collection<Article> articles = new HashSet<Article>() ;
	
	public Collection<Article> listArticles() {
		return articles ;
	}

	public void add(Article article) {
		articles.add(article) ;
	}

}
