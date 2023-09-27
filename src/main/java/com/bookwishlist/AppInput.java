package com.bookwishlist;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AppInput extends JFrame{
    private JTextField titleText;
    private JTextField authorText;
    private String userInputTitle;
    private String userInputAuthor;
    private JTextArea displayArea;
    private Library newLib = new Library();
    private JPanel contentPanel;  // Panel to switch between input and display

    public AppInput() {
        setTitle("Text Input");

        // Create a panel to hold the content (input fields, display, and back button)
        contentPanel = new JPanel();
        contentPanel.setLayout(new CardLayout());

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Create a label for "Title"
        JLabel title = new JLabel("Enter Book Title:");
        titleText = new JTextField(20);

        // Create a label for "Author"
        JLabel author = new JLabel("Enter Book Author:");
        authorText = new JTextField(20);

        // Add the label and text field to the panel
        panel.add(title);
        panel.add(titleText);
        panel.add(author);
        panel.add(authorText);

        // Create a button to switch to the display panel
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            // Get the user input from the input fields
            userInputTitle = titleText.getText();
            userInputAuthor = authorText.getText();

            // Create a new book and add it to the library
            Book newBook = new Book(userInputTitle, userInputAuthor);
            newLib.addBook(newBook);

            // Update the display area with the library's contents
            //displayLibraryContents();

            // Switch to the display panel
            //CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
            //cardLayout.next(contentPanel);

            // Reset the text fields after adding the book
            titleText.setText("");
            authorText.setText("");
        });

        JButton viewLibraryButton = new JButton("View Library");
        viewLibraryButton.addActionListener(e -> {
            displayLibraryContents();
            CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
            cardLayout.next(contentPanel);
        });

        // Add the button to the panel
        panel.add(submitButton);
        panel.add(viewLibraryButton);

        // Add the panel to the content panel
        contentPanel.add(panel, "Input");

        // Create a display area (JTextArea)
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false); // Make it non-editable
        displayArea.setWrapStyleWord(true);
        displayArea.setLineWrap(true);

        // Create a back button to switch back to the input panel
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            // Switch back to the input panel
            CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
            cardLayout.show(contentPanel, "Input");
        });

        // Create a panel for the display area and back button
        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);
        displayPanel.add(backButton, BorderLayout.SOUTH);

        // Add the display panel to the content panel
        contentPanel.add(displayPanel, "Display");

        // Add the content panel to the frame
        getContentPane().add(contentPanel);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the window
        setSize(400, 400);

        // Center the window on the screen
        setLocationRelativeTo(null);

    }

    private void displayLibraryContents() {
        ArrayList<Book> libraryContents = newLib.getBooks();

        // Create a message to display the library contents
        StringBuilder message = new StringBuilder("Library:\n");
        for (Book book : libraryContents) {
            message.append("Title: ").append(book.getTitle()).append(", Author: ").append(book.getAuthor()).append("\n");
        }

        // Update the display area
        displayArea.setText(message.toString());
    }
    
}
