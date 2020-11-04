package com.luedtkecode.booksearch.book;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final Books books;

    @Autowired
    public BookService() throws GeneralSecurityException, IOException {
        books = new Books(GoogleNetHttpTransport.newTrustedTransport(), new JacksonFactory(), null);
    }

    public List<Volume> getBooksByName(String name) {
        Volumes volumes = null;

        try {
            Books.Volumes.List request = books.volumes().list(name);
            volumes = request.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return volumes != null ? volumes.getItems() : new ArrayList<Volume>();
    }
}
