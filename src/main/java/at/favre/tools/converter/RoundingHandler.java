package at.favre.tools.converter;

/**
 * Defines how float numbers will be rounded
 */
public class RoundingHandler {
	enum Strategy {
		ROUND,
		CEIL,
		FLOOR,
		CAST
	}

	private final Strategy strategy;

	public RoundingHandler(Strategy strategy) {
		this.strategy = strategy;
	}

	public long round(double value) {
		switch (strategy) {
			case ROUND:
				return Math.round(value);
			case CEIL:
				return (long) Math.ceil(value);
			case FLOOR:
				return (long) Math.floor(value);
			default:
			case CAST:
				return (long) value;
		}
	}
}