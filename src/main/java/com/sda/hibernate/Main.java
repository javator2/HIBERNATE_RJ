package com.sda.hibernate;

import com.sda.hibernate.entity.Author;
import com.sda.hibernate.entity.Book;
import com.sda.hibernate.entity.Category;
import com.sda.hibernate.entity.Publisher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);

        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {

        Book book = new Book();
        book.setIsbn("324-234");
        book.setTitle("Nowe");

        Book book1 = new Book("Kolejne", "2");

        Session session = getSession();
        Transaction tx = session.getTransaction();

        tx.begin();
        session.save(book);
        session.save(book1);
        tx.commit();

        tx.begin();
        Book book2 = new Book("Nastepne", "3");
        session.save(book2);
        tx.commit();

        tx.begin();
        Category category = new Category("Komedia ");
        session.save(category);
        Category category1 = new Category("Horror");
        session.save(category1);
        tx.commit();

/*
        List<Book> bookList = session.createQuery("from " + Book.class.getName()).list();
        for (Book b : bookList){
            b = (Book) session.createQuery("delete from book where " + b.getTitle() + " = 'Nowe'").uniqueResult();
            System.out.println(b.getAuthor() + " " + b.getTitle());
        }

*/

/*        Book book3 = session.byId(Book.class).getReference(1);            // usuwanie ksiazki
        System.out.println(book3);

        tx.begin();
        session.delete(book3);
        tx.commit();

        session.close();*/
        Set<Author> authors = new HashSet<Author>();                     // tworzymy mape autorow, tworzymy ich i dodajemy do mapy
        Author author = new Author("Tomek", "Nowak");
        Author author1 = new Author("Ignacy", "Motykak");
        Author author2 = new Author("Witek", "Nawalka");
        authors.add(author);
        authors.add(author1);
        authors.add(author2);

        Publisher publisher = new Publisher("PWN", "Mickiewicza", "Torun");
        Category category2 = new Category("Fantastyka67");
        Book book3 = new Book();
        book3.setTitle("Jeszcze jedna");
        book3.setIsbn("3245-54353-432");
        book3.setCategory(category2);
        book3.setPublisher(publisher);
        book3.setAuthor(authors);

        tx.begin();
        session.save(book3);
        tx.commit();
        session.close();
    }
}

