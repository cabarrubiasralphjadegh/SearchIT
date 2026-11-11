
import java.util.List;

public class SearchITApplication {

    public static void main(String[] args) {

        ArticleManager manager = new ArticleManager();

        // Load encyclopedia articles
        ArticleData.loadArticles(manager);

        System.out.println("================================");
        System.out.println("          SEARCH IT");
        System.out.println("================================");

        System.out.println("Total Articles: "
                + manager.getAllArticles().size());

        System.out.println("\nAvailable Articles:");

        for (Article article : manager.getAllArticles()) {
            System.out.println("- " + article.getTitle());
        }

        // Test the search feature
        String keyword = "programming";

        Article result = manager.searchArticle(keyword);

        System.out.println("\nSearch: " + keyword);

        if (result != null) {

            System.out.println("Article Found: "
                    + result.getTitle());

            System.out.println("Category: "
                    + result.getCategory());

            System.out.println("Description: "
                    + result.getDescription());

            System.out.println("\nDefinition:");
            System.out.println(result.getDefinition());

        } else {
            System.out.println("No matching article found.");
        }
    }
}

