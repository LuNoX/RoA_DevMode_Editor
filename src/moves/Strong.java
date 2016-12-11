package moves;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utility.CommandStorage;

public class Strong extends Move
{
    protected float preChargeWindowFrames = 0;
    protected float postChargeWindowFrames = 0;
    
    public Strong (String name,int startPosition, int endPosition, String[] content)
    {
        super(name, startPosition, endPosition, content);
        for (int i = 0; i < this.other.length; i++)
        {
            Pattern p = Pattern.compile("\"([^\"]*)\"");
            Matcher m = p.matcher(this.other[i]);
            m = null;
            if (this.other[i].contains(CommandStorage.preChargeWindowFrames))
            {
                m = p.matcher(this.other[i]);
                m.find();
                this.preChargeWindowFrames = Float.parseFloat(m.group(1));
            }
            else if (this.other[i].contains(CommandStorage.postChargeWindowFrames))
            {
                m = p.matcher(this.other[i]);
                m.find();
                this.postChargeWindowFrames = Float.parseFloat(m.group(1));
            }
        }
    }
}
