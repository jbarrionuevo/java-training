package edu.globant.finalproject.dao;

import edu.globant.finalproject.model.Sale.ReceiptDTO;

public interface SellerDAO {
	void sell(ReceiptDTO receipt);
}
