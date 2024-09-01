
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class startMenu 
{
    public static void main(String[] args) 
    {
        // ใช้แค่ทดสอบโดยที่ไม่ต้องรันจาก mainMenu
        StartFrame startFrame = new StartFrame();
    }
}

class StartFrame implements ActionListener
{
    JFrame startFrame = new JFrame();
    // เกือบทุกอย่างจะเอามาใส่ไว่ใน Constructor StartFrame เพื่อแสดงผล
    public StartFrame()
    {
        startFrame.setIconImage((new ImageIcon("iconProgram.jpg")).getImage());
        startFrame.setTitle("PM 2.5 Simulator");
        startFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        startFrame.setLayout(null);
        startFrame.setLocationRelativeTo(null);
        startFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        startFrame.getContentPane().setBackground(new Color(29, 35, 56));

        setDataPanel();     // เมธอดบรรทัดที่ 71
        setGridPanel();     // เมธอดบรรทัดที่ 97
        setMenuPanel();     // เมธอดบรรทัดที่ 126
        setStatus();        // เมธอดบรรทัดที่ 182
        setPopulation();    // เมธอดบรรทัดที่ 226

        gridPanel.setVisible(false);
        startFrame.setVisible(true);
    }

    JPanel imagePanel = new JPanel();
    JLabel imgLabel = new JLabel();
    // setImagePanel เอาไว้แสดงรูปตามปุ่มที่กดต่างๆ
    private void setImagePanel(String picture)
    {
        imagePanel.setBounds(100, 30, 245, 245);
        imagePanel.setBackground(new Color(29, 35, 56));
        
        imgLabel.setIcon(new ImageIcon(picture));

        imagePanel.add(imgLabel);
        startFrame.add(imagePanel);
    }

    JPanel dataPanel = new JPanel();
    JLabel[] labels = new JLabel[5];
    Random random = new Random();
    // setDataPanel เอาไว้กำหนดข้อมููลทางด้านซ้าย
    private void setDataPanel()
    {
        dataPanel.setBounds(50, 350, 350, 300);
        dataPanel.setLayout(new GridLayout(7, 1));
        dataPanel.setBackground(new Color(29, 35, 56));

        for(int i = 0; i < labels.length; i++)
        {
            labels[i] = new JLabel();
            labels[i].setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
            labels[i].setForeground(Color.white);
            dataPanel.add(labels[i]);
        }

        labels[0].setText(" ปริมาณฝุ่น : "); 
        labels[1].setText(" จำนวนประชากร : ");
        labels[2].setText(" ประชากรที่สุขภาพดี : ");
        labels[3].setText(" ประชากรที่ป่วย : ");
        labels[4].setText(" ร้อยละของประชากรที่ป่วย : ");

        startFrame.add(dataPanel);
    }

    JPanel gridPanel = new JPanel();
    JButton[][] buttons = new JButton[10][20];
    // setGridPanel เป็นเมธอดที่สร้างปุ่มทั้งหมด 200 ปุ่มเพื่อจำลองพื้นที่
    private void setGridPanel()
    {
        gridPanel.setBounds(500, 20, 1400, 700);
        gridPanel.setLayout(new GridLayout(10, 20, 5, 5));
        gridPanel.setBackground(new Color(0x2E, 0x45, 0x83));

        for(int row = 0; row < buttons.length; row++)
        {
            for(int col = 0; col < buttons[row].length; col++)
            {
                buttons[row][col] = new JButton();
                buttons[row][col].addActionListener(this);
                gridPanel.add(buttons[row][col]);
            }
        }

        startFrame.add(gridPanel);
    }

    JPanel menuPanel = new JPanel();
    JButton btnDustFile = new JButton("ตั้งค่าปริมาณฝุ่น : เปิดไฟล์");
    JButton btnDustRandom = new JButton("ตั้งค่าปริมาณฝุ่น : สุ่ม");
    JButton btnHome = new JButton("หน้าหลัก");

