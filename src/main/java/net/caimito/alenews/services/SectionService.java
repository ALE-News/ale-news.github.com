package net.caimito.alenews.services;

import java.util.Collection;
import java.util.HashSet;

public class SectionService {

	private ArticleStore articleStore ;
	
	public SectionService(ArticleStore articleStore) {
		this.articleStore = articleStore ;
	}

	public Collection<String> listSections() {
		Collection<String> sections = new HashSet<String>() ;
		
		for (Article article : articleStore.listArticles()) {
			sections.add(article.getSection()) ;
		}
		
		return sections ;
	}

}
