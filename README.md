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

### History

This mod was originally created by [Phylogeny](https://github.com/Phylogeny) who original came up with the idea for the mod and released it on September 1st, 2018.

On January 28th, 2026 I came across this mod well developing a ProjectE addon called [ProjectE Charms](https://github.com/barnabeepickle/projecte-charm) since I wanted a way to see exact collisions on a block I was adding. The problem I found was that actually using the mod was a bit clunky so when I found that the source code was on Github I decided give a crack at improving it, so I forked it.

Subsequently I did the following:

 - Rebuilt the Gradle toolchain using [ForgeDevEnv](https://github.com/CleanroomMC/ForgeDevEnv).
 - Leveraging some custom code I originally wrote for [Make Panorama](https://github.com/barnabeepickle/MakePanorama) (it can be under the Unlicense since I originally wrote it) transplanted the original handling code to start on improving keybind detection and debounce.
 - Removed some janky [reflection](https://en.wikipedia.org/wiki/Reflective_programming) code and simplified it with an [Access Transformer](https://docs.minecraftforge.net/en/latest/advanced/accesstransformers/).
 - Started reworking the lang file and some of the corresponding code.
 - Replaced my single some what scattered keybind handler with two making it both easier to use and develop.
 - Finished the lang file rework along with adding two new config options.

Overall this rework only took me about a day with the new 2.0.0 version being done on January 29th, 2026.

## Modpacks

You don't need to ask permission or anything to use this in your modpack.

##  Issues

If you notice an issue and want to make me aware please report them on the [issues tab](https://github.com/barnabeepickle/DebugBlockCollision/issues).

## Pull-Requests

If you want to help fix an issue or improve the mod I am happy to merge pull requests.

Feature additions like additional modes or config options will probably be accepted but new overlays belong in different mods.
