package SInhVIen;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// trực tiếp import như java.swing.*;
public class Beo { //Đặt tên lớp không phù hợp với chương trình 

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
        frame.setBounds(100, 100, 450, 300); //frame.setBounds(100, 100, 450, 300); có thể thay bằng frame.setSize(450, 300); để dễ đọc hơn.
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
        num1.setText("0"); // để trống mặc định sẽ hay hơn
        num1.setBounds(138, 79, 96, 20);
        frame.getContentPane().add(num1);
        num1.setColumns(10);

        num2 = new JTextField();
        num2.setText("0");// để trống mặc định sẽ hay hơn
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
                    lblNewLabel_1.setText(null);//có thể gây lỗi hiển thị trong UI. Nên dùng setText("").

                    // Lỗi trong vòng lặp nếu y < x
                    StringBuilder result = new StringBuilder("Các số chia hết cho 3: "); //StringBuilder result = new StringBuilder("Các số chia hết cho 3: "); nếu danh sách số lớn, có thể tối ưu bằng cách sử dụng StringJoiner.
                    for (int i = x; i < y; i++) { // Nếu y < x, vòng lặp for sẽ không hoạt động hợp lý, có thể gây lỗi logic. Cần kiểm tra trước khi lặp.

                        if (i % 3 == 0) {
                            result.append(i); //Cần thêm ", " khi nối chuỗi trong StringBuilder để danh sách số rõ ràng hơn.
                        }
                    }
                    ketqua.setText(result.toString());

                } catch (NumberFormatException ex) { //Nếu nhập không phải số, chương trình chỉ hiển thị lỗi chung chung, không chỉ rõ nhập sai ở đâu.
                    ketqua.setText("Vui lòng nhập số hợp lệ!");
                }
                inketqua.setBounds(10, 1650, 89, 23); //nketqua.setBounds(10, 1650, 89, 23); có thể là lỗi nhập tọa độ sai (1650 không hợp lý).
            }
        });
       inketqua.setBounds(10, 165, 89, 23); // Button inketqua bị set setBounds 2 lần, gây lỗi giao diện.
        frame.getContentPane().add(inketqua);
    }
}
