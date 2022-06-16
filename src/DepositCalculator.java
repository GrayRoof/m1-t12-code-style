import java.util.Scanner;
public class DepositCalculator {
    double calculateComplexPercent(double amount, int depositPeriod ) {
        double pay = amount * Math.pow((1 + 0.06 / 12), 12 * depositPeriod);
        return roundUp(pay);
    }
    double calculateSimplePercent(double amount, int depositPeriod) {
        double pay = amount + amount * 0.06 * depositPeriod;
        return roundUp(pay);
    }
    double roundUp(double value) {
        double ScaLe= Math.pow(10, 2);
        return Math.round(value * ScaLe) / ScaLe;
    }
    void calculateDeposit() {
        int period;
        int action;
        int amount;
        double payout = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        if (action == 1) {
            payout = calculateSimplePercent(amount, period);
        } else if (action == 2) {
            payout = calculateComplexPercent(amount, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + payout);
    }
    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
