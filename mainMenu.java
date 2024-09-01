import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainMenu
{
    public static void main(String[] args) 
    {
        MenuFrame menuFrame = new MenuFrame();
    }
}

class MenuFrame implements ActionListener
{
    JFrame menuFrame = new JFrame();
    // เกือบทุกอย่างจะเอามาใส่ไว่ใน Constructor MenuFrame เพื่อแสดงผล
    public MenuFrame()
    {
        menuFrame.setIconImage((new ImageIcon("iconProgram.jpg")).getImage());
        menuFrame.setTitle("PM 2.5 Simulator");
        menuFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menuFrame.setLayout(null);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        menuFrame.getContentPane().setBackground(new Color(29, 35, 56));

        setLeftPanel();     // เมธอดบรรทัดที่ 46 
        setRightPanel();    // เมธอดบรรทัดที่ 57
        setLabel();         // เมธอดบรรทัดที่ 68
        setButton();        // เมธอดบรรทัดที่ 81

        menuFrame.setVisible(true);
    }

    JPanel leftPanel = new JPanel();
    // กำหนดค่าของ panel ที่เอาไว้ใส่ชื่อเรื่อง
    private void setLeftPanel()
    {
        leftPanel.setBounds(0, 0, 1250, 1080);
        leftPanel.setBackground(new Color(0x2E, 0x45, 0x83));
        leftPanel.setLayout(new GridBagLayout());

        menuFrame.add(leftPanel);
    }

    JPanel rightPanel = new JPanel();
    // กำหนดค่าของ panel ที่เอาไว้ใส่ปุ่ม
    private void setRightPanel()
    {
        rightPanel.setBounds(1400, 300, 400, 400);
        rightPanel.setLayout(new GridLayout(3, 1, 50, 50));
        rightPanel.setBackground(new Color(29, 35, 56));

        menuFrame.add(rightPanel);
    }

    JLabel label = new JLabel();
    // กำหนดขนาด สี และฟอนต์ของตัวอักษร
    private void setLabel()
    {
        label.setText("<html>OOP<br>Midterm Assignment<br>Graphical Users Interface (GUI)</html>");
        label.setForeground(Color.white);
        label.setFont(new Font("Tahoma", Font.BOLD, 40));

        leftPanel.add(label);
    }

    JButton btnStart = new JButton("เริ่ม");
    JButton btnMember = new JButton("รายชื่อผู้จัดทำ");
    JButton btnExit = new JButton("ออก");
    // กำหนดลักษณะต่างๆ ของปุ่ม
    private void setButton()
    {
        btnStart.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 40));
        btnStart.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        btnStart.setBackground(Color.lightGray);
        btnStart.setFocusable(false);

        btnMember.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 40));
        btnMember.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        btnMember.setBackground(Color.lightGray);
        btnMember.setFocusable(false);

        btnExit.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 40));
        btnExit.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        btnExit.setBackground(Color.lightGray);
        btnExit.setFocusable(false);
        
        btnStart.addActionListener(this);
        btnMember.addActionListener(this);
        btnExit.addActionListener(this);

        rightPanel.add(btnStart);
        rightPanel.add(btnMember);
        rightPanel.add(btnExit);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // กดที่ปุ่มเริ่ม
        if(e.getSource() == btnStart)
        {
            StartFrame startFrame = new StartFrame();   // เปิดไปที่หน้าจำลองพื้นที่
            menuFrame.dispose();
        }
        // กดที่ปุ่มรายชื่อผู้จัดทำ
        else if(e.getSource() == btnMember)
        {   
            MemberFrame memberFrame = new MemberFrame();    // เปิดไปที่หน้าสมาชิก
            menuFrame.dispose();
        }
        // กดที่ปุ่มออก
        else if(e.getSource() == btnExit)
        {
            System.exit(0);
        }
    }
}