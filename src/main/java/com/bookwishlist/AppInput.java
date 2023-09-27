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

    public AppInput() {
        setTitle("Text Input");

        // Create a panel to hold the components
        JPanel panel = new JPanel();

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

        // Add the panel to the frame
        getContentPane().add(panel);

        // Set the layout manager for the panel (optional)
        panel.setLayout(new FlowLayout());

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the window
        setSize(400, 400);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Create a display area (JTextArea)
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false); // Make it non-editable
        displayArea.setWrapStyleWord(true);
        displayArea.setLineWrap(true);

        // Add the display area to a scroll pane
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the scroll pane to the panel
        panel.add(scrollPane);

        // Create a button to perform an action with user input
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            // Get the user input from the input fields
            userInputTitle = titleText.getText();
            userInputAuthor = authorText.getText();

            // Create a new book and add it to the library
            Book newBook = new Book(userInputTitle, userInputAuthor);
            newLib.addBook(newBook);

            // Update the display area with the library's contents
            displayLibraryContents();

            // Reset the text fields after adding the book
            titleText.setText("");
            authorText.setText("");
        });

        // Add the button to the panel
        panel.add(submitButton);
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
