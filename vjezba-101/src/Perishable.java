import java.time.LocalDate;

public interface Perishable {

    void setBestBefore(LocalDate bestBefore);
    LocalDate getBestBefore();
}
