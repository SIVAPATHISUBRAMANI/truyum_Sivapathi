package com.cognizant.truyum.dao1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	private MenuItemDao menuItemDao;

	@Before
	public void setup() {
		menuItemDao = new MenuItemDaoCollectionImpl();
	}

	@Test
	public void testGetMenuItemListAdmin() {
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		assertEquals(menuItemList, menuItemDao.getMenuItemListAdmin());
	}

	@Test
	public void testGetMenuItemListCustomer() {

		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		assertEquals(menuItemList, menuItemDao.getMenuItemListCustomer());
	}

	@Test
	public void testModifyMenuItem() {
		MenuItem menuitem = new MenuItem(1, "RavaDosa", 30.00f, true, DateUtil.convertToDate("22/07/2015"),
				"Main Course", true);

		menuItemDao.modifyMenuItem(menuitem);
		assertEquals(menuitem, menuItemDao.getMenuItem(1));
	}

	@Test
	public void testGetMenuItem() {
		MenuItem menuItem = menuItemDao.getMenuItem(1);
		assertEquals(menuItem, menuItemDao.getMenuItem(1));
	}

}