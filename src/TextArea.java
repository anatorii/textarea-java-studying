import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TextArea extends JFrame {
    static int width = 800;
    static int height = 600;
    JTextField field;
    JTextArea area;
    public TextArea() {
        super("TextArea");

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(TextArea.width, TextArea.height);
        this.setLocation(d.width / 2 - TextArea.width / 2, d.height / 2 - TextArea.height / 2);
        this.getContentPane().setBackground(Color.orange);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JPanel panelUp = new JPanel(new GridBagLayout());
        panelUp.setBackground(Color.orange);
        this.add(panelUp, BorderLayout.CENTER);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0, 0, 10, 0);

        field = new JTextField("");
        field.setPreferredSize(new Dimension(500, 30));
        constraints.gridy = 0;
        panelUp.add(field, constraints);

        JButton button = new JButton("Записать");
        button.setPreferredSize(new Dimension(500, 30));
        constraints.gridy = 1;
        panelUp.add(button, constraints);

        area = new JTextArea();
        area.setRows(20);
        area.setColumns(45);
        constraints.gridy = 2;

        JScrollPane scroll = new JScrollPane(area);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panelUp.add(scroll, constraints);

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.grabFocus();
                if (field.getText().length() != 0) {
                    area.append(field.getText() + "\n");
                }
            }
        });

        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TextArea frame = new TextArea();
            }
        });
    }
}
