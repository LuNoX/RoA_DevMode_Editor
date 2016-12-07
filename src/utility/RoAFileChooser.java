package utility;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;

public class RoAFileChooser
{
	//TODO dont use AWT for remembering last location
	protected Component parent = null;
	protected File location = null;

	/**
	 * Öffnet ein GUI zur Auswahl einer Datei oder eines Directorys, und gibt dieses anschließend aus
	 * 
	 * @return das File oder Directory, das ausgewählt wurde
	 */
	public File chooseFile()
	{
		File result = null;
		JFileChooser chooser = new JFileChooser(this.location);
		int rueckgabewert = chooser.showOpenDialog(this.parent);

		if (rueckgabewert == JFileChooser.APPROVE_OPTION)
		{
			result = chooser.getSelectedFile();
			this.parent = chooser.getParent();
			this.location = chooser.getSelectedFile().getParentFile();
			//System.out.println(chooser.getSelectedFile().getName()); //Debug
		}
		return result;
	}
	
	/**
	 * Gibt ein File oder Directory anhand dessen vorher spezifizierten Directorys
	 * 
	 * @param directory das Directory zur Datei oder des Directorys
	 * @return
	 */
	public File chooseFile (String directory)
	{
		File result = null;
		
		result = new File(directory);
		
		return result;
	}
	
	/**
	 * Öffnet eine GUI zur Auswahl einer Datei, die einen bestimmten Namen hat oder eines Directorys in dem sich eine Datei mit diesem Namen befindet, und gibt dieses anschließend aus.
	 * Bei einer falschen Auswahl wird der Dialog rekursiv erneut geöffnet.
	 * 
	 * @param filename der Name der Datei oder des Directorys das ausgewählt werden soll
	 * @return die Datei mit dem Namen "filename"
	 */
	public File chooseSpecificFile(String filename)
	{
		File result = null;
		
		JFileChooser chooser = new JFileChooser(this.location);
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int rueckgabewert = chooser.showOpenDialog(this.parent);
		
		if (rueckgabewert == JFileChooser.APPROVE_OPTION)
		{
			result = chooser.getSelectedFile();
			
			this.parent = chooser.getParent();
			this.location = chooser.getSelectedFile().getParentFile();
			
			if (result.isDirectory()) //ist die ausgewählte Datei ein Directory?
			{
				this.parent = chooser;
				this.location = chooser.getSelectedFile();
				File[] listOfFiles = result.listFiles(); //speichere alle Dateien im Directory
				
				for (int i = 0; i<listOfFiles.length; i++) //gehe durch alle Dateien im Directory
				{
					if(listOfFiles[i].getName().equals(filename)) //ist die Datei die gesuchte Datei?
					{
						result = listOfFiles[i]; //speichere die Datei
					}
				}
			}
			else
			{
				this.parent = chooser.getParent();
				this.location = chooser.getSelectedFile().getParentFile();
			}
			if(!(result.getName().equals(filename))) //ist es die richtige Datei?
			{
				System.out.println("Wrong File - You selected " + result.getName() + " instead of " + filename + ". Please try again.");
				result = this.chooseSpecificFile(filename); //öffne die Methode erneut, um die richtige Datei auswählen zu lassen
			}
		}
		
		return result;
	}
}
