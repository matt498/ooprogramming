package Examples;
import java.awt.BorderLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class MovingWindow extends JFrame implements ComponentListener {
	private static final long serialVersionUID = 1L;
	private JLabel summary;

    public MovingWindow() {
    	super("Moving Window");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        summary = new JLabel("");
        panel.add(summary, BorderLayout.SOUTH);
        
        this.add(panel);
        this.addComponentListener(this);

        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void componentResized(ComponentEvent e) {
        String text = String.format("x: %d; y: %d; w: %d; h: %d\n", 
        		e.getComponent().getX(),
        		e.getComponent().getY(),
        		e.getComponent().getWidth(),
        		e.getComponent().getHeight());
        summary.setText(text);
    }

    public void componentMoved(ComponentEvent e) {
        String text = String.format("x: %d; y: %d; w: %d; h: %d\n", 
        		e.getComponent().getX(),
        		e.getComponent().getY(),
        		e.getComponent().getWidth(),
        		e.getComponent().getHeight());
        summary.setText(text);
    }

    public void componentShown(ComponentEvent e) {}

    public void componentHidden(ComponentEvent e) {}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MovingWindow ex = new MovingWindow();
                ex.setVisible(true);
            }
        });
    }
}