//By: @META_Tommy
//04/07/2023
package ImageToText_Display;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class ImageToText_Display {

    public static void main(String[] args) throws IOException {
        //file path for image
        File file = new File(args[0]);
        //file path for output
        Writer file2 = new OutputStreamWriter(new FileOutputStream(args[1]+"\\Text_Display_Data.txt"), StandardCharsets.UTF_8);
        //FileWriter file2 = new FileWriter (args[1]+"\\Text_Display_Data.txt");
        
        BufferedImage picture = ImageIO.read(file);
        
        //color palette
        ArrayList<Color> palette = new ArrayList<Color>();
        //temp variable used for loops
        Color rgb;
        
        int width = picture.getWidth();
        int height = picture.getHeight();
        //get all the colors in the image
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                rgb = new Color(picture.getRGB(x,y),true);
                if(rgb.getAlpha()==255 && !palette.contains(rgb)){
                    palette.add(rgb);
                }
            }
        }
        //write meta data about the image to output
        //meta data is the palette size and colors
        file2.write(palette.size()+"\n");
        for(int c = 0; c < palette.size(); c++){
            //substring(2) removes alpha channel
            file2.write(Integer.toHexString(palette.get(c).getRGB()).substring(2)+"\n");
        }
        
        //temp variable to reduce pallette.get calls
        Color current;
        
        //loop through every color in palette
        for(int c = 0; c < palette.size(); c++){
            current = palette.get(c);
            //loop through entire image
            for(int y = 0; y < height; y++){
                for(int x = 0; x < width; x++){
                    //output ⬛ and space depending on where current color is in image
                    rgb = new Color(picture.getRGB(x,y),true);
                    if(rgb.getAlpha()==255 && current.equals(rgb)){
                        file2.write("⬛");
                    }else{
                        file2.write("  ");
                    }
                }
                //outputs \\n
                file2.write("\\\\n");
            }
            //outputs new line
            file2.write("\n");
        }
        file2.close();
    }
    
}
