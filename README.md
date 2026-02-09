# Debug Block Collision Overlay Reloaded

A client-side mod that adds a new F3 debug overlay showing you exact block collisions.

## About

[Original Mod's Github](https://github.com/Phylogeny/DebugBlockCollision) - [Original Mod's Curseforge](https://www.curseforge.com/minecraft/mc-mods/debug-block-collision)

[Modrinth Page](https://modrinth.com/mod/debug-block-collision-reloaded) - [Curseforge Page](https://www.curseforge.com/minecraft/mc-mods/debug-block-overlay-reloaded)

### Features

 - Toggleable overlay, default keybind `F3 + O`.
 - Multiple overlay modes, default keybind `F3 + I`.
 - Config file which allows you to set the overlay mode, the level of chat feedback and line rendering settings.
 - In-game configuration through Forge that is dynamicly reloaded.
 - Has been tested with [Cleanroom Loader](https://github.com/CleanroomMC/Cleanroom) (0.4.2-alpha) and [Celeritas](https://git.taumc.org/embeddedt/celeritas).

### Usage

The main way to interact with this mods is by using the `F3 + KEY` keybinds which by default are `F3 + O` to toggle the overlay on/off and `F3 + I` to change the overlay mode.

There is also a config file which is dynamicly reloaded and can be edited in game or on the main menu.

<!-- TODO: Write instructions with screenshots -->

### Why

Well working on [ProjectE-Charms](https://github.com/barnabeepickle/projecte-charm) I had to create some custom collision for a block but was having trouble visualizing the boxes so I looked on curseforge for mod that would help me do that, I ended up on [Debug Block Collision](https://www.curseforge.com/minecraft/mc-mods/debug-block-collision)'s Curseforge so I downloaded it. After I had used it for a little bit on the [Cleanroom Mod Loader](https://github.com/CleanroomMC/Cleanroom) I noticed a few main issues:

- The keybind handling had broken debouce (actually a Cleanroom issue with modifier keys).
- Toggling modes was clunky since there was only one keybind.
- And the text and formatting could do with some improvement.

All of this inspired me to improve this mod by adding a second keybind, improving Cleanroom compatibility and rewriting the `lang` file; so I did.

## Modpacks

You don't need to ask permission or anything to use this in your modpack.

##  Issues

If you notice an issue and want to make me aware please report them on the [issues tab](https://github.com/barnabeepickle/DebugBlockCollision/issues).

## Pull-Requests

If you want to help fix an issue or improve the mod I am happy to merge pull requests.

Feature additions like additional modes or config options will probably be accepted but new overlays belong in different mods.
