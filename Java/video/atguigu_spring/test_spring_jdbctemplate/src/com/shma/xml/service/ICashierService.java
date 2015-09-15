package com.shma.xml.service;

import java.util.List;

public interface ICashierService {

	public void checkOut(int userId, List<Integer> isbns);
}
