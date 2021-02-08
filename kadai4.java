package kadai4;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class kadai4 extends JFrameimplements Runnable, ActionListener, MouseListener {
	int[][] cell    = new int[34][34];
	int[][] newCell = new int[34][34];
	boolean jikkouChuu;

	Container cPane;
	JPanel panelUp;
	Life_Panel panelDown;
	JButton btnExec;
	JButton btnNew;
	JButton btnClear;

	public static void main(String[] args) {
		new kadai4();
	}

	public kadai4() {
		guiSetting();

		Thread thread = new Thread( this );
		thread.start();
	}

	public void guiSetting() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cPane = getContentPane();
		cPane.setLayout(new BorderLayout());

		panelUp = new JPanel();
		btnExec = new JButton("Exec");
		btnExec.addActionListener( this );
		panelUp.add(btnExec);
		btnNew = new JButton("New");
		btnNew.addActionListener( this );
		panelUp.add(btnNew);
		btnClear = new JButton("Clear");
		btnClear.addActionListener( this );
		panelUp.add(btnClear);
		cPane.add(panelUp, BorderLayout.NORTH);

		panelDown = new Life_Panel(cell);
		panelDown.addMouseListener( this );
		cPane.add(panelDown, BorderLayout.CENTER);

		this.setSize(440, 490);
		this.setVisible(true);

	}

}
