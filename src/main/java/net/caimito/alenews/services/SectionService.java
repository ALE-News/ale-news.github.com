package net.caimito.alenews.services;

import java.util.Collection;
import java.util.HashSet;

public class SectionService {
	
	private Collection<? extends Article> articles ;

	public SectionService(Collection<? extends Article> articles) {
		this.articles = articles ;
	}

	public Collection<String> listSections() {
		Collection<String> sections = new HashSet<String>() ;
		
		for (Article article : articles) {
			sections.add(article.getSection()) ;
		}
		
		return sections ;
	}

}
