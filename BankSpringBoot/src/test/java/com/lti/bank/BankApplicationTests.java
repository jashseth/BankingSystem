package com.lti.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.util.Optional;

import javax.validation.constraints.Email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.bank.exception.RecordNotFoundException;
import com.lti.bank.model.Account;
import com.lti.bank.model.Beneficiary;
import com.lti.bank.model.Customer;
import com.lti.bank.model.Transactions;
import com.lti.bank.model.User;
import com.lti.bank.repo.AccountRepository;
import com.lti.bank.repo.BeneficiaryRepository;
import com.lti.bank.repo.CustomerRepository;
import com.lti.bank.repo.TransactionRepository;
import com.lti.bank.repo.UserRepository;
import com.lti.bank.service.AccountService;
import com.lti.bank.service.BeneficiaryService;
import com.lti.bank.service.CustomerService;
import com.lti.bank.service.TransactionService;
import com.lti.bank.service.UserService;

@SpringBootTest
class BankApplicationTests {
	@Autowired
	CustomerService cs;
	@Autowired
	CustomerRepository crepo;
	@Autowired
	BeneficiaryRepository br;
	@Autowired
	TransactionRepository tr;
	@Autowired
	BeneficiaryService bs;
	@Autowired
	AccountRepository ar;
	@Autowired
	AccountService as;
	@Autowired
	TransactionService ts;
	@Autowired
	UserService us;
	@Autowired
	UserRepository ur;

	@Test
	void contextLoads() {
	}

	@Test
	public void transactionTest() {
		Account ac1=new Account((long)1000,5000.0,1,null);
		Account ac2=new Account((long)1001,6000.0,1,null);
		ac1=ar.save(ac1);
		ac2=ar.save(ac2);
		Beneficiary b=new Beneficiary((long)151, "ABC", (long)1001, "A",ac1);
		b=br.save(b);
		Transactions t=new Transactions((long) 11, "IMPS","Received", new Date(2022,8,8),
				1000.0, ac1, b);
//		ts.createTransaction(t);
//		assertEquals(4000.0, ar.getBalanceByAccountId(ac1.getAccountId()));
		
		Transactions t1=tr.save(t);
		assertNotNull(tr.getReferenceById(t.getTransactionId()));
	}
	
