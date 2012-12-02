package net.caimito.alenews.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class InMemoryArticleStore implements ArticleStore {

	private Collection<Article> articles = new HashSet<Article>() ;
	
	public Collection<Article> listArticlesByTopic(String topic) {
		Collection<Article> selectedArticles = new ArrayList<Article>() ;
		
		for (Article article : articles) {
			if (topic.equalsIgnoreCase(article.getSection()))
				selectedArticles.add(article) ;
		}
		
		return selectedArticles ;
	}

	public void add(Article article) {
		articles.add(article) ;
	}

	public Collection<Article> listArticles() {
		return articles ;
	}

}
