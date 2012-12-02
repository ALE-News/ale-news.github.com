package net.caimito.alenews.services;

import static org.junit.Assert.* ;
import static org.hamcrest.Matchers.* ;

import org.junit.Test;

public class SectionServiceTest {

	@Test
	public void noSections() {
		SectionService sectionService = new SectionService(new InMemoryArticleStore()) ;
		assertThat(sectionService.listSections(), is(empty())) ;
	}
	
	@Test
	public void listAgileSection() {
		ArticleStore articleStore = new InMemoryArticleStore() ;
		Article article = new Article() ;
		article.setSection("Agile") ;
		articleStore.add(article) ;
		
		SectionService sectionService = new SectionService(articleStore) ;
		assertThat(sectionService.listSections(), hasItem(equalTo("Agile"))) ;
	}
}
