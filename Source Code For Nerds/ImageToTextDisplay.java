//By: @META_Tommy
//04/07/2023
package imagetotextdisplay;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import javax.imageio.ImageIO;

public class ImageToTextDisplay {

    public static void main(String[] args) throws IOException {
        //file path for image
        File file = new File(args[0]);
        //file path for output
        Writer file2 = new OutputStreamWriter(new FileOutputStream(args[1]+"\\Text_Display_Data.txt"), StandardCharsets.UTF_8);
        
        BufferedImage picture = ImageIO.read(file);
        
        //temp variable used for loops
        Color rgb;
        
        int width = picture.getWidth();
        int height = picture.getHeight();
        
        
        //temp variable to reduce pallette.get calls
        Color current = null;
        file2.write("[{\"text\":\"");
        //loop through every color in palette
        for(int y = 0; y < height; y++){
                for(int x = 0; x < width; x++){
                    rgb = new Color(picture.getRGB(x,y),true);
                    if(rgb.getAlpha()==255){
                        if(current == null){
                            current = rgb;
                        }else if(!current.equals(rgb)){
                            file2.write("\",\"color\":\"#"+Integer.toHexString(current.getRGB()).substring(2)+"\"},{\"text\":\"");
                            current = rgb;
                        }
                        file2.write("⬛");
                    }else{
                        file2.write("  ");
                    }
                }
                //outputs \\n
            file2.write("\\\\n");
        }
        file2.write("\",\"color\":\"#"+Integer.toHexString(current.getRGB()).substring(2)+"\"}]");
        file2.close();
    }
    
}
