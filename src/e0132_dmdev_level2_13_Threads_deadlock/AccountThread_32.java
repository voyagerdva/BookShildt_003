package e0132_dmdev_level2_13_Threads_deadlock;

public class AccountThread_32 extends Thread {

    private final Account_32 accountFrom;
    private final Account_32 accountTo;


    public AccountThread_32(Account_32 accountFrom, Account_32 accountTo) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            synchronized (accountFrom) {
                synchronized (accountTo) {
                    if (accountFrom.takeOff(10)) {
                        accountTo.add(10);
                    }
                }
            }
        }
    }
}
