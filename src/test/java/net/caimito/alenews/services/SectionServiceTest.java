package net.caimito.alenews.services;

import static org.junit.Assert.* ;
import static org.hamcrest.Matchers.* ;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class SectionServiceTest {

	@Test
	public void noSections() {
		SectionService sectionService = new SectionService(Collections.<Article>emptyList()) ;
		assertThat(sectionService.listSections(), is(empty())) ;
	}
	
	@Test
	public void listAgileSection() {
		List<Article> articles = Arrays.asList(new Article("Agile")) ;
		
		SectionService sectionService = new SectionService(articles) ;
		
		assertThat(sectionService.listSections(), hasItem(equalTo("Agile"))) ;
	}
}
