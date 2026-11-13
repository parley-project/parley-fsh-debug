package us.bringardner.fsh.debug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

/** Fsh Studio and fshdb share this library, and fshdb has no display, so it mustn't use a UI toolkit. */
public class TestHasNoUi {

	// fsh's DebugContext.isBreakpoint takes a java.awt.Point (a plain value, no UI)
	private static final List<String> ALLOWED = List.of("import java.awt.Point;");

	@Test
	public void noUiImports() throws IOException {
		Path dir = Path.of("src/main/java/us/bringardner/fsh/debug");
		assertTrue(Files.isDirectory(dir), "run from the project folder");
		List<String> found = new ArrayList<>();
		try(Stream<Path> files = Files.list(dir)) {
			for(Path p : files.filter(f->f.toString().endsWith(".java")).collect(java.util.stream.Collectors.toList())) {
				for(String line : Files.readAllLines(p)) {
					String t = line.trim();
					if( (t.startsWith("import javax.swing") || t.startsWith("import java.awt")
							|| t.startsWith("import javafx") || t.startsWith("import org.fife"))
							&& !ALLOWED.contains(t)) {
						found.add(p.getFileName()+": "+t);
					}
				}
			}
		}
		assertEquals(List.of(), found);
	}
}
