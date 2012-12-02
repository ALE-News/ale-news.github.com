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
		assertThat(articleStore.listArticles(Locale.ENGLISH), is(empty())) ;
	}
	
	@Test
	public void oneArticleEnglish() {
		ArticleStore articleStore = new InMemoryArticleStore() ;
		Article article = ArticleFactory.createArticle(Locale.ENGLISH, "Title", "Summary", "http://localhost", "Agile") ;
		articleStore.add(article) ;

		Article articleGerman = ArticleFactory.createArticle(Locale.GERMAN, "Title", "Zusammenfassung", "http://localhost", "Agil") ;
		articleStore.add(articleGerman) ;

		assertThat(articleStore.listArticles(Locale.ENGLISH), hasItem(equalTo(article))) ;
		assertThat(articleStore.listArticles(Locale.ENGLISH), not(hasItem(equalTo(articleGerman)))) ;
	}

	@Test
	public void filterOneArticleEnglish() {
		Article article = ArticleFactory.createArticle(Locale.ENGLISH, "Title", "Summary", "http://localhost", "Agile") ;
		Article articleGerman = ArticleFactory.createArticle(Locale.GERMAN, "Title", "Zusammenfassung", "http://localhost", "Agil") ;
		
		ArticleStore articleStore = new InMemoryArticleStore() ;
		articleStore.add(article) ;
		articleStore.add(articleGerman) ;

		assertThat(articleStore.listArticlesByTopic(Locale.ENGLISH, "Agile"), hasItem(equalTo(article))) ;
		assertThat(articleStore.listArticlesByTopic(Locale.ENGLISH, "Agile"), not(hasItem(equalTo(articleGerman)))) ;
	}

}
