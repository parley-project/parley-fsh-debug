# Changelog

## 1.1.0 (unreleased)

First version: running and debugging fsh scripts, with no user interface, shared by Fsh Studio
and fshdb.

- `ScriptText`, `ScriptDocument`, `ScriptRun`, `RunSettings`, `RunSettingsStore`, `DebugSession`,
  `DebugVariables`, `Breakpoint`, `Watchpoint`, `Variable`, `ShellEnvironment`, `Completions` and
  `Template` moved here from Fsh Studio's `us.bringardner.fsh.ide.core` package, as they were, to
  `us.bringardner.fsh.debug`, with their tests. fshdb used to depend on Fsh Studio's jar for them.
- `SettingsFolder` is the settings folder in the user's home, `~/.fsh-studio` (it was
  `~/.fsh-ide`); the run settings are kept there, and Fsh Studio keeps its configuration and
  spelling words there too. Settings in `~/.fsh-ide` are not copied across.
- `ShellEnvironment.setForTests` is public, so Fsh Studio's tests can still use it.
