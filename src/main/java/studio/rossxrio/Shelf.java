package studio.rossxrio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Scanner;

public class Shelf {
    private static HashMap<Integer, Reader> books = new HashMap<>();
    private Reader reader;

    private static int shelfIdentifier = 0;

    public Shelf() {
        shelfIdentifier++;
    }

    public JPanel addBookShelf() {
        int shelfId = shelfIdentifier;

        JPanel bookShelf = new JPanel();
        bookShelf.setPreferredSize(new Dimension(150, 150));
        bookShelf.setBackground(Color.BLACK);
        bookShelf.setLayout(new BorderLayout());

        JLabel nameBook = new JLabel("Lorem Ipsum");
        nameBook.setHorizontalAlignment(JLabel.CENTER);
        nameBook.setFont(new Font("Arial", Font.BOLD, 20));
        nameBook.setForeground(Color.WHITE);
        bookShelf.add(nameBook, BorderLayout.NORTH);

        JButton bookBtn = new JButton("Add book");
        bookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isBook(shelfId)) {
                    openBook(shelfId);
                } else {
                    addBook();
                    bookBtn.setText("Open book");
                    bookShelf.revalidate();
                    bookShelf.repaint();
                }
            }
        });
        bookShelf.add(bookBtn, BorderLayout.SOUTH);

        return bookShelf;
    }

    private boolean isBook(int id) {
        return books.containsKey(id);
    }

    private void addBook() {
        Scanner scan = new Scanner(System.in);
        Reader reader = new Reader();

        String path = scan.next();
        String bookName = scan.next();

        reader.setBook(path, bookName);

        books.put(getShelfIdentifier(), reader);
    }

    private void openBook(int id) {
        Reader reader = books.get(id);
        reader.initialize();
    }

    public static int getShelfIdentifier() {
        return shelfIdentifier;
    }
}
