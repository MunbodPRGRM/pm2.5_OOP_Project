
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class memberMenu 
{
    // ใช้แค่ทดสอบโดยที่ไม่ต้องรันจาก mainMenu
    public static void main(String[] args) 
    {
        MemberFrame memberFrame = new MemberFrame();
    }
}

class MemberFrame implements ActionListener
{
    JFrame memberFrame = new JFrame();
    // เกือบทุกอย่างจะเอามาใส่ไว่ใน Constructor MemberFrame เพื่อแสดงผล
    public MemberFrame()
    {
        memberFrame.setIconImage((new ImageIcon("iconProgram.jpg")).getImage());
        memberFrame.setTitle("PM 2.5 Simulator");
        memberFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        memberFrame.setLayout(null);
        memberFrame.setLocationRelativeTo(null);
        memberFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        memberFrame.getContentPane().setBackground(new Color(29, 35, 56));

        setImage();     // เมธอดบรรทัดที่ 49
        setLabel();     // เมธอดบรรทัดที่ 66
        setButton();    // เมธอดบรรทัดที่ 90

        memberFrame.setVisible(true);
    }

    JLabel imgLabel1 = new JLabel();
    JLabel imgLabel2 = new JLabel();
    JLabel imgLabel3 = new JLabel();
    // ใช้กำหนดการจัดวางรูปภาพของสมาชิก
    private void setImage()
    {
        imgLabel1.setIcon(new ImageIcon("member1.jpg"));
        imgLabel1.setBounds(250, 200, 500, 375);

        imgLabel2.setIcon(new ImageIcon("member2.jpg"));
        imgLabel2.setBounds(700, 200, 500, 375);

        imgLabel3.setIcon(new ImageIcon("member3.jpg"));
        imgLabel3.setBounds(1300, 200, 500, 375);

        memberFrame.add(imgLabel1);
        memberFrame.add(imgLabel2);
        memberFrame.add(imgLabel3);
    }

    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    // กำหนดลักษณะของชื่อของสมาชิกในกลุ่ม
    private void setLabel()
    {
        label1.setText("<html> ชื่อ : นายชวกร  บัญดิษฐตา <br> รหัสนิสิต : 66011212084 </html>");
        label1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        label1.setForeground(Color.white);
        label1.setBounds(250, 550, 300, 200);

        label2.setText("<html> ชื่อ : นายศิริวัฒน์  จันทมนตรี <br> รหัสนิสิต : 66011212136 </html>");
        label2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        label2.setForeground(Color.white);
        label2.setBounds(850, 550, 300, 200);

        label3.setText("<html> ชื่อ : นายณฐกฤต  นาสุวรรณ <br> รหัสนิสิต : 66011212165 </html>");
        label3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        label3.setForeground(Color.white);
        label3.setBounds(1450, 550, 300, 200);

        memberFrame.add(label1);
        memberFrame.add(label2);
        memberFrame.add(label3);
    }

    JButton btnHome = new JButton("หน้าหลัก");
    // กำหนดลักษณะของปุ่ม
    private void setButton()
    {
        btnHome.setBounds(750, 900, 450, 50);
        btnHome.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        btnHome.setBackground(Color.lightGray);
        btnHome.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        btnHome.setFocusable(false);

        btnHome.addActionListener(this);

        memberFrame.add(btnHome);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // เมื่อกดที่ปุ่มหน้าหลัก
        if(e.getSource() == btnHome)
        {
            MenuFrame menuFrame = new MenuFrame();      // เปิดไปที่หน้าหลัก
            memberFrame.dispose();
        }
    }
}