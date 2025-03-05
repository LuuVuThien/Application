package SInhVIen;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Beo { 

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

        JLabel lblNewLabel = new JLabel("Tìm các số chia hết cho 3"); // đặt lại tên biến có ý nghĩa
        lblNewLabel.setBounds(57, 39, 149, 14);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Khởi đầu"); // đặt lại tên biến có ý nghĩa
        lblNewLabel_1.setBounds(43, 82, 48, 14);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Kết thúc"); // đặt lại tên biến có ý nghĩa
        lblNewLabel_2.setBounds(85, 133, 48, 14);
        frame.getContentPane().add(lblNewLabel_2);

        num1 = new JTextField();  // đặt lại tên biến có ý nghĩa
        num1.setText("0");
        num1.setBounds(138, 79, 96, 20);
        frame.getContentPane().add(num1);
        num1.setColumns(10);

        num2 = new JTextField();  // đặt lại tên biến có ý nghĩa
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
                    for (int i = x; i < y; i++) { // Khi `y < x`, vòng lặp `for (int i = x; i <= y; i++)` sẽ không chạy đúng.
                        if (i % 3 == 0) {
                            result.append(i);  // thêm dấu phẩy cách giữa các kết quả
                        }
                    }
                    ketqua.setText(result.toString()); // Hiển thị chuỗi rỗng dù không có số chia cho 3

                } catch (NumberFormatException ex) {
                    ketqua.setText("Vui lòng nhập số hợp lệ!");

                  
                }
                inketqua.setBounds(10, 1650, 89, 23); // sửa lại kích thước, nếu dãy số quá dài, nó sẽ tràn ra ngoài giao diện

            }
        });
       inketqua.setBounds(10, 165, 89, 23);
        frame.getContentPane().add(inketqua);
    }
}

// Chương trình không thể chạy nhiều lần vì không có nút reset. Cần thêm nút "Làm mới" để nhập lại dữ liệu.
