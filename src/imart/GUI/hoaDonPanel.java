/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.GUI;

import com.toedter.calendar.JDateChooser;
import imart.BLL.hoaDonBLL;
import imart.BLL.khachHangBLL;
import imart.BLL.loaiHangBLL;
import imart.BLL.nhanVienBLL;
import imart.BLL.sanPhamBLL;
import imart.BLL.taiKhoanBLL;
import imart.DAO.ctHoaDonDAO;
import imart.DAO.hoaDonDAO;
import imart.DAO.khachHangDAO;
import imart.DAO.sanPhamDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bao Luan
 */
public class hoaDonPanel {
    private JPanel pncontent_left, pncontent_right, pncont1, pncont13 , pncont131, pncont132, pncont1321, pncont1322 ,pncont11, pncont12, pncont2, pncont_left1, pncont_left2, 
                   pnTotal, pnKhachTra, pnTienDu, pncont121;
    private JLabel[] lbctsp;
    private JTextField[] txctsp;
    private JLabel lbcreatedate, lbbillid, lbnhanvien, lbsdtkhachhang, lbtimkh, lbkhachhang ,lbdiachikh, lblaygia,lbghichu, lbTotal, lbKhachTra, lbTienDu, lbaddkh1, lbaddkh2, lbxoa;
    private JComboBox cbproducts, cbnhanvien, cbkhachhang, cblaygia;
    private JTextField txFindItem, txcreatedate, txbillid, txtimkh, txdiachikh, txsdtkhachhang, txghichu, txTotal, txKhachTra, txTienDu, txnhanvien;
    private JButton get, reset, newHoaDon, viewHoaDonList, sell;
    private static JTable tablehd = new JTable();
    private static DefaultTableModel modelhd= new DefaultTableModel();
    private static JScrollPane scroll= new JScrollPane();
    private JFrame jfaddkh;
    JDateChooser dc= new JDateChooser();
    sanPhamBLL spbll= new sanPhamBLL();
    taiKhoanBLL tkbll = new taiKhoanBLL();
    hoaDonBLL hdbll= new hoaDonBLL();
    
    public hoaDonPanel(){
        //this.control = new JLabel("B??n h??ng");
        modelhd=new DefaultTableModel();
        initCompornent();
    }
    
