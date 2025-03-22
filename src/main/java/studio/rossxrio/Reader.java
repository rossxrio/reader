package studio.rossxrio;

import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;

public class Reader extends JFrame {
    private JPanel topPane;
    private JPanel centerPane;

    private JEditorPane editorPane;

    private JScrollPane scrollPane;

    private JLabel bookTitle;


    public Reader() {
        // Frame configuration
        this.setSize(668, 924);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(new BorderLayout(10, 10));

        // topPane configuration
        topPane = new JPanel();
        topPane.setPreferredSize(new Dimension(0, 100));
        topPane.setBackground(Color.LIGHT_GRAY);
        topPane.setLayout(new BorderLayout());

        bookTitle = new JLabel();
        bookTitle.setText("Lorem Ipsum");
        bookTitle.setFont(new Font("Arial", Font.BOLD, 20));
        bookTitle.setHorizontalAlignment(JLabel.CENTER);
        topPane.add(bookTitle, BorderLayout.CENTER);

        // centerPane configuration
        centerPane = new JPanel();
        centerPane.setBackground(Color.LIGHT_GRAY);
        centerPane.setLayout(new BorderLayout());

        editorPane = new JEditorPane();
        editorPane.setEditorKit(new HTMLEditorKit());
        editorPane.setContentType("text/html");
        editorPane.setEditable(false);
        scrollPane = new JScrollPane(editorPane);
        editorPane.setBackground(new Color(17, 19, 38));
        centerPane.add(scrollPane);


        this.add(topPane, BorderLayout.NORTH);
        this.add(centerPane, BorderLayout.CENTER);
    }

    public boolean initialize() {
        Reader.this.setVisible(true);

        return Reader.this.isVisible();
    }

    public void setBook(String path, String bookName) {
        Book book = new Book(path, bookName);
        editorPane.setText(book.getBook());
        bookTitle.setText(book.getBookName());

        Reader.this.revalidate();
        Reader.this.repaint();
    }


    public static void main(String[] args) {
        Reader reader = new Reader();
        reader.setBook("src/main/resources/books/sample.html", "Sample book");
    }
}