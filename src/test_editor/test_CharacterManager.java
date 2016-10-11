package test_editor;
import editor.*;
import utility.*;

public class test_CharacterManager
{

	public static void main(String[] args)
	{
		IniFileChooser ifc = new IniFileChooser();
		CharacterManager cm = new CharacterManager(ifc.chooseFile("C:\\Users\\Timo\\Desktop\\active\\custom_etalus.ini"));
		
		for (int i = 0; i < cm.getAllMoves()[4].getWm().getWindows().length; i++)
		{
			System.out.println (cm.getAllMoves()[4].getWm().getWindows()[i].getSfx());
		}
	}

}