    public void initCompornent(){
        LocalDate date= LocalDate.now();
        dc.setDate(Date.valueOf(date));
        
        // con tr??i c???a pncontent 
        pncontent_left= new JPanel();
        pncontent_left.setBackground(Color.white);
        pncontent_left.setPreferredSize(new Dimension(380, 890));
        pncontent_left.setLayout(new FlowLayout(1, 10, 30));

        // con ph???i c???a pncontent 
        pncontent_right= new JPanel();
        pncontent_right.setPreferredSize(new Dimension(1494, 890));
        pncontent_right.setLayout(new BorderLayout(10,0));
        pncontent_right.setBackground(Color.white);
        
        // panel con c???a content_right 
        pncont1= new JPanel();
        pncont1.setPreferredSize(new Dimension(1494, 60));
        pncont1.setLayout(new FlowLayout(0, 0, 15));
        
        // panel con c???a pncont1 
        pncont11= new JPanel();
        pncont11.setPreferredSize(new Dimension(1494, 150));
        pncont11.setBackground(Color.white);
        pncont11.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.darkGray),BorderFactory.createEmptyBorder(10,0,10,100)));
        
        // panel con c???a pncont1 
        pncont12= new JPanel();
        pncont12.setPreferredSize(new Dimension(1494, 485));
        pncont12.setBackground(Color.white);
        pncont12.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        pncont12.setLayout(new BorderLayout());
        
        pncont121= new JPanel();
        pncont121.setBackground(Color.white);
        pncont121.setPreferredSize(new Dimension(0, 50));
        pncont121.setLayout(new BorderLayout());
        pncont121.setBorder(BorderFactory. createEmptyBorder(5,0,5,10));
        
        lbxoa= new JLabel("X??a");
        lbxoa.setFont(new Font("Tahoma", Font.BOLD, 20));
        lbxoa.setPreferredSize(new Dimension(70,0));
        lbxoa.setHorizontalAlignment(0);
        lbxoa.setBackground(new Color(240,0,0));
        lbxoa.setForeground(new Color(254, 246, 255));
        lbxoa.setOpaque(true);
        
        pncont121.add(lbxoa, BorderLayout.EAST);
        pncont12.add(pncont121, BorderLayout.NORTH);
        
        // panel con c???a pncont1 
        pncont13= new JPanel();
        pncont13.setPreferredSize(new Dimension(1494, 150));
        pncont13.setBackground(Color.white);
        pncont13.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        pncont13.setLayout(new GridLayout(2,1,0,20));
        
        tablehd= new JTable(modelhd){
            @Override
            public boolean isCellEditable(int row, int column) {                
                switch (column) {
                    case 6:
                        return true;
                    default:
                        return false;
                 }              
            };
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                case 6:
                    return Boolean.class;
                default:
                    return String.class;
                }
            }
        };
        
        
        pncont131= new JPanel();
        pncont131.setLayout(new GridLayout(1, 3, 20, 0));
        pncont131.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        pncont131.setBackground(Color.white);
        
        pncont132= new JPanel();
        pncont132.setLayout(new GridLayout(1, 2, 20, 0));
        pncont132.setBackground(Color.white);
        
        pncont1321= new JPanel();
        pncont1321.setLayout(new GridLayout(1, 1));
        pncont1321.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 450));
        pncont1321.setBackground(Color.white);
        
        pncont1322= new JPanel();
        pncont1322.setLayout(new GridLayout(1, 2, 20, 0));
        pncont1322.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        pncont1322.setBackground(Color.white);
        
        //add v??o pncon1 
        pncont1.add(pncont11);
        pncont1.add(pncont12);
        pncont1.add(pncont13);
        
        pncont2= new JPanel();
        pncont2.setLayout(new BorderLayout());
        pncont2.setPreferredSize(new Dimension(350,200));
        
        loaiHangBLL lhbll= new loaiHangBLL();
        cbproducts= new JComboBox(lhbll.getTenLoai());
        cbproducts.setPreferredSize(new Dimension(160, 30));
        cbproducts.setBackground(Color.white);
        
        //ph???n tr??n
        pncont_left1= new JPanel();
        pncont_left1.setPreferredSize(new Dimension(380, 300));
        pncont_left1.setBackground(Color.white);
        
        //ph???n d?????i
        pncont_left2= new JPanel();
        pncont_left2.setPreferredSize(new Dimension(380, 440));
        pncont_left2.setBackground(Color.white);
        
        pnTotal= new JPanel();
        pnTotal.setLayout(new FlowLayout(0, 20, 0));
        pnTotal.setBackground(Color.white);
        lbTotal= new JLabel("T???ng c???ng");
        txTotal= new JTextField();
        txTotal.setEditable(false);
        txTotal.setPreferredSize(new Dimension(160, 30));
        pnTotal.add(lbTotal);
        pnTotal.add(txTotal);
                    
        pnKhachTra= new JPanel();
        pnKhachTra.setLayout(new FlowLayout(0, 20, 0));
        pnKhachTra.setBackground(Color.white);
        lbKhachTra= new JLabel("Kh??ch tr???");
        txKhachTra= new JTextField();
        txKhachTra.setPreferredSize(new Dimension(160, 30));
        pnKhachTra.add(lbKhachTra);
        pnKhachTra.add(txKhachTra);
        
        pnTienDu= new JPanel();
        pnTienDu.setLayout(new FlowLayout(0, 20, 0));
        pnTienDu.setBackground(Color.white);
        lbTienDu= new JLabel("Ti???n d??");
        txTienDu= new JTextField();
        txTienDu.setPreferredSize(new Dimension(160, 30));
        pnTienDu.add(lbTienDu);
        pnTienDu.add(txTienDu);
       
        newHoaDon= new JButton("T???o h??a ????n m???i");
        viewHoaDonList= new JButton("Xem danh s??ch h??a ????n");
        sell= new JButton("Thanh to??n");
        
        get= new JButton("Ch???n");
        get.setPreferredSize(new Dimension(160, 40));
        reset= new JButton("L??m m???i");
        reset.setPreferredSize(new Dimension(160, 40));
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
        
    public void getHoaDonPanel(JPanel panel, JPanel pntitle, JLabel lbtitle, String us, String pw){
        panel.removeAll();
        panel.setLayout(new BorderLayout(15, 0));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 15));
        
        pncont_left1.removeAll();
        pncont_left2.removeAll();
        
        pncont_left1.setBorder(BorderFactory.createTitledBorder(null,"S???n ph???m",1,0, new Font("Tahoma",Font.BOLD,20)));
        pncont_left1.setLayout(new FlowLayout(0, 10, 15));
        
        pncont_left2.setBorder(BorderFactory.createTitledBorder(null,"Chi Ti???t S???n ph???m",1,0, new Font("Tahoma",Font.BOLD,20)));
        pncont_left2.setLayout(new FlowLayout(0, 10, 25));
        
        txFindItem= new JTextField();
        txFindItem.setPreferredSize(new Dimension(180,30));
        
        txFindItem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String find = txFindItem.getText().trim();
                cbproducts.setSelectedIndex(0);
                txFindItem.removeAll();
                pncont2.removeAll();
                JTable table= new JTable(){
                    @Override
                    public boolean isCellEditable(int row, int column) {                
                        switch (column) {
                            default:
                                return false;
                         }              
                    };
                };
                JScrollPane scroll= new JScrollPane();
                table= spbll.showData(find);
                table.getColumnModel().getColumn(0).setMinWidth(0); 
                table.getColumnModel().getColumn(0).setMaxWidth(0); 
                table.getColumnModel().getColumn(2).setMinWidth(0); 
                table.getColumnModel().getColumn(2).setMaxWidth(0); 
                table.getColumnModel().getColumn(3).setMinWidth(0); 
                table.getColumnModel().getColumn(3).setMaxWidth(0); 
                scroll.setViewportView(table);
                pncont2.add(scroll,BorderLayout.CENTER);
                setText(table);
                txFindItem.validate();
                pncontent_left.repaint();
                pncontent_left.validate();
            }
        });
        
        addFullTable();
        
        cbproducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loaiHangBLL lhbll = new loaiHangBLL();
                if(cbproducts.getSelectedIndex()==0){
                    pncont2.removeAll();
                    addFullTable();
                } else if (cbproducts.getSelectedIndex() > 0 && cbproducts.getSelectedIndex() < lhbll.slLoaiHang()) {
                    pncont2.removeAll();
                    txFindItem.setText("");
                    JTable table= new JTable(){
                        @Override
                        public boolean isCellEditable(int row, int column) {                
                            switch (column) {
                                default:
                                    return false;
                             }              
                        };
                    };
                    JScrollPane scroll= new JScrollPane();
                    table= spbll.showDataByMaLoai(String.valueOf(cbproducts.getSelectedIndex()));
                    table.getColumnModel().getColumn(0).setMinWidth(0); 
                    table.getColumnModel().getColumn(0).setMaxWidth(0); 
                    table.getColumnModel().getColumn(2).setMinWidth(0); 
                    table.getColumnModel().getColumn(2).setMaxWidth(0); 
                    table.getColumnModel().getColumn(3).setMinWidth(0); 
                    table.getColumnModel().getColumn(3).setMaxWidth(0); 
                    scroll.setViewportView(table);
                    pncont2.add(scroll,BorderLayout.CENTER);
                    setText(table);
                    pncontent_left.repaint();
                    pncontent_left.validate();
                }
            }
        });
        
        String header[]={"STT","M?? s???n ph???m","T??n s???n ph???m","S??? l?????ng","????n gi??","Th??nh ti???n", "Ch???n x??a"};
        this.modelhd.setColumnIdentifiers(header);
        tablehd.setModel(modelhd);
        tablehd.getColumnModel().getColumn(6).setMinWidth(0);
        tablehd.getColumnModel().getColumn(6).setMaxWidth(0);
        scroll.setViewportView(tablehd);
        pncont12.add(scroll,BorderLayout.CENTER);
        
        get.addActionListener((ActionEvent e) -> {
            try {
                tablehd.getColumnModel().getColumn(6).setMinWidth(100);
                tablehd.getColumnModel().getColumn(6).setMaxWidth(120);
                tablehd.validate();
                System.out.println(txctsp[0].getText());
                newHoaDon(txctsp[0].getText(), txctsp[1].getText(), Integer.parseInt(txctsp[5].getText()), Double.parseDouble(txctsp[4].getText()), 
                        (int) (Integer.parseInt(txctsp[5].getText()) * Double.parseDouble(txctsp[4].getText())));
                int Tong=0;
                for(int i=0;i<modelhd.getRowCount();i++){
                    Tong+= Double.parseDouble(String.valueOf(modelhd.getValueAt(i, 5)));
                    txTotal.setText(String.valueOf(Tong));
                }
                txFindItem.setText("");
                cbproducts.setSelectedIndex(0);
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(null,"H??y nh???p s??? l?????ng s???n ph???m","Th??ng b??o",2);
                txctsp[5].requestFocus();
            }
        });
        
        deleteFromBill(tablehd);
        
        txKhachTra.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    if (Double.parseDouble(txKhachTra.getText()) <= Double.parseDouble(txTotal.getText())) {
                        txTienDu.setText("0.0 VND");
                    } else {
                        txTienDu.setText(String.valueOf(Double.parseDouble(txKhachTra.getText()) - Double.parseDouble(txTotal.getText())));
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("Error at line298 HoaDonPanel");
                }
            }
        });
        
        billInfo(us,pw);
        
        lbctsp= new JLabel[spbll.getHeader().length];
        txctsp= new JTextField[spbll.getHeader().length];
        for(int i=0;i<spbll.getHeader().length;i++){
            lbctsp[i]= new JLabel(spbll.getHeader()[i]);
            lbctsp[i].setFont(new Font("Tahoma", Font.BOLD,16));
            txctsp[i]= new JTextField();
            lbctsp[i].setPreferredSize(new Dimension(160,30));
            txctsp[i].setPreferredSize(new Dimension(180,30));
            txctsp[i].setEditable(false);
            pncont_left2.add(lbctsp[i]);
            pncont_left2.add(txctsp[i]);
        }
        txctsp[5].setEditable(true);
        
        viewHoaDonList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jf= new JFrame("Danh s??ch h??a ????n");
                jf.setSize(700,300);
                jf.setLayout(new GridLayout());
                jf.add(hdbll.showData());
                jf.setLocationRelativeTo(null);
                jf.setVisible(true);
            }
        });
        
        sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hoaDonDAO hddao= new hoaDonDAO();
                ctHoaDonDAO cthddao= new ctHoaDonDAO();
                sanPhamDAO spdao= new sanPhamDAO();
                nhanVienBLL nvbll = new nhanVienBLL();
                khachHangBLL khbll = new khachHangBLL();
                
                SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd"); 
                
                String ghichu=null;
                
                if(txghichu.getText().equals("")){
                    ghichu= "Kh??ng";
                } else{
                    ghichu=txghichu.getText();
                }
                hddao.insertToDBHoaDon(txbillid.getText(),                                                          //m?? h??a ????n
                                       nvbll.getMaFromName(txnhanvien.getText()),                //m?? nh??n vi??n
                                       khbll.getMaFromName(cbkhachhang.getSelectedItem().toString()),               //m?? kh??ch h??ng
                                       Date_Format.format(dc.getDate()),                                            //ng??y b??n
                                       Double.parseDouble(txTotal.getText()),                                       //t???ng ti???n
                                       ghichu);                                                                     //ghi ch??
                
                // ????a s???n ph???m v??o chi ti???t h??a ????n v?? update l???i s??? l?????ng s???n ph???m 
                if(modelhd.getRowCount()>0){
                    for(int i=0;i<modelhd.getRowCount();i++){
                        // ????a s???n ph???m v??o chi ti???t h??a ????n
                        cthddao.insertToDBctHoaDon(txbillid.getText(), 
                                                   modelhd.getValueAt(i, 1).toString(), 
                                                   Integer.parseInt(String.valueOf(modelhd.getValueAt(i, 3))),
                                                   Double.parseDouble(modelhd.getValueAt(i, 4).toString()), 
                                                   Double.parseDouble(modelhd.getValueAt(i, 5).toString()));
                        // update l???i s??? l?????ng s???n ph???m
                        for(int a=0;a<spbll.getList().getSanpham().size();a++){
                            // n???u s???n ph???m trong list c?? m?? b???ng m?? s???n ph???m trong h??a ????n th?? c???p nh???t l???i s??? l?????ng m???i 
                            if(spbll.getList().getSanpham().get(a).getId().equals(modelhd.getValueAt(i, 1).toString())){
                                // s??? l?????ng m???i b???ng t???ng tr??? s??? l?????ng s???n ph???m trong h??a ????n
                                spdao.updateDBSanPham(modelhd.getValueAt(i, 1).toString(), 
                                                      spbll.getList().getSanpham().get(a).getSoluong());
                            }
                        }
                    }
                }
                
                reportBill rb= new reportBill();
                rb.printHoaDon(txbillid.getText());
                
                panel.removeAll();
                hoaDonPanel hdpn= new hoaDonPanel();
                hdpn.getHoaDonPanel(panel, pntitle, lbtitle, us, pw);
                panel.validate();
            }
        });
        
        pncont131.add(pnTotal);
        pncont131.add(pnKhachTra);
        pncont131.add(pnTienDu);
        
        pncont1321.add(newHoaDon);
        pncont1322.add(viewHoaDonList);
        pncont1322.add(sell);
        pncont132.add(pncont1321);
        pncont132.add(pncont1322);
        
        pncont13.add(pncont131);
        pncont13.add(pncont132);
        
        pncontent_left.add(pncont_left1);
        pncontent_left.add(pncont_left2);
        pncontent_left.add(get);
        pncontent_left.add(reset);
        pncont_left1.add(cbproducts);
        pncont_left1.add(txFindItem);
        pncont_left1.add(pncont2);
        
        //pncontent_right.add(spbll.showData(),BorderLayout.CENTER);

        //changeTabMenu(0);
        pncontent_right.removeAll();
        lbtitle.removeAll();
        lbtitle.setText("H??a ????n b??n h??ng");
        lbtitle.repaint();
        lbtitle.validate();

        pncontent_right.add(pncont1,BorderLayout.CENTER);
        pncontent_right.add(pntitle,BorderLayout.NORTH);
        pncont_left1.repaint();
        pncont_left1.validate();
        pncont_left2.repaint();
        pncont_left2.validate();
        pncontent_left.repaint();
        pncontent_left.validate();
        pncontent_right.repaint();
        pncontent_right.validate();
        
        panel.add(pncontent_left, BorderLayout.WEST);
        panel.add(pncontent_right, BorderLayout.CENTER);
        panel.repaint();
        panel.validate();
        panel.getRootPane().setDefaultButton(get);
    }
    
    public void setText(JTable tb){
        tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int i=tb.getSelectedRow();
                for(int a=0;a<spbll.getHeader().length;a++){
                    if(a == 5){
                        txctsp[a].setText("");
                        txctsp[a].requestFocus();
                    } else {
                        txctsp[a].setText(tb.getModel().getValueAt(i,a).toString());
                    }
                }
            }
        });
    }
    
    
    // table t??m ki???m 
    public void addFullTable(){
        JTable table= new JTable();
        JScrollPane scroll= new JScrollPane();
        table= spbll.showDataByMaLoai0();
        table.getColumnModel().getColumn(0).setMinWidth(0); 
        table.getColumnModel().getColumn(0).setMaxWidth(0); 
        table.getColumnModel().getColumn(2).setMinWidth(0); 
        table.getColumnModel().getColumn(2).setMaxWidth(0); 
        table.getColumnModel().getColumn(3).setMinWidth(0); 
        table.getColumnModel().getColumn(3).setMaxWidth(0); 
        scroll.setViewportView(table);
        pncont2.add(scroll,BorderLayout.CENTER);
        setText(table);
        pncontent_left.repaint();
        pncontent_left.validate();
    }
    
    public void billInfo(String us, String pw){
        pncont11.removeAll();
        pncont11.repaint();
        pncont11.validate();
        hoaDonBLL hdbll= new hoaDonBLL();
        khachHangBLL khbll= new khachHangBLL();
        nhanVienBLL nvbll= new nhanVienBLL();
        Font font = new Font("Tahoma",Font.PLAIN,20);
             
        lbcreatedate= new JLabel();
        lbcreatedate.setText("Ng??y l???p");
        lbcreatedate.setPreferredSize(new Dimension(50, 150));
        lbcreatedate.setFont(font);
        lbcreatedate.setHorizontalAlignment(JLabel.RIGHT);
        
        lbbillid= new JLabel();
        lbbillid.setText("S??? h??a ????n");
        lbbillid.setPreferredSize(new Dimension(50, 150));
        lbbillid.setFont(font);
        lbbillid.setHorizontalAlignment(JLabel.RIGHT);
        
        lbnhanvien= new JLabel();
        lbnhanvien.setText("Thu ng??n");
        lbnhanvien.setPreferredSize(new Dimension(50, 150));
        lbnhanvien.setFont(font);
        lbnhanvien.setHorizontalAlignment(JLabel.RIGHT);
        
        lbtimkh= new JLabel();
        lbtimkh.setText("T??m kh??ch h??ng");
        lbtimkh.setPreferredSize(new Dimension(50, 30));
        lbtimkh.setFont(font);
        lbtimkh.setHorizontalAlignment(JLabel.RIGHT);
        
        lbkhachhang= new JLabel();
        lbkhachhang.setText("Kh??ch h??ng");
        lbkhachhang.setPreferredSize(new Dimension(50, 30));
        lbkhachhang.setFont(font);
        lbkhachhang.setHorizontalAlignment(JLabel.RIGHT);
        
        lbdiachikh= new JLabel();
        lbdiachikh.setText("?????a ch???");
        lbdiachikh.setPreferredSize(new Dimension(50, 30));
        lbdiachikh.setFont(font);
        lbdiachikh.setHorizontalAlignment(JLabel.RIGHT);
        
        lbsdtkhachhang= new JLabel();
        lbsdtkhachhang.setText("S??? ??i???n tho???i");
        lbsdtkhachhang.setPreferredSize(new Dimension(50, 30));
        lbsdtkhachhang.setFont(font);
        lbsdtkhachhang.setHorizontalAlignment(JLabel.RIGHT);
        
        lblaygia= new JLabel();
        lblaygia.setText("L???y gi??");
        lblaygia.setPreferredSize(new Dimension(50, 30));
        lblaygia.setFont(font);
        lblaygia.setHorizontalAlignment(JLabel.RIGHT);
        
        lbghichu= new JLabel();
        lbghichu.setText("Ghi ch??");
        lbghichu.setPreferredSize(new Dimension(50, 30));
        lbghichu.setFont(font);
        lbghichu.setHorizontalAlignment(JLabel.RIGHT);
        
        lbaddkh1= new JLabel("Th??m kh??ch h??ng");
        lbaddkh1.setPreferredSize(new Dimension(50, 30));
        lbaddkh1.setFont(font);
        lbaddkh1.setHorizontalAlignment(JLabel.RIGHT);
        
        lbaddkh2= new JLabel("+");
        lbaddkh2.setPreferredSize(new Dimension(10, 30));
        lbaddkh2.setFont(font);
        lbaddkh2.setBackground(Color.black);
        lbaddkh2.setForeground(Color.white);
        lbaddkh2.setOpaque(true);
        lbaddkh2.setHorizontalAlignment(JLabel.CENTER);
        
        
        txnhanvien= new JTextField();
        String info[]= nvbll.getAllInfo(us, pw);
        txnhanvien.setText(info[1]+" "+info[2]);
        txnhanvien.setPreferredSize(new Dimension(10, 30));
        txnhanvien.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        txnhanvien.setEditable(false);
        txnhanvien.setBackground(Color.white);
//        cbnhanvien= new JComboBox(nvbll.getTenNhanVien());
//        cbnhanvien.setBackground(Color.white);
//        cbnhanvien.setPreferredSize(new Dimension(100, 30));
//        
//        for(int a=0;a < cbnhanvien.getItemCount();a++){
//            if(cbnhanvien.getItemAt(a).toString().equals(nvbll.getAllInfo(us, pw)[1]+" "+nvbll.getAllInfo(us, pw)[2])){
//                cbnhanvien.setSelectedIndex(a);
//            }
//        }
        
        cbkhachhang= new JComboBox(khbll.getTenKhachHang());
        cbkhachhang.setBackground(Color.white);
        cbkhachhang.setPreferredSize(new Dimension(100, 30));
        cbkhachhang.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        
        cbkhachhang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String choiceKhachHang= cbkhachhang.getSelectedItem().toString().trim();
                txdiachikh.setText(khbll.getDiaChiByName(choiceKhachHang));
                txsdtkhachhang.setText(khbll.getSDTByName(choiceKhachHang));
            }
        });
        
        cblaygia= new JComboBox();
        cblaygia.setPreferredSize(new Dimension(100, 30));
        
        txcreatedate= new JTextField();
        txcreatedate.setText(String.valueOf(java.time.LocalDate.now()));
        txcreatedate.setPreferredSize(new Dimension(100, 30));
        
        txbillid= new JTextField();
        txbillid.setText(hdbll.newHoaDon());
        txbillid.setPreferredSize(new Dimension(100, 30));
        txbillid.setEditable(false);
        txbillid.setBackground(Color.white);
        txbillid.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        
        txtimkh= new JTextField();
        txtimkh.setPreferredSize(new Dimension(100, 30));
        txtimkh.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        
        txdiachikh= new JTextField();
        txdiachikh.setPreferredSize(new Dimension(10, 30));
        txdiachikh.setEditable(false);
        txdiachikh.setBackground(Color.white);
        txdiachikh.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        
        txsdtkhachhang= new JTextField();
        txsdtkhachhang.setPreferredSize(new Dimension(10, 30));
        txsdtkhachhang.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        
        txghichu= new JTextField();
        txghichu.setPreferredSize(new Dimension(10, 30));
        txghichu.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        
