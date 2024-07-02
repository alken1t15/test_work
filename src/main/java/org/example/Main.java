package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBooks();
                    break;
                case 4:
                    displayAllBooks();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nСистема управления библиотекой");
        System.out.println("1. Добавить книгу");
        System.out.println("2. Удалить книгу");
        System.out.println("3. Искать книги");
        System.out.println("4. Показать все книги");
        System.out.println("5. Выйти");
        System.out.print("Введите ваш выбор: ");
    }

    private static void addBook() {
        System.out.print("Введите название: ");
        String title = scanner.nextLine();
        System.out.print("Введите автора: ");
        String author = scanner.nextLine();
        System.out.print("Введите год: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите ISBN: ");
        String isbn = scanner.nextLine();

        try {
            Book book = new Book(title, author, year, isbn);
            library.addBook(book);
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении книги: " + e.getMessage());
        }
    }

    private static void removeBook() {
        System.out.print("Введите ISBN книги для удаления: ");
        String isbn = scanner.nextLine();

        try {
            library.removeBook(isbn);
        } catch (Exception e) {
            System.out.println("Ошибка при удалении книги: " + e.getMessage());
        }
    }

    private static void searchBooks() {
        System.out.println("Искать по: 1. Название  2. Автор  3. Год");
        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        List<Book> results;
        switch (searchChoice) {
            case 1:
                System.out.print("Введите название: ");
                String title = scanner.nextLine();
                results = library.searchByTitle(title);
                break;
            case 2:
                System.out.print("Введите автора: ");
                String author = scanner.nextLine();
                results = library.searchByAuthor(author);
                break;
            case 3:
                System.out.print("Введите год: ");
                int year = scanner.nextInt();
                results = library.searchByYear(year);
                break;
            default:
                System.out.println("Неверный выбор.");
                return;
        }

        displayBooks(results);
    }

    private static void displayAllBooks() {
        List<Book> books = library.getAllBooks();
        displayBooks(books);
    }

    private static void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("Книги не найдены.");
        } else {
            books.forEach(System.out::println);
        }
    }
}