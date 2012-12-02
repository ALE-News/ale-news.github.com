package net.caimito.alenews.services;

import static org.junit.Assert.* ;
import static org.hamcrest.Matchers.* ;

import java.util.Locale;

import net.caimito.alenews.util.ArticleFactory;

import org.junit.Test;

public class InMemoryArticleStoreTest {

	@Test
	public void emptyArticleList() {
		ArticleStore articleStore = new InMemoryArticleStore() ;
		assertThat(articleStore.listArticles(), is(empty())) ;
	}
	
	@Test
	public void oneArticle() {
		ArticleStore articleStore = new InMemoryArticleStore() ;
		Article article = ArticleFactory.createArticle(Locale.ENGLISH, "Title", "Summary", "http://localhost", "Agile") ;
		articleStore.add(article) ;
		assertThat(articleStore.listArticles(), hasItem(equalTo(article))) ;
	}

	@Test
	public void filterOneArticle() {
		Article article = ArticleFactory.createArticle(Locale.ENGLISH, "Title", "Summary", "http://localhost", "Agile") ;
		
		ArticleStore articleStore = new InMemoryArticleStore() ;
		articleStore.add(article) ;
		assertThat(articleStore.listArticlesByTopic("Agile"), hasItem(equalTo(article))) ;
	}

}
