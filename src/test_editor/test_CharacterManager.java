package test_editor;
import characters.RoACharacter;
import utility.*;

public class test_CharacterManager
{
	public static void main(String[] args)
	{
		IniFileChooser ifc = new IniFileChooser();
		
		/*String[] tmp = {"a", "b", "c" , "d"};
		Utilities u = new Utilities();
		tmp = u.removeEntry(tmp, 1);
		System.out.print(tmp[0] + " " + tmp[1] + " " + tmp[2]);*/
		
		RoACharacter cm = new RoACharacter(ifc.chooseFile("C:\\Users\\Timo\\Desktop\\active\\custom_etalus.ini"));
		
		for (int i = 0; i < cm.getAllMoves()[4].getWm().getWindows().length; i++)
		{
			System.out.println (cm.getAllMoves()[4].getWm().getWindows()[i].getSfx());
		}
	}
}
