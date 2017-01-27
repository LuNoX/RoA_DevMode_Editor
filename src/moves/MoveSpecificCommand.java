package moves;

public class MoveSpecificCommand
{
    protected String name = "";
    protected double value = 0;
    
    //TODO rename this customCommand and relocate it
    public MoveSpecificCommand(String name, double value)
    {
        this.name = name;
        this.value = value;
    }
}
