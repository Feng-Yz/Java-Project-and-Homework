import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.stream.Collectors;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            TextComponentFrame frame = new TextComponentFrame();
            frame.setTitle("Homework of Yuzhen");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class TextComponentFrame extends JFrame
{
    private static final int WIDTH = 600;
    private static final int HEIGHT = 800;

    private String fileName;
    private String fileContent;
    private JTextArea contentArea;
    private JTextField fileNameField;

    public TextComponentFrame()
    {
        contentArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(contentArea);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        fileNameField = new JTextField();
        JButton loadFileButton = new JButton("加载文件");
        JButton saveFileButton = new JButton("保存文件");
        panel.add(fileNameField);
        panel.add(loadFileButton);
        panel.add(saveFileButton);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        pack();

        loadFileButton.addActionListener(new LoadFileAction());
        saveFileButton.addActionListener(new SaveFileAction());

        setSize(WIDTH, HEIGHT);
        setLocationByPlatform(true);
    }

    private class LoadFileAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            fileName = fileNameField.getText();
            String content;
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                content = reader.lines().collect(Collectors.joining(System.lineSeparator()));
                reader.close();
            } catch (FileNotFoundException ex)
            {
                try {
                    (new File(fileName)).createNewFile();
                } catch (IOException ex1) {
                    ex1.printStackTrace();
                }
                content = "";
            } catch (Exception ex)
            {
                content = "";
                ex.printStackTrace();
            }
            contentArea.setText(content);
        }
    }

    private class SaveFileAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            fileName = fileNameField.getText();
            BufferedWriter writer;
            try {
                writer = new BufferedWriter(new FileWriter(fileName));
                writer.write(contentArea.getText());
                writer.close();
            } catch (FileNotFoundException ex)
            {
                try {
                    (new File(fileName)).createNewFile();
                    writer = new BufferedWriter(new FileWriter(fileName));
                    writer.close();
                } catch (IOException ex1) {
                    ex1.printStackTrace();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}