### Release 2.1.1

- Updated the mod's logo.


### Release 2.1.0

- Fixed a crash where having a config file from the non-reloaded mod would crash the game on launch, this was done by changing the mod id from `debugblockcollision` to `blockcollisionoverlay`.
- Introduced workaround for the overlay toggle keybinding due to it not working on [Cleanroom Loader](https://github.com/CleanroomMC/Cleanroom) (as of `0.4.2-alpha`).
- Updated the archive base name to `DebugBlockCollisionReloaded`


### Release 2.0.0

Initial release of the reloaded version of this mod.

- Keybindings are now handled in such a way where they are properly debounced and don't result in repeatedly toggling on/off or changing modes.
- Toggling the debug overlay on/off and changing the overlay mode are now done through different keybindings.
- Lots of feedback text has been amended, edited or reformatted for readability, legibility and visual clarity.
- The `en_us.lang` file has been re-organized and re-written.

`Changes to the build process and non-mod files are not listed here.`
