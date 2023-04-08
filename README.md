# Image-To-Text_Display
Convert an image to a text_display entity in Minecraft: Java Edition!

![Ethlyn](https://i.imgur.com/0c0Gr0S.png)
![Ethlyn in Minecraft](https://i.imgur.com/Njws2hc.png)
# What third party items do I need to use this?
Java, Minecraft: Java Edition, [Fabric](https://fabricmc.net/), and [Carpet mod](https://www.curseforge.com/minecraft/mc-mods/carpet)

Would help to also have image editing software, such as [Paint.NET](https://www.getpaint.net/download.html)
# Prepare an Image for Conversion
**This step is critical to ensuring your game doesn't crash!**

The main thing you want to do is **reduce how many colors are in your image**. I use a color effect that comes with [Paint.NET](https://www.getpaint.net/download.html) called [Quantize](https://www.getpaint.net/doc/latest/EffectsColorMenu.html), but you can use any function that reduces how many colors are in your image. You'll probably want about 6 colors in an image, but you can go beyond that if you want. The game will very likely be unplayably laggy if you add too many colors, please proceed with caution. Below are the settings I use for [Quantize](https://www.getpaint.net/doc/latest/EffectsColorMenu.html), but you can mess around with these. Most important is the colors are set to a very low number. Dithering can help make your image seem like it has more color than it does, experiment with it and see what works for your image!

![Quantize Settings](https://i.imgur.com/aJJUo29.png)

Shrink your image down so that it doesn't lag as much. You can experiment with making the image bigger, but you should definitely try to load an image in small first since the program will take a long time with large images and Minecraft probably won't be playable with very large images. I suggest shrinking your image before you reduce how many colors are in the images as that'll lead to more details being maintained.

Any pixels with transparency with not be displayed in the text_display, so use this for a nice transparent background around your image!

Example Image:

![Ethlyn](https://i.imgur.com/0c0Gr0S.png)

Example Image after doing the above steps:

![Ethlyn Example](https://i.imgur.com/Q4TlQ9n.png)
# Convert an Image to Text_Display Strings
Download the `.jar` file

Open a command prompt where you downloaded the `.jar` file; you can do this in file explorer by typing `cmd` at the file location (the text box at the top of the file explorer where it says the folder address)

Do the command `ImageToText_Display.jar "The location of the Image" "The location where you want the output Text_Display_Data.txt file"`

For example `C:\Tommy\Downloads>ImageToText_Display.jar "C:\Tommy\Downloads\Ethlyn.png" "C:\Tommy\Downloads"` would take the image Ethlyn.png and output `Text_Display_Data.txt` inside the downloads folder

Don't put a backslash at the end of the output location
# What do I do with Text_Display_Data.txt
Navigate to `.minecraft\saves` and find the world where you want to put the text_displays in

Make sure cheats are enabled! (we are cheating)

Create a file inside the world called `scripts` and one inside that called `shared`. The file directory should look like `.minecraft\saves\YOUR_WORLD\scripts\shared`

Put `Text_Display_Data.txt` inside `.minecraft\saves\YOUR_WORLD\scripts\shared` so [scarpet](https://github.com/gnembon/scarpet) can read it!
# How do I use scarpet
Download and place `Image_To_Text_Display.sc` in `.minecraft\saves\YOUR_WORLD\scripts`

Open the your minecraft world and run the command `/script load image_to_text_display`

Now you can run `/image_to_text_display create x y z scale`, where x, y, and z are the bottom center of where the image will be placed in the world. Scale is contextual to how big your image is and how big you want it. I found 0.1 to be a good number, but you should experiment with it! With decimals make sure you include a 0 before the decimal point, or else the game won't understand the number you're typing.

If the `/script` command doesn't exist, you don't have [Carpet mod](https://www.curseforge.com/minecraft/mc-mods/carpet)

If the `image_to_text_display` script doesn't exist, you didn't put `Image_To_Text_Display.sc`  in the right location

This command will create text_display entities in your world which can only be removed with a command such as `/kill @e[type=minecraft:text_display]`, so keep that in mind.
# Useful tips
You can set the output of the .jar file to do be `.minecraft\saves\YOUR_WORLD\scripts\shared` and it'll automatically put `Text_Display_Data.txt` in a place where scarpet can read it

Make sure you have the command `/kill @e[type=minecraft:text_display]` ready incase the game gets unplayably laggy and you have to remove text_displays.

If you have any trouble, don't hesitate to message me on [Twitter](https://twitter.com/META_Tommy) or [Reddit](https://www.reddit.com/user/META_Tommy/)
