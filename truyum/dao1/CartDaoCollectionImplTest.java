package com.cognizant.truyum.dao1;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	private CartDao cartDao;

	@Before
	public void setup() {
		cartDao = new CartDaoCollectionImpl();
	}

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testAddCartItem() throws CartEmptyException {

		cartDao.addCartItem(1, 3);
		List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
		assertEquals(menuItemList, cartDao.getAllCartItems(1));
	}

	@Test
	public void testGetAllCartItems() throws CartEmptyException {
		List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
		assertEquals(menuItemList, cartDao.getAllCartItems(1));
	}

	@Test
	public void testRemoveCartItem() {
		cartDao.removeCartItem(1, 3);
		try {
			assertEquals("", cartDao.getAllCartItems(1));
		} catch (CartEmptyException e) {
			System.out.println("Cart is Empty");
		}
	}
}