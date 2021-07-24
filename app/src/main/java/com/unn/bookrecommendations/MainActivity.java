package com.unn.bookrecommendations;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISION_REQUEST_STORAGE = 1000;
    private static final int READ_RQST_CD = 42;
    RecyclerView recyclerView;


    int images[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
            R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED) {
//            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISION_REQUEST_STORAGE);
//        }
        BookService bookService = new BookService();
//        System.out.println(bookService.parseBooks("C:\\Users\\raulp\\Desktop\\fisiertext\\mybooks.txt"));
        List<Book> books = readBooks();
        printBooks(books);
    }

    private void printBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println(book + "n");
        }
    }

    private List<Book> readBooks() {
        List<Book> result = new ArrayList<>();
        BookService bookService = new BookService();
        int count = 0;
        String data = "";
        try (InputStream inputStream = this.getResources().openRawResource(R.raw.fisierul);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        ) {
            while ((data = reader.readLine()) != null) {
                count++;
                result.add(bookService.fetchBook(data));

            }
            if (count == 5) {
                inputStream.close();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println(" -------------- -------------------- --------------------------------- ");
        } finally {
            System.out.println("forta psd");
            System.out.println("psd");
            System.out.println("psd");
        }

        return result;
    }


}