    JPanel orderPanel = new JPanel();
    JButton btnAr = new JButton("ฝนเทียม");
    JButton btnRain = new JButton("ฝนจริง");
    JButton btnCancel = new JButton("ยกเลิก");
    // setMenuPanel เป็นเมธอดที่กำหนดตำแหน่งปุ่มกดต่างๆ ที่อยู่ด้านล่าง
    private void setMenuPanel()
    {
        // ปุ่มกำหนดค่าฝุ่นแบบเปิดไฟล์ แบบสุ่ม และปุ่มหน้าหลัก
        btnDustFile.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        btnDustFile.setBackground(Color.lightGray);
        btnDustFile.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        btnDustFile.setFocusable(false);
        btnDustFile.addActionListener(this);
        btnDustRandom.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        btnDustRandom.setBackground(Color.lightGray);
        btnDustRandom.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        btnDustRandom.setFocusable(false);
        btnDustRandom.addActionListener(this);
        btnHome.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        btnHome.setBackground(Color.lightGray);
        btnHome.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        btnHome.setFocusable(false);
        btnHome.addActionListener(this);

        // panel ที่เอาไว้ใส่ปุ่มกำหนดค่าฝุ่นแบบเปิดไฟล์ แบบสุ่ม และปุ่มหน้าหลัก
        menuPanel.setBounds(30, 780, 350, 180);
        menuPanel.setLayout(new GridLayout(3, 1, 10, 20));
        menuPanel.setBackground(new Color(29, 35, 56));
        menuPanel.add(btnDustFile);
        menuPanel.add(btnDustRandom);
        menuPanel.add(btnHome);
        
        // ปุ่มฝนเทียม ฝนจริง และปุ่มยกเลิก
        btnAr.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        btnAr.setBackground(Color.lightGray);
        btnAr.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        btnAr.setFocusable(false);
        btnAr.addActionListener(this);
        btnRain.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        btnRain.setBackground(Color.lightGray);
        btnRain.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        btnRain.setFocusable(false);
        btnRain.addActionListener(this);
        btnCancel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        btnCancel.setBackground(Color.lightGray);
        btnCancel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        btnCancel.setFocusable(false);
        btnCancel.setBounds(1750, 820, 100, 100);
        btnCancel.addActionListener(this);

        // panel ที่เอาไว้ใส่ปุ่มฝนเทียม ฝนจริง
        orderPanel.setBounds(820, 820, 900, 100);
        orderPanel.setLayout(new GridLayout(1, 2, 20, 20));
        orderPanel.setBackground(new Color(29, 35, 56));
        orderPanel.add(btnAr);
        orderPanel.add(btnRain);

        startFrame.add(menuPanel);
        startFrame.add(orderPanel);
        startFrame.add(btnCancel);
    }

    JLabel rainLabel = new JLabel();
    JLabel arRainLabel = new JLabel();
    // ใช้บอกสถานะว่าตอนนี้กดปุ่ม rain หรือ arRain อยู่หรือไม่
    private void setStatus()
    {
        arRainLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        arRainLabel.setText("arRainButtonPressed : " + btnArPressed);
        arRainLabel.setBounds(920, 900, 300, 130);
        rainLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        rainLabel.setText("rainButtonPressed : " + btnRainPressed);
        rainLabel.setBounds(1400, 900, 300, 130);

        // ตรวจสอบว่าปุ่มที่กดไว้อยู่เป็นฝนเทียมหรือไม่
        if(btnArPressed == true)
        {
            arRainLabel.setForeground(Color.green);
        }
        else
        {
            arRainLabel.setForeground(Color.red);
        }

        // ตรวจสอบว่าปุ่มที่กดไว้อยู่เป็นฝนจริงหรือไม่
        if(btnRainPressed == true)
        {
            rainLabel.setForeground(Color.green);
        }
        else
        {
            rainLabel.setForeground(Color.red);
        }

        startFrame.add(rainLabel);
        startFrame.add(arRainLabel);
    }

    JLabel hLabel = new JLabel("กำหนดช่วงของประชากร");
    JLabel tfLabel1 = new JLabel("ตั้งแต่");
    JLabel tfLabel2 = new JLabel("ถึง");
    JTextField textField1 = new JTextField("2000");
    JTextField textField2 = new JTextField("5000");
    JButton btnOK = new JButton("ตกลง");
    // setPopulation เป็นเมธอดที่เอาไว้กำหนดช่องใส่ช่วงของประชากร แต่ไม่ได้ใช้ panel
    private void setPopulation()
    {
        // ใช้กำหนดหัวข้อที่มีชื่อว่า "กำหนดช่วงของประชากร"
        hLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        hLabel.setForeground(Color.white);
        hLabel.setBounds(510, 750, 200, 100);

        // ใช้กำหนดขนาดของตัวอักษร "ตั้งแต่", "ถึง"
        tfLabel1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        tfLabel1.setForeground(Color.white);
        tfLabel1.setBounds(470, 820, 50, 50);
        tfLabel2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        tfLabel2.setForeground(Color.white);
        tfLabel2.setBounds(470, 855, 50, 50);

        // กำหนดกล่องใส่ข้อความ(ควรใส่เป็นตัวเลข)
        textField1.setBounds(530, 830, 200, 30);
        textField2.setBounds(530, 865, 200, 30);

        // กำหนดขนาดปุ่ม "ตกลง"
        btnOK.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        btnOK.setBackground(Color.lightGray);
        btnOK.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        btnOK.setBounds(500, 910, 200, 30);
        btnOK.setFocusable(false);
        btnOK.addActionListener(this);

        startFrame.add(hLabel);
        startFrame.add(tfLabel1);
        startFrame.add(tfLabel2);
        startFrame.add(textField1);
        startFrame.add(textField2);
        startFrame.add(btnOK);
    }

