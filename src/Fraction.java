import java.util.Objects;

public class Fraction implements FractionOperations {
    private int numerator;
    private int denominator;
    private Double cachedValue; // Кэш вещественного значения

    // Конструктор
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        this.numerator = numerator;
        this.denominator = Math.abs(denominator); // Знаменатель всегда положительный
        if (denominator < 0) {
            this.numerator = -numerator; // Переносим знак в числитель
        }
        this.cachedValue = null;
    }

    // Геттеры
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Получение вещественного значения с кэшированием
    @Override
    public double getValue() {
        if (cachedValue == null) {
            cachedValue = (double) numerator / denominator;
        }
        return cachedValue;
    }

    // Установка числителя
    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        invalidateCache();
    }

    // Установка знаменателя
    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        if (denominator < 0) {
            this.numerator = -this.numerator;
            denominator = Math.abs(denominator);
        }
        this.denominator = denominator;
        invalidateCache();
    }

    // Сброс кэша при изменении числителя/знаменателя
    private void invalidateCache() {
        cachedValue = null;
    }

    // Строковое представление
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Сравнение на равенство (по числителю и знаменателю)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fraction)) return false;
        Fraction other = (Fraction) obj;
        return this.numerator == other.numerator &&
                this.denominator == other.denominator;
    }

    // hashCode согласован с equals
    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}