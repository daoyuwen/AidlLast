package com.alap.aidllast;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AIDLService extends Service {

    private static final String TAG = "AIDLService";
    private final List<Book> bookList=new ArrayList<>();

    public AIDLService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();

        initData();
        Log.e(TAG, "onCreate: kaihsile" );

    }

    private void initData() {
        Book book1 = new Book("花千骨");
        Book book2 = new Book("公主小妹");
        Book book3 = new Book("仙剑奇侠传");
        Book book4 = new Book("飘");
        Book book5 = new Book("茶花女");
        Book book6 = new Book("解忧杂货铺");
        Book book7 = new Book("活着");
        Book book8 = new Book("三生三世十里桃花");
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        bookList.add(book6);
        bookList.add(book7);
        bookList.add(book8);
        Log.e(TAG, "initData: "+bookList );


    }

    private final BookController.Stub stub = new BookController.Stub() {
        @Override
        public int getInt() throws RemoteException {
            Log.e(TAG, "getInt: "+bookList.size() );
            return bookList == null ? 0 : bookList.size();

        }

        @Override
        public String getString() throws RemoteException {
            Log.e(TAG, "getInt: "+ bookList.get(0).getName() );
            return bookList == null ? "" : bookList.get(0).getName();
        }

        @Override
        public List<Book> getBookList() throws RemoteException {
            Log.e(TAG, "getInt: "+ bookList );
            return bookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            if (book != null) {
                bookList.add(book);
                Log.e(TAG, "getInt: 111"+ bookList );
            } else {
                Log.i("ruxing", "接收到了一个空对象 Inout");
            }
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind: "+stub );
        return stub;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: fuwuduanguanbi" );
    }
}