    // เอาไว้อ่านข้อมูลที่เปิดมาจากไฟล์ที่เลือกมา แล้วเอาใส่อาเรย์
    private void readFileFunction(String fileName)
    {
        try
        {
            Scanner scanner = new Scanner(new File(fileName));

            // ทำการอ่านข้อมูลด้วย scanner ซึ่งใช้วิธีอ่านข้อมูลจากชื่อไฟล์
            String data = "";
            while(scanner.hasNextLine())
            {
                data = data + (scanner.nextLine()) + " ";
            }
            scanner.close();

            // นำข้อมูลยาวๆ ของ data มาหั่นออกแล้วนำไปใส่อาเรย์ ด้วยคำสั่ง split
            String[] dataSplit = data.split("\\s+");
            int[][] dataInt = new int[10][20];
            int index = 0;

            // ทำการเอาข้อมูลที่ได้จากการ split มาใส่ในอาเรย์ 2 มิติ
            for(int row = 0; row < dataInt.length; row++)
            {
                for(int col = 0; col < dataInt[row].length; col++)
                {
                    dataInt[row][col] = Integer.parseInt(dataSplit[index++]);
                    if(dataInt[row][col] < 0)
                    {
                        dataInt[row][col] = 0;
                    }
                    else if(dataInt[row][col] > 250)
                    {
                        dataInt[row][col] = 250;
                    }
                }
            }

            randomPopFunction();            // เมธอดบรรทัดที่ 319
            dustFileFunction(dataInt);      // เมธอดบรรทัดที่ 332
            badPopAndPercentFunction();     // เมธอดบรรทัดที่ 358
            goodPopFunction();              // เมธอดบรรทัดที่ 390
            buttonsColor();                 // เมธอดบรรทัดที่ 402
            gridPanel.setVisible(true);
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
            errorFrame errorFrame = new errorFrame();       // เด้งหน้าต่างแจ้งเตือนว่าผิดพลาด
            gridPanel.setVisible(false);
        }
        catch(NumberFormatException e)
        {
            System.out.println(e.getMessage());
            errorFrame errorFrame = new errorFrame();       // เด้งหน้าต่างแจ้งเตือนว่าผิดพลาด
            gridPanel.setVisible(false);
        }
    }

    private int from = 2000;
    private int to = 5000;
    private int[][] population = new int[10][20];
    // สุ่มค่าประชากรลงในอาเรย์
    private void randomPopFunction()
    {
        for(int row = 0; row < buttons.length; row++)
        {
            for(int col = 0; col < buttons[row].length; col++)
            {
                population[row][col] = random.nextInt(to - from) + (from + 1);
            }
        }
    }

    private int[][] dust = new int[10][20];
    // อ่านค่าฝุ่นจากไฟล์ .txt แล้วนำใส่อาเรย์
    private void dustFileFunction(int[][] dataInt)
    {
        for(int row = 0; row < buttons.length; row++)
        {
            for(int col = 0; col < buttons[row].length; col++)
            {
                dust[row][col] = dataInt[row][col];
            }
        }
    }

    // สุ่มค่าฝุ่นลงในอาเรย์
    private void randomDustFunction()
    {
        for(int row = 0; row < buttons.length; row++)
        {
            for(int col = 0; col < buttons[row].length; col++)
            {
                dust[row][col] = random.nextInt(251);
            }
        }
    }

    private int[][] badPop = new int[10][20];
    private int[][] badPercent = new int[10][20];
    // สุ่มเปอร์เซ็นต์ของคนป่วย และคำนวนค่าของคนป่วยลงในอาเรย์
    private void badPopAndPercentFunction()
    {
        for(int row = 0; row < buttons.length; row++)
        {
            for(int col = 0; col < buttons[row].length; col++)
            {
                if(dust[row][col] <= 50)
                {
                    badPercent[row][col] = random.nextInt(10);
                    badPop[row][col] = (population[row][col] * badPercent[row][col]) / 100;
                }
                else if(dust[row][col] <= 100)
                {
                    badPercent[row][col] = random.nextInt(10) + 10;
                    badPop[row][col] = (population[row][col] * badPercent[row][col]) / 100;
                }
                else if(dust[row][col] <= 150)
                {
                    badPercent[row][col] = random.nextInt(10) + 20;
                    badPop[row][col] = (population[row][col] * badPercent[row][col]) / 100;
                }
                else if(dust[row][col] <= 250)
                {
                    badPercent[row][col] = random.nextInt(21) + 30;
                    badPop[row][col] = (population[row][col] * badPercent[row][col]) / 100;
                }
            }
        }
    }

