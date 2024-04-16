package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MainNewVer {
    private static final String FILENAME = "saved_text.txt";

    public static void main(String[] args) {
        UINewVer ui = new UINewVer();
        ui.setVisible(true);


        String savedText = loadTextFromFile();
        ui.getTextField().setText(savedText);

        ui.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredText = ui.getTextField().getText();


                saveTextToFile(enteredText);

                JOptionPane.showMessageDialog(ui, "Текст сохранен в файле!");
            }
        });

        JFrame newFrame = new JFrame("Нове вікно");
        newFrame.setSize(400, 300);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setVisible(true);
    }

    private static String loadTextFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            return reader.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    private static void saveTextToFile(String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}