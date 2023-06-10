package e0135_dmdev_level2_14_java_util_concurrent_Atomic_Lock;

public class AccountThread_34 extends Thread {

    private final Account_34 accountFrom;
    private final Account_34 accountTo;


    public AccountThread_34(Account_34 accountFrom, Account_34 accountTo) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            lockAccounts();

            try {
                if (accountFrom.takeOff(10)) {
                    accountTo.add(10);
                }
            } finally {
                accountFrom.getLock().unlock();
                accountTo.getLock().unlock();
            }
        }
    }

    private void lockAccounts() {
        while (true) {
            boolean fromLockResult = accountFrom.getLock().tryLock();
            boolean toLockResult = accountTo.getLock().tryLock();

            if (fromLockResult && toLockResult) {
                break;
            }

            if (fromLockResult) {
                accountFrom.getLock().unlock();
            }

            if (toLockResult) {
                accountTo.getLock().unlock();
            }
        }
    }
}
