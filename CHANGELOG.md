# Changelog

## 1.1.0 (unreleased)

First version: running and debugging fsh scripts, with no user interface, shared by Fsh Studio
and fshdb.

- `ScriptText`, `ScriptDocument`, `ScriptRun`, `RunSettings`, `RunSettingsStore`, `DebugSession`,
  `DebugVariables`, `Breakpoint`, `Watchpoint`, `Variable`, `ShellEnvironment`, `Completions` and
  `Template` moved here from Fsh Studio's `us.bringardner.fsh.ide.core` package, as they were, to
  `us.bringardner.fsh.debug`, with their tests. fshdb used to depend on Fsh Studio's jar for them.
- `RunSettingsStore.SETTINGS_DIR` names the settings folder in the user's home (`.fsh-ide`, as
  before); Fsh Studio keeps its configuration in the same folder.
- `ShellEnvironment.setForTests` is public, so Fsh Studio's tests can still use it.
