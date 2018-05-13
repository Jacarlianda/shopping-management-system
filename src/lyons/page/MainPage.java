package lyons.page;

import java.util.ArrayList;

import lyons.dao.GoodsDao;
import lyons.dao.GsalesDao;
import lyons.dao.SalesManDao;
import lyons.entity.Goods;
import lyons.entity.Gsales;
import lyons.entity.SalesMan;
import lyons.tools.Arith;
import lyons.tools.QueryPrint;
import lyons.tools.ScannerChoice;

/**
 * �̳��������ϵͳ������
 *
 * @author ����
 * @version 1.0
 */

public final class MainPage extends ScannerChoice {

    /**
     * ��ں���
     */
    public static void main(String[] args) {
        MainPage.mianPage();
    }

    /**
     * ������ ��ʵ�֣���У�飡
     */
    public static void mianPage() {
        System.out.println("***************************\n");
        System.out.println("\t 1.��Ʒά��\n");
        System.out.println("\t 2.ǰ̨����\n");
        System.out.println("\t 3.��Ʒ����\n");
        System.out.println("***************************");

        System.out.println("\n������ѡ��,���߰�0�˳�.");
        do {
            String choice = ScannerInfoString();
            String regex = "[0-3]";//������ʽ
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        System.out.println("------------------");
                        System.out.println("���Ѿ��˳�ϵͳ!");
                        System.exit(1);//�˳����򣬷���ֵ�������
                        break;
                    case 1:
                        MaintenancePage();
                        break;
                    case 2:
                        checkstandLogPage();
                        break;
                    case 3:
                        commodityManagementPage();
                        break;
                    default:
                        break;
                }
            }
            System.err.println("!��������!");
            System.out.println("����ѡ����߰�0�˳�.");
        } while (true);

    }

    /**
     * 1.��Ʒά������
     */
    public static void MaintenancePage() {

        System.out.println("***************************\n");
        System.out.println("\t 1.�����Ʒ\n");
        System.out.println("\t 2.������Ʒ\n");
        System.out.println("\t 3.ɾ����Ʒ\n");
        System.out.println("\t 4.��ѯ��Ʒ\n");
        System.out.println("\t 5.��ʾ������Ʒ\n");
        System.out.println("***************************");

        System.out.println("\n������ѡ��,���߰� 0 ������һ���˵�.");
        do {
            String choice = ScannerInfoString();
            String regex = "[0-5]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        mianPage();
                        break;
                    case 1:
                        GoodsPage.addGoodsPage();
                        break;
                    case 2:
                        GoodsPage.upateGoodsPage();
                        break;
                    case 3:
                        GoodsPage.deleteGoodsPage();
                        break;
                    case 4:
                        GoodsPage.queryGoodsPage();
                        break;
                    case 5:
                        GoodsPage.displayGoodsPage();
                        break;
                    default:
                        break;
                }
            }
            System.err.println("!��������!");
            System.out.println("��������� 0 ������һ���˵�.");
        } while (true);
    }

    /**
     * 2.ǰ̨������½����
     */
    public static void checkstandLogPage() {
        System.out.println("\n*******��ӭʹ���̳��������ϵͳ*******\n");
        System.out.println("\t 1.��¼ϵͳ\n");
        System.out.println("\t 2.�˳�\n");
        System.out.println("-----------------------------");
        System.out.println("������ѡ��,���߰� 0 ������һ���˵�.");

        do {
            String choice = ScannerInfoString();
            String regex = "[0-2]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        mianPage();
                        break;
                    case 1:
                        int loginTimes = 3;//3�ε�½����

                        while (loginTimes != 0) {
                            loginTimes--;
                            System.out.println("---�û���---");
                            String sName = ScannerInfoString();
                            System.out.println("---����---");
                            String sPssWord = ScannerInfoString();

                            ArrayList<SalesMan> salesManInfo = new SalesManDao().checkstandLog(sName); //���û��������ݿ��л�ȡ�û�����.

                            if (salesManInfo == null || salesManInfo.size() == 0)//û�д��û��������
                            {
                                System.err.println("\t!!�û�����������!!\n");
                                System.out.println("\nʣ���½������" + loginTimes);
                            } else {
                                SalesMan salesMan = salesManInfo.get(0);//�˵أ�ֻ������һ����ֵ��ֻ����1�μ���

                                if (sPssWord.equals(salesMan.getSPassWord()))//��֤���룬��½�ɹ��ˣ���
                                {
                                    System.out.println("\t  ---�˻��ɹ���½---");
                                    shoppingSettlementPage(salesMan.getSId());//����ΪӪҵԱ���sId
                                } else {
                                    System.err.println("\t!!�������!!\n");
                                    System.out.println("\nʣ���½������" + loginTimes);
                                }
                            }
                        }
                        //loginTimes = 0
                        System.out.println("------------------");
                        System.err.println("\t�������ѱ�ǿ���˳�ϵͳ����");
                        System.exit(1);
                        break;
                    case 2:
                        System.out.println("------------------");
                        System.out.println("���Ѿ��˳�ϵͳ!");
                        System.exit(-1);
                        break;
                    default:
                        break;
                }
            }
            System.err.println("!��������!");
            System.out.println("��������� 0 ������һ���˵�");
        } while (true);
    }

    /**
     * 3.��Ʒ�������
     */
    public static void commodityManagementPage() {
        System.out.println("***************************\n");
        System.out.println("\t 1.�ۻ�Ա����\n");
        System.out.println("\t 2.�г����������б�\n");
        System.out.println("***************************");

        System.out.println("\n������ѡ��,���߰� 0 ������һ���˵�.");
        do {
            String choice = ScannerInfoString();
            String regex = "[0-2]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        mianPage();
                        break;
                    case 1:
                        salesManManagementPage();
                        break;
                    case 2:
                        GsalesPage.dailySaleGoodsPage();
                        break;
                    default:
                        break;
                }
            }
            System.err.println("!��������!");
            System.out.println("��������� 0 ������һ���˵�.");
        } while (true);
    }

    /**
     * ����������
     */
    public static void shoppingSettlementPage(int salesManSid) {
        System.out.println("\n\t*******�������*******\n");
        do {
            System.out.println("�� S ��ʼ�������.�� 0 �����˻���¼����");
            String choNext = ScannerInfoString();
            if ("0".equals(choNext)) {
                checkstandLogPage();

            } else if ("s".equals(choNext) || "S".equals(choNext)) {
                System.out.println("\n--��������Ʒ�ؼ���--");

                int gid = QueryPrint.querySettlement();//����Ʒ��������ֻ��һ��ʱ������Ʒgid�ţ���Ʒ���ۿ�ʱ���� -1. >1��ʱ����-2 . ���޴���Ʒʱ����-3

                switch (gid) {
                    case -3:
                        //�޴���Ʒ,����ѭ��
                        break;
                    case -1:
                        System.err.println("\t--��Ǹ������Ʒ���ۿ�--");
                        break;

                    default:
                        System.out.println("--����Ʒ���ѡ����Ʒ--");

                        //����gid�����þ�ȷ��ѯ��Ʒ
                        int shoppingGid = ScannerNum();

                        ArrayList<Goods> goodsList = new QueryPrint().queryGoodsKey(shoppingGid, null);
                        if (goodsList == null || goodsList.size() == 0) {
                            System.err.println("\t�������޴���Ʒ ����\n");
                        } else {
                            Goods goods = goodsList.get(0);
                            int gNum = goods.getGnum();
                            double gPrice = goods.getGprice();

                            System.out.println("--�����빺������--");
                            do {
                                int choicegoodsNum = ScannerNum();//��ȡ�û�Ҫ���������

                                if (choicegoodsNum > gNum) {
                                    System.err.println("\t�����ֿⴢ�����㣡��");
                                    System.out.println("--���������빺������--");
                                } else {
                                    double allPrice = Arith.mul(choicegoodsNum, gPrice);//����BigDecimal���˷�����
                                    System.out.println("\t\t\t  ���ﳵ����\n");
                                    System.out.println("\t\t��Ʒ����\t��Ʒ����\t��������\t�ܼ�\n");
                                    System.out.println("\t\t" + goods.getGname() + "\t" + gPrice + " $\t" + choicegoodsNum + "\t" + allPrice + " $\n");

                                    do {
                                        System.out.println("ȷ�Ϲ���Y/N");
                                        String choShopping = ScannerInfoString();
                                        if ("y".equals(choShopping) || "Y".equals(choShopping)) {
                                            System.out.println("\n�ܼۣ�" + allPrice + " $");
                                            System.out.println("\nʵ�ʽɷѽ��");

                                            do {
                                                double amount = ScannerInfo();
                                                double balance = Arith.sub(amount, allPrice);  //�û���Ǯ�빺����Ʒ�ܼۼ�Ĳ��
                                                if (balance < 0) {
                                                    System.err.println("\t�������ɽ��㣡��");
                                                    System.out.println("\n������������ɽ��($)");
                                                } else {
																	
		/*	�����ǹ������������ݿ⣡����������----------------------	  1.����goods������ 
		  														  2.����sales������
																ԭ��Ʒ����gNum�� ����ԱId  salesManSid */

                                                    //��sales�����
                                                    Gsales gSales = new Gsales(goods.getGid(), salesManSid, choicegoodsNum);
                                                    boolean insert = new GsalesDao().shoppingSettlement(gSales);

                                                    //��goods�����
                                                    int goodsNewNum = gNum - choicegoodsNum; //����goods���и���Ʒ����
                                                    Goods newGoods = new Goods(goods.getGid(), goodsNewNum);
                                                    boolean update = new GoodsDao().updateGoods(3, newGoods);

                                                    if (update && insert) {
                                                        System.out.println("���㣺" + balance);
                                                        System.out.println("\nлл���٣���ӭ�´λݹ�");
                                                    } else {
                                                        System.err.println("��֧��ʧ�ܣ�"); //�����������һ�������ݿ���������⣡
                                                    }
                                                    shoppingSettlementPage(salesManSid);//�����ת�����������ҳ��
                                                    //	�����������������ݿ⣡����������-----------------------------------
                                                }
                                            } while (true);

                                        } else if ("N".equals(choShopping) || "n".equals(choShopping)) {
                                            shoppingSettlementPage(salesManSid);
                                        }
                                        System.err.println("\t������ȷ�Ϲ������򣡣�");
                                    } while (true);
                                }
                            } while (true);
                        }
                        break;
                }
            } else {
                System.err.println("\t!!������Ϸ��ַ�!!\n");
            }
        } while (true);
    }

    /**
     * �ۻ�Ա�������
     */
    public static void salesManManagementPage() {

        System.out.println("***************************\n");
        System.out.println("\t 1.����ۻ�Ա\n");
        System.out.println("\t 2.�����ۻ�Ա\n");
        System.out.println("\t 3.ɾ���ۻ�Ա\n");
        System.out.println("\t 4.��ѯ�ۻ�Ա\n");
        System.out.println("\t 5.��ʾ�����ۻ�Ա\n");
        System.out.println("***************************");

        System.out.println("\n������ѡ��,���߰� 0 ������һ���˵�.");
        do {
            String choice = ScannerInfoString();
            String regex = "[0-5]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        commodityManagementPage();
                        break;
                    case 1:
                        SalesManPage.addSalesManPage();
                        break;
                    case 2:
                        SalesManPage.updateSalesManPage();
                        break;
                    case 3:
                        SalesManPage.deleteSalesManPage();
                        break;
                    case 4:
                        SalesManPage.querySalesManPage();
                        break;
                    case 5:
                        SalesManPage.displaySalesManPage();
                        break;
                    default:
                        break;
                }
            }
            System.err.println("\t!��������!");
            System.out.println("��������� 0 ������һ���˵�.");
        } while (true);
    }
}