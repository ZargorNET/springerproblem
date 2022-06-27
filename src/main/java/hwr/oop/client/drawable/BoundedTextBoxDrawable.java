package hwr.oop.client.drawable;

import hwr.oop.client.util.CircularFifoQueue;
import java.util.Collection;
import org.fusesource.jansi.Ansi;

public class BoundedTextBoxDrawable implements IDrawable {

	public final int lineHeight;
	private final Collection<String> history;

	public BoundedTextBoxDrawable(int lineHeight) {
		this.lineHeight = lineHeight;
		this.history = new CircularFifoQueue<>(this.lineHeight);
	}

	public void put(String line) {
		history.add(line);
	}

	@Override
	public void draw(Ansi out) {
		history.forEach(h -> out.a(h).newline());

	}
}
