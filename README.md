# parley-fsh-debug

Runs and debugs bash/POSIX-style shell scripts, with
[fsh](https://github.com/parley-project/parley-fsh), the FileSource Shell, as the interpreter.
It has no user interface: it is the engine that
[Fsh Studio](https://github.com/parley-project/parley-fsh-studio) (the IDE) and
[fshdb](https://github.com/parley-project/parley-fshdb) (the terminal debugger) are both built on,
so it never uses Swing, JavaFX or any other UI toolkit.

The classes came from Fsh Studio's `us.bringardner.fsh.ide.core` package in November 2026.

## What's in it

Everything is in the package `us.bringardner.fsh.debug`.

1. **Running a script**: `ScriptRun` is one run of a script with fsh, on its own thread, with its
   arguments and its standard streams (the program's console, or redirect files).
   `ShellEnvironment` gives scripts the environment of the user's login shell.
2. **Debugging**: `DebugSession` (pause, step, run to a line), `Breakpoint` (optionally
   conditional), `Watchpoint` (stop when a variable is read or written), and `DebugVariables` and
   `Variable` for the variables of a paused script.
3. **Scripts and their settings**: `ScriptText` and `ScriptDocument` hold a script's text and the
   arguments and redirects it runs with. `RunSettings` and `RunSettingsStore` keep those per user,
   in `~/.fsh-studio/run-settings`, not in the script.
4. **Completion**: `Completions` finds what can finish the word being typed: templates (`if`,
   `for`, `case` and so on, each a `Template`) and the variables the script sets.

## Requirements

1. Java 11 or later.
2. fsh and [parley-files](https://github.com/parley-project/parley-files), version 2.0.0.

## Building

```
mvn install
```

The tests need no display. To build it with the rest of Parley, use
[parley-build](https://github.com/parley-project/parley-build).

## License

Apache License, Version 2.0. See [LICENSE](LICENSE).
