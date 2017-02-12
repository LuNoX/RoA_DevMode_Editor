// credit to xelu from
// http://opengameart.org/content/free-keyboard-and-controllers-prompts-pack for
// the button images
// credit to smash.gg for the character images
//creedit to http://www.iconsplace.com/red-icons/restart-icon for the restart button

package ui;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Resources
{
    public static String relativePath = "/resources/Icons/16/";

    public static Icon absaIcon;
    public static Icon etalusIcon;
    public static Icon forsburnIcon;
    public static Icon kraggIcon;
    public static Icon maypulIcon;
    public static Icon orcaneIcon;
    public static Icon wrastorIcon;
    public static Icon zetterburnIcon;

    public static Icon settingsIcon;

    public static Icon aButtonIcon;
    public static Icon bButtonIcon;
    public static Icon xButtonIcon;
    public static Icon yButtonIcon;
    
    public static Icon startButtonIcon;

    public Resources()
    {
        this.initalizeEverything();
    }

    public void initalizeEverything()
    {
        URL url = getClass().getResource(Resources.relativePath + "Absa.png");
        Resources.absaIcon = new ImageIcon(url);
        url = getClass().getResource(Resources.relativePath + "Etalus.png");
        Resources.etalusIcon = new ImageIcon(url);
        url = getClass().getResource(Resources.relativePath + "Forsburn.png");
        Resources.forsburnIcon = new ImageIcon(url);
        url = getClass().getResource(Resources.relativePath + "Kragg.png");
        Resources.kraggIcon = new ImageIcon(url);
        url = getClass().getResource(Resources.relativePath + "Maypul.png");
        Resources.maypulIcon = new ImageIcon(url);
        url = getClass().getResource(Resources.relativePath + "Orcane.png");
        Resources.orcaneIcon = new ImageIcon(url);
        url = getClass().getResource(Resources.relativePath + "Wrastor.png");
        Resources.wrastorIcon = new ImageIcon(url);
        url = getClass().getResource(Resources.relativePath + "Zetterburn.png");
        Resources.zetterburnIcon = new ImageIcon(url);

        url = getClass().getResource(Resources.relativePath + "Settings.png");
        Resources.settingsIcon = new ImageIcon(url);

        url = getClass().getResource(Resources.relativePath + "A Button.png");
        Resources.aButtonIcon = new ImageIcon(url);
        url = getClass().getResource(Resources.relativePath + "B Button.png");
        Resources.bButtonIcon = new ImageIcon(url);
        url = getClass().getResource(Resources.relativePath + "X Button.png");
        Resources.xButtonIcon = new ImageIcon(url);
        url = getClass().getResource(Resources.relativePath + "Y Button.png");
        Resources.yButtonIcon = new ImageIcon(url);
        
        url = getClass().getResource(Resources.relativePath + "Start Button.png");
        Resources.startButtonIcon = new ImageIcon(url);
    }

    public static Icon getCharacterIcon(String name)
    {
        if (name.contains("Absa"))
        {
            return Resources.absaIcon;
        }
        else if (name.contains("Etalus"))
        {
            return Resources.etalusIcon;
        }
        else if (name.contains("Forsburn"))
        {
            return Resources.forsburnIcon;
        }
        else if (name.contains("Kragg"))
        {
            return Resources.kraggIcon;
        }
        else if (name.contains("Maypul"))
        {
            return Resources.maypulIcon;
        }
        else if (name.contains("Orcane"))
        {
            return Resources.orcaneIcon;
        }
        else if (name.contains("Wrastor"))
        {
            return Resources.wrastorIcon;
        }
        else if (name.contains("Zetterburn"))
        {
            return Resources.zetterburnIcon;
        }
        return null;
    }

    public static Icon getMoveIcon(String name)
    {
        if (name.contains("SPECIAL"))
        {
            return Resources.xButtonIcon;
        }
        else if (name.contains("AIR"))
        {
            return Resources.yButtonIcon;
        }
        else if (name.contains("STRONG"))
        {
            return Resources.bButtonIcon;
        }
        else if (name.contains("TILT") || name.contains("JAB") || name.contains("DATTACK"))
        {
            return Resources.aButtonIcon;
        }
        Icon result = null;
        return result;
    }
}
