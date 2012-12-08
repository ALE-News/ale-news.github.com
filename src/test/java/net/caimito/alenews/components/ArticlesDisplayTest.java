package net.caimito.alenews.components;

import static org.junit.Assert.* ;
import static org.hamcrest.Matchers.* ;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import net.caimito.alenews.services.Article;
import net.caimito.alenews.services.ArticleCollectionGrouper;
import net.caimito.alenews.util.ArticleFactory;

import org.junit.Test;

public class ArticlesDisplayTest {

	@Test
	public void chopArticleCollectionInChunks() {
		List<Article> articles = new ArrayList<Article>() ;
		articles.add(ArticleFactory.createArticle(Locale.ENGLISH, "Article 1", "Summary 1", "http://localhost", "Agile")) ;
		articles.add(ArticleFactory.createArticle(Locale.ENGLISH, "Article 2", "Summary 2", "http://localhost", "Agile")) ;
		articles.add(ArticleFactory.createArticle(Locale.ENGLISH, "Article 3", "Summary 3", "http://localhost", "Agile")) ;
		articles.add(ArticleFactory.createArticle(Locale.ENGLISH, "Article 4", "Summary 4", "http://localhost", "Agile")) ;
		articles.add(ArticleFactory.createArticle(Locale.ENGLISH, "Article 5", "Summary 5", "http://localhost", "Agile")) ;
		articles.add(ArticleFactory.createArticle(Locale.ENGLISH, "Article 6", "Summary 6", "http://localhost", "Agile")) ;
		articles.add(ArticleFactory.createArticle(Locale.ENGLISH, "Article 7", "Summary 7", "http://localhost", "Agile")) ;
		
		ArticleCollectionGrouper grouper = new ArticleCollectionGrouper() ;
		
		List<List<Article>> articleCollections = grouper.group(articles, 3) ;
		
		assertThat(articleCollections.size(), is(2)) ;
		assertThat(articleCollections.get(0).size(), is(3)) ;
		assertThat(articleCollections.get(1).size(), is(3)) ;
	}
	
}
