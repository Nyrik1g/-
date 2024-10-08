import java.util.ArrayList;
import java.util.List;
 
abstract class Сотрудник {
    protected String имя;
    protected int идентификатор;
    protected String должность;

    public Сотрудник(String имя, int идентификатор, String должность) {
        this.имя = имя;
        this.идентификатор = идентификатор;
        this.должность = должность;
    }

    public abstract double рассчитатьЗарплату();

    @Override
    public String toString() {
        return "Сотрудник: " + имя + " (ID: " + идентификатор + ", Должность: " + должность + ")";
    }
}

class Рабочий extends Сотрудник {
    private double ставкаЗаЧас;
    private int количествоЧасов;

    public Рабочий(String имя, int идентификатор, String должность, double ставкаЗаЧас, int количествоЧасов) {
        super(имя, идентификатор, должность);
        this.ставкаЗаЧас = ставкаЗаЧас;
        this.количествоЧасов = количествоЧасов;
    }

    @Override
    public double рассчитатьЗарплату() {
        return ставкаЗаЧас * количествоЧасов;
    }

    @Override
    public String toString() {
        return super.toString() + " [Рабочий] (Ставка: " + ставкаЗаЧас + ", Часы: " + количествоЧасов + ")";
    }
}

class Менеджер extends Сотрудник {
    private double фиксированнаяЗарплата;
    private double премия;

    public Менеджер(String имя, int идентификатор, String должность, double фиксированнаяЗарплата, double премия) {
        super(имя, идентификатор, должность);
        this.фиксированнаяЗарплата = фиксированнаяЗарплата;
        this.премия = премия;
    }

    @Override
    public double рассчитатьЗарплату() {
        return фиксированнаяЗарплата + премия;
    }

    @Override
    public String toString() {
        return super.toString() + " [Менеджер] (Зарплата: " + фиксированнаяЗарплата + ", Премия: " + премия + ")";
    }
}

class СистемаСотрудников {
    private List<Сотрудник> сотрудники = new ArrayList<>();

    public void добавитьСотрудника(Сотрудник сотрудник) {
        сотрудники.add(сотрудник);
        System.out.println("Добавлен сотрудник: " + сотрудник);
    }

    public void рассчитатьЗарплаты() {
        for (Сотрудник сотрудник : сотрудники) {
            System.out.println(сотрудник + ", Зарплата: " + сотрудник.рассчитатьЗарплату());
        }
    }
}

public class ТестСотрудников {
    public static void main(String[] args) {
        СистемаСотрудников система = new СистемаСотрудников();

        Рабочий рабочий1 = new Рабочий("Иван Петров", 1, "Рабочий", 500, 40);
        Рабочий рабочий2 = new Рабочий("Мария Иванова", 2, "Рабочий", 450, 35);
        Менеджер менеджер1 = new Менеджер("Ольга Смирнова", 3, "Менеджер", 80000, 10000);

        система.добавитьСотрудника(рабочий1);
        система.добавитьСотрудника(рабочий2);
        система.добавитьСотрудника(менеджер1);

        система.рассчитатьЗарплаты();
    }
}
