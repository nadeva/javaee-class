package fr.nadeva;

import net.codestory.http.WebServer;

public class FluentServer {

    public static void main(String args[]) {
        int port = startServer(new Book("Passionate Programmer", 19.99));
        System.out.println("Server started on http://localhost:" + port);
    }

    public static int startServer(Book book) {
        return new WebServer().configure(routes -> routes.get("/", book)).startOnRandomPort().port();
    }
}
