import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ExpenseTracker {
    private JFrame frame;
    private JTextField dateField;
    private JTextField categoryField;
    private JTextField descriptionField;
    private JTextField amountField;
    private DefaultListModel<String> expenseListModel;
    private JList<String> expenseList;

    private ArrayList<Expense> expenses;

    public ExpenseTracker() {
        frame = new JFrame("Expense Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        JLabel dateLabel = new JLabel("Date:");
        dateField = new JTextField(10);
        JLabel categoryLabel = new JLabel("Category:");
        categoryField = new JTextField(10);
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionField = new JTextField(10);
        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField(10);
        JButton addButton = new JButton("Add Expense");

        inputPanel.add(dateLabel);
        inputPanel.add(dateField);
        inputPanel.add(categoryLabel);
        inputPanel.add(categoryField);
        inputPanel.add(descriptionLabel);
        inputPanel.add(descriptionField);
        inputPanel.add(amountLabel);
        inputPanel.add(amountField);
        inputPanel.add(new JLabel("")); // Empty space
        inputPanel.add(addButton);

        expenses = new ArrayList<>();
        expenseListModel = new DefaultListModel<>();
        expenseList = new JList<>(expenseListModel);
        JScrollPane listScrollPane = new JScrollPane(expenseList);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(listScrollPane, BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExpense();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    private void addExpense() {
        String date = dateField.getText();
        String category = categoryField.getText();
        String description = descriptionField.getText();
        double amount = Double.parseDouble(amountField.getText());

        Expense expense = new Expense(date, category, description, amount);
        expenses.add(expense);
        expenseListModel.addElement(expense.toString());

        // Clear input fields
        dateField.setText("");
        categoryField.setText("");
        descriptionField.setText("");
        amountField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ExpenseTracker();
            }
        });
    }
}

class Expense {
    private String date;
    private String category;
    private String description;
    private double amount;

    public Expense(String date, String category, String description, double amount) {
        this.date = date;
        this.category = category;
        this.description = description;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return date + " | " + category + " | " + description + " | " + amount;
    }
}