    private int[][] goodPop = new int[10][20];
    // คำนวนค่าของคนที่สุขภาพดีลงในอาเรย์
    private void goodPopFunction()
    {
        for(int row = 0; row < buttons.length; row++)
        {
            for(int col = 0; col < buttons[row].length; col++)
            {
                goodPop[row][col] = population[row][col] - badPop[row][col];
            }
        }
    }
    
    // buttonsColor เอาไว้กำหนดสีของปุ่มตามเปอร์เซ็นต์ของประชากรที่ป่วย
    private void buttonsColor()
    {
        for(int row = 0; row < buttons.length; row++)
        {
            for(int col = 0; col < buttons[row].length; col++)
            {
                if(badPercent[row][col] <= 9)
                {
                    buttons[row][col].setBackground(Color.green);
                }
                else if(badPercent[row][col] <= 19)
                {
                    buttons[row][col].setBackground(Color.yellow);
                }
                else if(badPercent[row][col] <= 29)
                {
                    buttons[row][col].setBackground(Color.orange);
                }
                else if(badPercent[row][col] >= 30)
                {
                    buttons[row][col].setBackground(Color.red);
                }
            }
        }
    }

    boolean btnRainPressed = false;
    boolean btnArPressed = false;
    boolean buttonsPressed = false;
    // checkRain ใช้เพื่อคำนวนปริมาณฝุ่น และเปลี่ยนสีตามข้อมูลที่เปลี่ยนไปแล้ว
    private void checkRain()
    {
        for(int row = 0; row < buttons.length; row++)
        {
            for(int col = 0; col < buttons[row].length; col++)
            {
                dust[row][col] = dust[row][col] - 50;

                if(dust[row][col] < 0)
                {
                    dust[row][col] = 0;
                }
            }
        }

        badPopAndPercentFunction();     // เมธอดบรรทัดที่ 358
        buttonsColor();                 // เมธอดบรรทัดที่ 402
        gridPanel.setVisible(false);
        gridPanel.setVisible(true);

        btnRainPressed = false;
        buttonsPressed = false;
    }

    private double dustDecimal = 0;
    // checkArRain ใช้เพื่อคำนวนปริมาณฝุ่น และเปลี่ยนสีตามข้อมูลที่เปลี่ยนไปแล้ว
    private void checkArRain(int row, int col)
    {
        for(int i = row - 1; i <= row + 1; i++)
        {
            for(int j = col - 1; j <= col + 1; j++)
            {
                if(i >= 0 && i < buttons.length && j >= 0 && j < buttons[i].length)
                {
                    if(i == row && j == col)
                    {
                        dustDecimal = Math.floor(dust[i][j] - ((dust[i][j] * 50) / (float)100));
                        dust[i][j] = (int)(dustDecimal);
                    }

                    if(i != row || j != col)
                    {
                        dustDecimal = Math.floor(dust[i][j] - ((dust[i][j] * 30) / (float)100));
                        dust[i][j] = (int)(dustDecimal);
                    }
                }
            }
        }

        badPopAndPercentFunction();     // เมธอดบรรทัดที่ 358
        buttonsColor();                 // เมธอดบรรทัดที่ 402
        gridPanel.setVisible(false);
        gridPanel.setVisible(true);

        btnArPressed = false;
        buttonsPressed = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // อยู่ด้านซ้ายล่าง กดปุ่มเพื่อกลับหน้าหลักของโปรแกรม
        if(e.getSource() == btnHome)
        {
            MenuFrame menuFrame = new MenuFrame();      // เปิดไปที่หน้าหลัก
            startFrame.dispose();
        }

        // เป็นจุดให้ใสค่าช่วงของประชากร กดปุ่มเพื่อยืนยันค่าที่ใส่ไป
        if(e.getSource() == btnOK)
        {
            try
            {
                popFrame popFrame = new popFrame();     // เด้งหน้าต่างแจ้งเตือนว่ากำหนดช่วงประชากรแล้ว

                gridPanel.setVisible(false);
                from = Integer.parseInt(textField1.getText());
                to = Integer.parseInt(textField2.getText());

                randomPopFunction();        // เมธอดบรรทัดที่ 319
            }
            catch(NumberFormatException nbfe)
            {
                errorFrame errorFrame = new errorFrame();       // เด้งหน้าต่างแจ้งเตือนว่าผิดพลาด
            }
        }

        // อยู่ด้านล่างซ้าย กดปุ่มเพื่อทำการเลือกไฟล์ .txt ที่อยู่ในเครื่อง
        if(e.getSource() == btnDustFile)
        {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);

            if(returnValue == JFileChooser.APPROVE_OPTION)
            {
                File selectedFile = fileChooser.getSelectedFile();
                String fileName = selectedFile.getName();

                readFileFunction(fileName);     // เมธอดบรรทัดที่ 262
            }
        }

