package SInhVIen;
/lỗi chỗ này sữa lại
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/Sữa lại
public class Beo {
/Sữa lại
    private JFrame frame;
    private JTextField num1;
    private JTextField num2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Beo window = new Beo();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Beo() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Tìm các số chia hết cho 3");
        lblNewLabel.setBounds(57, 39, 149, 14);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Khởi đầu");
        lblNewLabel_1.setBounds(43, 82, 48, 14);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Kết thúc");
        lblNewLabel_2.setBounds(85, 133, 48, 14);
        frame.getContentPane().add(lblNewLabel_2);

        num1 = new JTextField();
        num1.setText("0");
        num1.setBounds(138, 79, 96, 20);
        frame.getContentPane().add(num1);
        num1.setColumns(10);

        num2 = new JTextField();
        num2.setText("0");
        num2.setBounds(191, 130, 96, 20);
        frame.getContentPane().add(num2);
        num2.setColumns(10);

        JLabel ketqua = new JLabel("Danh sách các số :");
        ketqua.setBounds(31, 199, 381, 14);
        frame.getContentPane().add(ketqua);

        JButton inketqua = new JButton("Chạy");
        inketqua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Giả lập lỗi khi nhập không phải là số
                    int x = Integer.parseInt(num1.getText());
                    int y = Integer.parseInt(num2.getText());

                    // Lỗi setText(null) trên JLabel
                    lblNewLabel_1.setText(null);

                    // Lỗi trong vòng lặp nếu y < x
                    StringBuilder result = new StringBuilder("Các số chia hết cho 3: ");
                    for (int i = x; i < y; i++) {
                        if (i % 3 == 0) {
                            result.append(i);
                        }
                    }
                    ketqua.setText(result.toString());

                } catch (NumberFormatException ex) {
                    ketqua.setText("Vui lòng nhập số hợp lệ!");

                  
                }
                inketqua.setBounds(10, 1650, 89, 23);
            }
        });
       inketqua.setBounds(10, 165, 89, 23);
        frame.getContentPane().add(inketqua);
    }
}
