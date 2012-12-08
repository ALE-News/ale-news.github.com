package net.caimito.alenews.services;

import static org.junit.Assert.* ;
import static org.hamcrest.Matchers.* ;

import java.util.Locale;

import net.caimito.alenews.util.ArticleFactory;

import org.junit.Test;

public class FileArticleStoreTest {

	@Test
	public void listOneArticle() {
		Locale locale = Locale.ENGLISH ;
		Article article = new Article() ;
		article.setDestinationUrl("http://localhost") ;
		article.setLanguage(locale.getLanguage()) ;
		article.setSummary("summary") ;
		article.setTitle("title") ;
		article.setTopic("Agile") ;
		
		ArticleStore articleStore = new FileArticleStore() ;
		
		articleStore.add(article) ;
		assertThat(articleStore.listArticles(locale, ArticleStore.NO_LIMIT), hasItem(article)) ;
	}


	@Test
	public void listArticleWithLocale() {
		ArticleStore articleStore = new FileArticleStore() ;
		
		Article englishArticle = new Article() ;
		englishArticle.setDestinationUrl("http://localhost") ;
		englishArticle.setLanguage(Locale.ENGLISH.getLanguage()) ;
		englishArticle.setSummary("summary") ;
		englishArticle.setTitle("title") ;
		englishArticle.setTopic("Agile") ;
		articleStore.add(englishArticle) ;
		
		Article germanArticle = new Article() ;
		germanArticle.setDestinationUrl("http://localhost") ;
		germanArticle.setLanguage(Locale.GERMAN.getLanguage()) ;
		germanArticle.setSummary("summary") ;
		germanArticle.setTitle("title") ;
		germanArticle.setTopic("Agile") ;
		articleStore.add(germanArticle) ;
		
		assertThat(articleStore.listArticles(Locale.ENGLISH, ArticleStore.NO_LIMIT), hasItem(englishArticle)) ;
		assertThat(articleStore.listArticles(Locale.ENGLISH, ArticleStore.NO_LIMIT), not(hasItem(germanArticle))) ;
		assertThat(articleStore.listArticles(Locale.ENGLISH, ArticleStore.NO_LIMIT).size(), is(1)) ;
	}

	@Test
	public void filterOneArticleEnglish() {
		Article article = ArticleFactory.createArticle(Locale.ENGLISH, "Title", "Summary", "http://localhost", "Agile") ;
		Article articleGerman = ArticleFactory.createArticle(Locale.GERMAN, "Title", "Zusammenfassung", "http://localhost", "Agil") ;
		
		ArticleStore articleStore = new FileArticleStore() ;
		articleStore.add(article) ;
		articleStore.add(articleGerman) ;

		assertThat(articleStore.listArticlesByTopic(Locale.ENGLISH, "Agile", ArticleStore.NO_LIMIT), hasItem(equalTo(article))) ;
		assertThat(articleStore.listArticlesByTopic(Locale.ENGLISH, "Agile", ArticleStore.NO_LIMIT), not(hasItem(equalTo(articleGerman)))) ;
	}
	
	@Test
	public void limitNumberOfArticles() {
		Article article1 = ArticleFactory.createArticle(Locale.ENGLISH, "Title", "Summary", "http://localhost", "Agile") ;
		Article article2 = ArticleFactory.createArticle(Locale.ENGLISH, "Second Title", "Second Summary", "http://localhost", "Agile") ;
		
		ArticleStore articleStore = new FileArticleStore() ;
		articleStore.add(article1) ;
		articleStore.add(article2) ;
		
		assertThat(articleStore.listArticles(Locale.ENGLISH, 1).size(), is(1)) ;
	}

}
