package studio.rossxrio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;

public class Window extends JFrame {
    private JPanel headerPane;
    private JPanel settingsBayPane;
    private JPanel mainContentPane;

    private JLabel headerLabelTitle;

    private JButton settingsBtn;
    private JButton darkModeBtn;


    private static boolean isDarkMode = false;

    GridBagConstraints gbc;

    public Window() {
        // Window configuration
        this.setSize(1024, 668);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(new BorderLayout(10, 10));

        // headerPane configuration
        headerPane = new JPanel();
        headerPane.setPreferredSize(new Dimension(0, 100));
        headerPane.setBackground(Color.WHITE);
        gbc = new GridBagConstraints();
        headerPane.setLayout(new GridBagLayout());

        settingsBtn = new JButton("S");
        settingsBtn.setPreferredSize(new Dimension(50, 50));
        settingsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideSettingsBay();
            }
        });
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 0.8;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 10, 0, 0);
        headerPane.add(settingsBtn, gbc);

        headerLabelTitle = new JLabel();
        headerLabelTitle.setText("LOREM");
        headerLabelTitle.setFont(new Font("Arial", Font.BOLD, 50));
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.gridx = 1;
        gbc.gridy = 0;
        headerPane.add(headerLabelTitle, gbc);


        // settingsBayPane configuration
        settingsBayPane = new JPanel();
        settingsBayPane.setPreferredSize(new Dimension(250, 0));
        settingsBayPane.setBackground(Color.WHITE);
        settingsBayPane.setLayout(new GridBagLayout());

        darkModeBtn = new JButton("D");
        darkModeBtn.setPreferredSize(new Dimension(50, 50));
        darkModeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isDarkMode) {
                    lightMode();
                } else {
                    darkMode();
                }
            }
        });
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 0, 0);
        settingsBayPane.add(darkModeBtn, gbc);

        // mainContentPane
        mainContentPane = new JPanel();
        mainContentPane.setBackground(Color.WHITE);
        mainContentPane.setLayout(new BorderLayout(10,10));


        // Adding all pane's
        this.add(headerPane, BorderLayout.NORTH);
        this.add(settingsBayPane, BorderLayout.WEST);
        this.add(mainContentPane, BorderLayout.CENTER);
    }

    private void hideSettingsBay() {
        settingsBayPane.setVisible(!settingsBayPane.isVisible());

    }

    private void darkMode() {
        for (Component component : Window.this.getContentPane().getComponents()) {
            component.setBackground(Color.BLACK);
        }
        Window.this.getContentPane().setBackground(Color.GRAY);
        isDarkMode = true;
    }

    private void lightMode() {
        for (Component component : Window.this.getContentPane().getComponents()) {
            component.setBackground(Color.WHITE);
        }
        Window.this.getContentPane().setBackground(Color.BLACK);
        isDarkMode = false;
    }

    public void addMain(Component element, String pos) {
        mainContentPane.add(element, pos);
    }

    public void addHeader(Component element, String pos) {
        headerPane.add(element, pos);
    }

    public void refresh() {
        Window.this.revalidate();
        Window.this.repaint();
    }

    public void visible() {
        Window.this.setVisible(!Window.this.isVisible());
    }
}
