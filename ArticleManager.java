package org.example;

import java.util.ArrayList;
import java.util.List;

public class ArticleManager {

    private ArrayList<Article> articles = new ArrayList<>();

    public void addArticle(Article article) {
        articles.add(article);
    }

    public List<Article> getAllArticles() {
        return articles;
    }

    public Article searchArticle(String keyword) {

        String search = keyword.toLowerCase().trim();

        for (Article article : articles) {

            if (article.getTitle().toLowerCase().contains(search)
                || article.getDescription().toLowerCase().contains(search)
                || article.getDefinition().toLowerCase().contains(search)
                || article.getCoreConcepts().toLowerCase().contains(search)
                || article.getExamples().toLowerCase().contains(search)) {

                return article;
            }
        }

        return null;
    }
        public Article getArticleByTitle(String title) {
        for (Article article : articles) {
            if (article.getTitle().equalsIgnoreCase(title)) {
                return article;
            }
        }
        return null;
    }

    public List<Article> getArticlesByCategory(String category) {
        List<Article> list = new ArrayList<>();
        for (Article article : articles) {
            if (article.getCategory().equalsIgnoreCase(category)) {
                list.add(article);
            }
        }
        return list;
    }
        public List<Article> searchArticles(String keyword) {

        List<Article> results = new ArrayList<>();

        if (keyword == null || keyword.trim().isEmpty()) {
            return results;
        }

        String search = keyword.toLowerCase().trim();

        List<Article> titleMatches = new ArrayList<>();
        List<Article> categoryMatches = new ArrayList<>();
        List<Article> otherMatches = new ArrayList<>();

        for (Article article : articles) {

            if (article.getTitle().toLowerCase().contains(search)) {
                titleMatches.add(article);
            } else if (article.getCategory().toLowerCase().contains(search)) {
                categoryMatches.add(article);
            } else if (article.getDescription().toLowerCase().contains(search)
                    || article.getDefinition().toLowerCase().contains(search)
                    || article.getRelatedTopics().toLowerCase().contains(search)) {
                otherMatches.add(article);
            }
        }

        results.addAll(titleMatches);
        results.addAll(categoryMatches);
        results.addAll(otherMatches);

        return results;
    }
}
