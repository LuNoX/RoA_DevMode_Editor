package test_editor;
import editor.*;
import utility.*;

public class test_CharacterManager
{

	public static void main(String[] args)
	{
		IniFileChooser ifc = new IniFileChooser();
		CharacterManager cm = new CharacterManager(ifc.chooseFile());
		
		for (int i = 0; i < cm.getAllMoves()[4].getWindows().length; i++)
		{
			System.out.println (cm.getAllMoves()[4].getWindows()[i].getSfxValue());
		}
	}

}
