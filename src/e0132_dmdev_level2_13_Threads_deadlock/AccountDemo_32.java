package e0132_dmdev_level2_13_Threads_deadlock;

public class AccountDemo_32 {
    public static void main(String[] args) throws InterruptedException {
        Account_32 account1 = new Account_32(20000);
        Account_32 account2 = new Account_32(20000);

        AccountThread_32 accountThread1 = new AccountThread_32(account1, account2);
        AccountThread_32 accountThread2 = new AccountThread_32(account2, account1);

        accountThread1.start();
        accountThread2.start();

        accountThread1.join();
        accountThread2.join();

        System.out.println(account1);
        System.out.println(account2);
    }
}
