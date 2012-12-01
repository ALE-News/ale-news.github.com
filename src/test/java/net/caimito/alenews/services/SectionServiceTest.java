package net.caimito.alenews.services;

import static org.junit.Assert.* ;
import static org.hamcrest.Matchers.* ;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class SectionServiceTest {

	@Test
	public void noSections() {
		SectionService sectionService = new SectionService(new ArticleStore() {
			public Collection<Article> listArticles() {
				return Collections.emptyList() ;
			} }) ;
		assertThat(sectionService.listSections(), is(empty())) ;
	}
	
	@Test
	public void listAgileSection() {
		SectionService sectionService = new SectionService(new ArticleStore() {

			public Collection<Article> listArticles() {
				return Arrays.asList(new Article("Agile")) ;
			}} ) ;
		
		assertThat(sectionService.listSections(), hasItem(equalTo("Agile"))) ;
	}
}
