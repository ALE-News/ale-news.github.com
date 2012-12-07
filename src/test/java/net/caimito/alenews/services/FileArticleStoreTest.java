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
		assertThat(articleStore.listArticles(locale), hasItem(article)) ;
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
		
		assertThat(articleStore.listArticles(Locale.ENGLISH), hasItem(englishArticle)) ;
		assertThat(articleStore.listArticles(Locale.ENGLISH), not(hasItem(germanArticle))) ;
		assertThat(articleStore.listArticles(Locale.ENGLISH).size(), is(1)) ;
	}

	@Test
	public void filterOneArticleEnglish() {
		Article article = ArticleFactory.createArticle(Locale.ENGLISH, "Title", "Summary", "http://localhost", "Agile") ;
		Article articleGerman = ArticleFactory.createArticle(Locale.GERMAN, "Title", "Zusammenfassung", "http://localhost", "Agil") ;
		
		ArticleStore articleStore = new FileArticleStore() ;
		articleStore.add(article) ;
		articleStore.add(articleGerman) ;

		assertThat(articleStore.listArticlesByTopic(Locale.ENGLISH, "Agile"), hasItem(equalTo(article))) ;
		assertThat(articleStore.listArticlesByTopic(Locale.ENGLISH, "Agile"), not(hasItem(equalTo(articleGerman)))) ;
	}

}
