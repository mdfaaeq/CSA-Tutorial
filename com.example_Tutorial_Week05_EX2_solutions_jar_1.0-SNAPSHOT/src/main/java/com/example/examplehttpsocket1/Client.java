/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examplehttpsocket1;

/* Please import necessary classes for creating the GUI components */


/* Please import necessary classes for layout management */


/* Please import necessary classes for handling events */


/* Please import necessary classes for input and output operations */


/* Please import necessary classes for networking operations */


public class Client extends JFrame implements ActionListener, Runnable {

    private JTextField messageField;

    private JTextArea chatArea;

    private JButton sendButton, exitButton;

    private JList<String> userList;

    private DefaultListModel<String> listModel;

    private String username;

    /* Please create a Socket for connecting to the server */
   

    /* Please create a BufferedReader to read input from the server */
    

    /* Please create a PrintWriter to send output to the server */
    

    public Client() {

        super("Chat Client");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(600, 400);

        setLayout(new BorderLayout());

        chatArea = new JTextArea();

        chatArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());

        messageField = new JTextField();
        sendButton = new JButton("Send");
        sendButton.addActionListener(this);
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);

        listModel = new DefaultListModel<>();

        userList = new JList<>(listModel);

        JScrollPane userScrollPane = new JScrollPane(userList);

        userScrollPane.setPreferredSize(new Dimension(150, getHeight())); // Adjust width as needed

        add(userScrollPane, BorderLayout.WEST);

        exitButton = new JButton("Exit Chat");

        exitButton.addActionListener(this);

        JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        exitPanel.add(exitButton);

        add(exitPanel, BorderLayout.NORTH);

        setVisible(true);

        username = JOptionPane.showInputDialog(this, "Enter your username:");

        if (username == null || username.isEmpty()) {

            System.exit(0);
        }

        setTitle("Chat Client - " + username);

        try {
            /* Please create a Socket to connect to the server */
            

            /* Please initialize the BufferedReader to read input from the server */
            

            /* Please initialize the PrintWriter to send output to the server */
            

            /* Please send the username to the server */
            

            new Thread(this).start();
        } catch (IOException e) {

            e.printStackTrace();

            System.exit(1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == sendButton) {

            String message = messageField.getText();

            if (!message.isEmpty()) {
                String recipient = null;

                if (userList.getSelectedValue() != null && !userList.getSelectedValue().equals(username)) {
                    recipient = userList.getSelectedValue();

                    /* Please send a private message to the selected user */
                    

                    chatArea.append("You (to " + recipient + "): " + message + "\n");
                } else {
                    /* Please send the message to all users */
                    

                    chatArea.append("You: " + message + "\n");
                }

                messageField.setText("");
            }
        } else if (e.getSource() == exitButton) {
            try {
                /* Please notify the server of exit */
                

                /* Please close the input stream */
               

                /* Please close the output stream */
               

                /* Please close the socket */
                
                System.exit(0);
            } catch (IOException ex) {

                ex.printStackTrace();
            }
        }
    }

    @Override
    public void run() {

        try {
            String message;

            while ((message = in.readLine()) != null) {

                if (message.startsWith("USERLIST:")) {

                    String[] users = message.substring("USERLIST:".length()).split(",");

                    listModel.removeAllElements();

                    for (String user : users) {
                        listModel.addElement(user);
                    }
                } else {

                    chatArea.append(message + "\n");
                }
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new Client();
    }
}
