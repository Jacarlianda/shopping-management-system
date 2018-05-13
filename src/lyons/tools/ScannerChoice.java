package lyons.tools;

import java.util.Scanner;

import lyons.page.GoodsPage;
import lyons.page.MainPage;
import lyons.page.SalesManPage;

/**
 * 1.���N��ɲ������ ѡ����һ��
 * 2.����ѡ�����
 *
 * @author lyons(zhanglei)
 */

public class ScannerChoice {
    /**
     * @return double ���̻�ȡ��Ʒ�۸�,С�������λ
     */
    public static double ScannerInfo() {
        double num = 0.00;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("����С�������λ,�����룺");
            String info = sc.next();

            String regex = "(([1-9][0-9]*)\\.([0-9]{2}))|[0]\\.([0-9]{2})";//����С�����2λС��
            if (info.matches(regex)) {
                num = Double.parseDouble(info);
            } else {
                System.err.println("����������");
                continue;
            }
            break;
        } while (true);

        return num;
    }

    /**
     * @return int ���̻�ȡ��Ʒ����
     */
    public static int ScannerNum() {
        int num = 0;
        String regex = "([1-9])|([1-9][0-9]+)";//��Ʒ����
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("�����룺");
            String nums = sc.next();

            if (nums.matches(regex)) {
                num = Integer.parseInt(nums);
            } else {
                System.err.println("����������");
                continue;
            }
            break;
        } while (true);
        return num;
    }

    /**
     * @return String ��ȡ�ļ�������
     */
    public static String ScannerInfoString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("�����룺");
        return scanner.next();
    }

    /**
     * ��ȡ�û�-��������Ʒ-��һ��
     * ��ȡ�û�-ɾ������Ʒ-��һ��
     * ��ȡ�û�-�������Ʒ-��һ��
     *
     * @param ������
     */
    public static void changedInfoNext(String oper) {
        do {
            System.out.println("�Ƿ��������-��ǰ����:(Y/N)");
            String choice = ScannerChoice.ScannerInfoString();

            //��JAVA��: Equals�Ƚϵ���ֵ,==�Ƚϵ��ǵ�ַ
            if ("y".equals(choice) || "Y".equals(choice)) {
                //�����Ƕ��if-else �����û�ѡ�����������ǰ��������ת��ָ��ҳ�档����Ϊ��ͬ�������ã���ת��ָ��������ͬ��
                if ("upateGoodsPage".equals(oper)) {
                    GoodsPage.upateGoodsPage();
                } else if ("deleteGoodsPage".equals(oper)) {
                    GoodsPage.deleteGoodsPage();
                } else if ("addGoodsPage".equals(oper)) {
                    GoodsPage.addGoodsPage();
                }
                //�����Ƕ�׽���
            } else if ("N".equals(choice) || "n".equals(choice)) {
                MainPage.MaintenancePage();
            }
            System.out.println("\n������������������.");
        } while (true);
    }

    /**
     * ��ȡ�û�-����-���ۻ�Ա-��һ��
     * ��ȡ�û�-���-���ۻ�Ա-��һ��
     * ��ȡ�û�-��ѯ-���ۻ�Ա-��һ��
     * ��ȡ�û�-ɾ��-���ۻ�Ա-��һ��
     *
     * @param ������
     */
    public static void choiceSalesManNext(String oper) {
        do {
            System.out.println("�Ƿ��������-��ǰ����:(Y/N)");
            String choice = ScannerChoice.ScannerInfoString();

            if ("y".equals(choice) || "Y".equals(choice)) {
                //�����Ƕ��if-else �����û�ѡ�����������ǰ��������ת��ָ��ҳ�档����Ϊ��ͬ�������ã���ת��ָ��������ͬ��
                if ("updateSalesMan".equals(oper)) {
                    SalesManPage.updateSalesManPage();
                } else if ("deleteSalesMan".equals(oper)) {
                    SalesManPage.deleteSalesManPage();
                } else if ("addSalesMan".equals(oper)) {
                    SalesManPage.addSalesManPage();
                } else if ("querySalesMan".equals(oper)) {
                    SalesManPage.querySalesManPage();
                }
                //�����Ƕ�׽���
            } else if ("N".equals(choice) || "n".equals(choice)) {
                MainPage.salesManManagementPage();
            }
            System.err.println("\t��������");
        } while (true);
    }

}
