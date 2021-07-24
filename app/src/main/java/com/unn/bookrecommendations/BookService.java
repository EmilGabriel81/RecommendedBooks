package com.unn.bookrecommendations;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BookService extends AppCompatActivity {

//    private List<Book> parseBooks() {
//        List<Book> result = new ArrayList<>();
//        BookService bookService = new BookService();
//        int count = 0;
//        String data = "";
//        try (InputStream inputStream = this.getResources().openRawResource(R.raw.fisierul);
//             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//
//        ) {
//            while ((data = reader.readLine()) != null) {
//                count++;
//                result.add(bookService.fetchBook(data));
//
//            }
//            if (count==5){
//                inputStream.close();
//            }
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        } finally {
//            System.out.println("psd");
//            System.out.println("psd");
//            System.out.println("psd");
//        }
//
//        return result;
//    }

    public Book fetchBook(String line) {
        String [] bookDetails = line.split("\\|");
        int id = Integer.parseInt(bookDetails[0]);
        String name = bookDetails[1];
        String authors = bookDetails[2];
        String description = bookDetails[3];
        //System.out.println("name in file "+bookDetails[2]);
        return new Book(id, name, authors, description);
    }

//    public List<Book> getBookList(){
//        List<Book>books = new ArrayList<Book>();
//        books.addAll(parseBooks());
//        return books;
//    }
}
