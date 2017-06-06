package cs544.exercise16_1.bank.dao;

import java.util.*;

import org.hibernate.SessionFactory;

import cs544.exercise16_1.bank.HibernateUtil;
import cs544.exercise16_1.bank.domain.Account;

public class AccountDAO implements IAccountDAO {
	private SessionFactory sf = HibernateUtil.getSessionFactory();
	
	public void saveAccount(Account account) {
		sf.getCurrentSession().save(account.getCustomer());
		sf.getCurrentSession().save(account);
	}

	public void updateAccount(Account account) {
		sf.getCurrentSession().merge(account);
	}

	public Account loadAccount(long accountnumber) {
		return sf.getCurrentSession().get(Account.class, accountnumber);
	}

	public Collection<Account> getAccounts() {
		return sf.getCurrentSession().createQuery("From Account",Account.class).list();
	}
}
