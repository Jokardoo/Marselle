package Projects.Marselle.models.furnitureGenerator.exceptions;

// Исключение выбрасывается тогда, когда пользователь не указал требуемое значение для проектировки

public class SizeIsNotSpecifiedException extends Exception {
    public SizeIsNotSpecifiedException() {
        super("The user did not specify the required size");
    }
}