//        java.time.LocalDateTime now=  java.time.LocalDateTime.now();
//        datemodel.setDate(now.getYear(), now.getMonthValue()+1, now.getDayOfMonth());
        txsdtkhachhang.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String phone= txsdtkhachhang.getText().trim();
                if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                    txdiachikh.setText("");
                    txtimkh.setText("");
                    setKhachHangComboBox("Kh??ch l???");
                } else {
                    txdiachikh.setText(khbll.getDiaChiByPhone(phone));
                    txtimkh.setText(khbll.getNameByPhone(phone));
                    setKhachHangComboBox(khbll.getNameByPhone(phone));
                }
            }
        });
        
        txtimkh.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String name= txtimkh.getText().trim();
                if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                    txdiachikh.setText("");
                    txsdtkhachhang.setText("");
                    txtimkh.setText("");
                    setKhachHangComboBox("Kh??ch l???");
                } else {
                    txsdtkhachhang.setText(khbll.getSDTByName(name));
                    txdiachikh.setText(khbll.getDiaChiByName(name));
                    setKhachHangComboBox(name);
                }
            }
        });
        
        pncont11.setLayout(new GridLayout(3, 3,50,15));
        pncont11.add(lbcreatedate);
        pncont11.add(dc);
        pncont11.add(lbbillid);
        pncont11.add(txbillid);
        pncont11.add(lbtimkh);
        pncont11.add(txtimkh);
        pncont11.add(lbkhachhang);
        pncont11.add(cbkhachhang);
        pncont11.add(lbsdtkhachhang);
        pncont11.add(txsdtkhachhang);
        pncont11.add(lbdiachikh);
        pncont11.add(txdiachikh);
        pncont11.add(lbnhanvien);
        pncont11.add(txnhanvien);
        pncont11.add(lbghichu);
        pncont11.add(txghichu);
        pncont11.add(lbaddkh1);
        pncont11.add(lbaddkh2);
        
        lbaddkh2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jfaddkh= new JFrame();
                ImageIcon img = new ImageIcon("newperson.png");
                jfaddkh.setResizable(false);
                jfaddkh.setIconImage(img.getImage());
                jfaddkh.setSize(400, 500);
                jfaddkh.setTitle("Th??m kh??ch h??ng m???i");
                jfaddkh.setLayout(new BorderLayout(0, 20));
                JPanel newInfo= new JPanel();
                newInfo.setLayout(new GridLayout(4,1,0,50));
                newInfo.setPreferredSize(new Dimension(0, 250));
                newInfo.setBackground(Color.white);
                newInfo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(null, "Th??m kh??ch h??ng"), BorderFactory.createEmptyBorder(60,20,60,30)));
                String thongtin[]= {"H???","T??n","?????a ch???","??i???n tho???i"};
                JButton them= new JButton("Th??m");
                them.setPreferredSize(new Dimension(0, 50));
                them.setFont(new Font("Serif",Font.BOLD,20));
                JLabel lbthongtin[]= new JLabel[thongtin.length];
                JTextField txthongtin[]= new JTextField[thongtin.length];
                for(int i=0;i<thongtin.length;i++){
                    lbthongtin[i]=new JLabel(thongtin[i]);
                    lbthongtin[i].setHorizontalAlignment(JLabel.LEFT);
                    lbthongtin[i].setFont(new Font("Tahoma", Font.PLAIN,20));
                    txthongtin[i]=new JTextField("");
                    txthongtin[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
                    newInfo.add(lbthongtin[i]);
                    newInfo.add(txthongtin[i]);
                }
                
                them.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if("".equals(txthongtin[0].getText()) || "".equals(txthongtin[1].getText()) || "".equals(txthongtin[2].getText()) || "".equals(txthongtin[3].getText())){
                            JOptionPane.showMessageDialog(null, "H??y nh???p ?????y ????? th??ng tin kh??ch h??ng!","Th??ng b??o",2);
                        } else {
                            khachHangDAO khdao= new khachHangDAO();
                            String newid= khbll.getKhachHangList().get(khbll.getKhachHangList().size()-1).getId();
                            StringBuilder sb= new StringBuilder(newid);
                            khdao.insertToDBKhachHang("KH0"+String.valueOf(Integer.parseInt(sb.delete(0, 2).toString())+1), txthongtin[0].getText(), 
                                                        txthongtin[1].getText(), txthongtin[2].getText(), txthongtin[3].getText());
                        }
                        pncont11.removeAll();
                        billInfo(us, pw);
                        pncont11.validate();
                        pncont11.repaint();
                    }
                });
                
                jfaddkh.add(newInfo,BorderLayout.CENTER);
                jfaddkh.add(them,BorderLayout.SOUTH);
                jfaddkh.getRootPane().setDefaultButton(them);
                jfaddkh.setLocationRelativeTo(null);
                jfaddkh.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                lbaddkh2.setBackground(Color.lightGray);
                lbaddkh2.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                lbaddkh2.setBackground(Color.black);
                lbaddkh2.setForeground(Color.white);
            }
        });
    }
    
    public void setNewPnContent11(){
        pncont11.removeAll();
        pncont11.add(lbcreatedate);
        pncont11.add(dc);
        pncont11.add(lbbillid);
        pncont11.add(txbillid);
        pncont11.add(lbtimkh);
        pncont11.add(txtimkh);
        pncont11.add(lbkhachhang);
        pncont11.add(cbkhachhang);
        pncont11.add(lbsdtkhachhang);
        pncont11.add(txsdtkhachhang);
        pncont11.add(lbdiachikh);
        pncont11.add(txdiachikh);
        pncont11.add(lbnhanvien);
        pncont11.add(cbnhanvien);
        pncont11.add(lbghichu);
        pncont11.add(txghichu);
        pncont11.add(lbaddkh1);
        pncont11.add(lbaddkh2);
        pncont11.repaint();
        pncont11.validate();
    }
    
    public void setKhachHangComboBox(String name){
        for(int i=0;i<cbkhachhang.getItemCount();i++){
            if(cbkhachhang.getItemAt(i).toString().trim().equalsIgnoreCase(name)){
                cbkhachhang.setSelectedIndex(i);
            }
        }
    }
    
    // ki???m tra s???n ph???m ???? t???n t???i trong h??a ????n t???m t??nh hay ch??a
    public void newHoaDon(String id, String tensp, int soluong, double dongia, int thanhtien){
        // n???u h??a ????n ch??a c?? s???n ph???m n??o th?? t???o m???i
        System.out.println(txctsp[5].getText());
        if(spbll.kTSpTonTai(txctsp[0].getText(),txctsp[4].getText(), txctsp[5].getText())==true){
            if(tablehd.getModel().getRowCount()==0){
                pncont12.removeAll();
                pncont12.add(pncont121,BorderLayout.NORTH);
                pncont2.removeAll();
                spbll.selling(id, soluong);
                tablehd.getColumnModel().getColumn(6).setMinWidth(100);
                tablehd.getColumnModel().getColumn(6).setMaxWidth(120);
                addFullTable();
                tablehd.setRowHeight(30);
                Object[]obj ={this.tablehd.getRowCount()+1,id,tensp,soluong,dongia,thanhtien, false};
                hoaDonPanel.modelhd.addRow(obj);
                hoaDonPanel.tablehd.setModel(hoaDonPanel.modelhd);
                scroll.setViewportView(hoaDonPanel.tablehd);
                pncont12.add(scroll,BorderLayout.CENTER);
                pncont2.repaint();
                pncont2.validate();
                pncont12.repaint();
                pncont12.validate();
            } else { // s???n ph???m v???a ch???n c?? trong h??a ????n t???m
                if(kTTonTaiTrongHD(id, soluong)==true){
                    for(int i=0;i<tablehd.getRowCount();i++){
                        if(modelhd.getValueAt(i, 1).equals(id)) {
                            pncont12.removeAll();
                            pncont12.add(pncont121,BorderLayout.NORTH);
                            pncont2.removeAll();
                            spbll.selling(id, soluong);
                            modelhd.setValueAt(Integer.parseInt(modelhd.getValueAt(i,3).toString()) + soluong ,i, 3);
                            modelhd.setValueAt(Integer.parseInt(modelhd.getValueAt(i,3).toString()) * Double.parseDouble(modelhd.getValueAt(i,4).toString()) ,i, 5);
                            addFullTable();
                            tablehd.setModel(modelhd);
                            scroll.setViewportView(hoaDonPanel.tablehd);
                            pncont12.add(scroll,BorderLayout.CENTER);
                            pncont2.repaint();
                            pncont2.validate();
                            pncont12.repaint();
                            pncont12.validate();
                        }
                    }
                } else { // s???n ph???m v???a ch???n kh??ng c?? trong h??a ????n t???m 
                    pncont12.removeAll();
                    pncont12.add(pncont121,BorderLayout.NORTH);
                    pncont2.removeAll();
                    spbll.selling(id, soluong);
                    addFullTable();
                    tablehd.setRowHeight(30);
                    tablehd.getColumnModel().getColumn(6).setMinWidth(100);
                    tablehd.getColumnModel().getColumn(6).setMaxWidth(120);
                    Object[]obj ={hoaDonPanel.tablehd.getRowCount()+1,id,tensp,soluong,dongia,thanhtien, false};
                    hoaDonPanel.modelhd.addRow(obj);
                    hoaDonPanel.tablehd.setModel(hoaDonPanel.modelhd);
                    scroll.setViewportView(hoaDonPanel.tablehd);
                    pncont12.add(scroll,BorderLayout.CENTER);
                    pncont2.repaint();
                    pncont2.validate();
                    pncont12.repaint();
                    pncont12.validate();
                }
            }
        }
    }
    
    
    public boolean kTTonTaiTrongHD(String id, int soluong){
        for(int i=0;i<tablehd.getRowCount();i++){
            if(tablehd.getValueAt(i, 1).toString().equals(id)){
                return true;
            }
        }
        return false;
    }
    
    public void deleteFromBill(JTable tb){
        lbxoa.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for(int a=0;a<spbll.getHeader().length;a++){
                        txctsp[a].setText("");
                }
                int dem=0;
                for(int i=0;i<tb.getRowCount();i++){
                    if(tb.getValueAt(i, 6).equals(true)){
                        dem++;
                    }
                }
                if(dem!=0) {
                    for(int i=0;i<tb.getRowCount();){
                        if(tb.getValueAt(i, 6).equals(true)){
                            pncont12.removeAll();
                            pncont12.add(pncont121,BorderLayout.NORTH);
                            //tb.setValueAt(Integer.parseInt(tb.getValueAt(i, 1).toString())-1,i+1, 0);
                            pncont2.removeAll();
                            tb.setRowHeight(30);
                            spbll.unSelling(tb.getValueAt(i, 1).toString(), Integer.parseInt(tb.getValueAt(i, 3).toString()));
                            addFullTable();
                            ((DefaultTableModel)tb.getModel()).removeRow(i);
                            double Tong=0;
                            txTotal.setText(String.valueOf(Tong));
                            for(int a=0;a<tb.getRowCount();a++){
                                Tong+= Double.parseDouble(String.valueOf(modelhd.getValueAt(a, 5)));
                                txTotal.setText(String.valueOf(Tong));
                                tb.setValueAt(a+1,a, 0);
                                tb.validate();
                            }
                            pncont12.add(scroll,BorderLayout.CENTER);
                            pncont2.repaint();
                            pncont2.validate();
                            tb.repaint();
                            tb.validate();
                            pncont12.repaint();
                            pncont12.validate();
                        } else {
                            i++;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ch???n ??t nh???t 1 s???n ph???m ????? x??a", "Th??ng b??o", 2);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                lbxoa.setBackground(Color.red);
                lbxoa.setForeground(Color.white);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                lbxoa.setBackground(new Color(240,0,0));
                lbxoa.setForeground(new Color(254, 246, 255));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbxoa.setBackground(Color.red);
                lbxoa.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbxoa.setBackground(new Color(240,0,0));
                lbxoa.setForeground(new Color(254, 246, 255));
            }
        });
    }
    
    public static void main(String[] args) {
        
    }
}
