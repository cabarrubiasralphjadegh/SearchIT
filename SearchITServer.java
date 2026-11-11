
package org.example;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class SearchITServer {

    public static void main(String[] args) throws IOException {

        ArticleManager manager = new ArticleManager();
        ArticleData.loadArticles(manager);

        HttpServer server = HttpServer.create(
            new InetSocketAddress(8080), 0
        );

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

            Article result = manager.searchArticle(keyword);

            String response;

            if (result != null) {
                response = "{"
                    + "\"found\":true,"
                    + "\"title\":\"" + escape(result.getTitle()) + "\","
                    + "\"category\":\"" + escape(result.getCategory()) + "\","
                    + "\"description\":\"" + escape(result.getDescription()) + "\","
                    + "\"definition\":\"" + escape(result.getDefinition()) + "\""
                    + "}";
            } else {
                response = "{\"found\":false}";
            }

            byte[] data = response.getBytes(StandardCharsets.UTF_8);

            exchange.getResponseHeaders().set(
                "Content-Type", "application/json; charset=UTF-8"
            );

            exchange.sendResponseHeaders(200, data.length);

            try (OutputStream output = exchange.getResponseBody()) {
                output.write(data);
            }
        });

        server.start();

        System.out.println("Search IT server is running!");
        System.out.println("Port: 8080");
    }

    private static String escape(String text) {
        return text.replace("\\", "\\\\")
                   .replace("\"", "\\\"")
                   .replace("\n", "\\n")
                   .replace("\r", "\\r");
    }
}
