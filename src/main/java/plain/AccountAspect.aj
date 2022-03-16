import plain.Account;

public aspect AccountAspect {
    pointcut callWithDraw(int amount, Account acc) :
                call(boolean Account.withdraw(int)) && args(amount) && target(acc);

    before(int amount, Account acc) : callWithDraw(amount, acc) {
        System.out.printf("[before] withDraw, current balance %d%n", acc.balance);
    }

    boolean around(int amount, Account acc) : callWithDraw(amount, acc) {
        if (acc.balance < amount) {
            System.out.println("[around] withDraw, check failed");
            return false;
        }
        System.out.println("[around] withDraw, check success");
        return proceed(amount, acc);
    }

    after(int amount, Account acc) : callWithDraw(amount, acc) {
        System.out.printf("[after] withDraw, current balance %d%n", acc.balance);
    }
}