
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class errorFrame implements ActionListener
{
    JFrame errFrame = new JFrame();
    JLabel label = new JLabel();
    JButton btnOK = new JButton("ตกลง");
    // เกือบทุกอย่างจะเอามาใส่ไว่ใน Constructor errorFrame เพื่อแสดงผล เมื่อโปรแกรมไม่สามารถทำงานได้
    public errorFrame() 
    {
        errFrame.setSize(400, 200);
        errFrame.setLocationRelativeTo(null);
        errFrame.setLayout(null);
        errFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label.setText("ใส่ค่าผิดนะ ไปใส่ตัวเลขเดี๋ยวนี้!!!");
        label.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        label.setBounds(75, 30, 400, 50);
        btnOK.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        btnOK.setBounds(140, 100, 100, 40);
        btnOK.setFocusable(false);
        btnOK.addActionListener(this);

        errFrame.add(label);
        errFrame.add(btnOK);

        errFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == btnOK)
        {
            errFrame.dispose();
        }
    }
}
