package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/** Writes every article to docs/articles.json so the web version can show them. */
public class ExportJson {

    public static void main(String[] args) throws IOException {
        ArticleManager manager = new ArticleManager();
        ArticleData.loadArticles(manager);
        ArticleDataProgramming.load(manager);
        ArticleDataNetworking.load(manager);
        ArticleDataEmerging.load(manager);
        ArticleDataMore.load(manager);

        List<Article> all = manager.getAllArticles();
        StringBuilder sb = new StringBuilder("[\n");

        for (int i = 0; i < all.size(); i++) {
            Article a = all.get(i);
            sb.append("  {\"title\":").append(q(a.getTitle()));
            sb.append(",\"category\":").append(q(a.getCategory()));
            sb.append(",\"description\":").append(q(a.getDescription()));

            sb.append(",\"sections\":[");
            List<String[]> sections = sectionsOf(a);
            for (int j = 0; j < sections.size(); j++) {
                sb.append("{\"title\":").append(q(sections.get(j)[0]));
                sb.append(",\"content\":").append(q(sections.get(j)[1])).append("}");
                if (j < sections.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");

            sb.append(",\"references\":[");
            List<String> refs = a.getReferences();
            for (int j = 0; j < refs.size(); j++) {
                sb.append(q(refs.get(j)));
                if (j < refs.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("]}");
            sb.append(i < all.size() - 1 ? ",\n" : "\n");
        }
        sb.append("]\n");

        Path out = Paths.get("docs", "articles.json");
        Files.createDirectories(out.getParent());
        Files.write(out, sb.toString().getBytes(StandardCharsets.UTF_8));
        System.out.println("Exported " + all.size() + " articles to " + out);
    }

    /** Same section order the desktop reader uses. */
    private static List<String[]> sectionsOf(Article a) {
        List<String[]> list = new ArrayList<>();
        if (!a.getSections().isEmpty()) {
            for (Section s : a.getSections()) {
                list.add(new String[]{s.getTitle(), s.getContent()});
            }
        } else {
            list.add(new String[]{"Introduction", a.getDefinition()});
            list.add(new String[]{"History", a.getHistory()});
            list.add(new String[]{"Core Concepts", a.getCoreConcepts()});
            list.add(new String[]{"How It Works", a.getHowItWorks()});
            list.add(new String[]{"Types", a.getTypes()});
            list.add(new String[]{"Examples", a.getExamples()});
            list.add(new String[]{"Applications", a.getApplications()});
            list.add(new String[]{"Advantages", a.getAdvantages()});
            list.add(new String[]{"Limitations", a.getLimitations()});
            list.add(new String[]{"Related Topics", a.getRelatedTopics()});
        }
        return list;
    }

    /** Turns text into a safe JSON string. */
    private static String q(String s) {
        if (s == null) {
            return "\"\"";
        }
        StringBuilder b = new StringBuilder("\"");
        for (char c : s.toCharArray()) {
            switch (c) {
                case '"': b.append("\\\""); break;
                case '\\': b.append("\\\\"); break;
                case '\n': b.append("\\n"); break;
                case '\r': b.append("\\r"); break;
                case '\t': b.append("\\t"); break;
                default:
                    if (c < 0x20) {
                        b.append(String.format("\\u%04x", (int) c));
                    } else {
                        b.append(c);
                    }
            }
        }
        return b.append("\"").toString();
    }
}