package net.caimito.alenews.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

public class SectionService {

	private ArticleStore articleStore ;
	
	public SectionService(ArticleStore articleStore) {
		this.articleStore = articleStore ;
	}

	public Collection<String> listSections(Locale localeExpected) {
		Collection<String> sections = new HashSet<String>() ;
		
		for (Article article : articleStore.listArticles()) {
			if (localeExpected.getISO3Language().equals(article.getLanguage()))
				sections.add(article.getTopic()) ;
		}
		
		return sections ;
	}

}
