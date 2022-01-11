package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private static Book first = new Book(1, "Dracula", 1000, "Bram Stoker");
    private static Book second = new Book(2, "The Picture of Dorian Gray", 900, "Oscar Wilde");
    private static Book third = new Book(3, "Three Men In a Boat", 600, "Jerome K. Jerome");
    private static Smartphone fourth = new Smartphone(4, "iPhone 8 plus", 40000, "Apple");
    private static Smartphone fifth = new Smartphone(5, "Galaxy S21", 65000, "Samsung");
    private static Smartphone sixth = new Smartphone(6, "9 Pro", 40000, "One Plus");


    static ProductRepository repository = new ProductRepository();
    static ProductManager manager = new ProductManager(repository);

    @BeforeAll
    public static void init() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        System.out.println(repository);
    }


    @Test
    public void shouldSearchByBookAuthor() {

        Product[] actual = manager.searchBy("Bram Stoker");
        Book[] expected = {first};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldSearchByBookName() {

        Product[] actual = manager.searchBy("Three Men In a Boat");
        Book[] expected = {third};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldSearchBySmartphoneMaker() {

        Product[] actual = manager.searchBy("Apple");
        Smartphone[] expected = {fourth};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldSearchBySmartphoneName() {

        Product[] actual = manager.searchBy("9 Pro");
        Smartphone[] expected = {sixth};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldReturnNoMatches() {

        Product[] actual = manager.searchBy("11 Pro Max");
        Product[] expected = {};
        assertArrayEquals(actual, expected);

    }


}