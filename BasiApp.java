/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basiapp;

/**
 *
 * @author COMPUTER VILLAGE TEC
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BasiApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("BasiApp - Your Public Transport Guide in Tanzania");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);

        // Create main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel welcomeLabel = new JLabel("Welcome to BasiApp!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(welcomeLabel);

        JButton searchRoutesButton = new JButton("Search Routes");
        JButton viewScheduleButton = new JButton("View Schedule");
        JButton submitFeedbackButton = new JButton("Submit Feedback");

        panel.add(searchRoutesButton);
        panel.add(viewScheduleButton);
        panel.add(submitFeedbackButton);

        frame.add(panel);
        frame.setVisible(true);

        // Action Listeners
        searchRoutesButton.addActionListener(e -> openSearchRoutesDialog(frame));
        viewScheduleButton.addActionListener(e -> openViewScheduleDialog(frame));
        submitFeedbackButton.addActionListener(e -> openSubmitFeedbackDialog(frame));
    }

    private static void openSearchRoutesDialog(JFrame parentFrame) {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        JTextField startField = new JTextField();
        JTextField destinationField = new JTextField();

        panel.add(new JLabel("Starting Point:"));
        panel.add(startField);
        panel.add(new JLabel("Destination:"));
        panel.add(destinationField);

        int result = JOptionPane.showConfirmDialog(parentFrame, panel, "Search Routes", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String start = startField.getText().trim();
            String destination = destinationField.getText().trim();

            if (!start.isEmpty() && !destination.isEmpty()) {
                JOptionPane.showMessageDialog(parentFrame, "Available Route: Daily Route, Fare: 25,000 TZS", "Search Results", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Please fill in both fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void openViewScheduleDialog(JFrame parentFrame) {
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));

        JTextField routeField = new JTextField();
        panel.add(new JLabel("Write your route:"));
        panel.add(routeField);

        int result = JOptionPane.showConfirmDialog(parentFrame, panel, "View Schedule", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String route = routeField.getText().trim();

            if (!route.isEmpty()) {
                JOptionPane.showMessageDialog(parentFrame, "First Bus: 6:00 AM, Last Bus: 10:00 PM", "Schedule", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Please enter a route number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void openSubmitFeedbackDialog(JFrame parentFrame) {
        JTextArea feedbackArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(feedbackArea);

        int result = JOptionPane.showConfirmDialog(parentFrame, scrollPane, "Submit Feedback", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String feedback = feedbackArea.getText().trim();

            if (!feedback.isEmpty()) {
                JOptionPane.showMessageDialog(parentFrame, "Thank you for your feedback!", "Acknowledgment", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Feedback cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

