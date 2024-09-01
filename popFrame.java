import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class popFrame implements ActionListener
{
    JFrame popFrame = new JFrame();
    JLabel label = new JLabel();
    JButton btnOK = new JButton("ตกลง");
    // เกือบทุกอย่างจะเอามาใส่ไว่ใน Constructor popFrame เพื่อแสดงผล เมื่อมีการตั้งค่าช่วงของประชากร
    public popFrame() 
    {
        popFrame.setSize(400, 200);
        popFrame.setLocationRelativeTo(null);
        popFrame.setLayout(null);
        popFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label.setText("ตั้งค่าช่วงของประชากรแล้ว");
        label.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        label.setBounds(100, 30, 400, 50);
        btnOK.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        btnOK.setBounds(140, 100, 100, 40);
        btnOK.setFocusable(false);
        btnOK.addActionListener(this);

        popFrame.add(label);
        popFrame.add(btnOK);

        popFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == btnOK)
        {
            popFrame.dispose();
        }
    }
}
