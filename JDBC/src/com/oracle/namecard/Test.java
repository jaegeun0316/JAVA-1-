package com.oracle.namecard;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
        NamecardDao dao = new NamecardDao();
        //1.insert(Namecard) test: �Է��ϱ�
        //Namecard hong = new Namecard("ȫ�浿","010-1234-1234", "hk@naver.com", "�λ�IT");
        //dao.insert(hong); //������ sql developer Ȯ��
        //no�����ϱ�
        //dao.delete(3);
        //no ���� �����͸� Namecard Ŭ������ �Է��Ͽ� ����
        //Namecard card1 = dao.selectOne(1);
        //System.out.println(card1.toString());
        
        
        
        
   
        //2.selectAll() test: �� �����ͼ� ����Ʈ�� �Է����� �ֿܼ� ���
        //ArrayList<Namecard> list = dao.selectAll();
        //int size = list.size();
        //System.out.println(size);
        //for (int i = 0; i < size; i++) {
          //  Namecard card = list.get(i);
            //System.out.println(card);
        //}


   
        //3.selectByKeyword(String) test: �̸����� ã��
        //ArrayList<Namecard> matched = dao.selectByKeyword("ȫ�浿");
        //int length = matched.size();
        //System.out.println(length + "�� ã��.");
        //for (int i = 0; i < length; i++) {
        //    Namecard namecard = matched.get(i);
        //    System.out.println(namecard);
        //}


        
  
        //4.selectOne(int) test : ��ȣ�� ã��
        //Namecard card = dao.selectOne(5);
        //System.out.println("5�� ã��");
        //System.out.println(card);


 
        //5.delete(int) test : ��ȣ�� �����ϱ�
       // dao.delete(4);
        //ArrayList<Namecard> all = dao.selectAll();
        //int cardNum = all.size();
        //for (int i = 0; i < cardNum; i++) {
        //    Namecard namecard = all.get(i);
        //    System.out.println(namecard);
        //}
 
     
      
        //6. update(Namecard) test :  card�� no��ȣ�� ���� NAMECARD ����  �̸�, ��ȭ��ȣ, �̸���, ȸ�� ������Ʈ(�����ϱ�)
        Namecard card = dao.selectOne(5); //DB���� 5��° ���� ������
        System.out.println(card);
        card.setEmail("lalala@daum.net");
        card.setMobile("010-9999-9999");
        dao.update(card);
        System.out.println(card);
        
       // Namecard card1 = dao.selectOne(5); //DB���� 5��° ���� ������
       // System.out.println(card1);

    }
}
