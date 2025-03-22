package studio.rossxrio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    private Window window;

    private JPanel mainTopPane;
    private JPanel mainCenterPane;

    private JScrollPane scrollPane;

    private JButton addBtn;

    private JLabel mainTitle;

    private Shelf shelf;

    private static int shelfCount = 1;
    private static int height = 360;


    public App() {
        window = new Window();

        // mainTopPane configuration
        mainTopPane = new JPanel();
        mainTopPane.setBackground(Color.LIGHT_GRAY);
        mainTopPane.setPreferredSize(new Dimension(0, 80));
        mainTopPane.setLayout(new BorderLayout());

        mainTitle = new JLabel("My books");
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
        mainTitle.setForeground(Color.BLACK);
        mainTopPane.add(mainTitle, BorderLayout.CENTER);


        // mainCenterPane
        mainCenterPane = new JPanel();
        mainCenterPane.setBackground(Color.LIGHT_GRAY);
        mainCenterPane.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
        mainCenterPane.setPreferredSize(new Dimension(0, height));
        scrollPane = new JScrollPane(mainCenterPane);

        addBtn = new JButton("A");
        addBtn.setPreferredSize(new Dimension(70, 70));
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shelf = new Shelf();
                mainCenterPane.add(shelf.addBookShelf());
                window.refresh();

                shelfCount++;
                if (shelfCount == 6) {
                    height += 400;
                    mainCenterPane.setPreferredSize(new Dimension(0, height));
                    shelfCount = 0;
                    window.refresh();
                }
            }
        });
        JPanel wrapperAddBtn = new JPanel();
        wrapperAddBtn.setPreferredSize(new Dimension(100, 0));
        wrapperAddBtn.setBackground(Color.CYAN);
        wrapperAddBtn.add(addBtn);


        window.addMain(mainTopPane, "North");
        window.addMain(wrapperAddBtn, "West");
        window.addMain(scrollPane, "Center");
        window.visible();
    }

    public static void main(String[] args) {
        App app = new App();
    }
}
