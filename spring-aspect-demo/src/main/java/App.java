import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mj.springdemo.config.RootConfig;
import com.mj.springdemo.dao.AccountDao;
import com.mj.springdemo.dao.MembershipDao;
import com.mj.springdemo.entity.Account;

public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
        MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);
        
        accountDao.addAccount();
        accountDao.addAccount(new Account("test", "123"));
        accountDao.addAccount(new Account("test", "123"), true);
        membershipDao.addAccount();
        membershipDao.addSillyMember();
        
        context.close();
    }
}
