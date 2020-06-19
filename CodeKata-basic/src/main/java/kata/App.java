package kata;

import java.util.Collection;

/**
 * Hello world!
 *
 */
public final class App {
	int x = 3;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public static void main(String[] args) {
		App app = new App();
		app.foo();
		app.foo(13);
	}

	App() {
		// do nothing
	}

	public void foo() {
		x = 0;
	}

	public void foo(int y) {
		x = y;

	}

	Object[] getAsArray(Collection<String> c) {
		return c.toArray();
	}

}
