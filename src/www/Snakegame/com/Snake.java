package www.Snakegame.com;


import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("unused")
public class Snake {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame(); // ����һ����Ϸ����Ŀ��
        frame.setBounds(0, 0, 900, 700); // ���ÿ�ܵĴ�С
        frame.setResizable(false); // ���ÿ�ܴ�СΪ���ܸı�
        // ����رհ�ť �ر���Ϸ����
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        SnakePanel panel = new SnakePanel();  //��ӻ���
        frame.add(panel); // �����ʱ�����ǿյĿ�����
        
        frame.setVisible(true); // ������ʾ��Ϸ����
    }

}
