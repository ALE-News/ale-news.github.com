package net.caimito.alenews.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

import org.yaml.snakeyaml.Yaml;

public class FileArticleStore implements ArticleStore {

	private File articleFile;

	public FileArticleStore(final String fileName) {
		this.articleFile = new File(fileName);
	}

	public FileArticleStore() {
		try {
			File articleFile = File.createTempFile("articles", null);
			articleFile.deleteOnExit();

			this.articleFile = articleFile;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Collection<Article> listArticles(Locale locale, int limitNumberOfArticles) {
		Collection<Article> loadedArticles = loadYaml();
		Collection<Article> articles = new HashSet<Article>();

		for (Article article : loadedArticles) {
			if (article.getLanguage().equals(locale.getLanguage())) {
				articles.add(article);
				if (articles.size() == limitNumberOfArticles)
					break ;
			}
		}

		return articles;
	}

	private Collection<Article> loadYaml() {
		Collection<Article> articles = new HashSet<Article>();
		Yaml yaml = new Yaml();

		try {
			InputStream input = new FileInputStream(articleFile);
			for (Object collection : yaml.loadAll(input)) {
				for (Object item : (Iterable<Object>) collection) {
					Article article = (Article) item;
					articles.add(article);
				}
			}
		} catch (FileNotFoundException e) {
			return articles;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return articles;
	}

	public Collection<Article> listArticlesByTopic(Locale locale, String topic, int limitNumberOfArticles) {
		Collection<Article> allArticles = listArticles(locale, limitNumberOfArticles);
		Collection<Article> articles = new HashSet<Article>();

		for (Article article : allArticles) {
			if (article.getTopic().equals(topic))
				articles.add(article);
		}

		return articles;
	}

	public void add(Article article) {
		Collection<Article> existingArticles = loadYaml();
		existingArticles.add(article);

		Yaml yaml = new Yaml();
		try {
			FileWriter writer = new FileWriter(articleFile);
			writer.write(yaml.dump(existingArticles));
			writer.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
