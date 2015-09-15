package com.shma.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shma.tx.dao.IBook;
import com.shma.tx.dao.IBookStock;
import com.shma.tx.dao.IUserAccount;
import com.shma.tx.exception.BookStockException;
import com.shma.tx.exception.UserAccountException;

@Service("bookService")
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBook book;
	
	@Autowired
	private IUserAccount userAccount;
	
	@Autowired
	private IBookStock bookStock;
	
	//�������ע��
	//1.ʹ�� propagation ָ������Ĵ�����Ϊ, ����ǰ�����񷽷�������һ�����񷽷�����ʱ
	//���ʹ������, Ĭ��ȡֵΪ REQUIRED, ��ʹ�õ��÷���������
	//REQUIRES_NEW: �����Լ�������, ���õ����񷽷������񱻹���. 
	//2.ʹ�� isolation ָ������ĸ��뼶��, ��õ�ȡֵΪ READ_COMMITTED
	//3.Ĭ������� Spring ������ʽ��������е�����ʱ�쳣���лع�. Ҳ����ͨ����Ӧ��
	//���Խ�������. ͨ�������ȥĬ��ֵ����. 
	//4.ʹ�� readOnly ָ�������Ƿ�Ϊֻ��. ��ʾ�������ֻ��ȡ���ݵ�����������, 
	//�������԰������ݿ������Ż�����. �������һ��ֻ��ȡ���ݿ�ֵ�ķ���, Ӧ���� readOnly=true
	//5.ʹ�� timeout ָ��ǿ�ƻع�֮ǰ�������ռ�õ�ʱ��.  
	@Transactional(propagation=Propagation.REQUIRES_NEW,
			isolation=Isolation.READ_COMMITTED,
			timeout=3,
			readOnly=false,
			noRollbackFor={UserAccountException.class})
	@Override
	public void purchase(int userId, int isbn) {
		
		int bookPrice = book.getBookPriceByisbn(isbn);
		
		int account = userAccount.getAccount(userId);
		
		int stock = bookStock.getBookStockByIsbn(isbn);
		
		if(stock <= 0) {
			throw new BookStockException("��治��");
		}
		
		bookStock.updateBookStock(isbn);
		
		if(account < bookPrice) {
			throw new UserAccountException("����");
		}
		
		userAccount.updateAccount(userId, bookPrice);
	}

}
