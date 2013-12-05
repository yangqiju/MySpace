package com.joyveb.gens.core.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.joyveb.gens.core.dao.ContactDAO;
import com.joyveb.gens.core.domain.CoreLotoValiabl;

/**
 * Test Case
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class TestiBatis {
	
	private static ContactDAO contactDAO;

	@BeforeClass
	public static  void runBeforeClass() {
		contactDAO = new ContactDAO();
	}

	@AfterClass
	public static void runAfterClass() {
		contactDAO = null;
	}

	/**
	 * Test method for {@link com.loiane.dao.ContactDAO#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		List<CoreLotoValiabl> list = contactDAO.selectAll();
		assertNotNull(list);
		assertEquals(12, list.size());
	}

	/**
	 * Test method for {@link com.loiane.dao.ContactDAO#selectById(int)}.
	 */
//	@Test
	public void testSelectById() {
		
//		CoreLotoValiabl actual = new CoreLotoValiabl(2, "CoreLotoValiabl1", "(000) 000-0000", "CoreLotoValiabl1@loianetest.com");
//		
//		CoreLotoValiabl expected = contactDAO.selectById(2);
//		
//		assertNotNull(expected);
//		assertEquals(actual, expected);
//		assertNotSame(actual, expected);
	}

	/**
	 * Test method for {@link com.loiane.dao.ContactDAO#update(com.loiane.model.Contact)}.
	 */
//	@Test
	public void testUpdate() {

//		CoreLotoValiabl actual = new CoreLotoValiabl(3, "Contact2Updated", "(000) 111-1111", "contact1updated@loianetest.com");
//		
//		CoreLotoValiabl expected = contactDAO.selectById(3);
//		expected.setEmail("contact1updated@loianetest.com");
//		expected.setName("Contact2Updated");
//		expected.setPhone("(000) 111-1111");
//		contactDAO.update(expected);
//		expected = contactDAO.selectById(3);
//	
//		assertNotNull(expected);
//		assertEquals(actual, expected);
//		assertNotSame(actual, expected);
	}

	/**
	 * Test method for {@link com.loiane.dao.ContactDAO#insert(com.loiane.model.Contact)}.
	 */
//	@Test
	public void testInsert() {
		
		CoreLotoValiabl actual = new CoreLotoValiabl();
//		actual.setName("Loiane");
//		actual.setPhone("(000) 111-1111");
//		actual.setEmail("loianeg@gmail.com");
		contactDAO.insert(actual);
		
//		assertEquals(21, actual.getId());
		
//		CoreLotoValiabl expected = contactDAO.selectById(actual.getId()); //id = 21
		
//		assertEquals(actual, expected);
//		assertNotSame(actual, expected);
		
	}

	/**
	 * Test method for {@link com.loiane.dao.ContactDAO#delete(int)}.
	 */
//	@Test
	public void testDelete() {
		
		contactDAO.delete(21);
		
		CoreLotoValiabl expected = contactDAO.selectById(21);
		
		assertNull(expected);
	}

}
