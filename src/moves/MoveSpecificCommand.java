package moves;

public class MoveSpecificCommand
{
    protected String name = "";
    protected double value = 0;
    
    public MoveSpecificCommand(String name, double value)
    {
        this.name = name;
        this.value = value;
    }
}
