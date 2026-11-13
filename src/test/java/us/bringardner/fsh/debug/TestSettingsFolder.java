package us.bringardner.fsh.debug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/** The settings folder is ~/.fsh-studio. */
public class TestSettingsFolder {

	@TempDir
	Path home;

	@Test
	public void makesTheFolderInANewHome() {
		File dir = SettingsFolder.in(home.toFile());
		assertEquals(home.resolve(".fsh-studio").toFile(), dir);
		assertTrue(dir.isDirectory());
	}

	@Test
	public void leavesAnExistingFolderAsItIs() throws IOException {
		Path now = home.resolve(".fsh-studio");
		Files.createDirectories(now);
		Files.writeString(now.resolve("run-settings"), "kept");

		File dir = SettingsFolder.in(home.toFile());
		assertEquals("kept", Files.readString(dir.toPath().resolve("run-settings")));
	}
}
