
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
}
