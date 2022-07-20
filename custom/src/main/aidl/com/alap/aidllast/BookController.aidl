// BookController.aidl
package com.alap.aidllast;

// Declare any non-default types here with import statements
import com.alap.aidllast.Book;
interface BookController {

    int getInt();//int类型
    String getString();//String类型
    List<Book> getBookList();//aidl对象
    void addBook(inout Book book);//aidl对象

}
