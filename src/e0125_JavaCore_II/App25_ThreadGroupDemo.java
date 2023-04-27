package e0125_JavaCore_II;

public class App25_ThreadGroupDemo {
    public void launch() {
        ThreadGroup groupA = new ThreadGroup("Группа A");
        ThreadGroup groupB = new ThreadGroup("Группа B");

        Sample25_NewThread ob1 = new Sample25_NewThread("Один", groupA);
        Sample25_NewThread ob2 = new Sample25_NewThread("Два", groupA);
        Sample25_NewThread ob3 = new Sample25_NewThread("Три", groupB);
        Sample25_NewThread ob4 = new Sample25_NewThread("Четыре", groupB);

        System.out.println("\nВывод из метода list() : ");
        groupA.list();
        groupB.list();
        System.out.println();

        System.out.println("\nПрерывается группа A:");
        Thread tga[] = new Thread[groupA.activeCount()];
        groupA.enumerate(tga); // получить потоки исполнения из группы
        for (int i = 0; i < tga.length; i++) {
            ((Sample25_NewThread) tga[i]).mysuspend(); // приостановить каждый поток исполнения
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("Главный поток исполнения прерван.");
        }


        System.out.println("Возобновление Группы А:");
        for (int i = 0; i < tga.length; i++) {
            ((Sample25_NewThread) tga[i]).myresume(); // возобновить все потоки исполнения в группе
        }

        // ожидать завершения потоков исполнения:

        try {
            System.out.println("Ожидание завершения потоков исполнения.");
            ob1.join();
            ob2.join();
            ob3.join();
            ob4.join();

        } catch (InterruptedException e) {
            System.out.println("Исключение в главном поток исполнения");
        }

        System.out.println("Главный поток исполнения завершен.");

    }
}
