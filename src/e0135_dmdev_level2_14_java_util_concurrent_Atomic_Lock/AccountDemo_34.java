package e0135_dmdev_level2_14_java_util_concurrent_Atomic_Lock;

public class AccountDemo_34 {
    public static void main(String[] args) throws InterruptedException {
        Account_34 account1 = new Account_34(20000);
        Account_34 account2 = new Account_34(20000);

        AccountThread_34 accountThread1 = new AccountThread_34(account1, account2);
        AccountThread_34 accountThread2 = new AccountThread_34(account2, account1);

        accountThread1.start();
        accountThread2.start();

        accountThread1.join();
        accountThread2.join();

        System.out.println(account1);
        System.out.println(account2);
    }
}
