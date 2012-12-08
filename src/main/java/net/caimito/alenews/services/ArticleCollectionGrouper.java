package net.caimito.alenews.services;

import java.util.ArrayList;
import java.util.List;

public class ArticleCollectionGrouper {

	public List<List<Article>> group(List<Article> articles, int groupSize) {
		List<List<Article>> collectionOfGroups = new ArrayList<List<Article>>() ;
		
		List<Article> group = new ArrayList<Article>() ;
		for (Article article : articles) {
			group.add(article) ;
			if (group.size() == groupSize) {
				collectionOfGroups.add(group) ;
				group = new ArrayList<Article>() ;
			}
		}
		
		return collectionOfGroups ;
	}

}
