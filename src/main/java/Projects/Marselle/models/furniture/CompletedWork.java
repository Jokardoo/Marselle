package Projects.Marselle.models.furniture;


// Этот класс объединяет заказы, распил, кромление, стандартные позиции и все остальные виды работ
public class CompletedWork {
    private Integer costOfWork; // сумма к оплате работнику

    public CompletedWork() {
        this.costOfWork = 0;
    }

    public Integer getCostOfWork() {
        return costOfWork;
    }

    public void setCostOfWork(Integer costOfWork) {
        this.costOfWork = costOfWork;
    }
}
