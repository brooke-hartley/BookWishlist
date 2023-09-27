package com.bookwishlist;

import javax.swing.SwingUtilities;

public class App {
    public static void main( String[] args) {
       SwingUtilities.invokeLater(() -> {
            AppInput app = new AppInput();
            app.setVisible(true);
        });
    }
}
