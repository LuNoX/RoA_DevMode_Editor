package generals;

import java.util.List;

public class CharacterGeneral
{
    protected List<String> code = null;

    protected String[] groundMovement = null;
    protected String[] aerialMovement = null;
    protected String[] jumping = null;
    protected String[] invincibility = null;

    protected List<String> other = null;

    public CharacterGeneral(List<String> code)
    {
        this.code = code;
        this.other = code;

        this.initializeGroundMovement();
        this.initializeAerialMovement();
        this.initializeJumping();
        this.initializeInvincibility();
    }

    /**
     * Placeholder constructor to avoid errors in all CharacterGeneral classes
     */
    public CharacterGeneral()
    {
        // TODO make this constructor do at least something
    }

    public void initializeGroundMovement()
    {

    }

    public void initializeAerialMovement()
    {

    }

    public void initializeJumping()
    {

    }

    public void initializeInvincibility()
    {

    }
}
