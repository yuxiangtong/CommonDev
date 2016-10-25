package yutong.office.excel;

import java.io.IOException;
import org.apache.log4j.Logger;
import com.jxcell.CellException;
import com.jxcell.View;


public class EncryptExcelUtil {
    private static Logger logger = Logger.getLogger(EncryptExcelUtil.class);

    /**
     * 读取excel，并进行加密
     *
     * @param url
     *            excel文件路径 例：D:\\word.xls
     * @param pwd
     *            加密密码
     */
    public static void encrypt(String url, String pwd) {
        View m_view = new View();
        try {
            // 读取Excel文档
            m_view.read(url);
            // 设置文档打开密码
            m_view.write(url, pwd);
        } catch (CellException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * excel 解密
     *
     * @return void
     * @author lifq
     * @date 2015-3-13 下午02:15:49
     */
    public static void decrypt(String url, String pwd) {
        View m_view = new View();
        try {
            // read the encrypted excel file
            m_view.read(url, pwd);

            // write without password protected
            m_view.write(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        // 下面1与2 两个方法请分开执行，可以看到效果
        //
        //1. 把g:\\test.xls 添加打开密码123
//        EncryptExcelUtil.encrypt("f:\\test.xls", "123");
        //2. 把g:\\test.xls 密码123 去除
        EncryptExcelUtil.decrypt("C:\\Users\\tech-winning\\Desktop\\test\\test2.xlsx", "123456");

    }
    
}
