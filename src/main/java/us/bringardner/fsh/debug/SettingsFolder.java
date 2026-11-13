/**
 *	Copyright 2026 Tony Bringardner
 *
 *	Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *	http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *	on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
 *	the specific language governing permissions and limitations under the License.
 */
package us.bringardner.fsh.debug;

import java.io.File;

/**
 * The folder in the user's home where Fsh Studio and fshdb keep their settings: ~/.fsh-studio
 * (the run settings, and Fsh Studio's configuration and spelling words).
 */
public final class SettingsFolder {

	/** The folder's name in the user's home. */
	public static final String NAME = ".fsh-studio";

	private SettingsFolder() {
	}

	/** The user's settings folder, ~/.fsh-studio, made if it isn't there. */
	public static File forUser() {
		return in(new File(System.getProperty("user.home")));
	}

	/**
	 * home/.fsh-studio, made if it isn't there.
	 *
	 * @param home the user's home folder
	 * @return the settings folder
	 */
	public static File in(File home) {
		File dir = new File(home, NAME);
		if( !dir.isDirectory()) {
			dir.mkdirs();
		}
		return dir;
	}
}
