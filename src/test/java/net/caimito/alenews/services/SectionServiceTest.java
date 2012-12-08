package net.caimito.alenews.services;

import static org.junit.Assert.* ;
import static org.hamcrest.Matchers.* ;

import java.util.Locale;

import net.caimito.alenews.util.ArticleFactory;

import org.junit.Test;

public class SectionServiceTest {

	@Test
	public void noSections() {
		SectionService sectionService = new SectionService(new FileArticleStore()) ;
		assertThat(sectionService.listSections(Locale.ENGLISH), is(empty())) ;
	}
	
	@Test
	public void listAgileSection() {
		ArticleStore articleStore = new FileArticleStore() ;
		articleStore.add(ArticleFactory.createArticle(Locale.ENGLISH, "Title", "Summary", "http://localhost", "Agile")) ;
		
		SectionService sectionService = new SectionService(articleStore) ;
		assertThat(sectionService.listSections(Locale.ENGLISH), hasItem(equalTo("Agile"))) ;
	}

	@Test
	public void listAgileSectionForEnglish() {
		ArticleStore articleStore = new FileArticleStore() ;
		articleStore.add(ArticleFactory.createArticle(Locale.GERMAN, "Titel", "Zusammenfassung", "http://localhost", "Agil")) ;
		articleStore.add(ArticleFactory.createArticle(Locale.ENGLISH, "Title", "Summary", "http://localhost", "Agile")) ;

		SectionService sectionService = new SectionService(articleStore) ;
		assertThat(sectionService.listSections(Locale.ENGLISH), hasItem(equalTo("Agile"))) ;
		assertThat(sectionService.listSections(Locale.ENGLISH), not(hasItem(equalTo("Agil")))) ;
	}
}
