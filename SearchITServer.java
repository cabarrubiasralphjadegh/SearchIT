
package org.example;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class SearchITServer {

    public static void main(String[] args) throws IOException {

        ArticleManager manager = new ArticleManager();
        AccountStore accounts = new AccountStore();

        ArticleData.loadArticles(manager);
        ArticleDataProgramming.load(manager);
        ArticleDataNetworking.load(manager);
        ArticleDataEmerging.load(manager);
        ArticleDataMore.load(manager);

        HttpServer server = HttpServer.create(
            new InetSocketAddress(8080), 0
        );

server.createContext("/api/register", exchange -> {
    exchange.getResponseHeaders().set(
        "Access-Control-Allow-Origin", "*"
    );

    if (!exchange.getRequestMethod().equals("POST")) {
        exchange.sendResponseHeaders(405, -1);
        exchange.close();
        return;
    }

    try {
        String body = new String(
            exchange.getRequestBody().readAllBytes(),
            StandardCharsets.UTF_8
        );

        String username = getFormValue(body, "username");
        String email = getFormValue(body, "email");
        String password = getFormValue(body, "password");

        boolean registered = accounts.register(
            username, email, password.toCharArray()
        );

        sendJson(exchange, registered
            ? "{\"success\":true,\"message\":\"Account created!\"}"
            : "{\"success\":false,\"message\":\"Username or email already exists.\"}"
        );

    } catch (Exception e) {
        sendJson(exchange,
            "{\"success\":false,\"message\":\"Registration failed.\"}"
        );
    }
});

server.createContext("/api/login", exchange -> {
    exchange.getResponseHeaders().set(
        "Access-Control-Allow-Origin", "*"
    );

    if (!exchange.getRequestMethod().equals("POST")) {
        exchange.sendResponseHeaders(405, -1);
        exchange.close();
        return;
    }

    try {
        String body = new String(
            exchange.getRequestBody().readAllBytes(),
            StandardCharsets.UTF_8
        );

        String username = getFormValue(body, "username");
        String password = getFormValue(body, "password");

        boolean authenticated = accounts.authenticate(
            username, password.toCharArray()
        );

        sendJson(exchange, authenticated
            ? "{\"success\":true,\"message\":\"Login successful!\"}"
            : "{\"success\":false,\"message\":\"Invalid username or password.\"}"
        );

    } catch (Exception e) {
        sendJson(exchange,
            "{\"success\":false,\"message\":\"Login failed.\"}"
        );
    }
});


        server.createContext("/api/search", exchange -> {

            exchange.getResponseHeaders().set(
                "Access-Control-Allow-Origin", "*"
            );

            String query = exchange.getRequestURI()
                .getRawQuery();

            String keyword = "";

            if (query != null && query.startsWith("q=")) {
                keyword = URLDecoder.decode(
                    query.substring(2),
                    StandardCharsets.UTF_8
                );
            }

            List<Article> results = manager.searchArticles(keyword);

StringBuilder json = new StringBuilder();
json.append("{\"found\":").append(!results.isEmpty())
    .append(",\"count\":").append(results.size())
    .append(",\"results\":[");

for (int i = 0; i < results.size(); i++) {
    Article a = results.get(i);

    if (i > 0) {
        json.append(",");
    }

    json.append("{")
        .append("\"title\":\"").append(escape(a.getTitle())).append("\",")
        .append("\"category\":\"").append(escape(a.getCategory())).append("\",")
        .append("\"description\":\"").append(escape(a.getDescription())).append("\",")
        .append("\"definition\":\"").append(escape(a.getDefinition())).append("\"")
        .append("}");
}

json.append("]}");

String response = json.toString();

            byte[] data = response.getBytes(StandardCharsets.UTF_8);

            exchange.getResponseHeaders().set(
                "Content-Type", "application/json; charset=UTF-8"
            );

            exchange.sendResponseHeaders(200, data.length);

            try (OutputStream output = exchange.getResponseBody()) {
                output.write(data);
            }
        });

                server.createContext("/api/article", exchange -> {

            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");

            String query = exchange.getRequestURI().getRawQuery();
            String title = "";

            if (query != null && query.startsWith("title=")) {
                title = URLDecoder.decode(query.substring(6), StandardCharsets.UTF_8);
            }

            Article a = manager.getArticleByTitle(title);
            String response;

            if (a == null) {
                response = "{\"found\":false}";
            } else {
                StringBuilder json = new StringBuilder();
                json.append("{\"found\":true,")
                    .append("\"title\":\"").append(escape(a.getTitle())).append("\",")
                    .append("\"category\":\"").append(escape(a.getCategory())).append("\",")
                    .append("\"description\":\"").append(escape(a.getDescription())).append("\",")
                    .append("\"definition\":\"").append(escape(a.getDefinition())).append("\",")
                    .append("\"history\":\"").append(escape(a.getHistory())).append("\",")
                    .append("\"coreConcepts\":\"").append(escape(a.getCoreConcepts())).append("\",")
                    .append("\"howItWorks\":\"").append(escape(a.getHowItWorks())).append("\",")
                    .append("\"types\":\"").append(escape(a.getTypes())).append("\",")
                    .append("\"examples\":\"").append(escape(a.getExamples())).append("\",")
                    .append("\"applications\":\"").append(escape(a.getApplications())).append("\",")
                    .append("\"advantages\":\"").append(escape(a.getAdvantages())).append("\",")
                    .append("\"limitations\":\"").append(escape(a.getLimitations())).append("\",")
                    .append("\"relatedTopics\":\"").append(escape(a.getRelatedTopics())).append("\",")
                    .append("\"references\":[");

                List<String> refs = a.getReferences();
                for (int i = 0; i < refs.size(); i++) {
                    if (i > 0) json.append(",");
                    json.append("\"").append(escape(refs.get(i))).append("\"");
                }

                json.append("],\"sections\":[");

                List<Section> secs = a.getSections();
                for (int i = 0; i < secs.size(); i++) {
                    if (i > 0) json.append(",");
                    json.append("{\"title\":\"").append(escape(secs.get(i).getTitle()))
                        .append("\",\"content\":\"").append(escape(secs.get(i).getContent()))
                        .append("\"}");
                }

                json.append("],\"sameCategory\":[");

                List<Article> same = manager.getArticlesByCategory(a.getCategory());
                for (int i = 0; i < same.size(); i++) {
                    if (i > 0) json.append(",");
                    json.append("\"").append(escape(same.get(i).getTitle())).append("\"");
                }

                json.append("]}");
                response = json.toString();
            }

            byte[] data = response.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
            exchange.sendResponseHeaders(200, data.length);

            try (OutputStream output = exchange.getResponseBody()) {
                output.write(data);
            }
        });

        server.start();

        System.out.println("Search IT server is running!");
        System.out.println("Port: 8080");
    }
    
private static String getFormValue(String body, String key) {
    String[] pairs = body.split("&");

    for (String pair : pairs) {
        String[] parts = pair.split("=", 2);

        if (parts.length == 2 &&
            parts[0].equals(key)) {

            return URLDecoder.decode(
                parts[1],
                StandardCharsets.UTF_8
            );
        }
    }

    return "";
}

private static void sendJson(
    HttpExchange exchange,
    String response
) throws IOException {

    byte[] data = response.getBytes(StandardCharsets.UTF_8);

    exchange.getResponseHeaders().set(
        "Content-Type", "application/json; charset=UTF-8"
    );

    exchange.sendResponseHeaders(200, data.length);

    try (OutputStream output = exchange.getResponseBody()) {
        output.write(data);
    }
}

    private static String escape(String text) {
        return text.replace("\\", "\\\\")
                   .replace("\"", "\\\"")
                   .replace("\n", "\\n")
                   .replace("\r", "\\r");
    }
}
