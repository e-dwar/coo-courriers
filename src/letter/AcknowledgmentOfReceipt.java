package letter;

import city.Inhabitant;
import content.Text;

public class AcknowledgmentOfReceipt extends SimpleLetter {

	public AcknowledgmentOfReceipt(Inhabitant sender, Inhabitant receiver, Text content) {
		super(sender, receiver, content);
	}

	@Override
	public double getCost() {
		return 0;
	}

}