	@Test
	public void transactionByIdTest() {
		Account ac1=new Account((long)1002,5000.0,1,null);
		Account ac2=new Account((long)1003,6000.0,1,null);
		ac1=ar.save(ac1);
		ac2=ar.save(ac2);
		Beneficiary b=new Beneficiary((long)152, "ABC", (long)1003, "A",ac1);
		b=br.save(b);
		Transactions t=new Transactions((long) 11, "IMPS","Received", new Date(2022,8,8),
				1000.0, ac1, b);
//		ts.createTransaction(t);
//		assertEquals(4000.0, ar.getBalanceByAccountId(ac1.getAccountId()));
		
		Transactions t1=tr.save(t);
		try {
			assertInstanceOf(Transactions.class, ts.getTransactionsById(t1.getTransactionId()));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void createCustomerTest(){
		Customer c=new Customer(100, "Mr", "jashs@gmail.com",
				"ABC", "DEF", "GHI", "DEF", 123456789123l,
				"ORVPS7420I", "Mumbai", "Pune", 1234567890l,
				"Service", "SALARY", 30000, 1, 1,new Date(2000,3,3)
				, "Male", 0);
		cs.createCustomer(c);
		assertNotNull(crepo.findById((long) 100).get());
	}
	
	@Test
	public void CustomerIDTest(){
		Customer c=new Customer(100, "Mr", "jashs@gmail.com",
				"ABC", "DEF", "GHI", "DEF", 123456789123l,
				"ORVPS7420I", "Mumbai", "Pune", 1234567890l,
				"Service", "SALARY", 30000, 1, 1,new Date(2000,3,3)
				, "Male", 0);
		cs.createCustomer(c);
		assertEquals(c.getCustomerId(),crepo.findById((long) 100).get().getCustomerId());
	}
	
	@Test
	public void beneficiaryTest() {
		Account ac1=new Account((long)1000,5000.0,1,null);
		Account ac2=new Account((long)1001,6000.0,1,null);
		ac1=ar.save(ac1);
		ac2=ar.save(ac2);
		Beneficiary b=new Beneficiary((long)151, "ABC", (long)1001, "A",ac1);
		bs.createBeneficiary(b);
		Beneficiary b1=br.getById(b.getBeneficiaryId());
		assertEquals(b.getBeneficiaryId(), b1.getBeneficiaryId());
	
	}
	
	@Test
	public void CustomerAadharTest(){
		Customer c=new Customer(102, "Ms", "chhhaya@gmail.com",
				"ABC", "DEF", "GHI", "DEF", 12046789123l,
				"ORVPS7420P", "Mumbai", "Pune", 134567860l,
				"Service", "SALARY", 30000, 1, 1,new Date(2000,2,3)
				, "Female", 0);
		c=crepo.save(c);
		assertInstanceOf(Customer.class,crepo.findByAadharNumber((long)c.getAadharNumber()));
	}
	
	@Test
	public void CustomerPanTest(){
		Customer c=new Customer(103, "Ms", "chhaya@gmail.com",
				"ABC", "DEF", "GHI", "DEF", 12341789123l,
				"ORVPS7420Q", "Mumbai", "Pune", 134577890l,
				"Service", "SALARY", 30000, 1, 1,new Date(2000,2,3)
				, "Female", 0);
		c=crepo.save(c);
		assertInstanceOf(Customer.class,crepo.findByPancardNumber(c.getPancardNumber()));
	}
	
	@Test
	public void CustomerEmailTest(){
		Customer c=new Customer(104, "Ms", "chaya@gmail.com",
				"ABC", "DEF", "GHI", "DEF", 11341789123l,
				"ORVPS7420U", "Mumbai", "Pune", 114577890l,
				"Service", "SALARY", 30000, 1, 1,new Date(2000,2,3)
				, "Female", 0);
		c=crepo.save(c);
		assertInstanceOf(Customer.class,crepo.findByEmailId(c.getEmailId()));
	}
	
	@Test
	public void CustomerMobileTest(){
		Customer c=new Customer(105, "Ms", "chhayaa@gmail.com",
				"ABC", "DEF", "GHI", "DEF", 12341780123l,
				"PRVPS7420Q", "Mumbai", "Pune", 134517890l,
				"Service", "SALARY", 30000, 1, 1,new Date(2000,2,3)
				, "Female", 0);
		c=crepo.save(c);
		assertInstanceOf(Customer.class,crepo.findByMobileNumber(c.getMobileNumber()));
	}
	
	@Test
	public void getAccStatus() {
		Account ac1=new Account((long)1000,5000.0,1,null);
		ac1=ar.save(ac1);
		
		assertEquals(1, as.getStatusById(ac1.getAccountId()));
		
	}
	
	@Test
	public void testDeleteCustomer() {
		Customer c=new Customer(101, "Ms", "chhaya@gmail.com",
				"ABC", "DEF", "GHI", "DEF", 12346789123l,
				"ORVPS7420I", "Mumbai", "Pune", 134567890l,
				"Service", "SALARY", 30000, 1, 1,new Date(2000,2,3)
				, "Female", 0);
		c=crepo.save(c);
		c=cs.deleteCustomer(c.getCustomerId());
		assertFalse(crepo.getById(c.getCustomerId())==null);
	}
	
//	@Test
//	public void loginTest() {
//		User u=new User();
//		u.setUserid((long)1);
//		u.setAccountNumber((long)1000);
//		u.setPassword("123456");
//		u.setTransactionPassword("123456");
//		us.addUser(u);
//	}
	
//	@Test void approvalTest() {
//		Optional<Customer> co=Optional.ofNullable(crepo.getById((long) 100));
//		Customer c;
//		if(co.isEmpty())
//		{
//			 c=new Customer(100, "Mr", "jashs@gmail.com",
//					"ABC", "DEF", "GHI", "DEF", 123456789123l,
//					"ORVPS7420I", "Mumbai", "Pune", 1234567890l,
//					"Service", "SALARY", 30000, 1, 1,new Date(2000,3,3)
//					, "Male", 0);
//			 crepo.save(c);
//		}
//		else {
//			c=co.get();
//		}
//			cs.approveCustomer(c.getCustomerId(), c);
//			assertEquals(1, crepo.findById(c.getCustomerId()).get().getStatus());
//		
//	}
}
