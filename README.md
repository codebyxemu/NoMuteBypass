# DisableSignsWhileMuted
Disable Signs While a player is muted

This is a project I started on when I saw the lack of some features in certain punishment systems listed at SpigotMC and MC-Market/BuiltByBit.
Some plugins doesn't automatically prevent use of blocks, or other ways to bypass their mute to say something or write something that other people
can see.

DisableSignsWhileMuted uses a handler system in order to create different handlers to support various different punishment systems, which makes it very extendable.
This project is also open-sourced, so you guys can check out the project and see how it works!

I am constantly looking for new punishment systems to add to the handler list.

The requirements for a core to be usable is:
- Developer API allowing to check if a player is muted (check by uuid or player object)
- Comes with seperate API jar or Maven dependency.