        // อยู่ด้านซ้ายล่าง กดปุ่มเพื่อทำการสุ่มค่าฝุ่นโดยไม่ได้เปิดมาจากไฟล์
        if(e.getSource() == btnDustRandom)
        {
            randomPopFunction();            // เมธอดบรรทัดที่ 319
            randomDustFunction();           // เมธอดบรรทัดที่ 344
            badPopAndPercentFunction();     // เมธอดบรรทัดที่ 358
            goodPopFunction();              // เมธอดบรรทัดที่ 390
            buttonsColor();                 // เมธอดบรรทัดที่ 402
            gridPanel.setVisible(true);
        }

        // กดปุ่มเพื่อเตรียมที่จะใช้งานฝนจริง ก่อนที่จะกดที่ buttons
        if(e.getSource() == btnRain)
        {
            btnRainPressed = true;
            setStatus();        // เมธอดบรรทัดที่ 186
        }

        // กดปุ่มเพื่อเตรียมที่จะใช้งานฝนเทียม ก่อนที่จะกดที่ buttons
        if(e.getSource() == btnAr)
        {
            btnArPressed = true;
            setStatus();        // เมธอดบรรทัดที่ 186
        }

        // กดปุ่มเพื่อที่จะยกเลิกการกดปุ่มฝนจริง หรือฝนเทียม
        if(e.getSource() == btnCancel)
        {
            btnRainPressed = false;
            btnArPressed = false;
            setStatus();        // เมธอดบรรทัดที่ 186
        }

        // กดปุ่มบน gridPanel เพื่อตรวจหาว่าได้กดปุ่ม rain หรือ arRain หรือไม่ 
        for(int row = 0; row < buttons.length; row++)
        {
            for(int col = 0; col < buttons[row].length; col++)
            {
                if(e.getSource() == buttons[row][col])
                {
                    buttonsPressed = true;
                    
                    if(btnRainPressed && buttonsPressed)
                    {
                        checkRain();        // เมธอดบรรทัดที่ 432
                    }
                    else if(btnArPressed && buttonsPressed)
                    {
                        checkArRain(row, col);      // เมธอดบรรทัดที่ 458
                    }

                    setStatus();        // เมธอดบรรทัดที่ 186
                }
            }
        }
        
        // กดปุ่มบน gridPanel เพื่อแสดงข้อมูลต่างๆ ในช่องนั้นๆ
        for(int row = 0; row < buttons.length; row++)
        {
            for(int col = 0; col < buttons[row].length; col++)
            {
                if(e.getSource() == buttons[row][col])
                {
                    labels[0].setText(" ปริมาณฝุ่น : " + dust[row][col]);
                    labels[1].setText(" จำนวนประชากร : " + population[row][col]);
                    labels[2].setText(" ประชากรที่สุขภาพดี : " + goodPop[row][col]);
                    labels[3].setText(" ประชากรที่ป่วย : " + badPop[row][col]);
                    labels[4].setText(" ร้อยละของประชากรที่ป่วย : " + badPercent[row][col]);
                }
            }
        }

        String picture = "";
        // กดปุ่มบน gridPanel เพื่อแสดงรูปภาพตามข้อมูุลที่ปุ่มนั้นๆ มีอยู่
        for(int row = 0; row < buttons.length; row++)
        {
            for(int col = 0; col < buttons[row].length; col++)
            {
                if(e.getSource() == buttons[row][col])
                {
                    if(badPercent[row][col] <= 9)
                    {
                        picture = "emoticon1.png";
                    }
                    else if(badPercent[row][col] <= 19)
                    {
                        picture = "emoticon2.png";
                    }
                    else if(badPercent[row][col] <= 29)
                    {
                        picture = "emoticon3.png";
                    }
                    else if(badPercent[row][col] >= 30)
                    {
                        picture = "emoticon4.png";
                    }

                    setImagePanel(picture);     // เมธอดบรรทัดที่ 56
                }
            }
        }
    }
}