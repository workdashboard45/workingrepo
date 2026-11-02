import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class StopwatchGUI extends JFrame {
    private JLabel timeLabel;
    private JButton startButton, stopButton;
    private JButton resetButton, lapButton;
    private JTextArea lapArea;

    private volatile boolean running = false;
    private volatile boolean active = false;

    private long startTime;
    private long elapsedTime = 0;
    private int lapCount = 0;
    private Thread timerThread;

    public StopwatchGUI() {
        setTitle("Java Stopwatch");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        timeLabel = new JLabel("00:00:00.000",
                SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(timeLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");
        lapButton = new JButton("Lap");

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(lapButton);

        add(buttonPanel, BorderLayout.CENTER);

        lapArea = new JTextArea();
        lapArea.setEditable(false);
        lapArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        add(new JScrollPane(lapArea), BorderLayout.SOUTH);

        startButton.addActionListener(e -> startStopwatch());
        stopButton.addActionListener(e -> stopStopwatch());
        resetButton.addActionListener(e -> resetStopwatch());
        lapButton.addActionListener(e -> recordLap());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startStopwatch() {
        if (running) {
            return;
        }

        startTime = System.nanoTime() - elapsedTime;
        running = true;

        if (!active) {
            active = true;

            timerThread = new Thread(() -> {
                while (active) {
                    if (running) {
                        elapsedTime =
                                System.nanoTime() - startTime;

                        SwingUtilities.invokeLater(() ->
                                timeLabel.setText(
                                        formatTime(elapsedTime)));
                    }

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            });

            timerThread.setDaemon(true);
            timerThread.start();
        }
    }

    private void stopStopwatch() {
        if (running) {
            elapsedTime = System.nanoTime() - startTime;
            running = false;
            timeLabel.setText(formatTime(elapsedTime));
        }
    }

    private void resetStopwatch() {
        running = false;
        elapsedTime = 0;
        lapCount = 0;

        timeLabel.setText("00:00:00.000");
        lapArea.setText("");
    }

    private void recordLap() {
        if (running) {
            lapCount++;

            lapArea.append("Lap " + lapCount + " : "
                    + formatTime(System.nanoTime() - startTime)
                    + "\n");
        }
    }

    private String formatTime(long nanos) {
        long millis = TimeUnit.NANOSECONDS.toMillis(nanos);
        long hours = millis / 3600000;
        long minutes = (millis / 60000) % 60;
        long seconds = (millis / 1000) % 60;
        long milliseconds = millis % 1000;

        return String.format("%02d:%02d:%02d.%03d",
                hours, minutes, seconds, milliseconds);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StopwatchGUI::new);
    }
}